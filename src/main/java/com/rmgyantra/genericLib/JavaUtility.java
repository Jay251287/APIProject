package com.rmgyantra.genericLib;

import java.util.Random;

public class JavaUtility {
	
	public int randomNumber()
	{
		Random random = new Random();
		int randomNo = random.nextInt(2000);
		return randomNo;
	}


}
