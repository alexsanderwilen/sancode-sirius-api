package br.com.sancode.sancodesiriusapi.repository;

import br.com.sancode.sancodesiriusapi.model.Associacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociacaoRepository extends JpaRepository<Associacao, Long> {
    Associacao findByRazaoSocial(String razaoSocial);
}
