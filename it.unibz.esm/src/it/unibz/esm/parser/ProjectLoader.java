package it.unibz.esm.parser;

import it.unibz.esm.core.Global;
import it.unibz.esm.util.Product;
import it.unibz.esm.util.Stage;

import com.csvreader.CsvReader;


public class ProjectLoader {
	
	public static void parse()
	{
	try {
		CsvReader products = new CsvReader(Global.PROJECTS_FILE);
		products.readHeaders();

		while (products.readRecord())
		{
			String ProjectName = products.get("ProjectName");
			String EarlyStageStart = products.get("EarlyStageStart");
			String EarlyStageEnd = products.get("EarlyStageEnd");
			String LateStageStart = products.get("LateStageStart");
			String LateStageEnd = products.get("LateStageEnd");
			String StageLength = products.get("StageLength");
			String PathToCsv = products.get("PathToCsv");
			
			Stage early = new Stage(EarlyStageStart,EarlyStageEnd,Stage.EARLY,Integer.parseInt(StageLength));
			Stage late = new Stage(LateStageStart,LateStageEnd,Stage.LATE,Integer.parseInt(StageLength));

			Global.Products.add(new Product(ProjectName,early,late,PathToCsv));
		}

		products.close();
		
		loadArrayWithNames();
		
	} catch (Exception e) {
		e.printStackTrace();
	} 
	
	}
	private static void loadArrayWithNames(){
		Global.ProductsNames = new String[Global.Products.size()];
		for (int i =0; i<Global.Products.size();i++)
			Global.ProductsNames[i] = Global.Products.get(i).getName();
	}
}
