package com.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import com.ClaseBase.ClasesBase;
import com.PagesObjets.PagsObjetAlerts;
import com.PagesObjets.PagsObjetCalculadora;
import com.PagesObjets.PagsObjetMercadoLibre;
import com.PagesObjets.PagsObjetWidgets;
import com.utilidades.GenerarReportePdf;
import com.utilidades.MyScreenRecorder;
import com.utilidades.Utilidades;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;




public class RunTestNG 
{
 
	@SuppressWarnings("rawtypes")
	private AppiumDriver driver;
	ClasesBase claseBase;
	PagsObjetCalculadora paginaOperaciones;
	PagsObjetMercadoLibre paginaMercadoLibre;
	PagsObjetAlerts paginaAlerts; 
	PagsObjetWidgets paginaWidgets;
	GenerarReportePdf generarReportePdf;
	String rutaImgEncabezadoML,rutaImgEncabezadoCL,rutaImgEncabezadoTQA,platformNameCL,deviceNameCL,platformVersionCL,
	noResetCL,autoGrantPermissionsCL;
	
  @BeforeClass
  @Parameters({"rutaImgML","rutaImgCL","rutaImgTQA","platformName","deviceName","platformVersion","noReset","autoGrantPermissions"})
  public void beforeClass(@Optional("default") String rutaImgML,
		  				  @Optional("default") String rutaImgCL,
		  				  @Optional("default") String rutaImgTQA,
		  				  @Optional("default") String platformName,
		  				  @Optional("default") String deviceName,
		  				  @Optional("default") String platformVersion,
		  				  @Optional("default") String noReset,
		  				  @Optional("default") String autoGrantPermissions) throws Exception
  {
	  System.out.println(rutaImgCL);
	  System.out.println(rutaImgTQA);
	 
	
	//INSTANCIAR CLASE REPORTES
	generarReportePdf = new GenerarReportePdf();
	//GRABAR EN LA VARIABLE LA RUTA
	rutaImgEncabezadoML=rutaImgML;
	//GRABAR EN LA VARIABLE LA RUTA
	rutaImgEncabezadoCL=rutaImgCL;
	rutaImgEncabezadoTQA=rutaImgTQA;
	platformNameCL=platformName;
	deviceNameCL=deviceName;
	platformVersionCL=platformVersion;
	noResetCL=noReset;
	autoGrantPermissionsCL=autoGrantPermissions;
  }
  
  @DataProvider(name="calculadora")
  public Object[][] datosCL() throws Exception
  {
	  try {
		  Object[][] arreglo=Utilidades.getTableArray("./Data/DataTest.xlsx", "calculadora");
		  return arreglo;
	} catch (Exception e) {
		System.out.println(e);
	}
	return null;
	  
  }  
 
  @DataProvider(name="mercadolibre")
  public Object[][] datos() throws Exception
  {
	  try {
		  Object[][] arreglo=Utilidades.getTableArray("./Data/DataTest.xlsx", "mercadolibre");
		  return arreglo;
	} catch (Exception e) {
		System.out.println(e);
	}
	return null;
	  
  }
  
  @DataProvider(name="alerts")
  public Object[][] datos2() throws Exception
  {
	  try {
		  Object[][] arreglo=Utilidades.getTableArray("./Data/DataTest.xlsx", "toolsqaAlerts");
		  return arreglo;
	} catch (Exception e) {
		System.out.println(e);
	}
	return null;
	  
  }
  
  @DataProvider(name="widgts")
  public Object[][] datos3() throws Exception
  {
	  try {
		  Object[][] arreglo=Utilidades.getTableArray("./Data/DataTest.xlsx", "toolsqaWidgets");
		  return arreglo;
	} catch (Exception e) {
		System.out.println(e);
	}
	return null;
	  
  }
 
  @SuppressWarnings("unchecked")
  @Test(dataProvider = "calculadora",priority=1)
  public void calculadoraTestNG(String num1,String operacion,String num2,String appPackage,String appActivity,String generarReporte,String run) throws Exception 
  {

	  	if(run.equals("On")) {
	  		
			driver= ClasesBase.appiumDriverConnetion(platformNameCL,deviceNameCL,platformVersionCL,appPackage,appActivity,noResetCL,autoGrantPermissionsCL);

	  		claseBase = new ClasesBase(driver);
	  		paginaOperaciones = new PagsObjetCalculadora(driver);
	  		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			
			
			if(generarReporte.equals("Si")) {
				try{
				    //GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
				    generarReportePdf.setRutaImagen(rutaImgEncabezadoCL);
					//INICIO DE LA GRABACION DEL VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
					//ACCEDER A LA CALCULADORA
					paginaOperaciones.OperacionSuma(num1,operacion,num2,rutaCarpeta,generarReporte );
					//FINALIZA GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.cerrarPalntilla();
				}catch(Exception e)
				{
				  System.out.println(e);	
				}
			}else 
			{
				//ACCEDER A LA CALCULADORA
				paginaOperaciones.OperacionSuma(num1,operacion,num2,rutaCarpeta,generarReporte );	
			}
	  	}else {
	  		//URL ACCESO ALA PAGINA
	  		System.out.println("No a Seleccionado esta automatizacion");
	  	}
  }
  
  
  @SuppressWarnings("unchecked")
  @Test(dataProvider = "mercadolibre",priority=2)
  public void mercadoLibreTestNG(String url,String producto,String email,String appPackage,String appActivity,String generarReporte,String run) throws Exception 
  {

	  	if(run.equals("On")) {
	  		
			driver= ClasesBase.appiumDriverConnetion(platformNameCL,deviceNameCL,platformVersionCL,appPackage,appActivity,noResetCL,autoGrantPermissionsCL);

	  		claseBase = new ClasesBase(driver);
	  		paginaMercadoLibre = new PagsObjetMercadoLibre(driver);
	  		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			
			
			if(generarReporte.equals("Si")) {
				try{
				    //GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
				    generarReportePdf.setRutaImagen(rutaImgEncabezadoML);
					//INICIO DE LA GRABACION DEL VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
					//ACCEDER A LA CALCULADORA
					paginaMercadoLibre.mercadoLibre(url,producto,email,rutaCarpeta,generarReporte);
					
					//FINALIZA GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.cerrarPalntilla();
				}catch(Exception e)
				{
				  System.out.println(e);	
				}
			}else {
				
			}
	  	}else {
	  		//URL ACCESO ALA PAGINA
		  System.out.println("No a Seleccionado esta automatizacion");
	  	}
  }
  

  @SuppressWarnings("unchecked")
  @Test(dataProvider = "alerts",priority=3)
  public void alertsTestNG(String url,String text,String appPackage,String appActivity,String generarReporte,String run) throws Exception 
  {

	  	if(run.equals("On")) {
	  		
			driver= ClasesBase.appiumDriverConnetion(platformNameCL,deviceNameCL,platformVersionCL,appPackage,appActivity,noResetCL,autoGrantPermissionsCL);

	  		claseBase = new ClasesBase(driver);
	  		paginaAlerts = new PagsObjetAlerts(driver);
	  		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			
			
			if(generarReporte.equals("Si")) {
				try{
				    //GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
				    generarReportePdf.setRutaImagen(rutaImgEncabezadoTQA);
					//INICIO DE LA GRABACION DEL VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
					//ACCEDER A LA CALCULADORA
					paginaAlerts.alerts(url,text,rutaCarpeta,generarReporte);
					
					//FINALIZA GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.cerrarPalntilla();
				}catch(Exception e)
				{
				  System.out.println(e);	
				}
			}else {
				
			}
	  	}else {
	  		
	  		System.out.println("No a Seleccionado esta automatizacion");
	  	}
  }


  @SuppressWarnings("unchecked")
  @Test(dataProvider = "widgts",priority=4)
  public void widgetsTestNG(String url,String appPackage,String appActivity,String generarReporte,String run) throws Exception 
  {

	  	if(run.equals("On")) {
	  		
			driver= ClasesBase.appiumDriverConnetion(platformNameCL,deviceNameCL,platformVersionCL,appPackage,appActivity,noResetCL,autoGrantPermissionsCL);

	  		claseBase = new ClasesBase(driver);
	  		paginaWidgets = new PagsObjetWidgets(driver);
	  		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			
			
			if(generarReporte.equals("Si")) {
				try{
				    //GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
				    generarReportePdf.setRutaImagen(rutaImgEncabezadoTQA);
					//INICIO DE LA GRABACION DEL VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
					//ACCEDER A LA CALCULADORA
					paginaWidgets.widgets(url,rutaCarpeta,generarReporte);
					
					//FINALIZA GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.cerrarPalntilla();
				}catch(Exception e)
				{
				  System.out.println(e);	
				}
			}else {
				
			}
	  	}else {
	  		
	  		System.out.println("No a Seleccionado esta automatizacion");
	  	}
  }
  

  @AfterClass
  public void afterClass() 
  {
	  driver.quit();
  }

}
