package FashionShow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import FashionShow.Platform.Date;
import FashionShow.quotes.FemaleQuote;
import FashionShow.quotes.LQuote;
import FashionShow.quotes.MQuote;
import FashionShow.quotes.MaleQuote;
import FashionShow.quotes.SQuote;
import FashionShow.quotes.XLQuote;
import FashionShow.quotes.XSQuote;
import FashionShow.quotes.XXLQuote;

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
					EventsMainMenu();
					break;
				case 3:
					ItemsMainMenu();
					break;
				case 4:
					DesignersMainMenu();
					break;
				case 5:
					//TODO
					break;
				
			}
		}
	}
	
//----------------------------------------------Events--------------------------------------------------	
	
	public static void EventsMainMenu()
	{
		ArrayList<Event> foundEvents;
		while(true)
		{
			System.out.println("#==================Events Menu==================#");
			System.out.println("Choose an option: \n");
			System.out.println("1- Show All Events;");
			System.out.println("2- Event Operations;");
			System.out.println("3- Create Event");
			System.out.println("4- Delete Event;");
			System.out.println("0- Return;");
			System.out.println("#==============================================#");
			int option = intReader(0,4);
			switch (option)
			{
				case 0:
					return;
				case 1:
					viewAllEvents();
					break;
				case 2:	
					foundEvents = searchPlatformEvent();
					if(foundEvents.size()>0)
					{
						System.out.println("Choose a event to operate: (Index, 0 to Cancel;)");
						int index = intReader(0,foundEvents.size());
						if(index == 0)
							break;
						Event chosenEvent = foundEvents.get(index-1);
						operateEventMenu(chosenEvent);
					}
					break;
				case 3:
					createEvent();
					break;
				case 4:
					foundEvents = searchPlatformEvent();
					deleteEvent(foundEvents);
					break;
				
			}
		}
	}
	
	private static void operateEventMenu(Event event) {
		while(true)
		{
			ArrayList<Designer> foundDesigners;
			System.out.println("#==================Event: "+event.name+"==================#");
			System.out.println("Choose an option: \n");
			System.out.println("1- View Event Info;");
			System.out.println("2- Add Designer;");
			if(event instanceof Runway)
			{
				System.out.println("3- Add Model;");
				System.out.println("4- Add Item;");
			}
			System.out.println("0- Return;");
			System.out.println("#========================================#");
			if(event instanceof Runway)
			{
				int option = intReader(0,4);
				switch (option)
				{
					case 0:
						return;
					case 1:
						viewEventInfo(event);
						break;
					case 2:
						foundDesigners = searchPlatformDesigner();
						if(foundDesigners.size()>0)
						{
							System.out.println("Choose a desginer to add: (Index, 0 to Cancel;)");
							int index = intReader(0,foundDesigners.size());
							if(index==0)
								break;
							Designer chosenDesigner = foundDesigners.get(index-1);
							event.addDesigner(chosenDesigner);
							System.out.println("Designer added successfully");
						}
						
						break;
					case 3:	
						createModel(event);
						break;
					case 4:
						addItemToEvent(event);
						break;
				}
			}
			else
			{
				int option = intReader(0,2);
				switch (option)
				{
					case 0:
						return;
					case 1:
						viewEventInfo(event);
						break;
					case 2:
						foundDesigners = searchPlatformDesigner();
						if(foundDesigners.size()>0)
						{
							System.out.println("Choose a desginer to add: (Index, 0 to Cancel;)");
							int index = intReader(0,foundDesigners.size());
							if(index==0)
								break;
							Designer chosenDesigner = foundDesigners.get(index-1);
							event.addDesigner(chosenDesigner);
							System.out.println("Designer added successfully");
						}
						break;
					
				}
			}
		}
	}

	private static void addItemToEvent(Event event) {
		System.out.println("#==================Add Item==================#");
		if(event.designers.size()==0)
		{
			System.out.println("This Event has no Designers yet. Press Enter to return:");
			System.out.println("#============================================#");
			scanner.nextLine();
		}
		else
		{	
			int counter = 1;
			Iterator it = event.designers.iterator();
			ArrayList<Map<Designer,Item>> allItems = new ArrayList<Map<Designer,Item>>();
			while(it.hasNext())
			{
				Designer designer = (Designer) it.next();
				if(designer.items.size()>0)
				{
					System.out.println("Designer: "+designer.name);
					Iterator it2 = designer.items.iterator();
					while(it2.hasNext())
					{
						Item item = (Item)it2.next();
						System.out.println("        -> "+counter+"- Item: "+item.name+ " | Ref: " + item.reference);
						counter++;
						Map<Designer,Item> map = new HashMap<Designer,Item>();
						map.put(designer, item);
						allItems.add(map);
					}
				}
			}
			System.out.println("Choose a item to add to the event. (Index, 0 to cancel)");
			int index = intReader(0,allItems.size());
			if(index == 0)
				return;
			((Runway)event).addDesignerItem((Designer) allItems.get(index-1).keySet().toArray()[0], allItems.get(index-1).get(allItems.get(index-1).keySet().toArray()[0]));
			System.out.println("Item added successfully!");
		}
		
	}

	private static void createModel(Event event) {
		String name;
		int age;
		float height;
		Object gender;
		String nationality;
		
			System.out.println("What's the model name?");
			name=scanner.nextLine();
			System.out.println("What's the model age?");
			age= intReader(10,65);
			System.out.println("What's the model gender?");
			System.out.println(" --> 1- Female");
			System.out.println(" --> 2- Male");
			int genderChoice = intReader(1,2);
			if(genderChoice == 1)
				gender = new FemaleQuote();
			else
				gender = new MaleQuote();
			System.out.println("What's the model height?");
			height = Float.parseFloat(scanner.nextLine());
			System.out.println("What's the model nationality?");
			nationality = scanner.nextLine();
			
		Model model = new Model(name,age,height,nationality,gender);
		model.addShow(event);
		((Runway)event).addModel(model);
		
	}

	private static ArrayList<Designer> searchPlatformDesigner() {
		ArrayList<Designer> foundDesigners = new ArrayList<Designer>();
		System.out.println("Search for an Designer: (Name)");
		String designerString = scanner.nextLine();
		Iterator it = platform.designers.iterator();
		while(it.hasNext())
		{
			Designer designer = (Designer)it.next();
			if(designer.name.contains(designerString))
			{
				foundDesigners.add(designer);
			}
		}
		System.out.println("#===========Showing Designers==========#");
		if(foundDesigners.size()==0)
		{
			System.out.println("-> No Designers found press Enter to back;");
			System.out.println("#========================================#");
			scanner.nextLine();
		}
		else
		{
			for (int i = 0; i < foundDesigners.size(); i++)
			{
				Designer designer = foundDesigners.get(i);
				System.out.println("-> "+(i+1)+". Nome: "+ designer.name);
			}
			System.out.println("#========================================#");
		}
		return foundDesigners;
		
	}

	private static void viewEventInfo(Event event) {
		System.out.println("#==================Event==================#");
		System.out.println("Category: "+event.getClass().getCanonicalName());
		System.out.println("Name: "+ event.name);
		System.out.println("Theme: "+ event.theme);
		System.out.println("Place: "+ event.place);
		System.out.println("Price: "+ event.price + " �");
		System.out.println("Audience: "+ event.audience.size()+ "/" +event.maxSpectators);
		System.out.println("Designers:");
		Iterator it = event.designers.iterator();
		if(event.designers.size()==0)
		{
			System.out.println("        ->This event has no designers yet.");
		}
		else{
			while(it.hasNext())
			{
				Designer designer = (Designer) it.next();
				System.out.println("        ->Designer: "+designer.name+"");
			}
		}
		if(event instanceof Runway)
		{
			System.out.println("Models:");
			it = ((Runway)event).models.iterator();
			if(((Runway)event).models.size()==0)
			{
				System.out.println("        ->This event has no models yet.");
			}
			else{
				while(it.hasNext())
				{
					Model model = (Model) it.next();
					System.out.println("        ->Model: "+model.name);
				}
			}
			System.out.println("Items:");
			it = ((Runway)event).showItems.iterator();
			if(((Runway)event).showItems.size()==0)
			{
				System.out.println("        ->This event has no items yet.");
			}
			else{
				while(it.hasNext())
				{
					Item item = (Item) it.next();
					System.out.println("        ->Item: "+item.name+ " | Price: "+ item.price + "�");
				}
			}
		}
		System.out.println("#========================================#");
		System.out.println("Press Enter to go back:");
		scanner.nextLine();
		
	}

	private static ArrayList<Event> searchPlatformEvent() {
		ArrayList<Event> foundEvents = new ArrayList<Event>();
		System.out.println("Search for an Event: (Name or Theme)");
		String eventString = scanner.nextLine();
		Iterator it = platform.events.iterator();
		
		while(it.hasNext())
		{
			Event event = (Event)it.next();
			if(event.name.contains(eventString) || event.theme.contains(eventString))
			{
				foundEvents.add(event);
			}
		}
		System.out.println("#===========Showing Events==========#");
		if(foundEvents.size()==0)
		{
			System.out.println("-> No Events found press Enter to back;");
			System.out.println("#========================================#");
			scanner.nextLine();
		}
		else
		{
			for (int i = 0; i < foundEvents.size(); i++)
			{
				Event event = foundEvents.get(i);
				System.out.println("-> "+(i+1)+". Nome: "+ event.name+" | Theme: "+ event.theme +
						" | Place: "+ event.place + "| Price: " + event.price +" �;");
			}
			System.out.println("#========================================#");
		}
		return foundEvents;
	}

	private static void deleteEvent(ArrayList<Event> foundEvents) {
		if(foundEvents.size()>0)
		{
			System.out.println("Wich event do you want to delete?(Index) 0 to go back :");
			int index = intReader(0,foundEvents.size()+1);
			if(index == 0)
			{
				return;
			}
			else
			{
				Event chosenEvent = foundEvents.get(index-1);
				Iterator it = chosenEvent.audience.iterator();
				while(it.hasNext())
				{
					User user = (User)it.next();
					chosenEvent.refundUser(user);
				}
				platform.removeEvent(chosenEvent);
				System.out.println("Event deleted Successfully!");
			}
			
		}
	}

	private static void createEvent() {
		
		String name;
		String theme;
		String place;
		Date date;
		float price;
		int maxSpectators;

			System.out.println("What's the Event category? (Index, 0 to Cancel)");
			System.out.println("-> 1- Runway");
			System.out.println("-> 2- Presentation");
			System.out.println("-> 3- Primping Session");
			int category = intReader(0,3);
			if(category == 0)
				return;
			System.out.println("What's the Event name?");
			name=scanner.nextLine();
			System.out.println("What's the Event theme?");
			theme=scanner.nextLine();
			System.out.println("What's the Event place?");
			place=scanner.nextLine();
			System.out.println("What's the Event date?");
			System.out.println("Day:");
			int day = intReader(1,30);
			System.out.println("Month (int):");
			int month = intReader(1,12);
			System.out.println("Year:");
			int year = intReader(2000, 3000);
			date = new Date(year,month,day);
			System.out.println("What's the Event price?");
			price =(float)intReader(0,Integer.MAX_VALUE);
			System.out.println("What's the number of Max. participants?");
			maxSpectators =intReader(1,Integer.MAX_VALUE);
			
		switch (category)
		{
			
			case 1:
				platform.addEvent(new Runway(name,date,place,theme,price,maxSpectators));
				break;
			case 2:	
				platform.addEvent(new Presentation(name,date,place,theme,price,maxSpectators));
				break;
			case 3:
				platform.addEvent(new PrimpingSession(name,date,place,theme,price,maxSpectators));
				break;
				
		}
		System.out.println("Event created successfully!");
	}

	private static void viewAllEvents() {
		System.out.println("#================View All Events================#");
		if(platform.events.size()!=0)
		{
			Iterator iterator = platform.events.iterator();
			int counter = 1;
			while(iterator.hasNext())
			{
				Event event = (Event)iterator.next();
				System.out.println("->" + (counter) +". Type: "+ event.getClass().getCanonicalName() + " | Name: "+ event.name +
									" | Theme: " + event.theme + " | Place: "+ event.place + " | Price: " + event.price + "�" + 
									" | available spots: " + ((int)event.maxSpectators-event.audience.size()));
				counter++;
			}
		}
		else
		{
			System.out.println("There are no events at this moment.");
		}
		System.out.println("#==============================================#");
		System.out.println("Press Enter to go back:");
		scanner.nextLine();
		
	}

//-----------------------------------------------Users--------------------------------------------------	
	
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
			System.out.println("2- See User Events;");
			System.out.println("3- Buy Item;");
			System.out.println("4- Buy Event Ticket;");
			System.out.println("5- Refund Event Ticket;");
			System.out.println("6- Deposit Money;");
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
					showUserEvents(user);
					break;
				case 3:	
					searchItem(user);
					break;
				case 4:
					searchEvent(user); 
					break;
				case 5:
					refundEventTicket(user);
					break;
				case 6:
					depositMoney(user);
					break;
			}
		}
	}
	
	private static void refundEventTicket(User user) {
		System.out.println("#==================User Events==================#");
		ArrayList<Event> userEvents = platform.getUserEvents(user);
		if(userEvents.size()==0)
		{
			System.out.println("This user has no Event tickets");
		}
		else
		{
			for(int i = 0; i< userEvents.size(); i++)
			{
				Event event = userEvents.get(i);
				System.out.println("-> "+(i+1)+". Nome: "+ event.name+" | Theme: "+ event.theme +
						" | Place: "+ event.place + "| Price: " + event.price +" �;");
			}
		}
		System.out.println("#========================================#");
		System.out.println("Choose an event to be refunded: (Index, 0 to Cancel)");
		int index = intReader(0,userEvents.size());
		if(index==0)
			return;
		userEvents.get(index).refundUser(user);
		
	}

	private static void showUserEvents(User user) {
		System.out.println("#==================User Events==================#");
		ArrayList<Event> userEvents = platform.getUserEvents(user);
		if(userEvents.size()==0)
		{
			System.out.println("This user has no Event tickets");
		}
		else
		{
			for(int i = 0; i< userEvents.size(); i++)
			{
				Event event = userEvents.get(i);
				System.out.println("-> "+(i+1)+". Nome: "+ event.name+" | Theme: "+ event.theme +
						" | Place: "+ event.place + "| Price: " + event.price +" �;");
			}
		}
		System.out.println("#========================================#");
		System.out.println("Press Enter to go back:");
		scanner.nextLine();
		
	}

	private static void searchEvent(User user) {
		ArrayList<Event> foundEvents = new ArrayList<Event>();
		System.out.println("Search for an Event: (Name or Theme)");
		String eventString = scanner.nextLine();
		Iterator it = platform.events.iterator();
		while(it.hasNext())
		{
			Event event = (Event)it.next();
			if(event.name.contains(eventString) || event.theme.contains(eventString))
			{
				foundEvents.add(event);
			}
		}
		showFoundEvents(user,foundEvents, eventString);
		
	}

	private static void showFoundEvents(User user, ArrayList<Event> foundEvents, String eventString) {
		System.out.println("#===========Buy Event Ticket: " +  eventString + "==========#");
		if(foundEvents.size()==0)
		{
			System.out.println("-> No Events were found: Press Enter to go back;");
			System.out.println("#========================================#");
			scanner.nextLine();
		}
		else
		{
			for (int i = 0; i < foundEvents.size(); i++)
			{
				Event event = foundEvents.get(i);
				System.out.println("-> "+(i+1)+". Nome: "+ event.name+" | Theme: "+ event.theme +
						" | Place: "+ event.place + "| Price: " + event.price +" �;");
			}
			System.out.println("#========================================#");
			System.out.println("To wich Event do you want to buy a ticket? (Index) 0 to go back :");
			int index = intReader(0,foundEvents.size()+1);
			if(index == 0)
			{
				return;
			}
			else
			{
				foundEvents.get(index-1).registerUser(user);
				System.out.println("Ticket to event "+foundEvents.get(index-1).name +"bought!");
			}
			
		}
		
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
									" | Size: "+ item.size + "| Price: " + item.price +" �;");
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
		System.out.println("How much do you wanna deposit? (Max: 1000 �)");
		int value = intReader(0,1000);
		user.setBudget((Double)user.budget+value);
		System.out.println("Money deposited in user account");
		
	}

	private static void showUserInfo(User user) {
		System.out.println("#==================Info==================#");
		System.out.println("Username: "+user.username);
		System.out.println("Name: "+user.name);
		System.out.println("Budget: "+ user.budget + " �");
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
				System.out.println("        ->Item: "+item.name+" | Price: "+ item.price +" � | Ref: "+ item.reference);
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
				System.out.println("This user doesn't exist..");
			}
		}
		platform.removeUser(user);
		System.out.println("User: "+user.username+" deleted from platform.");
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
	
//-----------------------------------------------Items--------------------------------------------------	
	
	public static void ItemsMainMenu()
	{
		while(true)
		{
			System.out.println("#==================Items Menu==================#");
			System.out.println("Choose an option: \n");
			System.out.println("1- See all Items;");
			System.out.println("2- Create Item;");
			System.out.println("3- Delete Item");
			System.out.println("0- Return;");
			System.out.println("#==============================================#");
			int option = intReader(0,4);
			switch (option)
			{
				case 0:
					return;
				case 1:
					viewAllItems(1);
					break;
				case 2:	
					createItem();
					break;		
				case 3:
					deleteItem();
					break;
			}
		}
	}
	
	public static void viewAllItems(int n)
	{
		System.out.println("#================View All Items================#");
		if(platform.items.size() != 0)
		{
			Iterator iterator = platform.items.iterator();
			int counter = 1;
			while(iterator.hasNext())
			{
				Item item = (Item)iterator.next();
				System.out.println("->" + (counter) + ". Name: " + item.name + " | Price: " + item.price + " | Size: " + item.size + " | Reference: " + item.reference);
				counter++;
			}
		}
		else
		{
			System.out.println("There are no items created.");
		}
		System.out.println("#==============================================#");
		if(n == 1)
		{
			System.out.println("Press Enter to go back:");	
		}
		else
		{
			System.out.println("Press Enter to choose the item to delete.");
		}
		scanner.nextLine();
	}
	
	public static void createItem()
	{
		String name;
		String reference;
		Number price;
		Object size;
		while(true)
		{
			System.out.println("What's item names?(0 to cancel;)");
			name = scanner.nextLine();
			if(name.equals("0"))
			{
				return;
			}
			System.out.println("What's item reference?(0 to cancel;)");
			reference = scanner.nextLine();
			if(reference.equals("0"))
			{
				return;
			}
			System.out.println("What's item price?");
			price = Float.parseFloat(scanner.nextLine());
			System.out.println("What's item size?");
			System.out.println(" --> 1- XS");
			System.out.println(" --> 2- S");
			System.out.println(" --> 3- M");
			System.out.println(" --> 4- L");
			System.out.println(" --> 5- XL");
			System.out.println(" --> 6- XXL");
			int sizeChoice = intReader(1,6);			
			if(sizeChoice == 1)
			{
				size = new XSQuote();
			}
			else if(sizeChoice == 2)
			{
				size = new SQuote();
			}
			else if(sizeChoice == 3)
			{
				size = new MQuote();
			}
			else if(sizeChoice == 4)
			{
				size = new LQuote();
			}
			else if(sizeChoice == 5)
			{
				size = new XLQuote();
			}
			else
			{
				size = new XXLQuote();
			}
			break;
		}
		Item item = new Item(name, reference, price, size);
		platform.addItem(item);
	}
	
	public static boolean verifyItemReference(String reference)
	{
		Iterator iterator = platform.items.iterator();
		while(iterator.hasNext())
		{
			Item user = (Item)iterator.next();
			if(user.reference.equalsIgnoreCase(reference))
			{
				return false;
			}
		}
		return true;
	}
	
	public static void deleteItem()
	{
		viewAllItems(2);
		String reference;
		Item item = null;
		while(true)
		{
			System.out.println("What's the item (reference) you want to delete?(0 to cancel;)");
			reference = scanner.nextLine();
			if(reference.equals("0"))
			{
				return;
			}
			if(!verifyItemReference(reference))
			{
				item = platform.getItemByRef(reference);
				break;
			}
			else
			{
				System.out.println("This item doesn't exist.");
			}
		}
		platform.removeItem(item);
		System.out.println("Item: " + item.reference + " deleted from platform.");
	}

//-----------------------------------------------Designers--------------------------------------------------
	
	public static void DesignersMainMenu()
	{
		while(true)
		{
			System.out.println("#==================Users Menu==================#");
			System.out.println("Choose an option: \n");
			System.out.println("1- See all Designers;");
			System.out.println("2- Register Designer;");
			System.out.println("3- Add Item to Designer;");
			System.out.println("4- Ban Designer;");
			System.out.println("0- Return;");
			System.out.println("#==============================================#");
			int option = intReader(0,4);
			switch (option)
			{
				case 0:
					return;
				case 1:
					viewAllDesigners(1);
					break;
				case 2:
					registerDesigner();
					break;
				case 3:
					addItemToDesigner();
					break;
				case 4:
					banDesigner();
					break;
				
			}
		}
	}
	
	public static void viewAllDesigners(int n)
	{
		System.out.println("#================View All Designers================#");
		if(platform.designers.size()!=0)
		{
			Iterator iterator = platform.designers.iterator();
			int counter = 1;
			while(iterator.hasNext())
			{
				Designer designer = (Designer)iterator.next();
				System.out.println("->" + (counter) +".  Name: " + designer.name);
				counter++;
			}
		}
		else
		{
			System.out.println("There are no designers registed.");
		}
		System.out.println("#==============================================#");
		if(n == 1) 
		{
			System.out.println("Press Enter to go back:");
		}
		else
		{
			System.out.println("Press Enter to choose the designer to ban:");
		}
		scanner.nextLine();
	}
	
	public static void registerDesigner()
	{
		String name;
		while(true)
		{
			System.out.println("What's designer names?(0 to cancel;)");
			name=scanner.nextLine();
			if(name.equals("0"))
			{
				return;
			}
			if(verifyDesigner(name))
			{
				break;
			}
			else
			{
				System.out.println("This name already exists; Try another one.");
			}
		}
		Designer designer = new Designer(name);
		platform.addDesigner(designer);
	}
	
	public static boolean verifyDesigner(String name)
	{
		Iterator iterator = platform.designers.iterator();
		while(iterator.hasNext())
		{
			Designer designer = (Designer)iterator.next();
			if(designer.name.equalsIgnoreCase(name))
			{
				return false;
			}
		}
		return true;
	}
	
	private static void addItemToDesigner() 
	{
//		viewAllDesigners();
//		
//		System.out.println("#==================Add Item==================#");
//		if(platform.designers.size()==0)
//		{
//			System.out.println("This Platform has no Designers yet. Press Enter to return:");
//			System.out.println("#============================================#");
//			scanner.nextLine();
//		}
//		else
//		{	
//			int counter = 1;
//			Iterator it = platform.designers.iterator();
//			ArrayList<Map<Designer,Item>> allItems = new ArrayList<Map<Designer,Item>>();
//			while(it.hasNext())
//			{
//				Designer designer = (Designer) it.next();
//				if(designer.items.size()>0)
//				{
//					System.out.println("Designer: "+designer.name);
//					Iterator it2 = designer.items.iterator();
//					while(it2.hasNext())
//					{
//						Item item = (Item)it2.next();
//						System.out.println("        -> "+counter+"- Item: "+item.name+ " | Ref: " + item.reference);
//						counter++;
//						Map<Designer,Item> map = new HashMap<Designer,Item>();
//						map.put(designer, item);
//						allItems.add(map);
//					}
//				}
//			}
//			System.out.println("Choose a item to add to the event. (Index, 0 to cancel)");
//			int index = intReader(0,allItems.size());
//			if(index == 0)
//				return;
//			System.out.println("Item added successfully!");
//		}
		
	}
	
	public static void banDesigner()
	{
		viewAllDesigners(2);
		String name;
		Designer des = null;
		while(true)
		{
			System.out.println("What's the Designer (name) you want to ban?(0 to cancel;)");
			name = scanner.nextLine();
			if(name.equals("0"))
			{
				return;
			}
			if(!verifyDesigner(name))
			{
				Designer d = getDesigner(name);
				if(d != null)
				{
					des = d;
				}
				break;
			}
			else
			{
				System.out.println("This designer doesn't exist.");
			}
		}
		platform.removeDesigner(des);
		System.out.println("Designer: " + des.name + " deleted from platform.");
	}
	
	public static Designer getDesigner(String name)
	{
		Iterator iterator = platform.designers.iterator();
		Designer designer = null;
		while(iterator.hasNext())
		{
			designer = (Designer)iterator.next();
			if(designer.name.equalsIgnoreCase(name))
			{
				break;
			}
		}
		return designer;
	}
}
