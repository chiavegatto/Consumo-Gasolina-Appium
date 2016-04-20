package br.com.consumo.gasolina.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseTest {
	
	protected AndroidDriver<MobileElement> driver;
	protected final String CAMINHO_APK = "src/test/resources/Consumo-Gasolina-0.0.2-SNAPSHOT.apk";
	protected AppiumDriverLocalService appiumDriverLocalService;
	
	@Before
	public void iniciarTestes() throws MalformedURLException{
		appiumDriverLocalService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withArgument(GeneralServerFlag.SESSION_OVERRIDE));
		appiumDriverLocalService.start();
		
		File appFile = new File(CAMINHO_APK);
		DesiredCapabilities capabilities = new DesiredCapabilities();		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.APP, appFile);
		driver = new AndroidDriver <MobileElement> (new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	}
	
	
	@After
	public void finalizarTestes(){
		driver.quit();
		appiumDriverLocalService.stop();
	}

}
