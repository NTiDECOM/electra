package br.org.fepb.electra.servicos;

import br.org.fepb.electra.modelo.Parente;
import br.org.fepb.electra.repositorios.ParenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParenteService implements ServiceInterface<Parente> {

    @Autowired
    private ParenteRepositorio parenteRepositorio;


    @Override
    public Parente salvar(Parente parente) {
        return parenteRepositorio.save(parente);
    }

    @Override
    public void excluir(Parente parente) {
        parenteRepositorio.delete(parente);
    }

    @Override
    public List<Parente> listarTodos() {
        return (List<Parente>) parenteRepositorio.findAll();
    }

    public List<Parente> listarPorEvangelizando(Long idEvangelizando){
        return parenteRepositorio.findAllByEvangelizando(idEvangelizando);
    }
}
