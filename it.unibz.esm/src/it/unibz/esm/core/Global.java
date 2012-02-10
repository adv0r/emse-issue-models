package it.unibz.esm.core;

import it.unibz.esm.util.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

public class Global {
	public static String BASE_PATH;
	public static final String SEP = "/";
	

	public static final String R_INPUT_FILENAME = "r.in.txt";
	public static final String R_OUTPUT_FILENAME = "r.out.txt";
	public static final String HTML_REPORT_FILENAME = "report.htm";
	public static final String HTML_PROCESSING_FILENAME = "processing.htm";


	public static final String RES_DIR = "resources"+SEP;
	public static final String OUTPUT_DIR = "output"+SEP;
	
	public static final String BASH_DIR = RES_DIR+"bash"+SEP;
	public static final String CSV_DIR = RES_DIR+"csv"+SEP;
	public static final String HTML_DIR = RES_DIR+"html"+SEP;
	public static final String R_DIR = RES_DIR+"r"+SEP;
	
	public static final String MAX_IMG_SIZE = "600";
	public static final String LAUNCH_R = BASH_DIR+"launchR.sh";
	
	public static final String PROJECTS_FILE = CSV_DIR+"projects.csv";
	
	public static String ReportName = "Report_";
	public static final String ProgramName = "it.unibz.esm";
	public static String reportFolder;
	
	public static ArrayList<Product> Products;
	public static ArrayList<Product> ProductsSelected;
	public static String[] ProductsNames;
	
	
	public static void generateReportName()
	{
		 Calendar now = Calendar.getInstance();	
		 ReportName+=now.getTimeInMillis() ;
		 Global.reportFolder = Global.BASE_PATH+Global.ProgramName+"/"+Global.OUTPUT_DIR+Global.ReportName+"/";
	}
	
	public static void executeCmd(String cmd)
	{

		  try {
		      String line;
		      Process p = Runtime.getRuntime().exec("/bin/bash "+cmd);

		      BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

		      while ((line = input.readLine()) != null) {
		        System.out.println(line);
		      }
		      input.close();
		    } catch (Exception err) {
		      err.printStackTrace();
		    }
	}
	
	

}
