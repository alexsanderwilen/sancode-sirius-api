package br.com.sancode.sancodesiriusapi.service;

import br.com.sancode.sancodesiriusapi.dto.response.DadosVeiculoDTO;
import br.com.sancode.sancodesiriusapi.exception.NotFoundException;
import br.com.sancode.sancodesiriusapi.scrapping.fipe.FipeDadosVeiculoScrapping;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DadosVeiculoServiceImpl {

    private final FipeDadosVeiculoScrapping fipeDadosVeiculoScrapping;

    public DadosVeiculoServiceImpl(FipeDadosVeiculoScrapping fipeDadosVeiculoScrapping) {
        this.fipeDadosVeiculoScrapping = fipeDadosVeiculoScrapping;
    }

    public DadosVeiculoDTO getDadosVeiculoByPlaca(String placa) {
        try {
            return fipeDadosVeiculoScrapping.buscarDadosVeiculo(placa);
        } catch (IOException e) {
            throw new NotFoundException("Dados do Veículo não encontrado! Placa: " + placa + DadosVeiculoDTO.class.getName());
        }
    }
}