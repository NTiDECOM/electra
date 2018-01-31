package br.org.fepb.electra.enums;

/**
 * Criado por Thiago em 26/03/2016
 */
public enum TipoSituacaoMatricula {

    ATIVA("A"), CANCELADA("C"), EVADIDO("E");
    
    
    private final String codigo;
    
    TipoSituacaoMatricula(String codigo){
        this.codigo = codigo;
    }

	public String getCodigo() {
		return codigo;
	}
    
    
}
