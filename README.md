# Detective Bureau

Assignment 5 — Strategy pattern

Assign evidence using round robin, least workload, or matching specialization.
If no specialist matches, the specialization strategy uses least workload.
Equal workloads and multiple matching specialists are resolved by list order.
Every assignment increases workload by one.

## Run

JDK 8 or newer. From the project folder:

```text
javac -encoding UTF-8 -d out src/com/detectivebureau/model/*.java src/com/detectivebureau/strategy/*.java src/com/detectivebureau/core/*.java src/com/detectivebureau/Main.java
java -cp out com.detectivebureau.Main
```

Choose 1, 2 or 3 before each evidence item. Enter 0 to exit.

## Strategy pattern

- Interface: AllocationStrategy.
- Strategies: RoundRobinStrategy, LeastLoadedStrategy, SpecializationStrategy.
- Context: DetectiveBureau.
- Client: Main.

Main changes the strategy on the same bureau at runtime.
The bureau delegates selection through the interface, without checking strategy types.

## Clean Code

1. Meaningful names: strategy names describe their rules.
2. Single responsibility: each strategy owns one selection rule; the bureau updates workload; Main handles the menu.
3. Polymorphism: one selectDetective() call runs the chosen algorithm.
4. Depend on abstractions: the bureau depends on AllocationStrategy.
5. Encapsulation: fields are private; workload changes through addEvidence().

A new strategy implements AllocationStrategy without changing the bureau or existing algorithms.
The client configuration is updated to offer the new option.

Constructors reject null or blank text and negative workload. The bureau rejects null evidence.
SpecializationStrategy reports whether it found a specialist or used its fallback.

RoundRobinStrategy synchronizes selection to protect its counter when called concurrently with the same fixed detective list.
The application as a whole is a single-threaded console program; workload updates and strategy changes are not synchronized.
