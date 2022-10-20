package br.com.sancode.sancodesiriusapi.service;

import br.com.sancode.sancodesiriusapi.exception.NotFoundException;
import br.com.sancode.sancodesiriusapi.model.Associacao;
import br.com.sancode.sancodesiriusapi.repository.AssociacaoRepository;
import br.com.sancode.sancodesiriusapi.util.ISancodeCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociacaoServiceImpl implements ISancodeCRUDService<Associacao> {
    private final AssociacaoRepository associacaoRepository;

    public AssociacaoServiceImpl(AssociacaoRepository associacaoRepository) {
        this.associacaoRepository = associacaoRepository;
    }

    @Override
    public List<Associacao> findAll() {
        return associacaoRepository.findAll();
    }

    @Override
    public Associacao save(Associacao entity) {
        return associacaoRepository.save(entity);
    }

    @Override
    public Associacao findById(Long id) {
        Optional<Associacao> associacao = associacaoRepository.findById(id);
        if(!associacao.isPresent())
            throw new NotFoundException("Associacao não encontrado! Id: " + id + Associacao.class.getName());
        return associacao.get();
    }

    @Override
    public Associacao findByDescricao(String descricao) {
        return associacaoRepository.findByRazaoSocial(descricao);
    }

    @Override
    public void delete(Associacao entity) {
        associacaoRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        associacaoRepository.deleteById(id);
    }
}
