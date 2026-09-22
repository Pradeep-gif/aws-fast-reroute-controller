# Fast Reroute Controller

A compact Java 17 portfolio project that models a traffic-engineering controller for a backbone network. Given a failed or congested path, it selects the healthiest available alternate path and emits a decision event.

## Demonstrates

- Java service design with immutable network-path data models
- Failure and congestion detection
- Deterministic fast reroute based on availability, latency, and residual capacity
- Explicit no-route handling for operational safety
- Unit-style executable tests and GitHub Actions CI

## Run

```bash
javac -d out src/main/java/com/portfolio/reroute/*.java src/test/java/com/portfolio/reroute/*.java
java -ea -cp out com.portfolio.reroute.FastRerouteControllerTest
```

This is a simulation only; it does not connect to AWS infrastructure.
