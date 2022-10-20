package br.com.sancode.sancodesiriusapi.resource;

import br.com.sancode.sancodesiriusapi.model.Status;
import br.com.sancode.sancodesiriusapi.service.StatusServiceImpl;
import br.com.sancode.sancodesiriusapi.util.ISancodeResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/status")
public class StatusResource implements ISancodeResource<Status> {

    private final StatusServiceImpl statusService;

    public StatusResource(StatusServiceImpl statusService) {
        this.statusService = statusService;
    }

    @Override
    public List<Status> getAll() {
        return statusService.findAll();
    }

    @Override
    public Status getById(Long id) {
        return statusService.findById(id);
    }

    @Override
    public Status getByDescricao(String descricao) {
        return statusService.findByDescricao(descricao);
    }

    @Override
    public Status post(Status entity) {
        return statusService.save(entity);
    }

    @Override
    public Status put(Status entity) {
        return statusService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        statusService.deleteById(id);
    }
}
