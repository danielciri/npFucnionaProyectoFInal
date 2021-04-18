package site.danielcirilo.springboot.app.utils;

public class Lib {
	private final static char[] LETRAS = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
			'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
	private static final String LETRASNIE = "XYZ";

	public static String calcularletraDni(String stringNumDni) {
		int calcularLetraNif;
		char letraNif;
		int numeroDniInteger;
		String stringLetraDni;
		stringNumDni = stringNumDni.substring(0, 8);
		numeroDniInteger = Integer.parseInt(stringNumDni);
		calcularLetraNif = numeroDniInteger % 23;
		letraNif = LETRAS[calcularLetraNif];
		stringLetraDni = Character.toString(letraNif);
		stringLetraDni += String.valueOf(stringNumDni);
		char letra = stringLetraDni.charAt(0);
		StringBuilder myString = new StringBuilder(stringLetraDni);
		myString = myString.deleteCharAt(0);
		String dniCorrecto = myString.substring(0, 8) + letra;

		return dniCorrecto;
	}

	public  static String calculaNie(String nie) {
		String str = null;

		if (nie.length() == 9) {
			nie = nie.substring(0, nie.length() - 1);
		}

		if (nie.startsWith("X")) {
			str = nie.replace('X', '0');
		} else if (nie.startsWith("Y")) {
			str = nie.replace('Y', '1');
		} else if (nie.startsWith("Z")) {
			str = nie.replace('Z', '2');
		}

		return nie + calculaLetra(str);
	}
	
	  private static char calculaLetra(String aux) {
		
	        return LETRAS[Integer.parseInt(aux) % 23];
	    }
}
