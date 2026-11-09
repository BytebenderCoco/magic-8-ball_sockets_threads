# Magic 8-Ball — Sockets & Threads

A networked Magic 8-Ball for a distributed systems assignment. A multi-threaded
server (one virtual thread per client) answers yes/no questions from any number
of TCP clients with one of 20 randomly chosen answers.

## Run it

```bash
./start.sh
```

This compiles the project, starts the server on port 1235, and opens two
clients in separate terminal windows. Ask a question, get an answer, type
`EXIT` to quit.

Or manually:

```bash
javac -d target/classes src/main/java/magic8ball/*.java
java -cp target/classes magic8ball.Magic8BallServer   # terminal 1
java -cp target/classes magic8ball.Magic8BallClient    # terminal 2 (and more)
```

Stop everything with `pkill -f magic8ball`.
