package br.com.sancode.sancodesiriusapi.repository;

import br.com.sancode.sancodesiriusapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente getClienteByNome(String nome);
}
