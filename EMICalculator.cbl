       IDENTIFICATION DIVISION.
       PROGRAM-ID. EMI-CALCULATOR.
       AUTHOR. PUSHKAR ANAND.
       
       DATA DIVISION.
       WORKING-STORAGE SECTION.
       01 LOAN-AMOUNT PIC 9(10)V99.
       01 ANNUAL-RATE PIC 9(3)V99.
       01 LOAN-MONTHS PIC 9(5).
       01 MONTHLY-RATE PIC 9(5)V99.
       01 EMI PIC 9(10)V99.
       01 TOTAL-PAYMENT PIC 9(10)V99.
       01 TOTAL-INTEREST PIC 9(10)V99.
       01 TEMP1 PIC 9(10)V99.
       01 TEMP2 PIC 9(10)V99.
       
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           DISPLAY "Enter Loan Amount (₹): ".
           ACCEPT LOAN-AMOUNT.
           
           DISPLAY "Enter Rate of Interest (% per year): ".
           ACCEPT ANNUAL-RATE.
           
           DISPLAY "Enter Loan Term (months): ".
           ACCEPT LOAN-MONTHS.
           
           COMPUTE MONTHLY-RATE = (ANNUAL-RATE / 12) / 100.
           
           COMPUTE TEMP1 = (1 + MONTHLY-RATE) ** LOAN-MONTHS.
           COMPUTE TEMP2 = (LOAN-AMOUNT * MONTHLY-RATE * TEMP1) / (TEMP1 - 1).
           COMPUTE EMI = TEMP2.
           
           COMPUTE TOTAL-PAYMENT = EMI * LOAN-MONTHS.
           COMPUTE TOTAL-INTEREST = TOTAL-PAYMENT - LOAN-AMOUNT.
           
           DISPLAY "Loan EMI (₹): " EMI.
           DISPLAY "Total Interest (₹): " TOTAL-INTEREST.
           DISPLAY "Total Payment (₹): " TOTAL-PAYMENT.
           
           STOP RUN.
