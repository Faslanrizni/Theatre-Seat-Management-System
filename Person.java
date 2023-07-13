public class Person {
    private   String name;    /* we are unable to put static for instance because we cant print details in show_tickets_info()*/
    private  String surname;
    private  String email;
   public Person(String name,String surname,String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public Person() {

    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
