package it.unibz.esm.util;



import it.unibz.esm.core.Global;
import it.unibz.esm.report.OutputWriter;

public class RHandler {
	public static final String RInputFilePath = Global.BASE_PATH+Global.ProgramName+"/"+Global.R_DIR+Global.R_INPUT_FILENAME;
	
	public static  String ROutputFilePath ;

	public static final String RlaunchCmd = Global.BASE_PATH+Global.ProgramName+"/"+Global.LAUNCH_R;
	public static String getInputString()
	{
		String toReturn="source(file.path('"+Global.BASE_PATH+Global.ProgramName+"/"+Global.R_DIR+"main.R'))\n";
		for (int i=0; i<Global.ProductsSelected.size();i++)
		{
			Product temp = Global.ProductsSelected.get(i);
		    toReturn+="main('"+Global.BASE_PATH+Global.ProgramName+"/"+Global.CSV_DIR+"','"+temp.getCsv()+"')\n";
		}
		return toReturn;
	}
	
	public static void execute()
	{

		ROutputFilePath = Global.reportFolder+Global.R_OUTPUT_FILENAME;
		
		/*Create a input file for R*/
		try {
			OutputWriter.write(getInputString(), RInputFilePath);
			/*Create a script*/
			OutputWriter.write(getLaunchLine(),Global.BASE_PATH+Global.ProgramName+"/"+Global.LAUNCH_R);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Global.executeCmd(RlaunchCmd);
	}
	
	public static String getLaunchLine()
	{
       
		String toReturn="#!/bin/sh\n"+
		"mkdir "+Global.reportFolder+"\n"+ //Create the folder for the report
		"mkdir "+Global.reportFolder+"/img\n"+ //Create the folder for the report images
		"R < "+RInputFilePath+" --no-save > "+ROutputFilePath+"\n"+ //Execute R with the input instructions
		"mv "+Global.BASE_PATH+Global.ProgramName+"/Rplots* "+Global.reportFolder+"\n"+ //move Plots in report folder
		getPdfConvertCmd() + // Convert in Jpg and copy in img
		"rm "+Global.reportFolder+"Rplots*pdf\n"; //delete Pdfs
		return toReturn;
	}
	
	public static String getPdfConvertCmd()
	{
		String toReturn = "";
		int pdfNumber=0;
		for (int i=0; i<Global.ProductsSelected.size(); i++)
		{
			Product temp = Global.ProductsSelected.get(i);
			if(pdfNumber==0)
				toReturn += "sips -s format jpeg -s formatOptions 100 -Z "+Global.MAX_IMG_SIZE +" "+Global.reportFolder+"Rplots.pdf --out "+Global.reportFolder+"img/"+temp.getName()+"_box.jpg  > /dev/null\n";
			else
			    toReturn += "sips -s format jpeg -s formatOptions 100 -Z "+Global.MAX_IMG_SIZE +" "+Global.reportFolder+"Rplots"+pdfNumber+".pdf --out "+Global.reportFolder+"img/"+temp.getName()+"_box.jpg  > /dev/null\n";
			pdfNumber++;
			toReturn += "sips -s format jpeg -s formatOptions 100 -Z "+Global.MAX_IMG_SIZE+" " +Global.reportFolder+"Rplots"+pdfNumber+".pdf --out "+Global.reportFolder+"img/"+temp.getName()+"_earlyLate.jpg  > /dev/null\n";
			pdfNumber++;
			toReturn += "sips -s format jpeg -s formatOptions 100 -Z "+Global.MAX_IMG_SIZE +" "+Global.reportFolder+"Rplots"+pdfNumber+".pdf --out "+Global.reportFolder+"img/"+temp.getName()+"_increment.jpg  > /dev/null\n";
			pdfNumber++;
		}
		return toReturn;
	}
	
}
