package TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class fileUtils {

	public String getFiledata(String key) throws IOException {
		FileInputStream file=new FileInputStream("src\\test\\resources\\vtigercrm.properties");
		Properties p=new Properties();
		p.load(file);
		String value = p.getProperty(key);
		return value;
	}
}