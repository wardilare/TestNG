package com.MapsObjet;


import org.openqa.selenium.By;

import com.ClaseBase.ClasesBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapsObjectsAlerts extends ClasesBase
{
	
	//CONSTRUCTOR DE LA CLASE
	
	public MapsObjectsAlerts(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}	
	

	//ELEMENTOS DE PAGINA PRINCIPAL 
	
	
	protected By btnBusGoogle= By.id("com.android.chrome:id/url_bar");
	protected By btnAlertsFrame= By.xpath("//android.widget.TextView[@text='Alertas, marco y ventanas']");
	protected By btnAlerts= By.xpath("//android.widget.TextView[@text='Alertas']");
	protected By btnClick= By.xpath("//android.widget.Button[@resource-id='alertButton']");
	protected By btnClickAceptar= By.xpath("//android.widget.Button[@text='Aceptar']");
	protected By btnClickCancelar= By.xpath("//android.widget.Button[@text='Cancelar']");
	protected By btnClick2= By.xpath("//android.widget.Button[@resource-id='timerAlertButton']");
	protected By btnClick3= By.xpath("//android.widget.Button[@resource-id='confirmButton']");
	protected By btnClick4= By.xpath("//android.widget.Button[@resource-id='promtButton']");
	protected By btnInput= By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/js_modal_dialog_prompt']");
	
	
}
