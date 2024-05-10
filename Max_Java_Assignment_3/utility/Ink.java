package utility;
import objects.Shelter;
import java.util.Scanner;
import java.util.ArrayList;
import objects.Pet;

public class Ink {
  private Scanner input = new Scanner(System.in);
  private int choice;
 
  final String red = "\u001B[31m";
  final String green = "\u001B[32m";
  final String yellow = "\u001B[33m";
  final String blue = "\u001B[34m";
  final String magenta = "\u001B[35m";
  final String reset = "\u001B[0m";
  
  public int validateMainMenu() {
    boolean valid = false;

    while(!valid) {
      System.out.println(blue + "\n##### " + reset + yellow + " MAIN MENU " + reset + blue + " #####\n" + reset);
      System.out.println("(1) View Pets\n(2) Shelter Details\n(3) Book Appointment\n(4) Check your Appointments\n" + //
                "(5)" + red + " Exit\n" + reset);
      try {
        choice = input.nextInt();
        if(choice >= 1 && choice <=5) {
          valid = true; // escapes loop only if choice is correct dt and range
        }
        else {
          System.out.println(magenta + "\nPlease enter a 1 - 5\n" + reset);
        }
      } 
      catch (Exception e) { // runs on exception
        System.out.println(magenta + "\nThat's not a number!\n" + reset);
      } 
      finally { // always runs!
        input.nextLine();
      }
    } // while
    return choice;
  } // printMenu()

  public void printPetDetails(Pet pet) {
    System.out.printf(yellow + "\nName:" + reset + " %s\n", pet.getName());
    System.out.printf(yellow + "Age:" + reset + " %d\n", pet.getAge());
    System.out.printf(yellow + "Breed: " + reset + "%s\n", pet.getBreed());
    System.out.printf(yellow + "Color: " + reset + "%s\n", pet.getColor());
    System.out.printf(yellow + "Owner: " + reset + "%s\n", pet.getOwner());
    System.out.printf(yellow + "Is Adopted:" + reset + "%b\n", pet.getIsAdopted());
  } // printPetDetails()
  
  public void printAvailablePets(ArrayList<Pet> pets) {
    for(int i = 0; i < pets.size(); i++) {
      if(!pets.get(i).getIsAdopted()) {
        System.out.printf("\n(%d) " + yellow + "Name:" + reset + " %s " + yellow + "Type: " + reset + " %s " + yellow + "Age: " + reset + " %d \n", i + 1,
          pets.get(i).getName(), pets.get(i).getType(), pets.get(i).getAge());
      }
    } // for
    System.out.println(magenta + "\nEnter 0 to go back" + reset);
  } // printAvailablePets()

  public void printShelterDetails(Shelter shelter) {
    System.out.printf(yellow + "\nShelter Address: %s" + reset, shelter.getAddress());
    String[] hours = shelter.getHours();
    for(int i = 0; i < hours.length; i++) {
      System.out.println(hours[i]);
    } // for
    System.out.println(magenta + "Hit any key to go back\n" + reset);
  } // printShelterDetails


  public void printShelterDaysHours(Shelter shelter) {
    System.out.printf(yellow + "\nShelter Address: %s" + reset, shelter.getAddress());
    String[] hours = shelter.getHours();
    for(int i = 0; i < hours.length; i++) {
      System.out.println(hours[i]);
    }
  }

  public void printAppointmentMenu(){
    System.out.println(magenta + "\nWhich day you would like to book your appointment?"+ reset);
    System.out.println("1) " + magenta + "Monday" + reset);
    System.out.println("2) " + magenta + "Tuesday" + reset);
    System.out.println("3) " + magenta + "Wednesday" + reset);
    System.out.println("4) " + magenta + "Thursday" + reset);
    System.out.println("5) " + magenta + "Friday" + reset);
    System.out.println("  " + red + "Weekend is Off day for our little friends\n" + reset);
  }
} // class