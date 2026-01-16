# OSv1 - Multi-Threading OS Simulator

## Overview
OSv1 is a Java-based Operating System simulator designed to demonstrate process scheduling and execution in a multi-core environment. It implements a Master-Slave architecture where a **Master Core** handles process scheduling and two **Slave Cores** execute the instructions.

The system simulates an operating system's ability to load programs from text files, manage memory (variables) for each process, and schedule them using various algorithms.

## Features
- **Dual-Core Execution**: Simulates two slave cores (Core1, Core2) executing processes concurrently.
- **Scheduling Algorithms**:
  - **Round Robin (RR)**: Time-slice based scheduling.
  - **Shortest Job First (SJF)**: Prioritizes processes with shortest burst time.
- **Memory Management**: Isolated variable storage for each process ID.
- **Custom Instruction Set**: Interprets a simple assembly-like language.

## Architecture
- **MasterCore**: The main scheduler thread that manages the `ReadyQueue` and assigns processes to slave cores.
- **SlaveCore**: Worker threads that execute the actual instructions of a process.
- **Process**: Represents a loaded program with its instructions and burst time.
- **PCB (Process Control Block)**: Tracks the state of a process, including Program Counter (PC) and Process ID.
- **Memory**: A shared memory simulation that stores variables for each process.

## Supported Instructions
The simulator supports text-based program files with the following commands:

- **Input**: Assign a value from user input to a variable.
  ```
  assign <variable> input
  ```
- **Arithmetic**: Perform operations (`add`, `subtract`, `multiply`, `divide`).
  ```
  assign <result_var> <operation> <operand1> <operand2>
  ```
- **Output**: Print the value of a variable.
  ```
  print <variable>
  ```

### Example Program (`Program_2.txt`)
```text
assign a input
assign b input
assign c subtract a b
print c
assign c add a b
print c
```

## Prerequisites
- **Java**: JDK 22 or higher.
- **Maven**: For dependency management and building.

## Scheduling Demonstration
The `Main` class demonstrates different scheduling scenarios:
1. **Shortest Job First**: Runs `ShortestJobFirst()`.
2. **Round Robin**: Runs `roundRobin(quantum)`.
