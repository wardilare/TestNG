package com.PagesObjets;

import java.io.File;



import com.MapsObjet.MapsObjectsAlerts;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PagsObjetAlerts extends MapsObjectsAlerts
{

	//CREAR EL CONSTRUCTOR DE LA CLASE
	public PagsObjetAlerts(AppiumDriver<MobileElement> driver)
	{
		super (driver);
		this.driver =(AppiumDriver<MobileElement>) driver;
	}

	public void alerts(String url,String text,File rutaCarpeta,String generarEvidencia) throws InterruptedException, Exception
	{
		
		//REALIZAR CLICK EN EL BUSCADOR
		click(btnBusGoogle,rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(1000);
		//ESCRIBIR EN EL INPUT
		sendkey(url,btnBusGoogle, rutaCarpeta,generarEvidencia);
		//DAR ENTER A LA BUSQUEDA
		enter(btnBusGoogle,rutaCarpeta,generarEvidencia);
		//REALIZAR SCROLL
		scrollVertical(btnBusGoogle,rutaCarpeta,generarEvidencia,532,960,0,3);
		//REALIZAR CLICK EN ALERTS,FRAME
		click(btnAlertsFrame,rutaCarpeta,generarEvidencia);
		//REALIZAR SCROLL
		scrollVertical(btnAlertsFrame,rutaCarpeta,generarEvidencia,532,540,1400,2);
        
		//REALIZAR CLICK EN ALERTS
		click(btnAlerts,rutaCarpeta,generarEvidencia);
		//REALIZAR SCROLL
		 scrollVertical(btnAlertsFrame,rutaCarpeta,generarEvidencia,532,540,1400,3);
        tiempoEspera(2000);
        //REALIZAR SCROLL
      	scrollVertical(btnBusGoogle,rutaCarpeta,generarEvidencia,532,960,0,3);
        //REALIZAR CLICK EN EL PRIMER CLICK ME
		click(btnClick,rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(1000);
		//REALIZAR CLICK EN ACEPTAR
		click(btnClickAceptar,rutaCarpeta,generarEvidencia);
		//REALIZAR CLICK EN EL SEGUNDO CLICK ME
		click(btnClick2,rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(6000);
		//REALIZAR CLICK EN ACEPTAR
		click(btnClickAceptar,rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(1000);
		//REALIZAR CLICK EN EL TERCER CLICK ME
		click(btnClick3,rutaCarpeta,generarEvidencia);
		//REALIZAR CLICK EN ACEPTAR
		click(btnClickAceptar,rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(1000);
		//REALIZAR CLICK EN EL TERCER CLICK ME
		click(btnClick3,rutaCarpeta,generarEvidencia);
		//REALIZAR CLICK EN CANCELAR
		click(btnClickCancelar,rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(1000);
		//REALIZAR CLICK EN EL TERCER CLICK ME
		click(btnClick4,rutaCarpeta,generarEvidencia);
		//ESCRIBIR EN EL INPUT
		sendkey(text,btnInput, rutaCarpeta,generarEvidencia);
		//REALIZAR CLICK EN ACEPTAR
		click(btnClickAceptar,rutaCarpeta,generarEvidencia);
				
	}
		


}
