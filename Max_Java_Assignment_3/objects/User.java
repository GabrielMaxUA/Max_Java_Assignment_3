package objects;
import utility.Ink;
import java.util.Scanner;

public class User {
  final String red = "\u001B[31m";
  final String magenta = "\u001B[35m";
  final String reset = "\u001B[0m";
  private String name;
  private String email;
  private int phone;
  private Shelter shelter = new Shelter();
  private String appointment;
  private Ink ink = new Ink();
  private Scanner input = new Scanner(System.in);
  private int choice;
  final String blue = "\u001B[34m";

  public User(String name, String email, int phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
  } // constructor

  //===============>>
  // GETTERS
  public String getName() {
    return this.name;
  }
  public String getEmail() {
    return this.email;
  }
  public int getPhone() {
    return this.phone;
  }

  public String getAppointment(){
    return appointment;
  }

  //===============>>
  // SETTERS
  public void setName(String name) {
    this.name = name;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setPhone(int phone) {
    this.phone = phone;
  }

  public int validateAppointment() {
    boolean valid = false;
    while(!valid){
      ink.printShelterDaysHours(shelter);
      ink.printAppointmentMenu();
      try {
       choice = input.nextInt();
        if(choice >= 1 && choice <=5) {
          appointment = shelter.getHours()[choice - 1];  
          System.out.printf(magenta + "Mr./Mrs " + blue + "%s." + reset + magenta + " Your  appointment is set for:" +
          red +" %s.\n" +  magenta + "Press any key to return to main menu\n" + reset, getName(), appointment);
          valid = true;
        }
        else {
          System.out.println(red + "Please choose a valid day of operation" + reset);
        }
      } 
      catch (Exception e) { // runs on exception
        System.out.println(red + "\nThat's not a number!Please try again\n" + reset);
      } 
      finally { // always runs!
        input.nextLine();
      }
    } 
    return choice;
  }

} // class