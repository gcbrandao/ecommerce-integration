package br.com.spot.ecommerceintegration.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Utils {
	
	private static final String VALID_CHARS = "^[[ ]|\\p{L}*]+$";
	
	public static String normalizeCarteirinha(String numeroCarteirinha) {
		if (numeroCarteirinha.length() >= 20) {
			numeroCarteirinha = numeroCarteirinha.substring(3);
		}
		return numeroCarteirinha;
	}

	public static String removeAcentos(String text){
		 
		String nfdNormalizedString = Normalizer.normalize(text, Normalizer.Form.NFD); 
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
	
	public static boolean hasSpecialChar(String text) {
		
		if(text != null && (!text.isEmpty())) {  
			return !text.matches(VALID_CHARS);
		}
		return true;
	}

}