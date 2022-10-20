package br.com.sancode.sancodesiriusapi.repository;

import br.com.sancode.sancodesiriusapi.model.TipoAutomovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoAutomovelRepository extends JpaRepository<TipoAutomovel, Long> {
    TipoAutomovel getByDescricao(String descricao);
}
