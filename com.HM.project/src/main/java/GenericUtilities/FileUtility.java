package GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

public String dataFromPropertyFile(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/H&mdata.properties");
		Properties p = new Properties();
		p.load(fis);
		String value= p.getProperty(key);
		return value;
	}
}
