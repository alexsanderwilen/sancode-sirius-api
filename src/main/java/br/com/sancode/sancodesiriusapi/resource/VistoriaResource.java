package br.com.sancode.sancodesiriusapi.resource;

import br.com.sancode.sancodesiriusapi.model.Vistoria;
import br.com.sancode.sancodesiriusapi.service.VistoriaServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/vistorias")
public class VistoriaResource {
    private final VistoriaServiceImpl vistoriaService;

    public VistoriaResource(VistoriaServiceImpl vistoriaService) {
        this.vistoriaService = vistoriaService;
    }

    @GetMapping
    public List<Vistoria> getAllVistorias(){
        return vistoriaService.getAllVistoria();
    }
}
