package it.unibz.esm.report;

import it.unibz.esm.core.Global;
import it.unibz.esm.parser.RParserOutput;
import it.unibz.esm.util.Product;
import it.unibz.esm.util.Stage;

public class HtmlPageReport {
	
	public static String getHtmlCode()
	{
		String toReturn = "";
		toReturn+=getHeader();
		toReturn+=getBody();
		toReturn+=getFooter();

	    return toReturn;
	}

	
	private static String getHeader()
	{
		String toReturn = "";
	    toReturn+="<!-- Header Begin -->\n"+
	    	"<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\n"+
	    	"<html xmlns='http://www.w3.org/1999/xhtml'>\n"+
	    	"<head>\n"+
	    	"<title>ESM - Report "+Global.ReportName+" - Semester project</title>\n"+
	    	"<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />\n"+
	    	"<link href='../../resources/html/style2.css' rel='stylesheet' type='text/css' />\n"+
	    	"<link rel='stylesheet' href='../../resources/html/lightbox.css' type='text/css' media='screen' />\n"+
	    	"<script type='text/javascript' src='../../resources/html/js/cufon-yui.js'></script>\n"+
	    	"<script type='text/javascript' src='../../resources/html/js/droid_sans_400-droid_sans_700.font.js'></script>\n"+
	    	"<script type='text/javascript' src='../../resources/html/js/cuf_run.js'></script>\n"+
	    	"<script type='text/javascript' src='../../resources/html/js/jquery-1.3.2.min.js'></script>\n"+
	    	"<script type='text/javascript' src='../../resources/html/js/radius.js'></script>\n"+
	    	"<script type='text/javascript' src='../../resources/html/js/prototype.js'></script>\n"+
	    	"<script type='text/javascript' src='../../resources/html/js/scriptaculous.js?load=effects,builder'></script>\n"+
	    	"<script type='text/javascript' src='../../resources/html/js/lightbox.js'></script>\n"+
	    	"</head>\n"+
	    	"<!-- Header End -->\n";
	    return toReturn;
	}

	
	private static String getBody()
	{
		String toReturn = "";
		toReturn+="<!-- Body Begin -->\n"+
			"<body>\n"+
			"<div class='main'>\n"+
			"<div class='header'>\n"+
			"<div class='header_resize'>\n"+
			"<div class='menu_nav'>   \n"+ 
			"</div>\n"+
			"<div class='logo'>\n"+
			"<h1><a href='#'>Empirical <span>Software</span> Measurement <small>Report "+Global.ReportName+" </small></a></h1>\n"+
			"</div>\n"+
			"<div class='clr'></div>\n"+
			"</div>\n"+
			"</div>\n"+
			"<div class='content'>\n"+
			"<div class='content_resize'>\n"+
			"<div class='mainbar'>\n";
      
		toReturn+=getItems();
        
		toReturn+="<div class='clr'></div>\n"+
			"</div>\n"+
			"</div>\n"+
			"<!-- Body End -->\n";
	    return toReturn;
	}

	
	private static String getFooter()
	{
		String toReturn = "";
		toReturn+="<!-- Footer Begin -->\n"+
			"<div class='fbg'>\n"+
			"<div class='fbg_resize'>\n"+
			"<div class='col c1'>\n"+
			"<h2>EMSE</h2>\n"+
			"<a href='http://www.unibz.it'><img src='../../resources/html/images/emse.jpg' width='270' height='130' alt='pix' /></a>\n"+
			"</div>\n"+
			"<div class='col c2'>\n"+
			"<h2><span>Info box</span></h2>\n"+
			"<p>This tool was created for the final project of Empirical Software Measurement course, under the supervision of Prof. Pekka Abrahamson and Mariano Ceccato.</p>\n"+
			"<p>Free University of Bolzano</p>\n"+
			"</div>\n"+
			"<div class='col c3'>\n"+
			"<h2><span>Contact</span></h2>\n"+
			"<p>To contact the authors of this tools write an email to</p>\n"+
			"<p><a href='mailto:paternoster.nicolo@gmail.com'>Paternoster Nicolo<br /></a> \n"+
			"<p><a href='mailto:carmine.giardino@gmail.com'>Giardino Carmine<br /></a> \n"+
			"</a>   \n"+
			"<p>Master Students of <a href='http://emse.fi.upm.es/' target='_blank' >EMSE</a></p>\n"+
			"</div>\n"+
			"<div class='clr'></div>\n"+
			"</div>\n"+
			"</div>\n"+
			"<div class='footer'>\n"+
			"<div class='footer_resize'>\n"+
			"<p class='lf'><em>&copy; Copyright 2011 - Free University of Bolzano</em></p>\n"+
			"<div class='clr'></div>\n"+
			"</div>\n"+
			"</div>\n"+
			"</div>\n"+
			"</body>\n"+
			"</html>\n"+
			"<!-- Footer end -->\n";
	    return toReturn;
	}

	private static String getItems()
	{
		String toReturn="";
		
		for(int i=0; i<Global.ProductsSelected.size();i++)
		{
			Product p= Global.ProductsSelected.get(i);
			toReturn+="<!-- ITEM Begin -->\n"+
	        	"<div class='article'>\n"+
	        	"<h2  style=' text-align:center'><span >Product Name : "+p.getName()+"</span> </h2>\n"+
	        	"<table width='100%' border='0' style='border-bottom:solid 1px black;'>\n"+
	            "<td width='50%' style=' text-align:center'><br/>\n"+
	            "<h3>Product Overview</h3>\n"+
	            "<p><strong>Stage Duration [days] :</strong> "+p.getEarlyStage().getLength()+" <br />\n"+
	            "<strong>Early Stage Start :</strong> "+p.getEarlyStage().getStartDate()+"<br />\n"+
	            "<strong>Early Stage end :</strong> "+p.getEarlyStage().getEndDate()+"<br />\n"+
	            "<strong>Late Stage Start :</strong> "+p.getLateStage().getStartDate()+" <br />\n"+
	            "<strong>Late Stage end :</strong> "+p.getLateStage().getEndDate()+" <br />\n"+
	            "<strong>p-value: </strong>"+RParserOutput.getpValue(p.getCsv())+"<br />\n"+
	            "<strong>Raw data : </strong> <a href='../../"+Global.CSV_DIR+p.getCsv()+"'> .csv</a> | <a href='"+Global.R_OUTPUT_FILENAME+"'> .r.out</a><br />\n"+
	            "</p><br/>\n"+
	            "<h3><span>Regression line </span></h3>\n"+
	            "<p><a href='img/"+p.getName()+"_earlyLate.jpg'  rel='lightbox["+p.getName()+"]' ><img src='img/"+p.getName()+"_earlyLate.jpg' alt='img1' width='400' height='300' border='0' /></a></p>\n"+          
	            "<h3><span>Regression table </span></h3>\n"+
	            "<p>\n"+
	            "<textarea name='regression_"+p.getName()+"' cols='50' rows='16' readonly='readonly' style='margin-left:auto;margin-right:auto;width:50%;'>\n"+
	            "Early Stage : \n"+
	            RParserOutput.getRegressionTable(p.getCsv(),Stage.EARLY)+
	            " \n \nLate Stage : \n"+
	            RParserOutput.getRegressionTable(p.getCsv(),Stage.LATE)+
	            "</textarea>\n"+
	            "<br/>\n"+
	            "</p>\n"+
	            "<h3><span>Box plot </span></h3>\n"+
	            "<p><a href='img/"+p.getName()+"_box.jpg' rel='lightbox["+p.getName()+"]' ><img src='img/"+p.getName()+"_box.jpg' alt='img1' width='400' height='300' border='0'/></a></p>\n"+ 
	            "<p>\n"+ 
	            "<textarea name='quartile_"+p.getName()+"' cols='10' rows='8' readonly='readonly' style='margin-left:auto;margin-right:auto;width:35%;'>\n"+ 
	            "Quartiles \nEarly Stage : \n"+
	            RParserOutput.getQuartileTable(p.getCsv(),Stage.EARLY)+
	            " \n \nLate Stage : \n"+
	            RParserOutput.getQuartileTable(p.getCsv(),Stage.LATE)+
	            "</textarea>\n"+ 
	            "</p>\n"+ 	           
	            "<h3><span>Co-factor </span></h3>\n"+
	            "<p><a href='img/"+p.getName()+"_increment.jpg'  rel='lightbox["+p.getName()+"]' ><img src='img/"+p.getName()+"_increment.jpg' alt='img1' width='400' height='300' border='0' /></a></p>\n"+
	            "<h3><span>Analisys of variance</span> </h3>\n"+
	            "<p>\n"+
	            "<textarea name='variance_"+p.getName()+"' cols='51' rows='7' readonly='readonly' style='margin-left:auto;margin-right:auto;width:50%;'>\n"+
	            RParserOutput.getVarianceTable(p.getCsv())+
	            "</textarea>\n"+        
	            "</td>\n"+
	            "</tr>\n"+
	            "</table><br/><br/>\n"+
	            "<h3>&nbsp;</h3>\n"+
	            "<br \\></div>\n"+
	            "<!-- ITEM END -->\n";
		}
		return toReturn;
	}
	
}
