package br.org.fepb.electra.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe com métodos para manipulação com datas usando a api de gregorian calendar.
 * 
 * @author Sávio Canuto de Oliveira Sousa.
 */
public class DateUtil {
	
	/**
	 * Converte string para uma data
	 * 
	 * @param data string no formado dd/mm/yyyy.
	 * @return 
	 * @throws CadastroException caso a data tenha um dia maior que 31 ou um mes 
	 * 			maior que 12 ou a data esteja sem um ano
	 * @throws ParseException 
	 */
	public static GregorianCalendar string2Calendar(String data) {
		int dia = Integer.parseInt(data.substring(0,2));
		int mes = Integer.parseInt(data.substring(3,5));
		int ano = Integer.parseInt(data.substring(6,10));
		GregorianCalendar calendar = new GregorianCalendar(ano, mes-1, dia);
		calendar.setLenient(false);
		
		return calendar;
	}
	
	/**
	 * Metodo que faz uma copia de uma data passada como parametro.
	 * 
	 * @param date
	 * @return
	 */	
	public static GregorianCalendar copyDate(GregorianCalendar date){
		GregorianCalendar newDate = new GregorianCalendar(date.get(GregorianCalendar.YEAR)
				,date.get(GregorianCalendar.MONTH)
				,date.get(GregorianCalendar.DAY_OF_MONTH));
		newDate.setLenient(date.isLenient());
		return newDate;
	}
	
	public static Date copyDate(Date data) {
		Date retorno = new Date(data.getYear(), data.getMonth(), data.getDate());
		return retorno;
	}
	
	/**
	 * Metodo que retorna a string mes da data passada.
	 * 
	 * @param calendar
	 * @return
	 */
	public static String getMes(GregorianCalendar calendar){
		String data = calendar2String(calendar);
		return data.substring(3, 5); 
	}

	/**
	 * Metodo que formata uma string para uma data. Eh informado somente
	 * o ano e o mes, sendo acrescido internamente do dia 01.
	 * 
	 * @param data
	 * @return
	 */
	public static GregorianCalendar string2CalendarAnoMes(String data) {
		int ano = Integer.parseInt(data.substring(0,4));
		int mes = Integer.parseInt(data.substring(5,7));
		int dia = 1;
		GregorianCalendar calendar = new GregorianCalendar(ano, mes-1, dia);
		calendar.setLenient(false);
		
		return calendar;
	}
	
	/**
	 * Metodo que retorna a string dia da data passada.
	 * 
	 * @param calendar
	 * @return
	 */
	public static String getDia(GregorianCalendar calendar){
		String data = calendar2String(calendar);
		return data.substring(0, 2); 
	}
	
	/**
	 * Metodo que retorna a string ano da data passada.
	 * 
	 * @param calendar
	 * @return
	 */
	public static String getAno(GregorianCalendar calendar){
		String data = calendar2String(calendar);
		return data.substring(6, 10);
	}
	
	/**
	 * Metodo que retorna uma data somada de N dias passados como parametro.
	 * 
	 * @param data
	 * @param quantidadeDias
	 * @return GregorianCalendar data somada aos N dias.
	 */
	public static GregorianCalendar somaDia(GregorianCalendar data, int quantidadeDias) {
		
//		data.setTimeInMillis((quantidadeDias * MILISEGUNDOSDIA) + data.getTime().getTime());
		
		data.add(Calendar.DAY_OF_MONTH, quantidadeDias);
		
		return data;
	}
	
	/**
	 * Metodo que retorna uma data somada de N dias passados como parametro.
	 * 
	 * @param data
	 * @param quantidadeDias
	 * @return GregorianCalendar data somada aos N dias.
	 */
	public static GregorianCalendar subtraiDia(GregorianCalendar data, int quantidadeDias) {
		
		data.add(Calendar.DAY_OF_MONTH , -quantidadeDias);
		
		return data;
	}
	
	/**
	 * Metodo que transforma um GregorianCalendar em String no formato
	 * de dd/mm/aaaa.
	 * 
	 * @param dataCorrente
	 * @return
	 */
	public static String calendar2String(GregorianCalendar dataCorrente) {
		
		String diaInicioMes = String.valueOf(dataCorrente.get(dataCorrente.DAY_OF_MONTH));
		String mesTemporario = String.valueOf(dataCorrente.get(dataCorrente.MONTH) + 1);
		String mesCorr = "";

		// formata o dia
		if (diaInicioMes.length() == 1) {
			diaInicioMes = "0" + diaInicioMes + "/";
		} else {
			diaInicioMes = diaInicioMes + "/";
		}
		
		// formata o mês
		if (mesTemporario.length() == 1) {
			mesCorr = "0" + mesTemporario + "/";
		} else {
			mesCorr = mesTemporario + "/";
		}
		
		String ano = String.valueOf( dataCorrente.get(dataCorrente.YEAR) );
		diaInicioMes = diaInicioMes + mesCorr + ano;
		
		return diaInicioMes;
	}
	
	/**
	 * Metodo que recupera um determinado ano passando uma string como data.
	 * O padrao dessa string eh dd/mm/yyyy.
	 * 
	 * @param dataCorrente
	 * @return
	 */
	public static String getAno(String dataCorrente) {
		return dataCorrente.substring(6, 10);
	}
	
	/**
	 * Metodo que recupera um determinado mes de uma string como data.
	 * 
	 * @param dataCorrente
	 * @return
	 */
	public static String getMes(String dataCorrente) {
		return dataCorrente.substring(3, 5);
	}
	
	/**
	 * Metodo que recupera um determinado dia de uma string como data.
	 * 
	 * @param dataCorrente
	 * @return
	 */
	public static String getDia(String dataCorrente) {
		return dataCorrente.substring(0, 2);
	}
	
	/**
     * Cria um DateIntervalRule para comparar duas datas, ambas
     * no formato DD/MM/YYYY.
     *
     * @param beginDate A data de início do intervalo
     * @param endDate A data do fim do intervalo
     * @param equals Indica se as datas podem ser iguais
     */
	public static boolean checkDates(Object beginDate, Object endDate, boolean equals) {
 		
		if(beginDate == null || endDate == null) {
 			return true; // maybe optional!
 		}
 		
		if(beginDate.toString().trim().equals("") || endDate.toString().trim().equals("")) {
 			return true; // maybe optional!
 		}
 		
		try {
 			DateFormat df = DateFormat.getDateInstance();
 			Date dataInicio = df.parse((String) beginDate);
 			Date dataFim = df.parse((String) endDate);
 			
 			if(dataInicio.equals(dataFim)) {
 				if(equals) {
 					return true;
 				}
 			} else {
 				if(dataInicio.before(dataFim)) {
 					return true;
 				}
 			}
 		} catch(ParseException pe) {
 			pe.printStackTrace();
 			return false;
 		}
 		return false;
 	}
	
	/**
	 * Calcular a quantidade de dias que existe entre as duas datas informadas.
	 * 
	 * @param data1 Data 1.
	 * @param data2 Data 2.
	 * @return Diferença em dias.
	 */
	public static int calcularDiferencaDias(Date data1, Date data2) {
		Calendar calendarData1 = Calendar.getInstance();
		calendarData1.setTime(data1);
		Long dateStamp1 = (calendarData1.getTimeInMillis() - (calendarData1.getTimeInMillis() % (1000*60*60*24))) / (1000*60*60*24);
		Calendar calendarData2 = Calendar.getInstance();
		calendarData2.setTime(data2);
		Long dateStamp2 = (calendarData2.getTimeInMillis() - (calendarData2.getTimeInMillis() % (1000*60*60*24))) / (1000*60*60*24);
		Long diff = dateStamp1 - dateStamp2;
		return diff.intValue();
	}
	
	/**
     * Cria um DateIntervalRule para comparar duas datas, ambas
     * no formato DD/MM/YYYY.
     *
     * @param beginDate A data de início do intervalo
     * @param endDate A data do fim do intervalo
     * @param equals Indica se as datas podem ser iguais
     */
	public static boolean checkTimes(long beginTime, long endTime, long nowTime) {
 		
		if (beginTime < nowTime && endTime > nowTime)
			return true;
 		
		
 		return false;
 	}
	
	/**
     * Cria um DateIntervalRule para comparar duas datas, ambas
     * no formato DD/MM/YYYY.
     *
     * @param beginDate A data de início do intervalo
     * @param endDate A data do fim do intervalo
     * @param equals Indica se as datas podem ser iguais
     */
	public static boolean checkTimes(String beginTime, String endTime, String nowTime) {
 		
		try {
			
			long bTime =  DateFormat.getTimeInstance().parse(beginTime).getTime();
			long eTime = DateFormat.getTimeInstance().parse(endTime).getTime();
			long nTime = DateFormat.getTimeInstance().parse(nowTime).getTime();
			
			if (bTime < nTime && eTime > nTime)
				return true; 
			
		} catch (ParseException e) {
			return false;
		}
		
 		return false;
 	}

	/**
	 * Método para formatar uma data no padrão dd/mm/yyyy.
	 * 
	 * @param data
	 * @return data no padrão dd/mm/yyyy
	 */
	public static String formatarData(Date data) {
		String retorno = "-";
		
		if (data != null) {
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");  
			retorno = dt.format(data);
		}
	
		return retorno;
	}

	/**
	 * Método para formatar data de acordo com o formato especificado 
	 * @param data - Date com a data a ser formatada
	 * @param formato - String contendo o formato que a data deve assumir
	 * @return - String com a data formatada
	 */
	public static String formatarData(Date data, String formato) {
		String retorno = null;
		if (data != null) {
			SimpleDateFormat dt = new SimpleDateFormat(formato);  
			retorno = dt.format(data);
		}
		return retorno;
	}

	public static String formatarData(LocalDate data, String formato) {
		String retorno = "";
		if (data != null) {
			SimpleDateFormat dt = new SimpleDateFormat(formato);  
			retorno = dt.format(data);
		}
		return retorno;
	}
	

	public static Integer calcularDiferencaMinutos(Date data1, Date data2) {
		int diff = (int)((data1.getTime() / 60000) - (data2.getTime() / 60000));
		return diff;
	}
	
	/** 
	 * Calcula a Idade baseado em String. Exemplo:
	 * calculaIdade("20/08/1977","dd/MM/yyyy");
	 */
	public static int calcularIdade(LocalDate dataNasc, String pattern) {

		DateFormat sdf = new SimpleDateFormat(pattern);
		Date dataNascInput = null;

		try {
			dataNascInput = sdf.parse(sdf.format(dataNasc));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(dataNascInput);

		// Cria um objeto calendar com a data atual
		Calendar today = Calendar.getInstance();

		// Obtém a idade baseado no ano
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		dateOfBirth.add(Calendar.YEAR, age);

		if (today.before(dateOfBirth)) {
			age--;
		}

		return age;
	}

}
