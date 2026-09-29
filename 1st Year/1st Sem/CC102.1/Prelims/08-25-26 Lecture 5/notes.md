# Java Fundamentals Review
## Printing -> Variables and Data Types -> Scanner input

## 1. Java program anatomy
- System.out sends output stream to terminal
- println prints and moves to the next line
- String literals are inside double quotes
- Semicolons end statements
- Arithmetic in System.out.println is in parentheses, so it isn't a string literal

## 2. println() vs. print()
1. System.out.println() Prints with a line break
2. System.out.print prints on the same line

## 3. Variables & Data Types
    - char
    - int
    - double
    - boolean
    - String

## 4. Variable Operations and Mutation
### 1.
    String name = "Juan";

    int age = 18;

    System.out.println("Name: " + name);  
    System.out.println("Age " + age);

### Output:
    Name: Juan
    Age: 18

### 2.
    int score = 10;
    System.out.println(score);

    int score = 20;
    System.out.println(score);

### Output:
    10  
    20

## 4. Why do we need Scanner?
- Hardcoded values are bad to use, and inflexible
- Scanner is needed for dynamic user input

### Example:
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            // And then the code
        }
    }

input is a Scanner object that inherits from System.in (to take in input)

## 5. Reading input data types
    int age = input.nextInt();
    double grade = input.nextDouble();
    String name = input.nextLine();

### Pattern
1. Ask
2. Read
3. Display


