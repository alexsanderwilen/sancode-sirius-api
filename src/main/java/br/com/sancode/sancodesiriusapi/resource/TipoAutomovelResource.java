package br.com.sancode.sancodesiriusapi.resource;

import br.com.sancode.sancodesiriusapi.model.TipoAutomovel;
import br.com.sancode.sancodesiriusapi.service.TipoAutomovelServiceImpl;
import br.com.sancode.sancodesiriusapi.util.ISancodeResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipoautomoveis")
public class TipoAutomovelResource implements ISancodeResource<TipoAutomovel> {
    private final TipoAutomovelServiceImpl tipoAutomovelService;

    public TipoAutomovelResource(TipoAutomovelServiceImpl tipoAutomovelService) {
        this.tipoAutomovelService = tipoAutomovelService;
    }

    @Override
    public List<TipoAutomovel> getAll() {
        return tipoAutomovelService.findAll();
    }

    @Override
    public TipoAutomovel getById(Long id) {
        return tipoAutomovelService.findById(id);
    }

    @Override
    public TipoAutomovel getByDescricao(String descricao) {
        return tipoAutomovelService.findByDescricao(descricao);
    }

    @GetMapping("/somente/descricao")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getSomenteDescricao(){
        return tipoAutomovelService.somenteDescricao();
    }

    @Override
    public TipoAutomovel post(TipoAutomovel entity) {
        return tipoAutomovelService.save(entity);
    }

    @Override
    public TipoAutomovel put(TipoAutomovel entity) {
        return tipoAutomovelService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        tipoAutomovelService.deleteById(id);
    }
}
