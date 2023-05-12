package com.QALegend.qa.Util;


import java.io.IOException;

import org.testng.annotations.DataProvider;


public class Datadrivenutility {

	@DataProvider(name="testData")
	public String[][] getTestData() throws IOException{
		String data[][] = XLUtilities.tdata();
		return data;
	}
}




