
Smart Loan Decision System

The Smart Loan Decision System is designed to help users make informed decisions about loans. It includes:

A Java-based GUI application for an interactive user experience.
A COBOL-based command-line application for backend loan calculation.
Both implementations allow users to:

Select a loan type (e.g., Home Loan, Car Loan).
Input loan details (amount, interest rate, tenure).
Calculate the EMI.
Java Implementation

The Java implementation is a Swing-based GUI application with multiple screens:

Welcome Page: Displays a welcome message and a "Next" button.
Loan Selection Page: Allows users to select a loan type.
Loan Calculator Page: Prompts users for loan details and calculates the EMI.
Java File Structure

Main.java: Entry point of the application.
UIManager.java: Manages the navigation between pages.
WelcomePage.java: Displays the welcome screen.
LoanSelectionPage.java: Displays loan options.
LoanCalculatorPage.java: Handles loan details input and EMI calculation.
How to Run Java

Ensure you have Java Development Kit (JDK) installed.
Compile the Java files:
bash
Copy
javac *.java
Run the application:
bash
Copy
java Main
Use the GUI to navigate through the pages and calculate EMI.
COBOL Implementation

The COBOL implementation is a command-line application that mimics the functionality of the Java GUI. It provides a text-based interface for loan selection and EMI calculation.

COBOL File Structure

LoanSystem.cbl: The main COBOL program that handles the loan selection and EMI calculation.
How to Run COBOL

Ensure you have a COBOL compiler (e.g., GnuCOBOL) installed.
Compile the COBOL program:
bash
Copy
cobc -x LoanSystem.cbl
Run the compiled program:
bash
Copy
./LoanSystem
Follow the on-screen prompts to select a loan type, input loan details, and view the EMI.
Features
