import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Dog{
// Scanner object for user input
static Scanner sc = new Scanner(System.in);

    int id;
    String name;
    String weight;
    int age;

//Constructor
 Dog(int id, String name, String weight, int age) {
     this.id = id;
     this.name = name;
     this.weight = weight;
     this.age = age;

    }

static ArrayList<Dog> dogs = new ArrayList<>();

public String toString() {
    return "Dog ID #: " + id +
            "Dog Name: " + name +
            "Dog Weight: " + weight +
            "Dog Age: " + age;
}

// Method to display welcome message
public static void welcome() {  
System.out.println("Welcome, this program allows for a care attendant to be able to create, retrieve and update a dog record from the system."); }

public static int selection() {
    System.out.println("Select a menu option:");
    System.out.println("       1) Create a dog record");
    System.out.println("       2) Display dog record");
    System.out.println("       3) Update dog record");
    System.out.println("       4) Exit Program");

    System.out.print("Enter selection here --> ");
    int selection = sc.nextInt();
    while (selection != 1 && selection != 2 && selection != 3 && selection != 4) {
        System.out.println("Invalid menu option");
        selection = sc.nextInt();
    }
    
    return selection; }


//Method to create a dog record
public static void createDogRecord() {
    if (dogs.size() >= 12) {
        System.out.println("MPLS Dog Boarding is full.");
        return;
    }

    System.out.println("You have selected to enter a new dog.");

    System.out.print("Enter dog ID #: ");
    int id = sc.nextInt();
     
    for (Dog dog : dogs) {
        if (dog.id == id) {
            System.out.println("Dog ID already exists. Please enter a unique ID.");
            return;
        }
    }
    sc.nextLine(); {

     System.out.print("Enter dog name: ");
    String name = sc.nextLine();

    System.out.print("Enter dog weight: ");
    String weight = sc.nextLine();

    System.out.print("Enter dog age: ");
    int age = sc.nextInt();

    Dog newDog = new Dog(id, name, weight, age);
 dogs.add(newDog);
System.out.println();
System.out.println("The following information has been entered:");
System.out.println("      ID #: " + id);
System.out.println("      Name #: " + name);
System.out.println("      Weight #: " + weight);
System.out.println("      Age #: " + age);
System.out.println();
}
}
// Method to display dog record
public static void displayDogRecord() {
     System.out.println("Dogs currently in the system:");
for (Dog dog : dogs) {
        System.out.println("Dog ID #: " + dog.id + " for " + dog.name);
       
    }

    System.out.println("Please enter ID # to from above to display record: ");
    int id = sc.nextInt();
for (Dog dog : dogs) {
        if (dog.id == id) {
            printDog(dog);
            return;
        }
   
        System.out.println("Dog ID not found.");
    }
}
// Method to print dog details
public static void printDog(Dog dog) {
    System.out.println("Dog ID #: " + dog.id);
    System.out.println("Dog Name: " + dog.name);
    System.out.println("Dog Weight: " + dog.weight);
    System.out.println("Dog Age: " + dog.age);
}
// Method to update dog record
    public static void updateDogRecord() {
    System.out.println("Please enter the dog ID # to update record");
    int id = sc.nextInt();
    sc.nextLine();
// Check if the dog with the given ID exists and update its details
   for (Dog dog : dogs) {
        if (dog.id == id) {
            System.out.println("Enter new dog name: ");
            dog.name = sc.nextLine();
            System.out.println("Enter new dog weight: ");
            dog.weight = sc.nextLine();
            System.out.println("Enter new dog age: ");
            dog.age = sc.nextInt();
            System.out.println("Dog record updated.");
            return;

        }

    }

     System.out.println("ID # does not match dog id in system");
    
    }

// Main method
public static void main(String[] args) {
    welcome();

    while (true) {
// Display menu and get user selection
    int selection = selection();
    if (selection == 1) {
        createDogRecord();
    } else if (selection == 2) {
        displayDogRecord();
    } else if (selection == 3) {
        updateDogRecord();
    } else if (selection == 4) {
        System.out.println("Program has ended!");
        System.exit(0); 

        
            
            
            

        }
    }
}

}
