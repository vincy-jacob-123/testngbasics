package testngAssignments;

import org.testng.annotations.DataProvider;

public class DataProvidersSet1 {
	
	@DataProvider(name="members")
	public Object[][] memberNames()
	{
		return new Object [][] {{"Angelica Ramos"},{"Bradley Greer"},{"Cara Stevens"},{"Cedric Kelly"}}; 
	}
	
	@DataProvider(name="memberData")
	public Object[][] memberDatas()
	{
		return new Object [][] {{"Vincy","Jacob","vincyjacob27", "Ekm","Kerala","683011"},{"Naveen","Tom","naveenTom", "Chalakudy","Kerala","682018"}}; 
	}

}
