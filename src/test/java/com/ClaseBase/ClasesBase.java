package com.ClaseBase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.utilidades.GenerarReportePdf;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;



public class ClasesBase 
{
	
	protected AppiumDriver<MobileElement> driver;
	
	// CONSTRUCTOR DE CLASE
	public ClasesBase(AppiumDriver<MobileElement> driver)
	{
		super();
	}
	
	//METODO CONEXION PAGINA WEB EN CROMEDRIVER
	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConnetion(String platformName,String deviceName,String platformVersion,
			String appPackage,String appActivity,String noReset,String autoGrantPermissions) throws Exception
	
	{
		AppiumDriver driver = null;
		try {
			
			//CREAR LAS CAPA BILITIES DEL MOVIL
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName",platformName);
			caps.setCapability("deviceName",deviceName);
			caps.setCapability("platformVersion",platformVersion);
			caps.setCapability("appPackage",appPackage);
			caps.setCapability("appActivity",appActivity);
			caps.setCapability("noReset",noReset);
			caps.setCapability("autoGrantPermissions",autoGrantPermissions);
		
			//INSTANCIAR APPIUM DRIVER
			try {
				printConsola("Cargado Cability de appium, por favor espere...");
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps); 
				
			} catch (MalformedURLException e) {
				printConsola(e.getMessage());
			}
			return driver;
			
		} catch (Exception e) {
			printConsola(e.getMessage());
		}
		return driver;
		
	}
	
	//IMPRIMIR EN CONSOLE
	private static void printConsola(String texto) {
	System.out.println(texto);	
	}
	
	//METODO PARA DAR ENTER
	public void enter(By locator,File rutaCarpeta,String generarEvidencia)throws Exception
	{    
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		tiempoEspera(2000);
		captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
	}
	//METODO SCROLL EN MOBILE
	public void scrollVertical(By locator,File rutaCarpeta,String generarEvidencia, int xini,int yini, int yfinal, int iteraciones) throws Exception
	{
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();  
		for (int i = 1 ;i<=iteraciones;i++)
		{
			@SuppressWarnings("rawtypes")
			TouchAction touch = new TouchAction(driver);
			touch.press(PointOption.point(xini,yini))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(xini,yfinal))
			.release().perform();
			captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
		}
	}
	
	//METODO PARA REEMPLAZAR XPATH
    public By localizadorVariable(By locator, String valor)
    {
    	String jj = locator.toString().replace("{0}",valor);
    	String kk = jj.replace("By.xpath:", "");
    	By localizador=By.xpath(kk);
		return localizador;
    	
    }
    
    //METODO DE FECHA MENOS TIEMPO 
  	public static String fechaDateWidgets()
  	{
  		String[] fechaVector= fechaHora().split("-");
  		int year=Integer.parseInt(fechaVector[0]);
  		int mes=Integer.parseInt(fechaVector[1]);
  		int dia=Integer.parseInt(fechaVector[2]);
  					
  		dia=dia-1;
  		mes=mes-1;
  		year=year-1;		
  					
  		String fechaMenor=mes+"/"+dia+"/"+year;
  		return fechaMenor;
  	}
  	
	
	//METODO PARA SEPARAR NUMEROS DE VARIAS CIFRAS Y GUARDARLO EN UNO SOLO
	public void numeroSeparados (String numeros, By locator, File rutaCarpeta,String generarEvidencia ) throws Exception
	{
		String[] num= new String[numeros.length()] ;
			
		for (int i=0; i<numeros.length();i++) {
					num[i]=String.valueOf(numeros.charAt(i));
					click(localizadorVariable(locator,num[i]),rutaCarpeta,generarEvidencia);
			}			 
	}
		
	//METODO DEL CLICK
		public void click(By locator,File rutaCarpeta,String generarEvidencia) throws Exception
		{
			try {
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			driver.findElement(locator).click();
			tiempoEspera(2000);
			
			captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
			}
			catch(Exception e){
				captureScreenError(rutaCarpeta,locator,generarEvidencia,e.toString());
				//throw new InterruptedException();
			}
			{}
		}
		//METODO DEL CLICK
			public void clickTools(By locator,File rutaCarpeta,String generarEvidencia) throws Exception
			{
				try {
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
				driver.findElement(locator).click();
				tiempoEspera(2000);
				}
				catch(Exception e){
					captureScreenError(rutaCarpeta,locator,generarEvidencia,e.toString());
					//throw new InterruptedException();
				}
				
				
				
			}
		//METODO BORRAR
		public void borrar(By locator,File rutaCarpeta,String generarEvidencia) throws Exception
		{
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			tiempoEspera(2000);
			captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
		}
		//METODO ENVIAR TEXTO
		public void sendkey(String inputText, By locator,File rutaCarpeta, String generarEvidencia) throws Exception
		{
			try {
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			driver.findElement(locator).sendKeys(inputText);
			tiempoEspera(2000);
			captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
			}
			catch(Exception e){
				captureScreenError(rutaCarpeta,locator,generarEvidencia,e.toString());
				//throw new InterruptedException();
			}
		}
		//CAPTURE SCREEN ERROR
		public void captureScreenError(File rutaCarpeta, By locator, String evidencia, String msnError)
                throws Exception {
            if (evidencia.equals("Si")) {
                String hora = HoraSistema();
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
                String rutaImagen = new File(rutaCarpeta + "\\" + hora + ".png").toString();



              // INSTACIAMOS LA CLASE GENERAR PDF
                GenerarReportePdf informePdf = new GenerarReportePdf();
                // SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
                informePdf.crearbodyError(locator, rutaImagen, msnError);
                // ELIMINAR IMAGEN CREADA



              eliminarArchivo(rutaImagen);
            }
        }
		
		//METODO ENTER SUBMIN
		public void submit(By locator,File rutaCarpeta,String generarEvidencia) throws Exception
		{
			try {
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			driver.findElement(locator).submit();
			tiempoEspera(2000);
			captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
			}
			catch(Exception e){
				captureScreenError(rutaCarpeta,locator,generarEvidencia,e.toString());
				throw new InterruptedException();
			}
		}
		//METODO TIEMPO DE ESPERA
		public void tiempoEspera(long tiempo) throws InterruptedException
		{
			Thread.sleep(tiempo);
		}
		//IMPRIMIR MENSAJE CONSOLA
		public void imprimirMensaje(Exception mensaje) 
		{
			System.out.print(mensaje);
		}
		//METODO ENTER CLOSE COOKIE
		public void closeCookie(By locator,File rutaCarpeta,String generarEvidencia)throws Exception
		{
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//captureScreen(locator,rutaCarpeta,nomTest);
			driver.findElement(locator).click();
			tiempoEspera(2000);
			captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
		}
		//METODO CAPTURA DE LA FECHA DEL SISTEMA
		public static String fechaHora()
		{
			//TOMAMOS LA FECHA DEL SISTEMA 
			LocalDateTime fechaSistema = LocalDateTime.now();
			//DEFINIR FORMATO FECHA 
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}
		//METODO CAPTURA DE LA FECHA DEL SISTEMA
			public static String fechaHora2()
			{
				//TOMAMOS LA FECHA DEL SISTEMA 
				LocalDateTime fechaSistema = LocalDateTime.now();
				//DEFINIR FORMATO FECHA 
				DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				//DAR FORMATO A LA FECHA DEL SISTEMA
				String formatFecha = fecha.format(fechaSistema);
				return formatFecha;
			}
		//METODO PARA ELIMINAR ARCHIVOS
			public void eliminarArchivo(String rutaImagen)
			{
				try {
				File fichero = new File(rutaImagen);
				fichero.delete();
				}catch (Exception e) {
					System.out.println(e);// TODO: handle exception
				}
			}
		//METODO CAPTURA DE HORA DEL SISTEMA 
		public static String HoraSistema()
		{
			//TOMAMOS LA FECHA DEL SISTEMA 
			LocalTime horaSistema = LocalTime.now();
			//DEFINIR FORMATO FECHA 
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String hora = fecha.format(horaSistema);
			return hora;
		}
		//METODO CAPTURA DE SCREENSHOT
		public void captureScreen(By locator,File rutaCarpeta, String nomTest,String generarEvidencia) throws Exception
		{
			if("Si".equals(generarEvidencia)) {
			try
			{
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+nomTest+""+hora+".png"));
			String rutaImagen = new File(rutaCarpeta+"\\"+nomTest+""+hora+".png").toString();
			
			//INSTANCIAMOS LA CLASE DE GENERARREPORTES PDF
			GenerarReportePdf informePdf= new GenerarReportePdf();
			//SE INCERTA LOCALIZADOR Y RUTA DE LA IMAGEN EN EL PDF
			informePdf.crearBody(locator, rutaImagen);
			//ELIMINA EL ARCHIVO DE LA RUTA
			eliminarArchivo(rutaImagen);
			}catch(Exception e)
			{
				System.out.println(e);}
			}
		}
		//METODO CREAR CARPETA
		public File crearCarpeta( String nomTest)
		{
			//ALMACENAMOS LA FECHA DEL SISTEMA 
			String fecha = fechaHora();
			//CREAMOS EL NOMBRE DE LA CARPETA 
			String nomCarpeta = nomTest+"-"+fecha;
			//OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
			File directorio = new File("./output/"+nomCarpeta);
			//CREAMOS LA CARPETA
			directorio.mkdir();
			return directorio;
		}
		//METODO BUSCAR EN LISTA 
		public void selectOption( String inputText, By locator,File rutaCarpeta,String generarEvidencia) throws Exception
		{
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//CAPTURAMOS LA LISTA 
			Select selectList= new Select(driver.findElement(locator));
			//HACEMOS VISIBLE EL TEXTO DE ENTRADA
			selectList.selectByVisibleText(inputText);
			tiempoEspera(2000);
			captureScreen( locator,rutaCarpeta,nomTest,generarEvidencia);
				
		}
		//METODO MOVER EL SCROLLBY
				public void moverScroll(int y,int numMovimiento) throws Exception
				{
					
				JavascriptExecutor js = (JavascriptExecutor) driver;
				for (int i=0; i<=numMovimiento; i++) {
			    js.executeScript("window.scrollBy(0,"+y+")");
				}
			    tiempoEspera(2000);
				}
				//METODO ENVIA FECHA WIDGEST
				public String dateWidgest(int restYear,int restMes,int restDia) 
				{
					
						String[] fechaSeparada = fechaHora().split("-");
						int year=(Integer.parseInt(fechaSeparada[0]))-restYear;
						int mes=(Integer.parseInt(fechaSeparada[1]))-restMes;
						int dia=(Integer.parseInt(fechaSeparada[2]))-restDia;
						
						String Date=""+mes+"/"+dia+"/"+year+"";
						
					return Date;
				}
				public void validacion(By localizador, File rutaCarpeta, String generarEvidencia) {
				    try {
				        driver.findElement(localizador).isEnabled();
				        click(localizador,rutaCarpeta,generarEvidencia);
				    }catch (Exception e){
				        System.out.println(e);
				    }
				}
	}


