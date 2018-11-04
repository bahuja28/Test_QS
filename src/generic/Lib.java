package generic;

import java.io.FileInputStream;

import java.util.Properties;


/**
 * This class generic way of getting value from config properties file in order get value of config files
 * @author user
 *
 */


public class Lib implements IAutoConstant{
	
	public static FileInputStream fis;
	
	
	
	public static String getPropertyValue(String key) {
		
		
		String propertyValue=null;
		try {
			 
			 fis=new FileInputStream(CONFIG_PATH);
			Properties prop=new Properties();
			prop.load(fis);
			propertyValue=prop.getProperty(key);
			
		}  catch(Exception e) {
			System.out.println(e.toString());
			
		}
		return propertyValue;
		
		
	
	
	
}	
}


	
