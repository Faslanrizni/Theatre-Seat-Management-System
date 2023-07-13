# Theatre Seat Management System

This repository contains the coursework solution for the Software Development module, focusing on designing and implementing a Java program to manage and control seat sales in a theatre session. The program allows users to buy tickets, cancel tickets, view available seats, save and load data, and perform other related operations.

## Context

The program is developed for a theatre company called 'New Theatre'. The theatre has three rows, each with a different number of seats: 12, 16, and 20. The main objective is to keep track of the seats that have been sold and the seats that are still available.

## Features

- Welcome message displayed at program start.
- Menu-driven interface with eight options for different operations.
- Ability to buy tickets, cancel tickets, and view seating area.
- Printing available seats and saving/loading data to/from a file.
- Handling ticket information including the name, surname, email, row, seat, and price of the ticket.
- Sorting tickets by price and displaying ticket information with the total price.

## Implementation

The program is divided into two parts:

### Part A: Main Program 

- Task 1: Initializes the program with a floorplan of the theatre and sets all seats as free.
- Task 2: Implements a menu for users to select different options.
- Task 3: Allows users to buy tickets by selecting a row and seat.
- Task 4: Prints the seating area, showing sold seats as 'X' and available seats as 'O'.
- Task 5: Cancels a ticket and makes the seat available again.
- Task 6: Displays available seats for each row.
- Task 7: Saves the seating information to a file.
- Task 8: Loads the seating information from a file.

### Part B: Classes and Objects 

- Task 9: Implements a Person class with attributes for name, surname, and email.
- Task 10: Implements a Ticket class with attributes for row, seat, price, and Person.
- Task 11: Adds a print method to the Ticket class to display ticket information.
- Task 12: Manages tickets using an ArrayList and updates buy_ticket and cancel_ticket methods accordingly.
- Task 13: Shows ticket information and calculates the total price.
- Task 14: Sorts tickets by price in ascending order and prints the sorted ticket information.

## Usage

To use the program, follow these steps:

1. Clone the repository to your local machine.
2. Open the project in an IDE (IntelliJ IDEA or Netbeans recommended).
3. Build and run the program.
4. Follow the on-screen instructions to perform various operations using the menu options.

Please refer to the inline comments ,method documentation and coursework specification for further details on the implementation.


