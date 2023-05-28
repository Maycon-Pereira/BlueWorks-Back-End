package com.bluetips.tcc.bluetips.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {

	public static String getDataAtualFormatada() {
		Date today = Calendar.getInstance().getTime();        
		String dataAtualFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(today);
		return dataAtualFormatada;
	}
}
