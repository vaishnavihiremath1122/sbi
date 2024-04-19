package TestNG;

import org.testng.annotations.Test;
import org.testng.internal.annotations.DataProviderAnnotation;

public class FetchdataTest {
	
	
	@Test(dataProviderClass = dataProviderTest.class,dataProvider = "data")
	public void getData(String org, String loc, String course)
	{
		System.out.println("Organization--->"+org+" is located in--->"+loc+" Course available--->"+course);
	}
}
