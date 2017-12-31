package FashionShow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;


import FashionShow.Platform.Date;

public class DataManager {

	public static Platform createPlatform() 
	{
		LocalDate localDate = LocalDate.now();
		int year = localDate.getYear();
		int month = localDate.getMonth().getValue();
		int day = localDate.getDayOfMonth();
		Platform platform = new Platform(new Date(year,month,day));
		
		System.out.println("Platform Created.");
		savePlatformToFile(platform);
		return platform;
	}	
	
	public static Platform loadPlatformFromFile() throws ClassNotFoundException, IOException 
	{
		try 
		{
			FileInputStream platformFile = new FileInputStream("platform.data");

			ObjectInputStream platformObj = new ObjectInputStream(
					platformFile);

			Platform platform = (Platform) platformObj.readObject();

			platformObj.close();
			System.out.println("Platform Loaded.");
			return platform;
			
		} catch (FileNotFoundException e) {
			Platform platform = createPlatform();
			return platform;
		}
		
	}
	
	public static void savePlatformToFile(Platform platform) 
	{
		try 
		{
			FileOutputStream platformFile = new FileOutputStream("platform.data");
			ObjectOutputStream platformObj = new ObjectOutputStream(platformFile);
			platformObj.writeObject(platform);
			platformObj.close();
		} catch (FileNotFoundException e) 
		{
			System.out.println("platform.data: file not found");
			createPlatform();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
