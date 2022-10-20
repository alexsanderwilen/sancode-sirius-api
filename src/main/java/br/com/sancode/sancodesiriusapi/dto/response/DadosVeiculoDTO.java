package br.com.sancode.sancodesiriusapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DadosVeiculoDTO {
    private String placa;
    private String chassi;
    private String marca;
    private String modelo;
    private String ano;
    private String anoModelo;
    private String cor;
    private String cilindrada;
    private String potencia;
    private String combustivel;
    private String uf;
    private String municipio;
    private String importado;
    private String pesoBrutoTotal;
    private String capMaxTracao;
    private String tipoVeiculo;
    private String especieVeiculo;
    private String passageiros;
    private String segmento;
}
