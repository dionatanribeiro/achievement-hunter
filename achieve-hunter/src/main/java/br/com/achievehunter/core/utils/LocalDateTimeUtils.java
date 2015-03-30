package br.com.achievehunter.core.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public abstract class LocalDateTimeUtils {

	public static LocalDateTime dateToLocalDateTime(Date date) {
		return date == null ? null : LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}
	
}
