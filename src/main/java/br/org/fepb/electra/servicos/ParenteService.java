package br.org.fepb.electra.servicos;

import br.org.fepb.electra.modelo.Parente;
import br.org.fepb.electra.repositorios.ParenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParenteService {

    @Autowired
    private ParenteRepositorio parenteRepositorio;

    public List<Parente> listarPorEvangelizando(Long idEvangelizando){
        return parenteRepositorio.findAllByEvangelizando(idEvangelizando);
    }
}
