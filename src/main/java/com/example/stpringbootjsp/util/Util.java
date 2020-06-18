package com.example.stpringbootjsp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static Date getDateFromString(String format, String value) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat(format);
		return sdf1.parse(value);
	}
}
