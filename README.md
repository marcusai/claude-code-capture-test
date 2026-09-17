# hello

Minimal Spring Boot hello-world used as a clean baseline for testing Claude Code capture across
interfaces (terminal, IntelliJ plugin, VS Code, Claude Desktop) and Anthropic's compliance/monitoring APIs.

## Run

```bash
mvn spring-boot:run
```

Then:

```bash
curl http://localhost:8080/hello
# Hello World

curl http://localhost:8080/goodbye
# Goodbye World
```

## Test

```bash
mvn test
```

Runs both the plain unit test (`HelloControllerTest`) and the Cucumber scenario
(`src/test/resources/features/hello.feature`, backed by `HelloSteps`).

## Requirements

- Java 17+
- Maven 3.9+ (or use your IDE's bundled Maven)
