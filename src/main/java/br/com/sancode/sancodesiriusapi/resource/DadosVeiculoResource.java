package br.com.sancode.sancodesiriusapi.resource;

import br.com.sancode.sancodesiriusapi.dto.response.DadosVeiculoDTO;
import br.com.sancode.sancodesiriusapi.service.DadosVeiculoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dadosveiculofipe")
public class DadosVeiculoResource {

    private final DadosVeiculoServiceImpl dadosVeiculoService;

    public DadosVeiculoResource(DadosVeiculoServiceImpl dadosVeiculoService) {
        this.dadosVeiculoService = dadosVeiculoService;
    }

    @GetMapping("/placa/{placa}")
    @ResponseStatus(HttpStatus.OK)
    public DadosVeiculoDTO getDadosVeiculoByPlaca(@PathVariable("placa")String placa){
        return dadosVeiculoService.getDadosVeiculoByPlaca(placa);
    }
}