package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public Properties readPropertiesFile() {
		
		Properties prop=new Properties();
		
		File file=new File(System.getProperty("user.dir")+"//src//test//resource//config//config.properties");
		try {
			FileInputStream fis=new FileInputStream(file);
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
}
