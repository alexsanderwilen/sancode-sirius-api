package br.com.sancode.sancodesiriusapi.service;

import br.com.sancode.sancodesiriusapi.model.Vistoria;
import br.com.sancode.sancodesiriusapi.repository.VistoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VistoriaServiceImpl implements VistoriaService {

    private final VistoriaRepository vistoriaRepository;

    public VistoriaServiceImpl(VistoriaRepository vistoriaRepository) {
        this.vistoriaRepository = vistoriaRepository;
    }

    @Override
    public List<Vistoria> getAllVistoria() {
        return vistoriaRepository.findAll();
    }
}