#!/bin/bash
# Starts the Magic 8-Ball server plus two clients (each in its own Terminal window).
# Usage: ./start.sh   (stop everything with: pkill -f magic8ball)

cd "$(dirname "$0")"

echo "== Compiling =="
mkdir -p target/classes
javac -d target/classes src/main/java/magic8ball/*.java || { echo "Compilation failed"; exit 1; }

CP="target/classes"

echo "== Starting server on port 1235 =="
nohup java -cp "$CP" magic8ball.Magic8BallServer > server.log 2>&1 &
SERVER_PID=$!
sleep 2

if ! kill -0 "$SERVER_PID" 2>/dev/null; then
    echo "Server failed to start, see server.log"
    exit 1
fi

echo "== Opening two clients =="
# macOS: run each client in its own Terminal window via osascript
osascript -e "tell application \"Terminal\" to do script \"clear; cd '$PWD' && java -cp '$CP' magic8ball.Magic8BallClient\""
sleep 1
osascript -e "tell application \"Terminal\" to do script \"clear; cd '$PWD' && java -cp '$CP' magic8ball.Magic8BallClient\""

echo "Demo running. Server PID: $SERVER_PID (log: server.log)"
echo "Stop with: pkill -f magic8ball"
