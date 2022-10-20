package br.com.sancode.sancodesiriusapi.resource;

import br.com.sancode.sancodesiriusapi.model.MovimentoVistoria;
import br.com.sancode.sancodesiriusapi.service.MovimentoVistoriaServiceImpl;
import br.com.sancode.sancodesiriusapi.util.ISancodeResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movimentovistorias")

public class MovimentoVistoriaResource implements ISancodeResource<MovimentoVistoria> {
    private final MovimentoVistoriaServiceImpl movimentoVistoriaService;

    public MovimentoVistoriaResource(MovimentoVistoriaServiceImpl movimentoVistoriaService) {
        this.movimentoVistoriaService = movimentoVistoriaService;
    }

    @Override
    public List<MovimentoVistoria> getAll() {
        return movimentoVistoriaService.findAll();
    }

    @Override
    public MovimentoVistoria getById(Long id) {
        return movimentoVistoriaService.findById(id);
    }

    @Override
    public MovimentoVistoria getByDescricao(String descricao) {
        return movimentoVistoriaService.findByDescricao(descricao);
    }

    @Override
    public MovimentoVistoria post(MovimentoVistoria entity) {
        return movimentoVistoriaService.save(entity);
    }

    @Override
    public MovimentoVistoria put(MovimentoVistoria entity) {
        return movimentoVistoriaService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        movimentoVistoriaService.deleteById(id);
    }
}
