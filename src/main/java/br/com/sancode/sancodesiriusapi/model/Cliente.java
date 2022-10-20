package br.com.sancode.sancodesiriusapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    @Column(length = 80)
    private int tipoCliente;

    @Column(length = 80)
    private String nome;

    @Column(length = 14)
    private String documento;

    @Column(length = 8)
    private String cep;

    @Column(length = 50)
    private String estado;

    @Column(length = 100)
    private String cidade;

    @Column(length = 100)
    private String endereco;

    @Column(length = 100)
    private String bairro;

    @Column(length = 11)
    private String telefone;

    @Column(length = 100)
    private String email;
}
