package it.unibz.esm.util;

public class Stage {
	private boolean isEarly ;
	private int length;
	private String startDate ; //AAAA-MM-DD
	private String endDate ;  //AAAA-MM-DD
	public static final String EARLY = "e";
	public static final String LATE = "l";
	
	public Stage(String startDate, String endDate,String type,int length) {
		super();
		this.startDate = startDate;
		this.length=length;
		this.endDate = endDate;
		if (type.equals(EARLY) )
		 this.isEarly=true;	
		else 
		 this.isEarly=false;
	}
	
	public boolean isEarly() {
		return isEarly;
	}
	public void setEarly(boolean isEarly) {
		this.isEarly = isEarly;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	

}
