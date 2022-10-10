package com.MapsObjet;


import org.openqa.selenium.By;

import com.ClaseBase.ClasesBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapsObjectsWidgets extends ClasesBase
{
	
	//CONSTRUCTOR DE LA CLASE
	
	public MapsObjectsWidgets(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}	
	

	//ELEMENTOS DE PAGINA PRINCIPAL 
	
	protected By btnBusGoogle= By.id("com.android.chrome:id/url_bar");
	protected By btnWidgets= By.xpath("//android.widget.TextView[@text='Widgets']");
	protected By btnDatePicker= By.xpath("//android.widget.TextView[@text='Selector de fechas']");
	protected By btnSelectDate= By.xpath("//android.widget.EditText[@resource-id='datePickerMonthYearInput']");
	protected By btnDateAndTime= By.xpath("//android.widget.EditText[@resource-id='dateAndTimePickerInput']");

	
	
}
