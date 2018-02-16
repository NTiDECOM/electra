package br.org.fepb.electra.servicos;

import br.org.fepb.electra.modelo.UnidadeFederativa;
import br.org.fepb.electra.repositorios.UnidadeFederativaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeFederativaService implements ServiceInterface<UnidadeFederativa> {

    @Autowired
    private UnidadeFederativaRepositorio unidadeFederativaRepositorio;

    @Override
    public UnidadeFederativa salvar(UnidadeFederativa unidadeFederativa) {
        return unidadeFederativaRepositorio.save(unidadeFederativa);
    }

    @Override
    public void excluir(UnidadeFederativa unidadeFederativa) {
        unidadeFederativaRepositorio.delete(unidadeFederativa);
    }

    @Override
    public List<UnidadeFederativa> listarTodos() {
        return (List<UnidadeFederativa>) unidadeFederativaRepositorio.findAll();
    }
}
