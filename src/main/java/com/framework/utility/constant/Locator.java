package com.framework.utility.constant;

public interface Locator {

	public String Sel_Tut="XPATH##//a[@href='https://www.javatpoint.com/selenium-tutorial']";
	String Sel_Feat="XPATH##//a[@href='selenium-basic-terminology']/following-sibling:: a[@href='selenium-features']";
	String Search_box="XPATH##//td[@id=\"gs_tti50\"]/child::input[@name=\"search\" and @class=\"gsc-input\"]";
	String Search_Btn = "XPATH##//tbody/tr/td/div/div/div/div/form/table/tbody/tr/td[2]/button";
	String Sort_btn = "XPATH##//div/div/div/table/tbody/tr/td/div/div/div/div/div/div[3]/table/tbody/tr/td[2]/div/div[2]/div/div[2]";
	String Sort_By_Date_Btn = "XPATH##//div/div/div/table/tbody/tr/td/div/div/div/div/div/div[3]/table/tbody/tr/td[2]/div/div[2]/div[2]/div[2]/div[@class='gsc-option']";

}
