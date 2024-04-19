package TestNG;

import org.testng.annotations.Test;

public class runTest {
	
@Test(dataProviderClass =dataProviderFromExcel.class, dataProvider = "readDataFromExcel" )
	
	public void getOrgDataTest(String Org,String loc, String course)
	{
		System.out.println(Org+"==="+loc+"==="+course);
	}
}
