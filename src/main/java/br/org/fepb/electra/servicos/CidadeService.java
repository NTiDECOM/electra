package br.org.fepb.electra.servicos;

import br.org.fepb.electra.modelo.Cidade;
import br.org.fepb.electra.repositorios.CidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CidadeService implements Serializable, ServiceInterface<Cidade> {

    @Autowired
    private CidadeRepositorio cidadeRepositorio;

    @Override
    public Cidade salvar(Cidade cidade) {
        return cidadeRepositorio.save(cidade);
    }

    @Override
    public void excluir(Cidade cidade) {
        cidadeRepositorio.delete(cidade);
    }

    @Override
    public List<Cidade> listarTodos() {
        return (List<Cidade>) cidadeRepositorio.findAll();
    }

    public List<Cidade> listarCidadesPorUF(String siglaUF) {
        return (List<Cidade>) cidadeRepositorio.findAllBySiglaUF(siglaUF);
    }

    public Cidade buscarPorDescricao(String naturalidadeSelecionada) {
        return cidadeRepositorio.findByDescricao(naturalidadeSelecionada);
    }
}
