package br.com.consumo.gasolina.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageListarAbastecimentos {

	private AndroidDriver<MobileElement> driver;

	public PageListarAbastecimentos (AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
/*	
	public void pressiono_no_abastecimento_com_a_data(String txDataAbastecimento) throws Throwable {
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+txDataAbastecimento+"\")").click();
	}
	
	public void deve_ser_exibido_o_abastecimento_com_as_seguintes_informações(DataTable dadosAbastecimentos) throws Throwable {
		for(Map<String, String> abastecimentos : dadosAbastecimentos.asMaps(String.class, String.class)){
			assertEquals(abastecimentos.get("Data Abastecimento"), driver.findElement(By.id("br.com.consumogasolina:id/textView_valor_data_do_abastecimento")).getText());
			assertEquals(abastecimentos.get("Quantidade Litros"), driver.findElement(By.id("br.com.consumogasolina:id/textView_valor_litros_do_abastecimento")).getText());
			assertEquals(abastecimentos.get("Valor"), driver.findElement(By.id("br.com.consumogasolina:id/textView_valor_abastecido")).getText());
			assertEquals(abastecimentos.get("KM Abastecimento"), driver.findElement(By.id("br.com.consumogasolina:id/textView_valor_km_no_abastecimento")).getText());
		}
	}
	
	public void pressiono_longamente_no_abastecimento_com_a_data(String txDataAbastecimento) throws Throwable {
		MobileElement abastecimento = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+txDataAbastecimento+"\")");
		TouchAction touch = new TouchAction(driver);
		touch.longPress(abastecimento).perform();
	}
	
	public void confirmo_a_exclusão_do_abastecimento() throws Throwable {
		driver.findElement(By.id("android:id/button1")).click();
	}


	public void deve_ser_exibido_a_mensagem_na_listagem_de_abastecimentos(String txMensagem) throws Throwable {
		assertEquals(txMensagem, driver.findElement(By.id("android:id/empty")).getText());
	}
	
	public void preencho_a_data_inicial_e_data_final(String dataInicial, String dataFinal) throws Throwable {
		driver.findElement(By.id("br.com.consumogasolina:id/editText_data_inicio")).click();
		AppiumUtil.preencheDatePicker(dataInicial, driver);
		driver.findElement(By.id("br.com.consumogasolina:id/editText_data_final")).click();
		AppiumUtil.preencheDatePicker(dataFinal, driver);
	}

	public void seleciono_o_tipo_de_visualização(String txTipoVisualizacao) throws Throwable {
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+txTipoVisualizacao+"\")").click();
	}
	
	public void deve_ser_exibido_os_abastecimentos(DataTable dadosAbastecimento) throws Throwable {
		for(Map<String, String> abastecimentos : dadosAbastecimento.asMaps(String.class, String.class)){
			assertTrue("KM do abastecimento não exibido.",driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+abastecimentos.get("KM Abastecimento")+"\")").isDisplayed());
			assertTrue("Quantidade do abastecimento não exibido.",driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+abastecimentos.get("Quantidade Litros")+"\")").isDisplayed());
			assertTrue("Valor do abastecimento não exibido.",driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+abastecimentos.get("Valor")+"\")").isDisplayed());
			assertTrue("Data do Abastecimento não exibido.",driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+abastecimentos.get("Data Abastecimento")+"\")").isDisplayed());*/
}
