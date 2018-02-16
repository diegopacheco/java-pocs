package com.github.diegopacheco.quartz.scheduller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

}
