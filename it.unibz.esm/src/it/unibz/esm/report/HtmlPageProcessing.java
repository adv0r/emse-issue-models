package it.unibz.esm.report;

import it.unibz.esm.core.Global;

public class HtmlPageProcessing {
	

	public static String getHtmlCode(String reportName,int projectNumber)
	{
		String toReturn ="";
		
		toReturn+="		<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\n"+
		"<html xmlns='http://www.w3.org/1999/xhtml'>\n"+
		"<head>\n"+
		"<title>ESM - Processing tests</title>\n"+
		"<meta http-equiv='Content-Type' content='text/html'; charset=UTF-8' />\n"+   
		"<META HTTP-EQUIV='REFRESH' CONTENT='"+getDelay(projectNumber)+"; URL="+getReportUrl()+"'>\n"+
		"<link href='../../"+Global.HTML_DIR+"style.css' rel='stylesheet' type='text/css' />\n"+
		"<script type='text/javascript' src='../../"+Global.HTML_DIR+"js/cufon-yui.js'></script>\n"+
		"<script type='text/javascript' src='../../"+Global.HTML_DIR+"js/droid_sans_400-droid_sans_700.font.js'></script>\n"+
		"<script type='text/javascript' src='../../"+Global.HTML_DIR+"js/cuf_run.js'></script>\n"+
		"<script type='text/javascript' src='../../"+Global.HTML_DIR+"js/jquery-1.3.2.min.js'></script>\n"+
		"<script type='text/javascript' src='../../"+Global.HTML_DIR+"js/radius.js'></script>\n"+
		"<!-- CuFon ends -->\n"+
		"</head>\n"+
		"<body>\n"+
		"<div class='main'>\n"+
		 " <div class='header'>\n"+
		    "<div class='header_resize'>\n"+
		     "<div class='menu_nav'> \n"+
		      "</div>\n"+
		      "<div class='logo'>\n"+
		        "<h1><a href='#'>Empirical <span>Software</span> Measurment<small>Semester Project - Generating "+reportName+" </small></a></h1>\n"+
		      "</div>\n"+
		      "<div class='clr'></div>\n"+
		    "</div>\n"+
		  "</div>\n"+
		  "<div class='content'>\n"+
		    "<div class='content_resize' style='text-align:center'>\n"+
		     "<h2><span>Please Wait</span></h2>\n"+
		      "<div class='clr'></div>\n"+
		    "Running statistical  analysis and tests ...<img src='../../"+Global.HTML_DIR+"images/loading.gif' width='49' height='50' alt='loading' /></div>\n"+
		  "</div>\n"+
		  "<div class='footer'>\n"+
		   " <div class='footer_resize'>\n"+
		     " <p class='lf'><em>&copy; Copyright 2011 - Free University of Bolzano</em></p>\n"+
		     " <div class='clr'></div>\n"+
		   " </div>\n"+
		  "</div>\n"+
		"</div>\n"+
		"</body>\n"+
		"</html>\n";
		return toReturn;
		
	}
	
	private static int getDelay(int projectNumber)
	{
		return (int) (3 + Math.round(projectNumber * 0.3));
	}
	
	private static String getReportUrl()
	{
		return "file:///"+Global.reportFolder+Global.HTML_REPORT_FILENAME;
	}

}
