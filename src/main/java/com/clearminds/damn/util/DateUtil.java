package com.clearminds.damn.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	 	
	public static String convertirFecha(Date date){		
		SimpleDateFormat fomateador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String fFormat = fomateador.format(date);
		return fFormat;
	}

}
