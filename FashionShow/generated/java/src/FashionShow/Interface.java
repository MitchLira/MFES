package FashionShow;

import java.io.IOException;
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
			System.out.println(platform.actualDate.day+"/"+platform.actualDate.month+"/"+platform.actualDate.year);
			System.out.println("Choose an option: \n");
			System.out.println("1- Users;");
			System.out.println("2- Events;");
			System.out.println("3- Items;");
			System.out.println("4- Designers;");
			System.out.println("0- Exit;");
			System.out.println("#=============================================#");
			int option = intReader(0,4);
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
			System.out.println("2- See User Info;");
			System.out.println("3- Register User;");
			System.out.println("4- Ban User;");
			System.out.println("0- Return;");
			System.out.println("#=============================================#");
			int option = intReader(0,4);
			switch (option)
			{
				case 0:
					return;
				case 1:
					viewAllUsers();
					break;
				case 2:	
					//TODO
					break;
				case 3:
					registerUser();
					break;
				case 4:
					//TODO
					break;
				
			}
		}
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
				System.out.println("->" + (counter+1) +". Username: "+ user.username + " | Name: " + user.name);
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
	
	public static void registerUser()
	{
		while(true)
		{
			String name;
			String username;
			boolean badUser=false;
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
			User user = null;
			try
			{	
				user = new User(username,name);
			}
			catch(Exception e)
			{
				badUser = true;
				System.out.println("Error: Bad user values.");
			}
			if(!badUser)
			{
				try
				{	
					platform.addUser(user);
					return;
				}
				catch(Exception e)
				{
					System.out.println("Error: Username already exists.");
				}
			}
		}
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
				System.out.println("Invalid value, choose another option:");

			}
		}
		return Integer.parseInt(option);
	}
}
