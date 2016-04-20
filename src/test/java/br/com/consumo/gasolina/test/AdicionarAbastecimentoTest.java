package br.com.consumo.gasolina.test;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.junit.Test;

import br.com.consumo.gasolina.page.PageAdicionarAbastecimento;
import br.com.consumo.gasolina.page.PagePrincipal;
import br.com.consumo.gasolina.utils.Util;

public class AdicionarAbastecimentoTest extends BaseTest {
	
	PagePrincipal pagePrincipal;
	PageAdicionarAbastecimento pageAdicionarAbastecimento;
	
	@Override
	public void iniciarTestes() throws MalformedURLException {
		super.iniciarTestes();
		pagePrincipal = new PagePrincipal(driver);
		pageAdicionarAbastecimento = new PageAdicionarAbastecimento(driver);
		
		pagePrincipal.clicarNoMenuOpcoes();
		pagePrincipal.selecionarUmaOpcaoDoMenu("Adicionar Abastecimento");
		
	}
	
	@Test
	public void abastecimentoComADataAtualDoSistema() {
	
		String txKMAbastecimento = "45744";
		String txLitros = "47.95";
		String txValor = "172.14";
		String txQuantidadeAbastecimentoNoMes = "1 Vez(es)/Mês";
		
		pageAdicionarAbastecimento.informarKMNoAbastecimento(txKMAbastecimento);
		pageAdicionarAbastecimento.informarLitrosNoAbastecimento(txLitros);
		pageAdicionarAbastecimento.informarValorNoAbastecimento(txValor);
		pageAdicionarAbastecimento.clicarNoBotaoCadastrar();
		
		assertTrue(pagePrincipal.retornaOValorAbastecidoNoMes().contains(txValor));
		assertTrue(pagePrincipal.retornaQuantidadeDeLitrosAbastecidosNoMes().contains(txLitros));
		assertTrue(pagePrincipal.retornaAQuantidadeDeVezesAbastecidaNoMes().contains(txQuantidadeAbastecimentoNoMes));
	}
	
	@Test
	public void abastecimentoComADataDiferenteDaDataAtual() throws ParseException{
		
		String txKMAbastecimento = "45296";
		String txLitros = "39.97";
		String txValor = "152.69";
	
		
		String txDataAbastecimento = "14/04/2016";
		String txQuantidadeAbastecimentoNoMes = "1 Vez(es)/Mês";
		
		pageAdicionarAbastecimento.informarKMNoAbastecimento(txKMAbastecimento);
		pageAdicionarAbastecimento.informarLitrosNoAbastecimento(txLitros);
		pageAdicionarAbastecimento.informarValorNoAbastecimento(txValor);
		pageAdicionarAbastecimento.clicarNoCampoData();
		pageAdicionarAbastecimento.preencherODatePicker(Util.retornaDataAtualComMenosUmDia(txDataAbastecimento));
		pageAdicionarAbastecimento.clicarNoBotaoCadastrar();
		
		assertTrue(pagePrincipal.retornaOValorAbastecidoNoMes().contains(txValor));
		assertTrue(pagePrincipal.retornaQuantidadeDeLitrosAbastecidosNoMes().contains(txLitros));
		assertTrue(pagePrincipal.retornaAQuantidadeDeVezesAbastecidaNoMes().contains(txQuantidadeAbastecimentoNoMes));
	}
	
	
	@Test
	public void abastecimentoComADataDiferenteDoMesAtual() throws ParseException{
		
		String txKMAbastecimento = "45296";
		String txLitros = "39.97";
		String txValor = "152.69";
		String txDataAbastecimento = "14/03/2016";
		
		pageAdicionarAbastecimento.informarKMNoAbastecimento(txKMAbastecimento);
		pageAdicionarAbastecimento.informarLitrosNoAbastecimento(txLitros);
		pageAdicionarAbastecimento.informarValorNoAbastecimento(txValor);
		pageAdicionarAbastecimento.clicarNoCampoData();
		pageAdicionarAbastecimento.preencherODatePicker(Util.converteStringEmCalendar(txDataAbastecimento));
		pageAdicionarAbastecimento.clicarNoBotaoCadastrar();
		
		String txValorAbastecimento = "0.0";
		String txLitrosAbastecidos = "0.0";
		String txQuantidadeAbastecimentoNoMes = "0 Vez(es)/Mês";
		assertTrue(pagePrincipal.retornaOValorAbastecidoNoMes().contains(txValorAbastecimento));
		assertTrue(pagePrincipal.retornaQuantidadeDeLitrosAbastecidosNoMes().contains(txLitrosAbastecidos));
		assertTrue(pagePrincipal.retornaAQuantidadeDeVezesAbastecidaNoMes().contains(txQuantidadeAbastecimentoNoMes));
	}
	
}
