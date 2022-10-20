package br.com.sancode.sancodesiriusapi.repository;

import br.com.sancode.sancodesiriusapi.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByDescricao(String descricao);
}
