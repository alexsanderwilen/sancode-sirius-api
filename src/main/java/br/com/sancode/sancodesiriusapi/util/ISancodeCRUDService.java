package br.com.sancode.sancodesiriusapi.util;

import java.util.List;

public interface ISancodeCRUDService<T> {
    List<T> findAll();
    T save(T entity);
    T findById(Long id);
    T findByDescricao(String descricao);
    void delete(T entity);
    void deleteById(Long id);
}