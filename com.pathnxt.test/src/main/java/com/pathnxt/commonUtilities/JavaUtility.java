package com.pathnxt.commonUtilities;

import java.util.Random;
/**
 * 
 * @author -Priyaranjan Mohanty-
 *
 */
public class JavaUtility 
{
	/**
	 * create a  random number
	 * @return
	 */
public int randomNumber()
{
	Random random = new Random();
	int randomNum = random.nextInt();
	return randomNum;
	
	
}
}
