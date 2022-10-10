package com.MapsObjet;


import org.openqa.selenium.By;

import com.ClaseBase.ClasesBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapsObjetCalculadora extends ClasesBase
{
	
	//CONSTRUCTOR DE LA CLASE
	
	public MapsObjetCalculadora(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}	
	

	//ELEMENTOS DE PAGINA PRINCIPAL 
	
	protected By btnNumero= By.xpath("//android.widget.Button[@text = '{0}']");
	protected By btnOperacion= By.xpath("//android.widget.ImageView[@content-desc='{0}']");
	protected By btnIgual= By.xpath("//android.widget.ImageView[@content-desc='igual a']");
	protected By btnLimpiar =By.xpath("//android.widget.ImageView[@content-desc='borrar']");
		
	

}
