package br.com.sancode.sancodesiriusapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MovimentoVistoriaVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private MovimentoVistoria movimentoVistoria;
    private String placa;
    private String chassi;
    private String marca;
    private String modelo;
    private String ano;
    private String anoModelo;
    private String cor;
    private String cilindrada;
    private String potencia;
    private String combustível;
    private String uf;
    private String municipio;
    private String importado;
    private String pesoBrutoTotal;
    private String capMaxTração;
    private String tipoVeiculo;
    private String especieVeiculo;
    private String passageiros;
    private String segmento;
    private String imageLinkVeiculoFrontal;
    private String imageLinkVeiculoTraseira;
    private String imageLinkVeiculoLateralEsquerdo;
    private String imageLinkVeiculoLaterialDireita;
}
