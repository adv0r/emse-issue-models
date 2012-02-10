package it.unibz.esm.parser;

import it.unibz.esm.core.Global;
import it.unibz.esm.util.Stage;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Parse the output R file . See resources/r/r.out.example */

public class RParserOutput {
	
	public static String rOut = "";
	public static boolean alreadyParsed = false;
	public static String rDir = Global.reportFolder;
	
	public static final String STRING_PVALUE = "HTMLOUT";
	public static final String STRING_VARIANCE = "ESM_VARIANCE";
	public static final String STRING_QUARTILE_LATE = "ESM_QUARTILE_L";
	public static final String STRING_QUARTILE_EARLY = "ESM_QUARTILE_E" ;
	public static final String STRING_REGRESSION_LATE = "ESM_REGRESSION_L" ;
	public static final String STRING_REGRESSION_EARLY = "ESM_REGRESSION_E" ;
	
	/** Look-up for the string [1] "HTMLOUT 1_Mandriva.csv p.value= 2.41928987996375e-11"*/
	public static String getpValue(String csvName)  
	{			
		String toReturn = "";
		parse();
		
		String[] splitted = rOut.split(STRING_PVALUE);
		 for(int i=1; i< splitted.length;i++)
		 {
			 if(splitted[i].startsWith(" "+csvName) )
			 {
				String temp =  splitted[i];
				String pVal = temp.substring(csvName.length()+10, csvName.length()+31);
				toReturn+=pVal;
			 }
		 }
		return toReturn.replace("\"", "");			
	}
	
	
	/** Look-up for the string f.i.
	 * [1] "ESM_REGRESSION_E 1_Mandriva.csv" or 
	 * [1] "ESM_REGRESSION_L 1_Mandriva.csv"
	 * */
	public static String getRegressionTable(String csvName,String type)  
	{
		String toReturn = "";
		String[] splitted = null;
		parse();
		if (type.equals(Stage.EARLY))
			 splitted = rOut.split(STRING_REGRESSION_EARLY);
		else
			 splitted = rOut.split(STRING_REGRESSION_LATE);
		
		for(int i=1; i< splitted.length;i++)
		 {
			 if(splitted[i].startsWith(" "+csvName) )
			 {
				String temp =  splitted[i];
				String tempTable = temp.substring(csvName.length()+55,csvName.length()+600);
				String header = "            Estimate Std. Error t value Pr(>|t|) \n";   
				String line1 = tempTable.substring(tempTable.indexOf("(Intercept)"),tempTable.indexOf("len"))+"\n";
				String line2 = tempTable.substring(tempTable.indexOf("len"),tempTable.indexOf("---"))+"\n";
				String footer = "---\nCodes: 0 '***' 0.001 '**' 0.01 '*' 0.05 '.' 0.1 ' ' 1\n";
				String rLine = tempTable.substring(tempTable.indexOf("Adjusted R-squared:"),tempTable.indexOf("Adjusted R-squared:")+26)+"\n"; ;
				toReturn+=header+line1+line2+footer+rLine;
			 }
		 }
		return toReturn;	
	}
	
	
	/** Look-up for the string f.i.
	 *	[1] "ESM_VARIANCE 1_Mandriva.csv"
	 * */
	public static String getVarianceTable(String csvName)  
	{
		String toReturn = "";
		parse();
		
		String[] splitted = rOut.split(STRING_VARIANCE);
		 for(int i=1; i< splitted.length;i++)
		 {
			 if(splitted[i].startsWith(" "+csvName) )
			 {
				 /** To parse sth like that
				  *                  Df Sum Sq  MeanSq F value  Pr(>F)    
					Stage             1  57462   57462 99.4742 < 2e-16 ***
					Increment         1   3771    3771  6.5281 0.01089 *  
					Stage:Increment   1    908     908  1.5718 0.21049    
					Residuals       540 311935     578                    
					---
					Signif. codes:  0 '***' 0.001 '**' 0.01 '*' 0.05 '.' 0.1 ' ' 1 
				  */
				String temp =  splitted[i];
				String tempTable = temp.substring(csvName.length()+10,csvName.length()+305);
				String header = "                 Df Sum Sq Mean Sq F value  Pr(>F)\n";
				String line1 = tempTable.substring(tempTable.indexOf("Stage ") , tempTable.indexOf("Increment") ) +"\n";
				String line2 = tempTable.substring(tempTable.indexOf("Increment") , tempTable.indexOf("Stage:") ) +"\n"; 
				String line3 = tempTable.substring(tempTable.indexOf("Stage:") , tempTable.indexOf("Residuals") ) +"\n"; 
				String line4 = tempTable.substring(tempTable.indexOf("Residuals") , tempTable.indexOf("---") ) +"\n"; 
				String footer = "---\nCodes: 0 '***' 0.001 '**' 0.01 '*' 0.05 '.' 0.1 ' ' 1";
				toReturn+=header+line1+line2+line3+line4+footer;
			 }
		 }
		return toReturn;	
	}
	
	/** Look-up for the string f.i.
	 *	[1] "ESM_QUARTILE_E 2_Ant.csv" or
	 *  [1] "ESM_QUARTILE_L 2_Ant.csv"
	 * */
	public static String getQuartileTable(String csvName,String type)  
	{
		String toReturn = "";
		String[] splitted = null;
		parse();
		String toFind = null;
		if (type.equals(Stage.EARLY)){
			 splitted = rOut.split(STRING_QUARTILE_EARLY);
			 toFind="[1] \"ESM_QUARTILE_L";
		}
		else
		{
			 splitted = rOut.split(STRING_QUARTILE_LATE);
			 toFind="[1] \"HTMLOUT";

		}
		
		for(int i=1; i< splitted.length;i++)
		 {
			 if(splitted[i].startsWith(" "+csvName) )
			 {
				String temp = splitted[i];
				String tempTable = temp.substring(csvName.length()+4,temp.indexOf(toFind));
				String quartileTable = tempTable.substring(0,tempTable.indexOf("100%")+4) + "\n" + tempTable.substring(tempTable.indexOf("100%")+5);
				toReturn+=quartileTable;
			 }
		 }
		return toReturn;	
	}
	
	
	private static void parse()
	{
		if(!alreadyParsed){
			rOut = readFromFile(rDir+Global.R_OUTPUT_FILENAME);
			alreadyParsed=true;
		}
	}
	 

	 public static String readFromFile(String fileName)
		{
			String toReturn = "";
			   try{
				    FileInputStream fstream = new FileInputStream(fileName);
				    DataInputStream in = new DataInputStream(fstream);
				        BufferedReader br = new BufferedReader(new InputStreamReader(in));
				    String strLine;
				    while ((strLine = br.readLine()) != null)   {
				    	toReturn+=strLine;
				    }
				    in.close();
				    }catch (Exception e){
				      System.err.println("Error: " + e.getMessage());
				    }
			return toReturn;
		}


}
