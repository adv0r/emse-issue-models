package it.unibz.esm.UI;

import it.unibz.esm.core.Global;
import it.unibz.esm.report.HtmlPageProcessing;
import it.unibz.esm.report.HtmlPageReport;
import it.unibz.esm.report.OutputWriter;
import it.unibz.esm.util.BareBonesBrowserLaunch;
import it.unibz.esm.util.Product;
import it.unibz.esm.util.RHandler;

import javax.swing.JFrame;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InitialFrame extends JFrame {

    JLabel projectsLabel;
    JButton goBtn;
    JPanel content;
    JList productList;
   
    public InitialFrame() {

        content = new JPanel();
        content.setLayout(new BorderLayout(5, 5));
            
        /*Main Panel*/

        projectsLabel = new JLabel("Select projects to analyze");
        productList = new JList(Global.ProductsNames);
        
        JButton goBtn = new JButton("GO!!!");
        goBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { go(); } });
        
        
        content.add(projectsLabel,BorderLayout.NORTH);
        content.add(productList,BorderLayout.CENTER);
        content.add(goBtn, BorderLayout.SOUTH);


        setContentPane(content);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ESM | Semester Project | Launcher");
        setLocation(100, 100);
        setSize(300, 300);
        setVisible(true);
    }

    

    private void go()
    {
    	Global.generateReportName(); //TODO 
    	
    	if(!productList.isSelectionEmpty()){
    		
    		/*Create an arrayList with selected Projects*/
    		Global.ProductsSelected = new ArrayList<Product>();
    		int[] selectedIndex = productList.getSelectedIndices();
    		for (int j=0; j< selectedIndex.length; j++)
    		{
    			Global.ProductsSelected.add(Global.Products.get(selectedIndex[j]));
    		}
    		
    		/*Hide the frame*/
    		this.setVisible(false);
    		
    		/*Generate the HTML page "processing" */

    		String htmlSourceProcessing = HtmlPageProcessing.getHtmlCode(Global.ReportName, Global.Products.size()) ;
    		

    		  try {
    			RHandler.execute();
    			String pathToProcessing = Global.reportFolder+Global.HTML_PROCESSING_FILENAME;
    			String urlToProcessing = "file://"+pathToProcessing;
				OutputWriter.write(htmlSourceProcessing, pathToProcessing);  
	    	    BareBonesBrowserLaunch.openURL(urlToProcessing);
	    	    
	    		/*Generate the HTML page "report" */
	    		String htmlSourceReport = HtmlPageReport.getHtmlCode() ;
				OutputWriter.write(htmlSourceReport, Global.reportFolder+Global.HTML_REPORT_FILENAME);
	    	    
	    		System.exit(0); //Close the application
			} catch (IOException e) {
				e.printStackTrace();
			}
    	    

    	}
    	else
    		JOptionPane.showMessageDialog(null, "Select at least one project");
    }
}