package com.bluetips.tcc.bluetips.config;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatacaoDataUtil {

	public static String getDataAtualFormatada() {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String dataFormatada = formatter.format(new Date());
		return dataFormatada;
	}		
}
