package ust.AppiumAssessment.utilities;

import java.io.FileInputStream;
import java.util.Properties;

//To get the externalized configurations from the properties file 
public class FileIO {
	public static Properties properties;
	
	public static Properties getProperties() {
		properties = new Properties();
		try {
				FileInputStream fis = new FileInputStream("C:\\Users\\268859\\Desktop\\mobileaplications\\AppiumAssessment\\src\\test\\resources\\prop.properties");
				properties.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

}
