package com.Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {
 
  public static String readprorperty(String key) {
	  Properties prop= new Properties();	  
	  try {
	  FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
	   prop.load(fis);
	  }
	  catch (Exception e) {
		  e.printStackTrace();
	  }
		return prop.getProperty(key);	  
  }
}
