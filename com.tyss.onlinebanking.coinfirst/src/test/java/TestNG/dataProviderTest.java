package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderTest {
		//	@Test(dataProvider="data")
		//	public void getData(String org, String loc, String course)
		//	{
		//		System.out.println("Organization--->"+org+" is located in--->"+loc+" Course available--->"+course);
		//	}
	
			@DataProvider
			public Object[][] data()
			{
				Object [][]obj=new Object[3][3];
				
				obj[0][0]="Qspiders";
				obj[0][1]="Basavangudi";
				obj[0][2]="Automation";
				
				obj[1][0]="Jspiders";
				obj[1][1]="Mysore";
				obj[1][2]="Java";
				
				obj[2][0]="Prospiders";
				obj[2][1]="Hyderbad";
				obj[2][2]="Python";
				
				return obj;
				
			
			}	
			@DataProvider
			
			public Object[][] loginpage()
			{
				Object [][]obj=new Object[2][2];
				
				obj[0][0]="210001";
				obj[0][1]="210001";
				
				obj[1][0]="210001";
				obj[1][1]="password";
				
				return obj;
			}
			
			
			}

