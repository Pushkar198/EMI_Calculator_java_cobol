       IDENTIFICATION DIVISION.
       PROGRAM-ID. LoanSystem.
       DATA DIVISION.
       WORKING-STORAGE SECTION.
       01 User-Input          PIC X(1).
       01 Loan-Type           PIC 9(1).
       01 Loan-Amount         PIC 9(7)V99.
       01 Interest-Rate       PIC 9(2)V99.
       01 Loan-Tenure         PIC 9(2).
       01 Monthly-Interest    PIC 9(2)V99.
       01 EMI                 PIC 9(7)V99.

       PROCEDURE DIVISION.
       MAIN-LOGIC.
           PERFORM WELCOME-SCREEN.
           PERFORM LOAN-SELECTION-SCREEN.
           PERFORM LOAN-CALCULATOR-SCREEN.
           STOP RUN.

       WELCOME-SCREEN.
           DISPLAY "*******************************************".
           DISPLAY " Welcome to the Smart Loan Decision System!".
           DISPLAY " Your one-stop solution for making intelligent loan choices.".
           DISPLAY "*******************************************".
           DISPLAY "Press any key to continue...".
           ACCEPT User-Input.

       LOAN-SELECTION-SCREEN.
           DISPLAY "*******************************************".
           DISPLAY " Loan Type Selection".
           DISPLAY "*******************************************".
           DISPLAY "1. Home Loan".
           DISPLAY "2. Car Loan".
           DISPLAY "3. Personal Loan".
           DISPLAY "4. Education Loan".
           DISPLAY "Enter your choice (1-4): ".
           ACCEPT Loan-Type.

       LOAN-CALCULATOR-SCREEN.
           DISPLAY "*******************************************".
           DISPLAY " Loan Calculator".
           DISPLAY "*******************************************".
           DISPLAY "Enter Loan Amount: ".
           ACCEPT Loan-Amount.
           DISPLAY "Enter Interest Rate (%): ".
           ACCEPT Interest-Rate.
           DISPLAY "Enter Loan Tenure (years): ".
           ACCEPT Loan-Tenure.

           COMPUTE Monthly-Interest = Interest-Rate / 100 / 12.
           COMPUTE EMI = Loan-Amount * Monthly-Interest *
                         (1 + Monthly-Interest) ** (Loan-Tenure * 12) /
                         ((1 + Monthly-Interest) ** (Loan-Tenure * 12) - 1).

           DISPLAY "*******************************************".
           DISPLAY " EMI: ", EMI.
           DISPLAY "*******************************************".