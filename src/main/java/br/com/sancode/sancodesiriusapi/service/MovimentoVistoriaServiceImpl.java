package br.com.sancode.sancodesiriusapi.service;

import br.com.sancode.sancodesiriusapi.exception.NotFoundException;
import br.com.sancode.sancodesiriusapi.model.MovimentoVistoria;
import br.com.sancode.sancodesiriusapi.repository.MovimentoVistoriaRepository;
import br.com.sancode.sancodesiriusapi.util.ISancodeCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MovimentoVistoriaServiceImpl implements ISancodeCRUDService<MovimentoVistoria> {

    private final MovimentoVistoriaRepository movimentoVistoriaRepository;

    public MovimentoVistoriaServiceImpl(MovimentoVistoriaRepository movimentoVistoriaRepository) {
        this.movimentoVistoriaRepository = movimentoVistoriaRepository;
    }

    @Override
    public List<MovimentoVistoria> findAll() {
        return movimentoVistoriaRepository.findAll();
    }

    @Override
    public MovimentoVistoria save(MovimentoVistoria entity) {
        return movimentoVistoriaRepository.save(entity);
    }

    @Override
    public MovimentoVistoria findById(Long id) {
        Optional<MovimentoVistoria> movimentoVistoria = movimentoVistoriaRepository.findById(id);
        if(! movimentoVistoria.isPresent())
            throw new NotFoundException("Vistoria não encontrado! Id: " + id + MovimentoVistoria.class.getName());
        return movimentoVistoria.get();
    }

    @Override
    public MovimentoVistoria findByDescricao(String descricao) {
        return null;
    }

    @Override
    public void delete(MovimentoVistoria entity) {
        movimentoVistoriaRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        movimentoVistoriaRepository.deleteById(id);
    }
}
