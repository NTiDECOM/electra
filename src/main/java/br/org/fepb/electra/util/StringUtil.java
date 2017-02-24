package br.org.fepb.electra.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe para manipulação e validação de strings.
 * 
 * @author Sávio Canuto de Oliveira Sousa.
 */
public class StringUtil {
	
	/**
	 * Método que valida e-mail.
	 * 
	 * @param email O e-mail a ser validado.
	 * @return Indicação de sucesso ou não.
	 */
	public static boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-z]{2,4}");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}


	/**
	 * Método que valida um CEP.
	 * 
	 * @param cep O CEP a ser validado.
	 * @return Indicação de sucesso ou não.
	 */
	public static boolean validateCep(String cep) {
		Pattern pattern = Pattern.compile("[0-9]{2}\\.[0-9]{3}-[0-9]{3}");
		Matcher matcher = pattern.matcher("58.102-400");
		return matcher.matches();
	}
	
	/**
	 * Método para formatar os segundos em HH:MM:SS.
	 * 
	 * @param segundos
	 * @return
	 */
	public static String parseHHmmss(int segundos){
	    int segundo = segundos % 60;
		int minutos = segundos / 60;
		int minuto = minutos % 60;
		int hora = minutos / 60;
		String hms = String.format ("%02d:%02d:%02d", hora, minuto, segundo);
		return hms;
	}
	
	/**
	 * Retira a mascara de telefone ex: entrada (83)8888-888; saida: 8388888888
	 * @param string
	 * @return string
	 */
	public static String retiraMascaraTelefone(String string){
		return string.replaceAll("[\\D]","");
	}
	
	/**
	 * Retira a mascara do CNPJ ex: entrada 00.000.000/0000-00; saida: 00000000000000
	 * @param string
	 * @return string
	 */
	public static String retiraMascaraCnpj(String string){
		return string.replaceAll("[\\D]","");
	}
	
	/**
	 * Retira a mascara de Cpf ex: entrada 000.000.000-00; saida: 00000000000
	 * @param string
	 * @return string
	 */
	public static String retiraMascaraCpf(String string){
		return string.replaceAll("[\\D]","");
	}
	
	/**
	 * Retira a mascara de cep ex: entrada 00.000-000; saida: 00000000
	 * @param string
	 * @return string
	 */
	public static String retiraMascaraCep(String string){
		return string.replaceAll("[\\D]","");
	}
	
	/**
	 * Coloca a mascara de telefone ex: entrada: 8388888888  saida: (83)8888-888;
	 * @param string
	 * @return string
	 */
	public static String colocaMascaraTelefone(String string){
		
		if (string != null && !string.trim().equals("")) {
			if ((string.charAt(0) == '1' || string.charAt(0) == '2') && string.charAt(2) == '9') {
				string = string.replaceAll("[\\D]","");
				string = string.replaceAll("(\\d{2})(\\d{5})(\\d{4})","($1)$2-$3");
			} else if (string.length() == 10) {
				string = string.replaceAll("[\\D]","");
				string = string.replaceAll("(\\d{2})(\\d{4})(\\d{4})","($1)$2-$3");
			} else {
				string = string.replaceAll("[\\D]","");
				string = string.replaceAll("(\\d{2})(\\d{5})(\\d{4})","($1)$2-$3");
			}
		}
		return string;
	}
	
	/**
	 * Retira a mascara de Cpf ex: entrada: 00000000000 saida: 000.000.000-00;
	 * @param string
	 * @return string
	 */
	public static String colocaMascaraCpf(String string){
		string = string.replaceAll("[\\D]","");
		string = string.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})","$1.$2.$3-$4");
		return string;
	}
	
	/**
	 * Retira a mascara do CNPJ ex: entrada: 00000000000000 saida:  00.000.000/0000-00;
	 * @param string
	 * @return string
	 */
	public static String colocaMascaraCnpj(String string){
		string = string.replaceAll("[\\D]","");
		string = string.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})","$1.$2.$3/$4-$5");
		return string;
	}
	
	/**
	 * Retira a mascara de cep ex: entrada: 00000000 saida: 00.000-000;
	 * @param string
	 * @return string
	 */
	public static String colocaMascaraCep(String string){
		string = string.replaceAll("[\\D]","");
		string = string.replaceAll("(\\d{2})(\\d{3})(\\d{3})","$1.$2-$3");
		return string;
	}
	
	/**
	 * Método para ajustar uma string colocando um ponto final no fim.
	 * 
	 * @param campos
	 * @return string formatada.
	 */
	public static String ajustaCamposMsg(String campos){
		return campos.substring(0, campos.lastIndexOf(",")) + ".";
	}

	/**
	 * Trocar os caracteres acentuados por seus equivalentes sem acentuação e deixar a frase em caixa alta.
	 * 
	 * @param frase Frase que terá os caracteres trocados e caixa alta.
	 * @return Frase com os caracteres trocados e caixa alta.
	 */
	public static String converteMaiusculoSemAcento(String frase) {
		
		if ( frase == null ) return frase;
		return StringUtil.trocarCaracteresAcentuados(frase.toUpperCase());
	}
	
	/**
	 * Trocar os caracteres acentuados por seus equivalentes sem acentuação.
	 * 
	 * @param frase Frase que terá os caracteres trocados.
	 * @return Frase com os caracteres trocados.
	 */
	public static String trocarCaracteresAcentuados(String frase) {
		if ( frase == null ) return frase;
		return frase.replaceAll("[ãâàáä]", "a")   
        .replaceAll("[êèéë]", "e")   
        .replaceAll("[îìíïĩ]", "i")   
        .replaceAll("[õôòóö]", "o")   
        .replaceAll("[ûúùüũ]", "u")   
        .replaceAll("[ÃÂÀÁÄ]", "A")   
        .replaceAll("[ÊÈÉË]", "E")   
        .replaceAll("[ÎÌÍĨÏ]", "I")   
        .replaceAll("[ÕÔÒÓÖ]", "O")   
        .replaceAll("[ÛÙÚŨÜ]", "U")   
        .replace('ç', 'c')   
        .replace('Ç', 'C')   
        .replace('ñ', 'n')   
        .replace('Ñ', 'N'); 
		
	}
	
	/**
	 * Remove os caracteres de pontuação.
	 * 
	 * @param frase Frase que terá as pontuações removidas.
	 * @return Frase sem pontuações.
	 */
	public static String removerPontuacao(String frase) {
		if ( frase == null ) return frase;
		return frase.replaceAll("[-!,.:;?/]", "")   
           .replace("\b\t\n\f\r\"\'\\", "");
	}
	
}

