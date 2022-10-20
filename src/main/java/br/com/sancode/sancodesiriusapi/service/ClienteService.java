package br.com.sancode.sancodesiriusapi.service;

import br.com.sancode.sancodesiriusapi.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> getAllClientes();
    List<String> getAllNomeClientes();
    Cliente getCliente(Long id);
    Cliente getCClienteNome(String nome);

    Cliente salvarCliente(Cliente cliente);
    Cliente atualizarCliente(Cliente cliente);
    void excluirCliente(Long id);
}
