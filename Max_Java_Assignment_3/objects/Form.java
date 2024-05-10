package objects;
import java.util.Scanner;

public class Form {
  private String address;
  private String name;
  private int phone;
  final String yellow = "\u001B[33m";
  final String reset = "\u001B[0m";
  private User user = new User(name, address, phone);
  
  private static Scanner input = new Scanner(System.in);

public Form(){
}

public int getPhone(){
  return phone;
}

public String getAddress(){
  return address;
}
public String getName(){
  return name;
}


public void setPhone(int phone){
  this.phone = user.getPhone();
}

public void setName(String name){
  this.phone = user.getPhone();
}

public void fillForm(){
  System.out.println(yellow + "\nPlease eneter your address" + reset);
  String address = input.nextLine();
  this.address = address;
}
}
