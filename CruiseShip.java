import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CruiseShip {
    //Creating Global variables and Class arrays for the programme
    public static Scanner input = new Scanner(System.in);
    public static Cabin[] cabins = new Cabin[13];
    public static String queue[] = new String[5];
    public static int cabinNumber = 1;
	public static int expenses = 1;
	
    //method for initialization
    public static void initialise() {
        for (int x = 1; x < 13; x++) {//initialize all the arrays for the count of 12
            cabins[x] = new Cabin("", new Passenger("e", "e", "e", "e", "e", "e", "e", "e", "e", 0));
        }
        System.out.println("initialise ");//conformation message
    }

    public static void queueCheck() {
        int x = 0;
        for (int i = 1; i < cabins.length; i++) {
            if (!(cabins[i].passenger.firstName1.equals("e"))) {   //Checking if there are any empty cabins available
                x = x + 1;
            }
        }
        if (x == 12) {
            System.out.println("Since All the cabins are Occupied You will be Added to the waiting list. \nPlease enter your first name to add in the waiting list: ");
            for(int i = 1; i < queue.length; i++)
                if(queue[i] == null) {
                    queue[i] = input.next().toUpperCase();
                    break;
                }
            //Requesting user for their name to add to the waiting list
        }
    }


    //method for main menu
    public static String menu() {
        System.out.println("Welcome sir!");
        System.out.println("Menu");
        System.out.println("||==================================================================||");
        System.out.println("||  -To View all cabins enter                            	'V'     ||");
		System.out.println("||  -To Add a passenger enter                            	'A'     ||");
        System.out.println("||  -To Display empty cabins enter                       	'E'     ||");
        System.out.println("||  -To Delete a passenger from a cabin enter            	'D'     ||");
        System.out.println("||  -To Find a cabin by passenger's name enter           	'F'     ||");
        System.out.println("||  -To Store data to a file enter                       	'S'     ||");
        System.out.println("||  -To Load data from a file enter                      	'L'     ||");
        System.out.println("||  -To View Passenger's name in alphabetical order enter  	'O'     ||");
		System.out.println("||  -To Print the expenses per passenger                    'T'     ||");
		System.out.println("||  -To Quit the program                                    'Q'     ||");
        System.out.println("||==================================================================||");
        System.out.print("Enter your selection : ");//gets the user input
        String option = input.next().toLowerCase();

        return option;
    }

    //method for adding passenger
    public static void addPassenger() {
        boolean correct = false;
			do {
				System.out.print("Enter cabin number (1-12) :" );
				String number = input.next();
				
				try{
					cabinNumber = Integer.parseInt(number);
					correct = true;
				}
				catch(NumberFormatException e){
					System.out.println("Integer expected, String entered");
				}
			}
		while (!correct);
            
			if (cabinNumber > 0 && cabinNumber < 13) {
				if (cabins[cabinNumber].passenger.firstName1.equals("e") && cabins[cabinNumber].passenger.firstName2.equals("e") && cabins[cabinNumber].passenger.firstName3.equals("e")) {
					System.out.print("Enter the first name of the first passenger in cabin no " + cabinNumber + " :");  //Program checks if the desired Cabin is free before entering name, if not prints message
					cabins[cabinNumber].passenger.firstName1 = input.next().toUpperCase();
					System.out.print("Enter the last name of the first passenger in cabin no " + cabinNumber + " :");  //Program checks if the desired Cabin is free before entering name, if not prints message
					cabins[cabinNumber].passenger.lastName1 = input.next().toUpperCase();
					boolean cost1 = false;
						do {
							System.out.print("Enter the Expenses (enter numbers only) :");  //Program checks if the desired Cabin is free before entering name, if not prints message
							cabins[cabinNumber].passenger.expenses1 = input.next();
							
							try{
								expenses = Integer.parseInt(cabins[cabinNumber].passenger.expenses1);
								cost1 = true;
							}
							catch(NumberFormatException e){
								System.out.println("Integer expected, String entered");
							}
						}
					while (!cost1);
					cabins[cabinNumber].passenger.totalExpense = Integer.parseInt(cabins[cabinNumber].passenger.expenses1);
							

					System.out.println("Do You want to add a second passenger to the cabin? Y or N");
					String roomInput = input.next().toLowerCase();

					if(roomInput.equals("y")) {
						System.out.print("Enter the first name of the second passenger in cabin no " + cabinNumber + " :");  //Program checks if the desired Cabin is free before entering name, if not prints message
						cabins[cabinNumber].passenger.firstName2 = input.next().toUpperCase();
						System.out.print("Enter the last name of the second passenger in cabin no " + cabinNumber + " :");  //Program checks if the desired Cabin is free before entering name, if not prints message
						cabins[cabinNumber].passenger.lastName2 = input.next().toUpperCase();
						boolean cost2 = false;
						do {
							System.out.print("Enter the Expenses (enter numbers only) :");  //Program checks if the desired Cabin is free before entering name, if not prints message
							cabins[cabinNumber].passenger.expenses2 = input.next();

							try{
								expenses = Integer.parseInt(cabins[cabinNumber].passenger.expenses2);
								cost2 = true;
							}
							catch(NumberFormatException e){
								System.out.println("Integer expected, String entered");
							}
						}
						while (!cost2);
						cabins[cabinNumber].passenger.totalExpense = Integer.parseInt(cabins[cabinNumber].passenger.expenses1)  + Integer.parseInt(cabins[cabinNumber].passenger.expenses2);


					}else if (roomInput.equals("n")){
						return;

					}
					System.out.println("Do You want to add a third passenger to the cabin? Y or N");
					String roomsInput = input.next().toLowerCase();

					if(roomsInput.equals("y")) {
						System.out.print("Enter the first name of the third passenger in cabin no " + cabinNumber + " :");  //Program checks if the desired Cabin is free before entering name, if not prints message
						cabins[cabinNumber].passenger.firstName3 = input.next().toUpperCase();
						System.out.print("Enter the last name of the third passenger in cabin no " + cabinNumber + " :");  //Program checks if the desired Cabin is free before entering name, if not prints message
						cabins[cabinNumber].passenger.lastName3 = input.next().toUpperCase();
						boolean cost3 = false;
						do {
							System.out.print("Enter the Expenses (enter numbers only) :");  //Program checks if the desired Cabin is free before entering name, if not prints message
							cabins[cabinNumber].passenger.expenses3 = input.next();

							try{
								expenses = Integer.parseInt(cabins[cabinNumber].passenger.expenses3);
								cost3 = true;
							}
							catch(NumberFormatException e){
								System.out.println("Integer expected, String entered");
							}
						}
						while (!cost3);
						cabins[cabinNumber].passenger.totalExpense = Integer.parseInt(cabins[cabinNumber].passenger.expenses1)  + Integer.parseInt(cabins[cabinNumber].passenger.expenses2) + Integer.parseInt(cabins[cabinNumber].passenger.expenses3);

					}else if (roomsInput.equals("n")){
						return;
					}

					System.out.println("Passenger details added successfully");


					}
					else {
						System.out.println("cabin is already full Try a Different cabin");
                        queueCheck();
					}
				
			}
			else{
				System.out.println("Enter Valid Cabin Number");
			}
        
        
    }

    //method for viewing all cabins
    public static void viewCabins() {
        for (int x = 1; x < cabins.length; x++) {
            System.out.println("Cabin " + x + " occupied by \n\n" + cabins[x].passenger.firstName1 + " " + cabins[x].passenger.lastName1 + "\n" + cabins[x].passenger.firstName2 + " " + cabins[x].passenger.lastName2 + "\n" + cabins[x].passenger.firstName3 + " " + cabins[x].passenger.lastName3 + "\n\n--------------------------------------------");
        }
    }

    //method to delete passenger
    public static void deletePassenger() {
        int x = 0;
        System.out.println("Enter cabin number to delete");
        //String passengerName = input.next().toUpperCase();
        int cabinNo = input.nextInt();

        for (int i = 1; i < cabins.length; i++) {

            if (!(cabins[i].passenger.firstName1.equals("e"))) {   //Checking if there are any empty cabins available
                x = x + 1;
            }
            if (i == cabinNo) {
                System.out.println(cabins[i].passenger.firstName1 + " Staying in cabin Number " + i + " has been removed");
                cabins[i].passenger.firstName1 = "e";    //assigns the string e to mentioned cabin to make it empty
                cabins[i].passenger.firstName2 = "e";
                cabins[i].passenger.firstName3 = "e";

                cabins[i].passenger.lastName1 = "e";
                cabins[i].passenger.lastName2 = "e";
                cabins[i].passenger.lastName3 = "e";

                cabins[i].passenger.expenses1 = "e";
                cabins[i].passenger.expenses2 = "e";
                cabins[i].passenger.expenses3 = "e";

                cabins[i].passenger.totalExpense = 0;

                System.out.println("Deleted passenger from cabin " + i + " successfully");
            }

            if (queue[1] != null) {
                if (x == 12) {
                    //String wName = queue.get(0);
                    String wName = queue[1];
                    for (int j = 1; j < queue.length - 1; j++) {
                        queue[j] = queue[j + 1];
                    }
                    queue[queue.length - 1] = null;
                    cabins[cabinNo].passenger.firstName1 = wName;
                    System.out.println("A cabin has been freed, you shall be added to the cabin");
                    System.out.print("Enter the last name of the first passenger in cabin no " + cabinNo + " :");  //Program checks if the desired Cabin is free before entering name, if not prints message
                    cabins[cabinNo].passenger.lastName1 = input.next().toUpperCase();
                    boolean cost1 = false;
                    do {
                        System.out.print("Enter the Expenses (enter numbers only) :");  //Program checks if the desired Cabin is free before entering name, if not prints message
                        cabins[cabinNo].passenger.expenses1 = input.next();

                        try {
                            expenses = Integer.parseInt(cabins[cabinNo].passenger.expenses1);
                            cost1 = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Integer expected, String entered");
                        }
                    }
                    while (!cost1);
                    cabins[cabinNo].passenger.totalExpense = Integer.parseInt(cabins[cabinNo].passenger.expenses1);


                    System.out.println("Do You want to add a second passenger to the cabin? Y or N");
                    String roomInput = input.next().toLowerCase();

                    if (roomInput.equals("y")) {
                        System.out.print("Enter the first name of the second passenger in cabin no " + cabinNo + " :");  //Program checks if the desired Cabin is free before entering name, if not prints message
                        cabins[cabinNo].passenger.firstName2 = input.next().toUpperCase();
                        System.out.print("Enter the last name of the second passenger in cabin no " + cabinNo + " :");  //Program checks if the desired Cabin is free before entering name, if not prints message
                        cabins[cabinNo].passenger.lastName2 = input.next().toUpperCase();
                        boolean cost2 = false;
                        do {
                            System.out.print("Enter the Expenses (enter numbers only) :");  //Program checks if the desired Cabin is free before entering name, if not prints message
                            cabins[cabinNo].passenger.expenses2 = input.next();

                            try {
                                expenses = Integer.parseInt(cabins[cabinNo].passenger.expenses2);
                                cost2 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Integer expected, String entered");
                            }
                        }
                        while (!cost2);
                        cabins[cabinNo].passenger.totalExpense = Integer.parseInt(cabins[cabinNo].passenger.expenses1) + Integer.parseInt(cabins[cabinNo].passenger.expenses2);


                    } else if (roomInput.equals("n")) {
                        return;

                    }
                    System.out.println("Do You want to add a third passenger to the cabin? Y or N");
                    String roomsInput = input.next().toLowerCase();

                    if (roomsInput.equals("y")) {
                        System.out.print("Enter the first name of the third passenger in cabin no " + cabinNo + " :");  //Program checks if the desired Cabin is free before entering name, if not prints message
                        cabins[cabinNo].passenger.firstName3 = input.next().toUpperCase();
                        System.out.print("Enter the last name of the third passenger in cabin no " + cabinNo + " :");  //Program checks if the desired Cabin is free before entering name, if not prints message
                        cabins[cabinNo].passenger.lastName3 = input.next().toUpperCase();
                        boolean cost3 = false;
                        do {
                            System.out.print("Enter the Expenses (enter numbers only) :");  //Program checks if the desired Cabin is free before entering name, if not prints message
                            cabins[cabinNo].passenger.expenses3 = input.next();

                            try {
                                expenses = Integer.parseInt(cabins[cabinNo].passenger.expenses3);
                                cost3 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Integer expected, String entered");
                            }
                        }
                        while (!cost3);
                        cabins[cabinNo].passenger.totalExpense = Integer.parseInt(cabins[cabinNo].passenger.expenses1) + Integer.parseInt(cabins[cabinNo].passenger.expenses2) + Integer.parseInt(cabins[cabinNo].passenger.expenses3);

                    } else if (roomsInput.equals("n")) {
                        return;
                    }

                    System.out.println("Passenger details added successfully");
                }
            }
        }
    }

    //methode to view empty cabin
    public static void emptyCabins() {
        int counter = 0;
        for (int x = 1; x < cabins.length; x++) {
            if (cabins[x].passenger.firstName1.equals("e") && cabins[x].passenger.firstName2.equals("e") && cabins[x].passenger.firstName3.equals("e")) {
                System.out.println("cabin " + x + " is empty");
            } else counter++;
        }
        if (counter == 12)//when all the cabins are full and no empty cabins
            System.out.println("All the cabins are occupied no empty cabins");
    }

    //method to find cabin of a passenger
    public static void findCabins() {
        System.out.print("Enter the passenger's first name: ");
        String passengerName = input.next().toUpperCase();
        boolean isCustomerFound = false;
        for (int x = 1; x < cabins.length; x++) {
            if (cabins[x].passenger.firstName1.equals(passengerName) || cabins[x].passenger.firstName2.equals(passengerName) || cabins[x].passenger.firstName3.equals(passengerName)) {
                System.out.println(passengerName + " is found in cabin number " + x);
                isCustomerFound = true;
                break;
            }
        }
        if (!isCustomerFound) {
            System.out.println("Passenger not found");
        }

    }

    //method to store data to a file
    public static void storeData() throws IOException {
        File Storage = new File("customerData.txt");
        Storage.createNewFile();  //A new file is created using the method

        FileWriter writer = new FileWriter(Storage.getName());
        for (int x = 1; x < cabins.length; x++) {//stores all the data of a particular passenger in a proper order
            writer.write(cabins[x].passenger.firstName1 + "\n");
            writer.write(cabins[x].passenger.lastName1 + "\n");
            writer.write(cabins[x].passenger.expenses1 + "\n");
            writer.write(cabins[x].passenger.firstName2 + "\n");
            writer.write(cabins[x].passenger.lastName2 + "\n");
            writer.write(cabins[x].passenger.expenses2 + "\n");
            writer.write(cabins[x].passenger.firstName3 + "\n");
            writer.write(cabins[x].passenger.lastName3 + "\n");
            writer.write(cabins[x].passenger.expenses3 + "\n");
			writer.write(cabins[x].passenger.totalExpense + "\n");
        }
        writer.close();
        System.out.println("your data saved to a file successfully");//Once the file is created a message is printed
    }

    //method to load data from a file
    public static void loadData() throws IOException {
        int index = 1;
        File Storage = new File("customerData.txt");

        Scanner reader = new Scanner(Storage);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String data1 = reader.nextLine();
            String data2 = reader.nextLine();
			String data3 = reader.nextLine();
            String data4 = reader.nextLine();
            String data5 = reader.nextLine();
			String data6 = reader.nextLine();
            String data7 = reader.nextLine();
            String data8 = reader.nextLine();
			String data9 = reader.nextLine();
            cabins[index].passenger.firstName1 = data; //data taken from file is stored to class array
            cabins[index].passenger.lastName1 = data1;
            cabins[index].passenger.expenses1 = data2;
			cabins[index].passenger.firstName2 = data3; //data taken from file is stored to class array
            cabins[index].passenger.lastName2 = data4;
            cabins[index].passenger.expenses2 = data5;
			cabins[index].passenger.firstName3 = data6; //data taken from file is stored to class array
            cabins[index].passenger.lastName3 = data7;
            cabins[index].passenger.expenses3 = data8;
			cabins[index].passenger.totalExpense = Integer.parseInt(data9);
            index++;
        }
        reader.close();
        System.out.println("Loaded successfully from the text file");  //prints message when successfully loaded
    }

    //method to view passenger name in alphabetical order
    public static void customerAlphabeticOrder() {  //method to arrange the passenger details in alphabetical order
        for (int i = 1; i < cabins.length; i++) {
            for (int j = i + 1; j < cabins.length; j++) {
                if (cabins[i].passenger.firstName1.compareTo(cabins[j].passenger.firstName1) > 0) //compares two different elements of the array at a time
                {
                    String temp = cabins[i].passenger.firstName1;
                    cabins[i].passenger.firstName1 = cabins[j].passenger.firstName1;
                    cabins[j].passenger.firstName1 = temp;  //rearranged in a way to make sure it is in alphabetical order
                }
            }
        }
        for (int x = 1; x < cabins.length; x++) {
            if(!cabins[x].passenger.firstName1.equals("e"))
                System.out.println("-"+ cabins[x].passenger.firstName1);
        }
    }

	//method for printing Expenses
    public static void viewExpenses() {
        for (int x = 1; x < cabins.length; x++) {
            System.out.println(cabins[x].passenger.firstName1 + "    $" + cabins[x].passenger.expenses1 + "\n" + cabins[x].passenger.firstName2 + "    $" + cabins[x].passenger.expenses2 + "\n" + cabins[x].passenger.firstName3 + "    $" + cabins[x].passenger.expenses3 );
			System.out.println("\nTotal Expenses of Cabin " + x + " is $" + cabins[x].passenger.totalExpense + "\n\n----------------------------------------------------------");
        }
    }
	
	
	
	
	

    public static void main(String[] args) {

        initialise(); //initializes all the arrays and classes
        boolean isContinue = true;//boolean to keep the program running until the user wants to stop
        while (isContinue) {
            String option = menu();

            switch (option) {
                case "v":
                    viewCabins();       //The Method view is called
                    break;
                case "e":
                    emptyCabins();      //The Method empty is called
                    break;
                case "a":
                    addPassenger();     //The Method add is called
                    break;
                case "d":
                    deletePassenger();  //The Method delete is called
                    break;
                case "f":
                    findCabins();       //The Method find is called
                    break;
                case "s":
                    try {
                        storeData();    //The Method store is called
                    } catch (IOException e) {
                        e.printStackTrace();  //method passed to handle exceptions and error
                    }
                    break;
                case "l":
                    try {
                        loadData(); //The method load is called
                    } catch (IOException e) {
                        e.printStackTrace();  //method passed to handle exceptions and error
                    }
                    break;
                case "o":
                    customerAlphabeticOrder();  //The Method alphabetic order is called
                    break;
				case "t":
                    viewExpenses();
                    break;
				case "q":
					System.out.println("Program ends");
                    System.exit(0);      //Terminates the program
                    break;
                default://when the user enters something other than the options given
                    System.out.print("you have entered an invalid option");
                    break;
            }
            //taking the user input to run the program again or to stop
			boolean value = true;
				while (value) {
				System.out.println("\nSelect from below");
				System.out.println("To go back to menu enter M");
				System.out.println("To exit enter E");
				System.out.print("Enter your option: ");
				String select = input.next().toLowerCase();

				if (select.equals("m")) {//program will run until other inputs given than 'm'
					break;
					
				}
				else if (select.equals("e")) {
					System.out.println("Program ends");
					System.exit(0);      //Terminates the program
					
				}
				else
					System.out.println("Enter Valid Input");
					value = true;
				}
			isContinue = true;
		
        }
    }
}
