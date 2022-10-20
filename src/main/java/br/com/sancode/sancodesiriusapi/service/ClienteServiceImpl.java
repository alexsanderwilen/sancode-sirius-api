package br.com.sancode.sancodesiriusapi.service;


import br.com.sancode.sancodesiriusapi.exception.NotFoundException;
import br.com.sancode.sancodesiriusapi.model.Cliente;
import br.com.sancode.sancodesiriusapi.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public List<String> getAllNomeClientes() {
        return clienteRepository.findAll().stream().map((cli -> cli.getNome())).collect(Collectors.toList());
    }

    @Override
    public Cliente getCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (!cliente.isPresent()){
            throw new NotFoundException("Cliente não encontrado! Id: " + id + Cliente.class.getName());
        }

        return cliente.get();
    }

    @Override
    public Cliente getCClienteNome(String nome) {
        return clienteRepository.getClienteByNome(nome);
    }

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
