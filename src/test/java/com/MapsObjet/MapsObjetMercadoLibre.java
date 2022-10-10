package com.MapsObjet;


import org.openqa.selenium.By;

import com.ClaseBase.ClasesBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapsObjetMercadoLibre extends ClasesBase
{
	
	//CONSTRUCTOR DE LA CLASE
	
	public MapsObjetMercadoLibre(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}	
	

	//ELEMENTOS DE PAGINA PRINCIPAL 
	
	protected By btnPestaña= By.xpath("//android.widget.ImageButton[@content-desc='Nueva pestaña']");
	protected By btnBusGoogle= By.id("com.android.chrome:id/url_bar");
	protected By btnBusObjeto= By.xpath("//android.widget.EditText[@resource-id='cb1-edit']");
	protected By btnProducto= By.xpath("(//android.view.View)[18]");
	protected By btnAddCarrito= By.xpath("//android.widget.Button[@text='Agregar al carrito']");
	protected By btnCrearCuenta= By.xpath("//android.view.View[@content-desc='Crear cuenta']");
	protected By btnCheckBox= By.xpath("//android.widget.CheckBox[@text='Autorizo el uso de mis datos de acuerdo a la Declaración de Privacidad (abrirá una nueva ventana) y acepto los Términos y condiciones (abrirá una nueva ventana) .']");
	protected By btnContinuar= By.xpath("//android.view.View[@content-desc='Continuar']");
	protected By btnValidar= By.xpath("//android.widget.Button[@text='Validar']");
	protected By btnInput= By.xpath("//android.widget.EditText");
	
	
	
}
