package com.PagesObjets;

import java.io.File;

import com.MapsObjet.MapsObjetCalculadora;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PagsObjetCalculadora extends MapsObjetCalculadora
{

	//CREAR EL CONSTRUCTOR DE LA CLASE
	public PagsObjetCalculadora(AppiumDriver<MobileElement> driver)
	{
		super (driver);
		this.driver =(AppiumDriver<MobileElement>) driver;
	}

	public void OperacionSuma(String num1,String operacion,String num2,File rutaCarpeta,String generarEvidencia) throws InterruptedException, Exception
	{
		// CLICK EN LIMPIAR
		click(localizadorVariable(btnLimpiar,operacion),rutaCarpeta,generarEvidencia);
		//CLIC AL PRIMER NUMERO
		numeroSeparados(num1,btnNumero,rutaCarpeta,generarEvidencia);
		// CLICK EN EL OPERADOR SUMA
		click(localizadorVariable(btnOperacion,operacion),rutaCarpeta,generarEvidencia);
		//CLIC AL SEGUNDO NUMERO
		numeroSeparados(num2,btnNumero,rutaCarpeta,generarEvidencia);
		//CLIC EN EL SIGNO IGUAL
		click(btnIgual,rutaCarpeta,generarEvidencia);
		// CLICK EN LIMPIAR
		click(localizadorVariable(btnLimpiar,operacion),rutaCarpeta,generarEvidencia);
		
		
	}
 	


}
