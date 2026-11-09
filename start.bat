@echo off
REM Starts the Magic 8-Ball server plus two clients (each in its own CMD window).
REM Usage: start-demo.bat   (stop everything: taskkill /F /IM java.exe /FI "COMMANDLINE like magic8ball" )

cd /d "%~dp0"

echo == Compiling ==
if not exist target\classes mkdir target\classes
javac -d target\classes src\main\java\magic8ball\*.java
if errorlevel 1 (
    echo Compilation failed
    exit /b 1
)

set CP=target\classes

echo == Starting server on port 1235 ==
start /b java -cp %CP% magic8ball.Magic8BallServer > server.log 2>&1
timeout /t 2 /nobreak >nul

echo == Opening two clients ==
start "8-Ball Client 1" cmd /k "cd /d "%~dp0" && java -cp %CP% magic8ball.Magic8BallClient"
timeout /t 1 /nobreak >nul
start "8-Ball Client 2" cmd /k "cd /d "%~dp0" && java -cp %CP% magic8ball.Magic8BallClient"

echo Demo running. Server log: server.log
echo Stop with: taskkill /F /IM java.exe
