package it.unibz.esm.core;

import it.unibz.esm.util.*;
import it.unibz.esm.UI.InitialFrame;
import it.unibz.esm.parser.ProjectLoader;

import java.io.File;
import java.util.ArrayList;

public class Launcher {
	
	public static void main(String[] a)
	{
		Global.BASE_PATH = getBasePath();
		Global.Products = new ArrayList<Product>();
		ProjectLoader.parse();
		new InitialFrame();
	}
	
	public static String getBasePath()
	{
		String toReturn = "";
		File dir2 = new File ("..");
		    try{
		    	toReturn=dir2.getCanonicalPath()+"/";
		     }
		    catch(Exception e) {
		       e.printStackTrace();
		     }
		return toReturn;  
		  
	}

}
