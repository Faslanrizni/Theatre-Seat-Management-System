import java.io.*;
import java.util.*;

import static sun.misc.Version.print;

public class Theatre {
    //declaring and initializing 3 arrays for 3 rows
    // arrays ara global for code
    static Integer[] Row1 = new Integer[12];
    static Integer[] Row2 = new Integer[16];
    static Integer[] Row3 = new Integer[20];

    //declaring and initializing 3 arrays for 3 rows

    static ArrayList<Ticket> saveTickets = new ArrayList<>();  // arraylist for save customer information

    //=========================main method===================
    public static void main(String[] args) throws IOException {


        initializeArraysWithZero(Row1);
        initializeArraysWithZero(Row2);
        initializeArraysWithZero(Row3);

        boolean keepGoing = false;
        System.out.println("Welcome to new Theatre");
        System.out.println("-------------------------------------------------");

        while (!keepGoing) {
            userOptions();
            System.out.print("Enter the option you need to select: ");
            switchUserOptions();
        }
    }
    //=========================main method===================

    //====initialize arrays with zero to indicate free seats====
    private static void initializeArraysWithZero(Integer[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = 0;
        }
    }

    //====initialize arrays with zero to indicate free seats====
    private static void userOptions() {
        System.out.println("1) Buy a ticket \n" +
                "2) Print seating area \n" +
                "3) Cancel ticket \n" +
                "4) List available seats \n" +
                "5) Save to file \n" +
                "6) Load from file \n" +
                "7) Print ticket information and total price \n" +
                "8) Sort tickets by price \n" +
                " 0) Quit "
        );
        System.out.println("--------------------------------------------------");

    }

    private static void switchUserOptions() throws IOException {
        Scanner input = new Scanner(System.in);
        int userOptions;
        while (true){

            String userInput = input.nextLine();
            try {
                userOptions = Integer.parseInt(userInput);
                if(userOptions >= 0 && userOptions <=8){
                    break;
                }else {
                    System.out.print("Enter a valid number: ");   // display when input range is incorrect
                }


            }catch (NumberFormatException e){
                System.out.print("Enter a valid number : ");   // display when user entered a sting input
            }
        }

        switch (userOptions) {
            case 1:
                buy_ticket();
                break;
            case 2:
                print_seating_area();
                break;
            case 3:
                cancel_ticket();
                break;
            case 4:
                show_available();
                break;
            case 5:
                save();
                break;
            case 6:
                load();
                break;
            case 7:
                show_tickets_info();
                break;
            case 8:
                sort_tickets();
                break;
            case 0:
                System.out.println("Have a good day!!..");
                System.exit(0);

            default:
                System.out.println("invalid input enter valid number");

        }
    }
    //===================buy ticket process=====================
//    static Ticket ticket = new Ticket();
    public static void buy_ticket() {
        Ticket ticket = new Ticket();
        Person person = new Person();

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        person.setName(input.nextLine());

        System.out.print("Enter second name: ");
        person.setSurname(input.nextLine());

        System.out.print("Enter email: ");
        person.setEmail(input.nextLine());


        int option;
        while (true){
            String[] Rows = {
                    "1) Row 1",
                    "2) Row 2",
                    "3) Row 3"
            };
            for (String rowChoice : Rows) {
                System.out.println(rowChoice);
            }
            System.out.print("Enter row number: ");
            String userInput = input.nextLine();
            try {
                option = Integer.parseInt(userInput);
                if(option > 0 && option <=3){
                    break;

                }else {
                    System.out.print("Enter valid option: \n");
                }
            }catch (NumberFormatException e){
                System.out.print("Enter valid option: \n");

            }
        }
        ticket.setRow(option); // set option to setRow inside in the ticket object
        int seatNo;
        switch (option) {
            case 1:
                seatNo=bookRow(Row1);
                ticket.setSeat(seatNo); // set seatNo to setSeat inside in the ticket object
                break;
            case 2:
                seatNo=bookRow(Row2);
                ticket.setSeat(seatNo);
                break;
            case 3:
                seatNo=bookRow(Row3);
                ticket.setSeat(seatNo);
                break;
            default:
                System.out.println("Invalid input");
        }
        ticket.setPearson(person);
        saveTickets.add(ticket);
    }



    public static int bookRow(Integer[] row) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the seat number on row ");
        int seatNo;
        while (true){
            String userInput = input.nextLine();
            try {
                seatNo = Integer.parseInt(userInput);
                if(seatNo >=1 && seatNo<=20 ){
                    break;
                }else {
                    System.out.print("Enter valid input: ");
                }

            }catch (NumberFormatException e){
                System.out.print("Enter valid input: ");

            }
        }
        if (row[seatNo - 1] == 0) {
            System.out.println("seat is booked successfully");
            row[seatNo - 1] = 1;
        } else {
            System.out.println("seat is sold out");
        }
        return seatNo; // return seatNo ,seatNo called in side in the buy_ticket method
    }
    //=================buy ticket process=======================
    //=================print seating area========================
   public static void passingRowsForPrintSeating(Integer[] Row) {
       for (int i = 0; i < Row.length; i++){
           String printSeating="";  //
           for (int k : Row){
               if(k == 0){
                   printSeating+="O";
               }else{
                   printSeating+="X";
               }
           }
             // formatting for to get printseating pattern
           System.out.format("%12s",printSeating.substring(0,printSeating.length()/2));
           System.out.format("%-1s"," "+printSeating.substring((printSeating.length()/2)),printSeating.length()+1);
           System.out.println();
           break;
       }
    }

    public static void print_seating_area() {

        System.out.format("%20s","***********\n");
        System.out.format("%20s","*  stage  *\n");
        System.out.format("%20s","***********\n");


        passingRowsForPrintSeating(Row1);
        passingRowsForPrintSeating(Row2);
        passingRowsForPrintSeating(Row3);
    }

    //=================print seating area==========================
    // ===================cancel ticket============================

    public static void cancel_ticket() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the row to cancel ticket: ");
        int row = input.nextInt();
        System.out.print("Enter the seat number to cancel ticket: ");
        int seat = input.nextInt();

        Ticket ticketToRemove = new Ticket(row, seat);
        boolean removed = saveTickets.remove(ticketToRemove);
        if (removed) {
            System.out.println("Ticket removed successfully!");
            switch (row) {
                case 1:
                    Row1[seat-1] = 0;
                    break;
                case 2:
                    Row2[seat-1] = 0;
                    break;
                case 3:
                    Row3[seat-1] = 0;
                    break;
                default:
                    System.out.println("Invalid row!");
            }
        } else {
            System.out.println("No matching ticket found to remove!");
        }
    }

    //=====================cancel ticket====================================
    // ====================code for show available=========================
    public static void passingRowsForShowAvailable(Integer[] Row) {
        for (int i = 0; i < Row.length; i++) {
            if (Row[i] != null && Row[i] == 0) {
                System.out.print(i + 1 + ", ");
            }
        }
        System.out.print("\b\b");
        System.out.println('\n');
    }

    public static void show_available() {
        System.out.print("Seats available in row 1:");
        passingRowsForShowAvailable(Row1);
        System.out.print("seats available in row 2 :");
        passingRowsForShowAvailable(Row2);
        System.out.print("seats available in row 3:");
        passingRowsForShowAvailable(Row3);
    }
    //================code for show available=========================


    //=================save to file===================================

    public static void save() throws IOException {
        FileWriter fos = new FileWriter("save.txt");
        fos.write("0 indicates free seats and 1 indicate sold seats" + "\n");
        fos.write("Row 1 Available seats: ");
        fos.write(Arrays.toString(Row1).replaceAll("\\[|\\]", "") + "\n");
        fos.write("Row 2 Available seats: ");
        fos.write(Arrays.toString(Row2).replaceAll("\\[|\\]", "") + "\n");
        fos.write("Row 3 Available seats: ");
        fos.write(Arrays.toString(Row3).replaceAll("\\[|\\]", "") + "\n");
        fos.close();
        System.out.println("successfully saved to text file");

    }
    //=================save to file=====================================

    //================= load to file=====================================
    public static void load() throws IOException {
        FileReader fr = new FileReader("save.txt");
        int code = fr.read();
        while (code != -1) {
            System.out.print((char) code);

            code = fr.read();
        }
    }
    //================= load to file=====================================
    //=================show ticket info==================================
    public static void show_tickets_info() {
        double total = 0;
        for (Ticket content : saveTickets){
            content.print();
        }
        for (Ticket M : saveTickets){
            total = total + M.getPrice();
        }
        System.out.println("Total amount of Ticket: "+total);


    }
    //=================show ticket info==================================
    // sorted by sort() method inherited in object class
/*    public static void sort_tickets() {
        ArrayList<Ticket> sortedTickets = new ArrayList<>(saveTickets);
        sortedTickets.sort(Comparator.comparingDouble(Ticket::getPrice));
        System.out.println("Sorted tickets by price:");
        for (Ticket ticket : sortedTickets) {
            ticket.print();
        }
    }*/
    // ==========sorted customer information by price====================
    static void sort_tickets(){             // referenced by week8 sort search pdf- selection sort

        int minIndex;
        Ticket temp;
        for(int start = 0; start < saveTickets.size()-1; start++) {
            minIndex = start;
            for(int i = start+1; i <= saveTickets.size()-1; i++) {
                if(saveTickets.get(i).getPrice() < saveTickets.get(minIndex).getPrice()) minIndex = i;
            }
            temp = saveTickets.get(start);
            saveTickets.set(start,saveTickets.get(minIndex));
            saveTickets.set(minIndex,temp);

        }
        System.out.println("Sorted tickets by price:");
        for(Ticket element:saveTickets){
            element.print();
        }
    }
    // ==========sorted customer information by price====================
}











