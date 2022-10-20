package br.com.sancode.sancodesiriusapi.service;

import br.com.sancode.sancodesiriusapi.exception.NotFoundException;
import br.com.sancode.sancodesiriusapi.model.TipoAutomovel;
import br.com.sancode.sancodesiriusapi.repository.TipoAutomovelRepository;
import br.com.sancode.sancodesiriusapi.util.ISancodeCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoAutomovelServiceImpl implements ISancodeCRUDService<TipoAutomovel> {

    private final TipoAutomovelRepository tipoAutomovelRepository;

    public TipoAutomovelServiceImpl(TipoAutomovelRepository tipoAutomovelRepository) {
        this.tipoAutomovelRepository = tipoAutomovelRepository;
    }

    @Override
    public List<TipoAutomovel> findAll() {
        return tipoAutomovelRepository.findAll();
    }

    @Override
    public TipoAutomovel save(TipoAutomovel entity) {
        return tipoAutomovelRepository.save(entity);
    }

    @Override
    public TipoAutomovel findById(Long id) {
        Optional<TipoAutomovel> tipoAutomovel = tipoAutomovelRepository.findById(id);
        if(!tipoAutomovel.isPresent())
            throw new NotFoundException("Tipo Automóvel não encontrado! Id: " + id + TipoAutomovel.class.getName());

        return tipoAutomovel.get();
    }

    @Override
    public TipoAutomovel findByDescricao(String descricao) {
        return tipoAutomovelRepository.getByDescricao(descricao);
    }

    @Override
    public void delete(TipoAutomovel entity) {
        tipoAutomovelRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        tipoAutomovelRepository.deleteById(id);
    }

    public List<String> somenteDescricao(){
        return tipoAutomovelRepository.findAll().stream().map((ta -> ta.getDescricao())).collect(Collectors.toList());
    }
}
