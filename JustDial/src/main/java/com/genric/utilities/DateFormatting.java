package com.genric.utilities;

public class DateFormatting 
{
	
	public static String replaceSpaceToHyphen(String s)
	{
		
		String s1 = s.replaceAll("-", " ");
		return s1;
	}
	
	public static String replaceHyphenToSpace(String s)
	{
		
		String s1 = s.replaceAll(" ", "-");
		
		return s1;
	}
}
