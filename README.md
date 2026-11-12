# Factory-Robot-Hazard-Analyzer


## 1. Introduction

The **Factory Robot Hazard Analyzer** is a simple Java-based application designed to identify possible safety risks when industrial robots work inside a factory.

Factories use robots to perform tasks such as lifting heavy materials, welding, assembling products, and moving objects. Although these robots make work faster and easier, they can sometimes create safety risks for nearby workers.

For example:
- A robot with poor arm precision may accidentally hit a nearby worker.
- A factory with too many workers near a robot may have a higher chance of accidents.
- Old or damaged machinery may increase the possibility of safety problems.

This project takes these factors as input and calculates a **Robot Hazard Risk Score**.

The project is developed step by step using eight use cases (UC1–UC8). Each use case introduces a new programming concept and gradually improves the application.

---

## 2. Why Is This Project Needed?

Imagine a factory where a robot is working near human workers.

Before allowing the robot to operate, we should consider three important factors:

1. **Arm Precision:** How accurately can the robot move its arm?
2. **Worker Density:** How many workers are present in the robot's working area?
3. **Machinery State:** What is the current condition of the robot's machinery?

By considering these factors, the application calculates a numerical risk score.

The main purpose of this project is to demonstrate how a simple Java program can collect information, validate it, process it, and handle incorrect inputs safely.

---

## 3. Project Objectives

The main objectives are:

- To understand the basic structure of a Java application.
- To accept input from users.
- To calculate a hazard risk score using a mathematical formula.
- To validate user inputs before processing them.
- To understand conditional statements and methods.
- To create and handle custom exceptions.
- To separate business logic from user interaction.
- To develop a modular application using Object-Oriented Programming (OOPS) concepts.
- To write and execute unit tests using JUnit 5.

---

## 4. Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Main programming language |
| Maven | Project management and dependency handling |
| JUnit 5 | Testing the application |
| IntelliJ IDEA / VS Code | Writing and executing Java code |
| Git | Tracking code changes |
| GitHub | Hosting and managing the project repository |

---

## 5. Understanding the Basic Inputs

The application requires three inputs from the user.

### A. Arm Precision

Arm precision represents how accurately the robot can move its arm.

- A value closer to `1.0` represents better precision.
- A value closer to `0.0` represents lower precision.

**Valid range:** 0.0 to 1.0

Examples:

| Arm Precision | Meaning |
|---|---|
| 1.0 | Very high precision |
| 0.8 | Good precision |
| 0.5 | Medium precision |
| 0.2 | Low precision |
| 0.0 | Very low precision |

### B. Worker Density

Worker density represents the number of workers present in the robot's working area.

For this project, the accepted range is 1 to 20.

| Worker Density | Meaning |
|---|---|
| 1–5 | Low worker density |
| 6–10 | Moderate worker density |
| 11–15 | High worker density |
| 16–20 | Very high worker density |

These descriptions are illustrative categories for the project, not official safety classifications.

### C. Machinery State

Machinery state represents the current condition of the robot's machinery.

The application supports only three states:

| Machinery State | Risk Factor | Meaning |
|---|---:|---|
| Worn | 1.3 | Machinery shows signs of wear |
| Faulty | 2.0 | Machinery has faults |
| Critical | 3.0 | Machinery is in a critical condition |

**Important:** The machinery state is case-sensitive.

For example:
- `Worn` is valid.
- `worn` is invalid.
- `Normal` is invalid.

---

## 6. Hazard Risk Calculation

The application calculates the hazard risk using the following formula:

**Hazard Risk Score =**

`((1.0 - Arm Precision) × 15.0) + (Worker Density × Machinery Risk Factor)`

### Understanding the Formula

The formula contains two parts:

**Part 1: Arm Precision Risk**

`(1.0 - Arm Precision) × 15.0`

This calculates the risk contribution from the robot's arm precision.

When arm precision decreases, this part of the risk score increases.

**Part 2: Machinery and Worker Risk**

`Worker Density × Machinery Risk Factor`

This calculates the risk contribution based on the number of workers and the machinery condition.

A higher worker density or machinery risk factor increases this part of the score.

### Example Calculation

Suppose the user enters:

- Arm Precision = 0.5
- Worker Density = 10
- Machinery State = Critical
- Machinery Risk Factor = 3.0

Applying the formula:

`Risk = ((1.0 - 0.5) × 15.0) + (10 × 3.0)`

`Risk = (0.5 × 15.0) + 30`

`Risk = 7.5 + 30`

**Final Hazard Risk Score = 37.5**

### Example Risk Scores

| Arm Precision | Worker Density | Machinery State | Risk Score |
|---:|---:|---|---:|
| 0.5 | 10 | Worn | 20.5 |
| 0.5 | 10 | Faulty | 27.5 |
| 0.5 | 10 | Critical | 37.5 |

The score is a numerical output of the project's formula. The application does not currently define official low-, medium-, or high-risk thresholds.

---

## 7. Understanding the Eight Use Cases (UC1–UC8)

The project is developed through eight use cases. Each use case improves the previous version by introducing a new programming concept.

### UC1: Display Static Hazard Message

**Goal:** Display a message explaining the purpose of the application.

**What happens?**

1. The user runs the program.
2. The program displays the message.
3. The program exits.

**Example Output:**

`Factory Robot Hazard Analyzer`

**Concepts Used:**
- Class and main() method
- Print statements
- String literals
- Program execution

**Learning:** Understanding how a Java program starts and displays information.

---

### UC2: Accept User Inputs

**Goal:** Collect the required information from the user.

**What happens?**

1. The program asks for arm precision.
2. The program asks for worker density.
3. The program asks for machinery state.
4. The entered values are accepted and displayed.

**Concepts Used:**
- Scanner class
- User input
- Variables
- Data types
- String handling

**Learning:** Understanding how to accept information from users using Java.

---

### UC3: Calculate Hazard Risk

**Goal:** Calculate the robot hazard risk score using the given inputs.

**What happens?**

1. The program accepts the three inputs.
2. It identifies the machinery risk factor.
3. It applies the hazard calculation formula.
4. It displays the final risk score.

**Concepts Used:**
- Arithmetic operators
- Conditional statements
- Methods
- Parameters
- Return values

**Learning:** Understanding how input values can be processed using mathematical operations.

---

### UC4: Introduce Validation Using Conditional Logic

**Goal:** Prevent invalid input values from being used in calculations.

**What happens?**

1. The program checks arm precision.
2. It checks worker density.
3. If an input is invalid, an error message is displayed.
4. If the inputs are valid, the program calculates the risk.

**Validation Rules:**

| Input | Valid Range |
|---|---|
| Arm Precision | 0.0 to 1.0 |
| Worker Density | 1 to 20 |

**Concepts Used:**
- If-else statements
- Input validation
- Conditional logic
- Defensive programming

**Learning:** Understanding why input validation is important before performing calculations.

**Limitation:** Keeping all validation conditions inside the main method makes the code longer and harder to maintain.

---

### UC5: Refactor Validation into a Separate Method

**Goal:** Move validation and calculation logic into a separate method.

**What happens?**

1. The main method collects user inputs.
2. It calls the `calculateHazardRisk()` method.
3. The method validates the inputs.
4. If valid, it calculates and returns the risk score.

**Concepts Used:**
- Method abstraction
- Parameters
- Return values
- Separation of concerns
- Code reusability

**Learning:** Understanding how methods make code cleaner and easier to maintain.

**Improvement:** The main method becomes shorter because validation and calculation are moved into a separate method.

---

### UC6: Introduce Custom Exception – RobotSafetyException

**Goal:** Handle invalid inputs using a custom exception.

**What happens?**

1. A custom exception class named `RobotSafetyException` is created.
2. The calculation method validates the inputs.
3. If an input is invalid, it throws the custom exception.
4. The main method catches the exception and displays its message.

**Custom Exception:**

`RobotSafetyException extends Exception`

**Concepts Used:**
- Custom exception creation
- Exception inheritance
- throw keyword
- throws keyword
- try-catch blocks

**Learning:** Understanding how Java handles errors using custom exceptions.

**Improvement:** Instead of returning a temporary value such as `-1`, the application now uses a proper exception to represent invalid scenarios.

---

### UC7: Machinery State Risk Mapping

**Goal:** Handle machinery risk factors using structured conditional logic.

**What happens?**

1. The program checks the machinery state.
2. It maps the state to its corresponding risk factor.
3. The risk factor is used in the hazard calculation.
4. If an unsupported state is entered, a custom exception is thrown.

**Machinery Mapping:**

| State | Risk Factor |
|---|---:|
| Worn | 1.3 |
| Faulty | 2.0 |
| Critical | 3.0 |

**Concepts Used:**
- Constants and enums (conceptually)
- Case-sensitive string comparison
- Business rule encapsulation
- Custom exception handling

**Learning:** Understanding how business rules can be implemented using structured conditions.

**Improvement:** The application now rejects unsupported machinery states instead of silently assigning an incorrect risk factor.

---

### UC8: Fully Modular and OOPS-Compliant Hazard Analyzer

**Goal:** Develop a clean, modular, and extensible application.

**What happens?**

1. The main class collects user inputs.
2. The `RobotHazardAuditor` class handles business logic.
3. The auditor validates the inputs.
4. The machinery state is mapped to its risk factor.
5. Invalid scenarios throw `RobotSafetyException`.
6. The main method catches exceptions and displays the result.

**Concepts Used:**
- Encapsulation
- Abstraction
- Modularity
- Separation of concerns
- Exception handling
- Code reusability

**Learning:** Understanding how to organize a Java application into separate classes, each with a specific responsibility.

**Improvement:** User interaction, business logic, and exception handling are separated, making the application easier to understand, test, and extend.

---

## 8. Final Project Structure

After completing UC8, the project has the following structure:

```text
Factory-Robot-Hazard-Analyzer
│
├── src
│   │
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── factory
│   │               └── robot
│   │                   │
│   │                   ├── FactoryRobotHazardAnalyzer.java
│   │                   ├── RobotHazardAuditor.java
│   │                   └── RobotSafetyException.java
│   │
│   └── test
│       └── java
│           └── com
│               └── factory
│                   └── robot
│                       │
│                       └── FactoryRobotHazardAnalyzerTest.java
│
├── pom.xml
└── README.md
```

### Explanation of Each File

| File | Responsibility |
|---|---|
| FactoryRobotHazardAnalyzer.java | Accepts user input and displays the result |
| RobotHazardAuditor.java | Validates inputs, maps machinery states, and calculates risk |
| RobotSafetyException.java | Defines the custom exception for invalid scenarios |
| FactoryRobotHazardAnalyzerTest.java | Contains JUnit test cases |
| pom.xml | Manages project configuration and dependencies |
| README.md | Explains the project and its working |

---

## 9. Understanding the Application Architecture

The final application follows a simple modular structure.

```text
             USER
               |
               v
  FactoryRobotHazardAnalyzer
       (Main Class)
               |
               | Accepts Inputs
               |
               v
       RobotHazardAuditor
        (Business Logic)
               |
        -----------------
        |               |
        v               v
   Validation      Risk Mapping
        |               |
        -----------------
               |
               v
       Calculate Risk
               |
        ----------------
        |              |
     Valid          Invalid
        |              |
        v              v
   Return Score   RobotSafetyException
        |              |
        v              v
   Display Score   Catch Exception
```

This structure ensures that every class has a specific responsibility.

---

## 10. Object-Oriented Programming Concepts Used

The final application demonstrates important OOPS concepts.

| OOPS Concept | How It Is Used |
|---|---|
| Encapsulation | Machinery risk mapping is kept private inside the auditor class |
| Abstraction | The main class uses the auditor's calculation method without handling its internal logic |
| Inheritance | `RobotSafetyException` inherits from Java's `Exception` class |
| Polymorphism | Not explicitly demonstrated in the current implementation |

**Important:** The project demonstrates selected OOPS principles. It does not need to use every OOPS concept to be modular.

---

## 11. How to Run the Project

### Prerequisites

Make sure the following software is installed:

- Java JDK 21 or later
- Apache Maven
- IntelliJ IDEA or VS Code
- Git (optional, for version control)

### Step 1: Clone the Repository

Open your terminal and execute:

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

Replace the placeholder with your actual GitHub repository URL.

### Step 2: Open the Project

Open the cloned project folder in IntelliJ IDEA or VS Code.

### Step 3: Check Java Version

```bash
java --version
```

### Step 4: Run the Application

Using Maven, compile the project:

```bash
mvn compile
```

Then run the main class from your IDE:

`FactoryRobotHazardAnalyzer.java`

### Step 5: Run Unit Tests

Execute:

```bash
mvn test
```

This command compiles and executes the JUnit test cases.

---

## 12. Sample Application Execution

### Example 1: Valid Input

```text
Enter Arm Precision (0.0 - 1.0):
0.5

Enter Worker Density (1 - 20):
10

Enter Machinery State (Worn/Faulty/Critical):
Critical

Arm Precision: 0.5
Worker Density: 10
Machinery State: Critical
Robot Hazard Risk Score: 37.5
```

### Example 2: Invalid Arm Precision

```text
Enter Arm Precision (0.0 - 1.0):
1.5

Enter Worker Density (1 - 20):
10

Enter Machinery State (Worn/Faulty/Critical):
Critical

Invalid Arm Precision! Enter a value between 0.0 and 1.0.
```

### Example 3: Invalid Worker Density

```text
Enter Arm Precision (0.0 - 1.0):
0.5

Enter Worker Density (1 - 20):
25

Enter Machinery State (Worn/Faulty/Critical):
Critical

Invalid Worker Density! Enter a value between 1 and 20.
```

### Example 4: Unsupported Machinery State

```text
Enter Arm Precision (0.0 - 1.0):
0.5

Enter Worker Density (1 - 20):
10

Enter Machinery State (Worn/Faulty/Critical):
Normal

Invalid Machinery State! Use Worn, Faulty, or Critical.
```

---

## 13. Unit Testing

JUnit 5 is used to verify whether the application works correctly.

The test cases cover:

| Test Case | Expected Behaviour |
|---|---|
| Valid user inputs | Accepts and displays inputs |
| Critical machinery | Calculates risk score as 37.5 |
| Worn machinery | Calculates risk score as 20.5 |
| Faulty machinery | Calculates risk score as 27.5 |
| Invalid arm precision | Throws custom exception |
| Invalid worker density | Throws custom exception |
| Unsupported machinery state | Throws custom exception |
| Lowercase machinery state | Throws custom exception |

**Expected Result:** All 8 test cases should pass.

Run the tests using:

```bash
mvn test
```

---

## 14. Advantages of the Project

1. **Simple Input Handling:** Accepts all required inputs from the user.
2. **Input Validation:** Prevents invalid values from being used in calculations.
3. **Exception Handling:** Uses a custom exception to handle invalid scenarios.
4. **Modular Structure:** Separates user interaction from business logic.
5. **Code Reusability:** The auditor class can be reused by other parts of an application.
6. **Easy Maintenance:** Changes to business rules can be made without unnecessarily modifying the main class.
7. **Testability:** JUnit test cases help verify the correctness of the application.

---

## 15. Limitations

- The risk calculation uses a simplified mathematical formula.
- The application accepts inputs through the command line only.
- It does not connect to real factory sensors or robot hardware.
- It does not store previous hazard analysis results.
- It does not provide a graphical user interface.
- It does not use official industrial safety standards or calibrated risk thresholds.

---

## 16. Future Enhancements

The project can be improved in the future by adding:

- A graphical user interface for easier interaction.
- Database integration to store hazard analysis records.
- Real-time data collection from industrial sensors.
- More machinery conditions and configurable risk factors.
- Enums for structured machinery state representation.
- Risk-level classification based on a properly defined safety model.
- Reports and dashboards for monitoring factory safety.

---

## 17. Conclusion

The Factory Robot Hazard Analyzer demonstrates how a basic Java program can gradually develop into a modular application.

Starting with simple print statements and user inputs, the project progresses through calculations, validation, custom exception handling, machinery risk mapping, and Object-Oriented Programming concepts.

The eight use cases help demonstrate the importance of writing clean, structured, reusable, and maintainable code.

**The main learning outcome of this project is understanding how to build a Java application step by step, from basic programming concepts to a modular OOPS-based implementation.**