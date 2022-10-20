package br.com.sancode.sancodesiriusapi.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface ISancodeResource<T> {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<T> getAll();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    T getById(@PathVariable("id") Long id);

    @GetMapping("/descricao/{descricao}")
    @ResponseStatus(HttpStatus.OK)
    T getByDescricao(@PathVariable("descricao")String descricao);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    T post(@RequestBody T entity);

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    T put(@RequestBody T entity);

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable("id")Long id);
}