package FashionShow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Interface {
	
	public static Platform platform;
	public static Scanner scanner;
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		platform = DataManager.loadPlatformFromFile();
		scanner = new Scanner(System.in);
		mainMenu();
	}
	
	public static void mainMenu()
	{
		while(true)
		{
			System.out.println("#==================Main Menu==================#");
			System.out.println("Date: "+platform.actualDate.day+"/"+platform.actualDate.month+"/"+platform.actualDate.year);
			System.out.println("Choose an option: \n");
			System.out.println("1- Users;");
			System.out.println("2- Events;");
			System.out.println("3- Items;");
			System.out.println("4- Designers;");
			System.out.println("5- Next Day;");
			System.out.println("0- Exit;");
			System.out.println("#=============================================#");
			int option = intReader(0,5);
			switch (option)
			{
				case 0:
					return;
				case 1:
					UsersMainMenu();
					break;
				case 2:	
					//TODO
					break;
				case 3:
					//TODO
					break;
				case 4:
					//TODO
					break;
				case 5:
					//TODO
					break;
				
			}
		}
	}
	
	public static void UsersMainMenu()
	{
		while(true)
		{
			System.out.println("#==================Users Menu==================#");
			System.out.println("Choose an option: \n");
			System.out.println("1- See all Users;");
			System.out.println("2- User Operations;");
			System.out.println("3- Register User;");
			System.out.println("4- Ban User;");
			System.out.println("0- Return;");
			System.out.println("#==============================================#");
			int option = intReader(0,4);
			switch (option)
			{
				case 0:
					return;
				case 1:
					viewAllUsers();
					break;
				case 2:	
					chooseUser();
					break;
				case 3:
					registerUser();
					break;
				case 4:
					banUser();
					break;
				
			}
		}
	}
	
	private static void userOperationsMenu(User user)
	{
		while(true)
		{
			System.out.println("#==================User: "+user.username+"==================#");
			System.out.println("Choose an option: \n");
			System.out.println("1- See User Info;");
			System.out.println("2- Buy Item;");
			System.out.println("3- Buy Event Ticket;");
			System.out.println("4- Refund Event Ticket;");
			System.out.println("5- Deposit Money;");
			System.out.println("0- Return;");
			System.out.println("#========================================#");
			int option = intReader(0,5);
			switch (option)
			{
				case 0:
					return;
				case 1:
					showUserInfo(user);
					break;
				case 2:	
					searchItem(user);
					break;
				case 3:
					searchEvent(user); //TODO
					break;
				case 4:
					//TODO
					break;
				case 5:
					depositMoney(user);
					break;
			}
		}
	}
	
	private static void searchEvent(User user) {
		// TODO
		
	}

	private static void searchItem(User user) {
		ArrayList<Item> foundItems = new ArrayList<Item>();
		System.out.println("Search for an item: (Name or Reference)");
		String itemString = scanner.nextLine();
		Iterator it = platform.items.iterator();
		while(it.hasNext())
		{
			Item item = (Item)it.next();
			if(item.name.contains(itemString) || item.reference.contains(itemString))
			{
				foundItems.add(item);
			}
		}
		showFoundItems(user,foundItems, itemString);
	}

	private static void showFoundItems(User user, ArrayList<Item> foundItems, String itemString) {
		System.out.println("#===========Buy Item: " +  itemString + "==========#");
		if(foundItems.size()==0)
		{
			System.out.println("-> No Items were found: Press Enter to go back;");
			System.out.println("#========================================#");
			scanner.nextLine();
		}
		else
		{
			for (int i = 0; i < foundItems.size(); i++)
			{
				Item item = foundItems.get(i);
				System.out.println("-> "+(i+1)+". Nome: "+ item.name+" | Ref: "+ item.reference +
									" | Size: "+ item.size + "| Price: " + item.price +" €;");
			}
			System.out.println("#========================================#");
			System.out.println("Which Item do you want to buy (Index)?  0 to go back :");
			int index = intReader(0,foundItems.size()+1);
			if(index == 0)
			{
				return;
			}
			else
			{
				user.setBoughtItem(foundItems.get(index-1));
				System.out.println("Item "+foundItems.get(index-1).name +"bought!");
			}
			
		}
		
	}

	private static void depositMoney(User user) {
		System.out.println("How much do you wanna deposit? (Max: 1000 €)");
		int value = intReader(0,1000);
		user.setBudget((Double)user.budget+value);
		System.out.println("Money deposited in user account");
		
	}

	private static void showUserInfo(User user) {
		System.out.println("#==================Info==================#");
		System.out.println("Username: "+user.username);
		System.out.println("Name: "+user.name);
		System.out.println("Budget: "+ user.budget + " €");
		System.out.println("Bought Items:");
		Iterator it = user.boughtItems.iterator();
		if(user.boughtItems.size()==0)
		{
			System.out.println("        ->This user didn't bought any item yet.");
		}
		else{
			while(it.hasNext())
			{
				Item item = (Item) it.next();
				System.out.println("        ->Item: "+item.name+" | Price: "+ item.price +" € | Ref: "+ item.reference);
			}
		}
		System.out.println("#========================================#");
		System.out.println("Press Enter to go back:");
		scanner.nextLine();
		
	}

	private static void chooseUser() {
		String username;
		User user;
		while(true)
		{
			System.out.println("Choose user (username): (0 to Cancel;)");
			username = scanner.nextLine();
			if(username.equals("0"))
			{
				return;
			}
			if(!verifyUsername(username))
			{
				user = platform.getUserByUsername(username);
				break;
			}
			else
			{
				System.out.println("This user does not exist; Try another.");
			}
			
		}
		userOperationsMenu(user);
		
	}

	public static void viewAllUsers()
	{
		System.out.println("#================View All Users================#");
		if(platform.users.size()!=0)
		{
			Iterator iterator = platform.users.iterator();
			int counter = 1;
			while(iterator.hasNext())
			{
				User user = (User)iterator.next();
				System.out.println("->" + (counter) +". Username: "+ user.username + " | Name: " + user.name);
				counter++;
			}
		}
		else
		{
			System.out.println("There are no users registed.");
		}
		System.out.println("#==============================================#");
		System.out.println("Press Enter to go back:");
		scanner.nextLine();
	}
	
	public static void banUser()
	{
		String username;
		User user = null;
		while(true)
		{
			System.out.println("What's the user (username) you want to ban?(0 to cancel;)");
			username = scanner.nextLine();
			if(username.equals("0"))
			{
				return;
			}
			if(!verifyUsername(username))
			{
				 user = platform.getUserByUsername(username);
				 break;
			}
			else
			{
				System.out.println("Este username não existe.");
			}
		}
		platform.removeUser(user);
		System.out.println("User: "+user.username+" eliminado da plataforma");
	}
	
	public static void registerUser()
	{
		String username;
		String name;
		while(true)
		{
			System.out.println("What's your username?(0 to cancel;)");
			username=scanner.nextLine();
			if(username.equals("0"))
			{
				return;
			}
			System.out.println("What's your name?(0 to cancel;)");
			name=scanner.nextLine();
			if(name.equals("0"))
			{
				return;
			}
			if(verifyUsername(username))
			{
				break;
			}
			else
			{
				System.out.println("This username already exists; Try another one.");
			}
		}
		User user = new User(username,name);
		platform.addUser(user);
	}
	
	
	public static int intReader(int min, int max)  
	{  
		String option;
		while(true)
		{
			try {
				option = scanner.nextLine();
				if(cg_Utils.isNumeric(option))
				{
					int optionNr = Integer.parseInt(option);
					if(optionNr < min || optionNr >max)
					{
						throw new Exception();
					}
					break;
				}
				else 
				{
					throw new Exception();
				}
			}
			catch(Exception e)
			{
				System.out.println("Invalid value, choose a valid one:");

			}
		}
		return Integer.parseInt(option);
	}
	
	public static boolean verifyUsername(String username)
	{
		Iterator iterator = platform.users.iterator();
		while(iterator.hasNext())
		{
			User user = (User)iterator.next();
			if(user.username.equalsIgnoreCase(username))
			{
				return false;
			}
		}
		return true;
	}
	
}
