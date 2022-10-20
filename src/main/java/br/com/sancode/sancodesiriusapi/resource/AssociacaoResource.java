package br.com.sancode.sancodesiriusapi.resource;

import br.com.sancode.sancodesiriusapi.model.Associacao;
import br.com.sancode.sancodesiriusapi.service.AssociacaoServiceImpl;
import br.com.sancode.sancodesiriusapi.util.ISancodeResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/associacoes")
public class AssociacaoResource implements ISancodeResource<Associacao> {
    private final AssociacaoServiceImpl associacaoService;

    public AssociacaoResource(AssociacaoServiceImpl associacaoService) {
        this.associacaoService = associacaoService;
    }

    @Override
    public List<Associacao> getAll() {
        return associacaoService.findAll();
    }

    @Override
    public Associacao getById(Long id) {
        return associacaoService.findById(id);
    }

    @Override
    public Associacao getByDescricao(String descricao) {
        return associacaoService.findByDescricao(descricao);
    }

    @Override
    public Associacao post(Associacao entity) {
        return associacaoService.save(entity);
    }

    @Override
    public Associacao put(Associacao entity) {
        return associacaoService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        associacaoService.deleteById(id);
    }
}
