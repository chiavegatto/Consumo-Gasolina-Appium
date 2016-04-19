package br.com.consumo.gasolina.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Util {
	public static String converteStringParaFormatoDoBancoDeDados(String data) throws ParseException{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAlterada = formato.parse(data);
		SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
		data=formatoBanco.format(dataAlterada);
		return data;
	}

	public static Calendar converteStringEmCalendar(String data) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(formato.parse(data));
		return cal;
	}
	
	public static String retornaMesEmExtensoPassandoUmInteiro(int mes) {
		String[] meses = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov","Dec" };
		return meses[mes];
	}
	
	public static Calendar retornaDataAtualComMenosUmDia(String txData) throws ParseException{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(formato.parse(txData));
		
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		return calendar;
		
	}
}
