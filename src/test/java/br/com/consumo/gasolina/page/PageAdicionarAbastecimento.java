package br.com.consumo.gasolina.page;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;

import br.com.consumo.gasolina.utils.Util;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageAdicionarAbastecimento {
	
	private AndroidDriver<MobileElement> driver;

	public PageAdicionarAbastecimento (AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public void informarKMNoAbastecimento(String txKMAbastecimento){
		driver.findElement(By.id("br.com.consumogasolina:id/editText_km_abastecimento")).sendKeys(txKMAbastecimento);
	}
	
	public void informarLitrosNoAbastecimento(String txLitros){
		driver.findElement(By.id("br.com.consumogasolina:id/editText_quantidade_litros")).sendKeys(txLitros);
	}
	
	public void informarValorNoAbastecimento(String txValor){
		driver.findElement(By.id("br.com.consumogasolina:id/editText_valor")).sendKeys(txValor);	
	}
	
	public void clicarNoCampoData() {
		driver.findElement(By.id("br.com.consumogasolina:id/editText_data")).click();
	}
	
	public void preencherODatePicker(Calendar dataInformada) throws ParseException {
		List<MobileElement> datePicker = driver.findElements(By.className("android.widget.NumberPicker"));
		datePicker.get(0).sendKeys(Util.retornaMesEmExtensoPassandoUmInteiro(dataInformada.get(Calendar.MONTH)));
		datePicker.get(1).sendKeys(String.valueOf(dataInformada.get(Calendar.DATE)));
		datePicker.get(2).sendKeys(String.valueOf(dataInformada.get(Calendar.YEAR)));
		driver.findElement(By.id("android:id/button1")).click();
	}
	
	public void clicarNoBotaoCadastrar(){
		driver.findElement(By.id("br.com.consumogasolina:id/button_cadastrar")).click();
	}
}
