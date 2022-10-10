package com.PagesObjets;

import java.io.File;

import com.MapsObjet.MapsObjetMercadoLibre;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PagsObjetMercadoLibre extends MapsObjetMercadoLibre
{
//	String busquedas = null;
	//CREAR EL CONSTRUCTOR DE LA CLASE
	public PagsObjetMercadoLibre(AppiumDriver<MobileElement> driver)
	{
		super (driver);
		this.driver =(AppiumDriver<MobileElement>) driver;
	}

	public void mercadoLibre(String url,String producto,String email,File rutaCarpeta,String generarEvidencia) throws InterruptedException, Exception
	{
		
		//REALIZAR CLICK EN EL BUSCADOR
		click(btnBusGoogle,rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(1000);
		//ESCRIBIR EN EL INPUT
		sendkey(url,btnBusGoogle, rutaCarpeta,generarEvidencia);
		//TOCAR PANTALLA
		//tocarPantalla(325,387);
		//DAR ENTER A LA BUSQUEDA
		enter(btnBusGoogle,rutaCarpeta,generarEvidencia);
		//REALIZAR CLICK EN EL BUSCADOR
		click(btnBusObjeto,rutaCarpeta,generarEvidencia);
		//ESCRIBIR EN EL INPUT DE BUSQUEDA DE MERCADO LIBRE
		sendkey(producto,btnBusObjeto, rutaCarpeta,generarEvidencia);
		//DAR ENTER A LA BUSQUEDA
		enter(btnBusObjeto,rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(3000);
		//ESCOGER ALGUNA OPCION
		click(btnProducto,rutaCarpeta,generarEvidencia);
		//REALIZAR SCROLL
		scrollVertical(btnProducto,rutaCarpeta,generarEvidencia,532,400,0,7);
		//REALIZAR CLICK EN EL BOTON DE AGREGAR A CARRITO
		click(btnAddCarrito,rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		//REALIZAR CLICK EN EL BOTON DE CREAR CUENTA
		click(btnCrearCuenta,rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		//REALIZAR CLICK EN EL CHECKBOX
		click(btnCheckBox,rutaCarpeta,generarEvidencia);
		//REALIZAR CLICK EN EL BOTON DE CONTINUAR
		click(btnContinuar,rutaCarpeta,generarEvidencia);
		//REALIZAR CLICK EN EL BOTON DE VALIDAR
		click(btnValidar,rutaCarpeta,generarEvidencia);
		//ESCRIBIR EN EL INPUT DE GMAIL
		sendkey(email,btnInput, rutaCarpeta,generarEvidencia);
				
	}
		


}
