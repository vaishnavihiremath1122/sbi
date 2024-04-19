package com.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class fileUtility {
	/**
	 * This method is used to read data from property file
	 * @author vaishnavi
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IpathConstant.Filepath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		}

}
