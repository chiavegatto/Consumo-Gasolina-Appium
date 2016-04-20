package br.com.consumo.gasolina.page;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PagePrincipal {

	AndroidDriver<MobileElement> driver;

	public PagePrincipal(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void clicarNoMenuOpcoes() {
		driver.findElement(By.id("br.com.consumogasolina:id/action_opcoes")).click();
	}

	public void selecionarUmaOpcaoDoMenu(String txMenu) {
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + txMenu + "\")").click();
	}

	public String retornaOKmLitroDoMes() {
		return driver.findElement(By.id("br.com.consumogasolina:id/editText_km_litro")).getText();
	}

	public String retornaOValorAbastecidoNoMes() {
		return driver.findElement(By.id("br.com.consumogasolina:id/editText_valor_abastecimento")).getText();
	}

	public String retornaAQuantidadeDeVezesAbastecidaNoMes() {
		return driver.findElement(By.id("br.com.consumogasolina:id/editText_quantidade_abastecimento")).getText();
	}

	public String retornaQuantidadeDeLitrosAbastecidosNoMes() {
		return driver.findElement(By.id("br.com.consumogasolina:id/editText_quantidade_litros")).getText();
	}

	public String retornaQuantidadeDeKmRodadosNoMes() {
		return driver.findElement(By.id("br.com.consumogasolina:id/editText_quantidade_km")).getText();
	}

}
