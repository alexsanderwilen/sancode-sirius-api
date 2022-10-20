package br.com.sancode.sancodesiriusapi.resource;

import br.com.sancode.sancodesiriusapi.model.Cliente;
import br.com.sancode.sancodesiriusapi.service.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteResource {

    private final ClienteServiceImpl clienteService;

    public ClienteResource(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteService.getAllClientes();
    }

    @GetMapping("/nomes")
    public List<String> getAllNomesClientes(){
        return clienteService.getAllNomeClientes();
    }

    @GetMapping("/nomes/{nome}")
    public Cliente getClienteNome(@PathVariable("nome") String nome){
        return clienteService.getCClienteNome(nome);
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable("id") Long id) {
        return clienteService.getCliente(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente saveCliente(@RequestBody Cliente cliente) {
         return clienteService.salvarCliente(cliente);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Cliente updateCliente(@RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCliente(@PathVariable("id") Long id) {
        clienteService.excluirCliente(id);
    }
}