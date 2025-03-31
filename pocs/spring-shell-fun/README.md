### Build

```bash
./build.sh
```

### Run

```bash
./run.sh
```

### Result

```bash
❯ ./run.sh

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.4)

2025-03-30T10:47:09.191-07:00  INFO 95912 --- [spring-shell-fun] [           main] c.g.d.s.SpringShellFunApplication        : Starting SpringShellFunApplication v0.0.1-SNAPSHOT using Java 21 with PID 95912 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-shell-fun/target/spring-shell-fun-0.0.1-SNAPSHOT.jar started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-shell-fun)
2025-03-30T10:47:09.194-07:00  INFO 95912 --- [spring-shell-fun] [           main] c.g.d.s.SpringShellFunApplication        : No active profile set, falling back to 1 default profile: "default"
2025-03-30T10:47:10.142-07:00  INFO 95912 --- [spring-shell-fun] [           main] c.g.d.s.SpringShellFunApplication        : Started SpringShellFunApplication in 1.353 seconds (process running for 1.818)
shell:>help
AVAILABLE COMMANDS

Built-In Commands
       help: Display help about available commands
       stacktrace: Display the full stacktrace of the last error.
       clear: Clear the shell screen.
       quit, exit: Exit the shell.
       history: Display or save the history of previously run commands
       version: Show version info
       script: Read and execute commands from a file.

Hello Command
       hello-world:



shell:>hello-world john-doe
Hello world john-doe
shell:>history
[help, history, quit, hello, help, hello-world, hello-world diego, help, hello-world john-doe, history]
shell:>
```