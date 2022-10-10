package com.PagesObjets;

import java.io.File;


import com.MapsObjet.MapsObjectsWidgets;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PagsObjetWidgets extends MapsObjectsWidgets
{
//	String busquedas = null;
	//CREAR EL CONSTRUCTOR DE LA CLASE
	public PagsObjetWidgets(AppiumDriver<MobileElement> driver)
	{
		super (driver);
		this.driver =(AppiumDriver<MobileElement>) driver;
	}

	public void widgets(String url,File rutaCarpeta,String generarEvidencia) throws InterruptedException, Exception
	{
		
		//REALIZAR CLICK EN EL BUSCADOR
		click(btnBusGoogle,rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(1000);
		//ESCRIBIR EN EL INPUT
		sendkey(url,btnBusGoogle,rutaCarpeta,generarEvidencia);
		//DAR ENTER A LA BUSQUEDA
		enter(btnBusGoogle,rutaCarpeta,generarEvidencia);
		//REALIZAR SCROLL
		scrollVertical(btnBusGoogle,rutaCarpeta,generarEvidencia,532,960,0,4);
		//REALIZAR CLICK EN WIDGETS
		click(btnWidgets,rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(1000);
		//REALIZAR SCROLL
		scrollVertical(btnWidgets,rutaCarpeta,generarEvidencia,532,540,1400,3);
		//TIEMPO DE ESPERA
		tiempoEspera(1000);
		//REALIZAR CLICK EN DATE PICKER
		click(btnDatePicker,rutaCarpeta,generarEvidencia);
		//REALIZAR SCROLL
		scrollVertical(btnDatePicker,rutaCarpeta,generarEvidencia,532,540,1400,2);
		//SELECCIONAR EL INPUT DE SELECT DATE
		click(btnSelectDate,rutaCarpeta,generarEvidencia);
		//BORRAR CAMPO
		borrar(btnSelectDate,rutaCarpeta,generarEvidencia);
		//ESCRIBIR EN EL INPUT
		sendkey(fechaDateWidgets(),btnSelectDate,rutaCarpeta,generarEvidencia);
		//DAR ENTER AL CAMPO
		enter(btnSelectDate,rutaCarpeta,generarEvidencia);
		//SELECCIONAR EL INPUT DE DATE AND TIME
		click(btnDateAndTime,rutaCarpeta,generarEvidencia);
		//BORRAR CAMPO
		borrar(btnDateAndTime,rutaCarpeta,generarEvidencia);
		//ESCRIBIR EN EL INPUT
		sendkey(fechaDateWidgets(),btnDateAndTime,rutaCarpeta,generarEvidencia);
		//DAR ENTER A LA BUSQUEDA
		enter(btnDateAndTime,rutaCarpeta,generarEvidencia);
		
				
	}
		

}
