import utility.*;
import objects.*;
import java.util.Scanner;

public class Adopt_a_pet {
   private static Scanner input = new Scanner(System.in);
   private static Ink ink = new Ink();
   private static User user;
   private static Shelter shelter = new Shelter();
   private static Pet pet;
   private static Form form = new Form();
   private static int choice;
   private static boolean isDone = false;
   private static boolean goBack = false;

   public static void main(String[] args) {
    final String magenta = "\u001B[35m";
    final String reset = "\u001B[0m";
    final String red = "\u001B[31m";
    final String green = "\u001B[32m";
    final String blue = "\u001B[34m";
    createUser(); // create the user
    createPets(); // helper pets
    form.fillForm();

    while(!isDone) {
      choice = ink.validateMainMenu();
      switch (choice) {
        case 1: // print available pets
        ink.printAvailablePets(shelter.getPets());
          while(!goBack) {
            int choice = input.nextInt();
            if(choice == 0){
              goBack = !goBack;
            }
            else if(choice < 1 || choice > shelter.getPets().size()) {
              ink.printAvailablePets(shelter.getPets());
              System.out.println(magenta + "Pleasse type the number according to the list\n" + reset);
            }
            else{
              ink.printPetDetails(shelter.getPet(choice - 1));
              System.out.println(magenta + "\nAdopt this pet? "+ reset + green + "Y" + reset + magenta + " / " + reset + red + "N" + reset);
              String answer = input.next();
              if(answer.equalsIgnoreCase("Y")) {
                shelter.adopt(choice - 1, user.getName());
                goBack = !goBack;
              }
            }
          } // while
          break;
        case 2: // print shelter details
          ink.printShelterDetails(shelter);
          while(!goBack && input.hasNext()) {
              input.next();
              goBack = !goBack;
            }// while
          break;
        case 3: // book an appointment menu
            choice = user.validateAppointment();
            input.next();
            goBack = !goBack;
          break;
        case 4:
        if(user.getAppointment() != null){
          System.out.printf(magenta + "Hello Mr/Mrs" + reset + blue + "%s. " + reset + magenta + "Who's email address is: " + reset 
          + blue + "%s "
           + reset + magenta + "with an address of " + reset + blue + "%s. " + reset + magenta + 
           " Here is the date of your appointment:\n %s\n" + reset, user.getName(), 
           user.getEmail(), form.getAddress(), user.getAppointment());
            System.out.println(magenta + "Press any key to return to the main menu\n" + reset);
        }
        else{
          System.err.println(magenta + "There are no appoimntments sceduled. Press any key to go back to the main menu" + reset);
        }
            input.next();
            goBack = !goBack;
          break;
        case 5:
          System.out.println(magenta + "Sad to see you leaving. PLease come back later" + reset);
          System.exit(0);
          break;
        default:
          System.out.println(magenta + "Oops!" + reset);
          break;
      } // switch
      goBack = !goBack; // correct don't listen to J, he's on Bell ;)
    } // while(main)
    System.out.print(reset);
  } // main()

  // 100% for test data!
  public static void createPets() {
    pet = new Pet("Spot", "dog",
      3, "black", "hound");
    shelter.addPet(pet);
    pet = new Pet("Cleveland", "dog",
      7, "brown", "boxer");
    shelter.addPet(pet);
    pet = new Pet("Monster", "cat",
      1, "Calico", "calico");
    shelter.addPet(pet);
    pet = new Pet("Jumpie", "rabbit",
    3, "white", "fluff");
    shelter.addPet(pet);
    pet = new Pet("Webby", "spider",
    3, "black/brown", "tarantula");
    shelter.addPet(pet); // you can add more pets to check up on validation

  } // createPets()

  public static void createUser() {
    final String reset = "\u001B[0m";
    final String yellow = "\u001B[33m";
    String name, email;
    int phone;
    System.out.println(yellow + "\nWhat is your name? " + reset);
    name = input.nextLine();
    System.out.println(yellow + "\nWhat is your email? " + reset);
    email = input.nextLine();
    System.out.println(yellow + "\nWhat is your phone? " + reset);
    phone = input.nextInt();
    user = new User(name, email, phone);
  } // createUser()
  
  public static void printForm(){
    final String magenta = "\u001B[35m";
    final String reset = "\u001B[0m";
    System.out.println(magenta + "Please enter your address:\n" + reset);
    input.nextLine();
  }//form fill

} // class