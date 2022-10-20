package br.com.sancode.sancodesiriusapi.resource;

import br.com.sancode.sancodesiriusapi.model.MovimentoVistoriaVeiculo;
import br.com.sancode.sancodesiriusapi.service.MovimentoVistoriaVeiculoServiceImpl;
import br.com.sancode.sancodesiriusapi.util.ISancodeResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movimentovistoriaveiculos")
public class MovimentoVistoriaVeiculoResource implements ISancodeResource<MovimentoVistoriaVeiculo> {
    private final MovimentoVistoriaVeiculoServiceImpl movimentoVistoriaVeiculoService;

    public MovimentoVistoriaVeiculoResource(MovimentoVistoriaVeiculoServiceImpl movimentoVistoriaVeiculoService) {
        this.movimentoVistoriaVeiculoService = movimentoVistoriaVeiculoService;
    }

    @Override
    public List<MovimentoVistoriaVeiculo> getAll() {
        return movimentoVistoriaVeiculoService.findAll();
    }

    @Override
    public MovimentoVistoriaVeiculo getById(Long id) {
        return movimentoVistoriaVeiculoService.findById(id);
    }

    @Override
    public MovimentoVistoriaVeiculo getByDescricao(String descricao) {
        return movimentoVistoriaVeiculoService.findByDescricao(descricao);
    }

    @Override
    public MovimentoVistoriaVeiculo post(MovimentoVistoriaVeiculo entity) {
        return movimentoVistoriaVeiculoService.save(entity);
    }

    @Override
    public MovimentoVistoriaVeiculo put(MovimentoVistoriaVeiculo entity) {
        return movimentoVistoriaVeiculoService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        movimentoVistoriaVeiculoService.deleteById(id);
    }

    @PostMapping(
            path = "/foto/veiculofrontal/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadImageVeiculoFrontal(@RequestParam("file") MultipartFile file){
        movimentoVistoriaVeiculoService.uploadImageVeiculoFrontal(1L, file);
    }

    @PostMapping(
            path = "/foto/veiculo/traseira/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadImageVeiculoTraseira(@RequestParam("file") MultipartFile file){
        movimentoVistoriaVeiculoService.uploadImageVeiculoTraseira(1L, file);
    }

    @PostMapping(
            path = "/foto/veiculo/lateral/esquerdo/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadImageVeiculoLateralEsquerdo(@RequestParam("file") MultipartFile file){
        movimentoVistoriaVeiculoService.uploadImageVeiculoLateralEsquerdo(1L, file);
    }

    @PostMapping(
            path = "/foto/veiculo/lateral/direito/direito/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadImageVeiculoLateralDireito(@RequestParam("file") MultipartFile file){
        movimentoVistoriaVeiculoService.uploadImageVeiculoLateralDireito(1L, file);
    }

    @GetMapping("/foto/veiculofrontal/download/{id}")
    public byte[] downloadImageVeiculoFrontal(@PathVariable("id") Long id){
        return movimentoVistoriaVeiculoService.downloadImageVeiculoFrontal(id);
    }
    @GetMapping("/foto/veiculo/traseira/download/{id}")
    public byte[] downloadImageVeiculoTraseira(@PathVariable("id") Long id){
        return movimentoVistoriaVeiculoService.downloadImageVeiculoTraseira(id);
    }
    @GetMapping("/foto/veiculo/lateral/esquerdo/download/{id}")
    public byte[] downloadImageVeiculoLateralEsquedo(@PathVariable("id") Long id){
        return movimentoVistoriaVeiculoService.downloadImageVeiculoLateralEsquerdo(id);
    }
    @GetMapping("/foto/veiculo/lateral/direito/direito/download/{id}")
    public byte[] downloadImageVeiculoLateralDireita(@PathVariable("id") Long id){
        return movimentoVistoriaVeiculoService.downloadImageVeiculoLateralDireito(id);
    }
}
