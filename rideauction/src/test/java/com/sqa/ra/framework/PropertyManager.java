package com.sqa.ra.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
	
	private static Properties props = null;

		private PropertyManager(){
			
		}
	public static String getProperty(String key) {
		if (props == null) {
			props = new Properties();
			try {
				//FileInputStream fis = new FileInputStream(
				//		"C:\\sqa_class\\RARcProject\\src\\rideauction.properties");
				InputStream fis=ClassLoader.getSystemClassLoader().getResourceAsStream("rideauction.properties");
				
				props.load(fis);
			} catch (FileNotFoundException fne) {
				fne.printStackTrace();

			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}
		String value=props.getProperty(key);
		System.out.println("value of key="+key+" value"+value);
		if(value==null){
			value=System.getProperty(key);
		}
		System.out.println("value of key="+key+" value"+value);
		return value;
		//return props.getProperty(key);

	}

}
