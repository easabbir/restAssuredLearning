package restAssuredTestPractice;

import org.testng.annotations.DataProvider;

public class DataForTests {
	
	
	@DataProvider(name = "DataForPost2")
	public Object [][] dataForPost2() 
	{
//		Object[][] data= new Object[2][3];
//		
//		data[0][0]="Albert";
//		data[0][1]="Einstein";
//		data[0][2]=2;
//		
//
//		data[1][0]="Thomas";
//		data[1][1]="Eddison";
//		data[1][2]=1;
//		
		return new Object[][] {
				{ "Graham", "Bell", 1},
				{ "Henry", "Ford", 2}
	};
	

	}
	

	
	@DataProvider(name="DeleteData")
	public Object[] dataForDelete()
	{
		
		return new Object[] 
				{
					5,6
				};
	}
	
	
	

}
