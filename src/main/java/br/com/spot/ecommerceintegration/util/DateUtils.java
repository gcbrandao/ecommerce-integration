package br.com.spot.ecommerceintegration.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

	public static String getDateNow() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public static String getCompleteDate() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	}

	public static Date localDateToDate(LocalDateTime initialDate) {
		return Date.from(initialDate.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static LocalDateTime simpleDateToLocalDateTime(String stringDate) {
		LocalDate date = LocalDate.parse(stringDate);
		return date.atStartOfDay();
	}
	
	public static LocalDateTime convertToLocalDateTime(Date date) {
	    return date.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
}
