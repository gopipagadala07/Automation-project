package com.Assessments.Utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class UtilityMethods {

	public static String getConsoleFormatedText(String text){
		
		return text.replace("<br>", "\n\t\t").replace("<b>", "").replace("</b>", "").replace("<pre>", "").replace("</pre>", "").replace("</br>", "\n\t");
	}

	public static String getException(Exception e) {
		try {
			
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			e.printStackTrace();
			return "<pre><br>"+sw.toString()+"</pre>";
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			return "<br>";
			
		}
	}

}