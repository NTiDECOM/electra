package br.org.fepb.electra.enums;

import lombok.Getter;

/**
 * Criado por Thiago em 26/03/2016
 */
public enum TipoSituacaoMatricula {

    ATIVA("A"), CANCELADA("C"), EVADIDO("E");
    
    @Getter
    private final String codigo;
    
    TipoSituacaoMatricula(String codigo){
        this.codigo = codigo;
    }
}
