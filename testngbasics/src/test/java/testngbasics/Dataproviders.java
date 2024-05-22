package testngbasics;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	
	@DataProvider(name="amazonProducts")
	public Object[][] amazonDataProvider()
	{
		return new Object [][] {{"Headset"},{"Saree"},{"phone"},{"fan"}}; //test case runs these many times
		//this is single dimensional data provider
	}

	
	@DataProvider(name="facebookLoginData")
	public Object[][] facebookLoginProvider()
	{
		return new Object [][] {{"vincyjacob27@gmail.com","vinmaria27"},{"jacob","pswd2"}};//for three dimensional. give 3 comma separated value
	}
}
