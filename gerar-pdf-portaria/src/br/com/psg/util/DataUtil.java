package br.com.psg.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataUtil {
	public static String formatDate(Date data) throws ParseException {

		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		String formatedDate = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-"
				+ cal.get(Calendar.YEAR);
		System.out.println("formatedDate : " + formatedDate);

		return formatedDate;
	}
	
	public static String dataAtualExtenso(){
		Date data =  new Date();
		Locale local = new Locale("pt","BR");
		DateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy",local);
		System.out.println(formato.format(data));
		return formato.format(data);
	}
}
