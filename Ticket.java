public class Ticket {
    private int row;
    private int seat;
    private double price;
    private Person person;


    public Ticket(int row,int seat,double price,Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    public Ticket(int row,int seat){   // constructor overloading to Ticket ticketToRemove = new Ticket(row, seat);
        this.row = row;
        this.seat = seat;
    }

    public Ticket() {

    }


    public void print(){
        passValuesForRows(getRow());
        System.out.println("Row: " + getRow() + " | Seat: " + getSeat() + " | Price: " + getPrice() + " | Customer: " + person.getName() + " " + person.getSurname() + " (email: " + person.getEmail() + ")\n");

    }

    private void passValuesForRows(int rowNo) {    // assigning price for each row
        if (rowNo ==1){
            setPrice(100);
        } else if (rowNo==2) {
            setPrice(200);
        }else{
            setPrice(300);
        }

    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        if (row > 4){
            System.out.println("there are only 3 rows available");
        }else{
            this.row = row;
        }

    }
    // ==============getters and setters============
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPearson() {
        return person;
    }

    public void setPearson(Person person) {
        this.person = person;
    }

    // =================getters and setters======================

    // equal method inherit by object class to check the equals of seatNo and row no when cancelling ticket
    public boolean equals(Object obj) {
        if (obj instanceof Ticket) {
            Ticket other = (Ticket) obj;  // cast obj to Ticket type
            return row == other.row && seat == other.seat;
        }
        return false;
    }

}

