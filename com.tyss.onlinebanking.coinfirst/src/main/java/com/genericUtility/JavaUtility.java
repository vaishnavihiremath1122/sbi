package com.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class JavaUtility {
			public int getRandomNo() 
			{
				Random ran=new Random();
				int random = ran.nextInt(500);
				return random;
				
			}
			
			public String getsystemdate() {
				Date dt=new Date();
				String date = dt.toString();
				return date;
			}
			
			public String getSystemDateInFormat() 
			{
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				Date dt = new Date();
				String sysDateFormat=dateFormat.format(dt);
				return sysDateFormat;
			}
}
