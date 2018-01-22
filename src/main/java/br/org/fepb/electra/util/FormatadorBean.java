package br.org.fepb.electra.util;

import java.time.LocalDate;

import br.org.fepb.electra.modelo.InstituicaoEspirita;

public class FormatadorBean {

	public static final String SIM = "Sim";
	public static final String NAO = "Não";
	
	public static String formatarEvangeliza(String valor) {
		String resultado = "---";
		if ( validaString(valor) ) {
			if ( valor.equals(InstituicaoEspirita.EVANGELIZA_SIM) )
				resultado = SIM;
			else
				resultado = NAO;
		}
		return resultado;
	}

	public static String formatarTipoInstituicao(String valor) {
		String resultado = "---";
		if ( validaString(valor) ) {
			if ( valor.equals(InstituicaoEspirita.TIPO_CASA) )
				resultado = InstituicaoEspirita.CASA_ESPIRITA;
			else
				resultado = InstituicaoEspirita.FEDERATIVA;
		}
		return resultado;
	}
	
	public static String formatarData(LocalDate dia) {
		String retorno = "---";
		if ( validaDate(dia) ) {
			retorno = DateUtil.formatarData(dia, "dd/MM/yyyy");
		}
		return retorno;
	}
	
	public static String formatarTelefone(String telefone) {
		String retorno = "---";
		if ( validaString(telefone) ) {
			retorno = StringUtil.colocaMascaraTelefone(telefone);
		}
		return retorno;
	}
	
	public static String formatarIdade(LocalDate nascimento) {
		String retorno = "---";
		if ( validaDate(nascimento) ) {
			retorno = String.valueOf(DateUtil.calcularIdade(nascimento, "dd/MM/yyyy"));
		}
		return retorno;
	}
	
	private static boolean validaString(String valor) {
		return valor != null && !valor.equals("");
	}
	
	private static boolean validaDate(LocalDate data) {
		return data != null;
	}
}
