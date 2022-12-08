package com.pathnxt.commonUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
public String getPropertyKeyValue(String Key) throws IOException
{
	FileInputStream fileinputstream = new FileInputStream(Iconstants.filePath);
	Properties properties = new Properties();
	properties.load(fileinputstream);
	String value=properties.getProperty(Key);
	return value;
	
	
}
}
