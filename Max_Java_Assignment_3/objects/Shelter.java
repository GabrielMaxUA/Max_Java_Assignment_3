package objects;
import java.util.ArrayList;

public class Shelter {
  final String red = "\u001B[31m";
  final String reset = "\u001B[0m";
  final String yellow = "\u001B[33m";
  private String address = "123 Scoopers Lane\n";
  final String green = "\u001B[32m";
  private String[] hours = {
    yellow + "Mon:" + reset + " 8am - 4pm",
    yellow + "Tues:" + reset + " 8am - 4pm",
    yellow + "Wed:" + reset + " 8am - 4pm",
    yellow + "Thurs:" + reset +  " 8am - 4pm",
    yellow + "Fri:" + reset + " 8am - 4pm",
    red + "Sat/Sun:" + reset + " closed\n" + reset
  };
  // composition: a class made up of other classes
  private ArrayList<Pet> pets = new ArrayList<>();

  public Shelter() {
    // do nothing
  }

  //=============>>
  // GETTERS
  public String getAddress() {
    return this.address;
  }
  public String[] getHours() {
    return this.hours;
  }
  public ArrayList<Pet> getPets() {
    return this.pets;
  }
  public Pet getPet(int idx) {
    return pets.get(idx);
  }

  //=============>>
  // SETTERS
  public void setAddress(String address) {
    this.address = address;
  }
  public void setHours(String[] hours) {
    this.hours = hours;
  }
  public void adopt(int idx, String owner) {
    pets.get(idx).setIsAdopted();
    pets.get(idx).setOwner(owner);
    System.out.printf(green + "\n%s" + reset + " is now yours!\n\n", pets.get(idx).getName());
    pets.remove(idx); // takes the pet from the shelter
  }
  public void addPet(Pet pet) {
    pets.add(pet);
  }
} // class