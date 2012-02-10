package it.unibz.esm.util;

public class Product {
	
	private String name;
	private Stage earlyStage;
	private Stage lateStage;
	private String csv;

	public Product(String name, Stage earlyStage, Stage lateStage,String csv) {
		super();
		this.name = name;
		this.earlyStage = earlyStage;
		this.lateStage = lateStage;
		this.csv=csv;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Stage getEarlyStage() {
		return earlyStage;
	}
	
	public void setEarlyStage(Stage earlyStage) {
		this.earlyStage = earlyStage;
	}
	
	public Stage getLateStage() {
		return lateStage;
	}
	
	public void setLateStage(Stage lateStage) {
		this.lateStage = lateStage;
	}
	
	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

}
