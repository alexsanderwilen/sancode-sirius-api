package br.com.sancode.sancodesiriusapi.service;

import br.com.sancode.sancodesiriusapi.exception.NotFoundException;
import br.com.sancode.sancodesiriusapi.model.Status;
import br.com.sancode.sancodesiriusapi.repository.StatusRepository;
import br.com.sancode.sancodesiriusapi.util.ISancodeCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements ISancodeCRUDService<Status> {
    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status save(Status entity) {
        return statusRepository.save(entity);
    }

    @Override
    public Status findById(Long id) {
        Optional<Status> status = statusRepository.findById(id);
        if (!status.isPresent())
            throw new NotFoundException("Status não encontrado! Id: " + id + Status.class.getName());
        return status.get();
    }

    @Override
    public Status findByDescricao(String descricao) {
        return statusRepository.findByDescricao(descricao);
    }

    @Override
    public void delete(Status entity) {
        statusRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        statusRepository.deleteById(id);
    }
}