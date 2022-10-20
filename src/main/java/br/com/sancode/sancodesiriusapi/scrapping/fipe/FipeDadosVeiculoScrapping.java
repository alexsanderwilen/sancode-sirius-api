package br.com.sancode.sancodesiriusapi.scrapping.fipe;

import br.com.sancode.sancodesiriusapi.dto.response.DadosVeiculoDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FipeDadosVeiculoScrapping {

	Document documento = null;

	public DadosVeiculoDTO buscarDadosVeiculo(String placa) throws IOException {

		documento = Jsoup.connect("https://www.tabelafipebrasil.com/placa/"+placa)
				.timeout(5000)
				.userAgent("Mozilla")
				.get();

		Elements row = documento
				.select("table")
				.get(0).select("tr")
				.select("td");

		List dadosVeiculo = row.stream().map((cli -> cli.getAllElements().first())).collect(Collectors.toList());

		if(dadosVeiculo.size() > 30){


		int posFin =  dadosVeiculo.get(1).toString().lastIndexOf("</a>");
		String s = dadosVeiculo.get(1).toString().substring(0, posFin);
		int posIni = s.lastIndexOf(">") + 1;
		return DadosVeiculoDTO
				.builder()
				.placa(placa)
				.marca(dadosVeiculo.get(1).toString().substring(posIni, posFin))
				.modelo(dadosVeiculo.get(3).toString().replace("<td>", "").replace("</td>", ""))
				.ano(dadosVeiculo.get(5).toString().replace("<td>", "").replace("</td>", ""))
				.anoModelo(dadosVeiculo.get(7).toString().replace("<td>", "").replace("</td>", ""))
				.cor(dadosVeiculo.get(9).toString().replace("<td>", "").replace("</td>", ""))
				.cilindrada(dadosVeiculo.get(11).toString().replace("<td>", "").replace("</td>", ""))
				.potencia(dadosVeiculo.get(13).toString().replace("<td>", "").replace("</td>", ""))
				.combustivel(dadosVeiculo.get(15).toString().replace("<td>", "").replace("</td>", ""))
				.chassi(dadosVeiculo.get(17).toString().replace("<td>", "").replace("</td>", ""))
				.uf(dadosVeiculo.get(19).toString().replace("<td>", "").replace("</td>", ""))
				.municipio(dadosVeiculo.get(21).toString().replace("<td>", "").replace("</td>", ""))
				.importado(dadosVeiculo.get(23).toString().replace("<td>", "").replace("</td>", ""))
				.pesoBrutoTotal(dadosVeiculo.get(25).toString().replace("<td>", "").replace("</td>", ""))
				.capMaxTracao(dadosVeiculo.get(27).toString().replace("<td>", "").replace("</td>", ""))
				.tipoVeiculo(dadosVeiculo.get(29).toString().replace("<td>", "").replace("</td>", ""))
				.especieVeiculo(dadosVeiculo.get(31).toString().replace("<td>", "").replace("</td>", ""))
				.passageiros(dadosVeiculo.get(33).toString().replace("<td>", "").replace("</td>", ""))
				.segmento(dadosVeiculo.get(35).toString().replace("<td>", "").replace("</td>", ""))
				.build();}
		else{
			int posFin =  dadosVeiculo.get(1).toString().lastIndexOf("</a>");
			String s = dadosVeiculo.get(1).toString().substring(0, posFin);
			int posIni = s.lastIndexOf(">") + 1;
			return DadosVeiculoDTO
					.builder()
					.placa(placa)
					.marca(dadosVeiculo.get(1).toString().substring(posIni, posFin))
					.modelo(dadosVeiculo.get(3).toString().replace("<td>", "").replace("</td>", ""))
					.ano(dadosVeiculo.get(5).toString().replace("<td>", "").replace("</td>", ""))
					.anoModelo(dadosVeiculo.get(4).toString().replace("<td>", "").replace("</td>", ""))
					.cor(dadosVeiculo.get(7).toString().replace("<td>", "").replace("</td>", ""))
					.cilindrada(dadosVeiculo.get(6).toString().replace("<td>", "").replace("</td>", ""))
					.potencia(dadosVeiculo.get(7).toString().replace("<td>", "").replace("</td>", ""))
					.combustivel(dadosVeiculo.get(9).toString().replace("<td>", "").replace("</td>", ""))
					.chassi(dadosVeiculo.get(11).toString().replace("<td>", "").replace("</td>", ""))
					.uf(dadosVeiculo.get(13).toString().replace("<td>", "").replace("</td>", ""))
					.municipio(dadosVeiculo.get(15).toString().replace("<td>", "").replace("</td>", ""))
					.importado(dadosVeiculo.get(17).toString().replace("<td>", "").replace("</td>", ""))
					.pesoBrutoTotal(dadosVeiculo.get(13).toString().replace("<td>", "").replace("</td>", ""))
					.capMaxTracao(dadosVeiculo.get(14).toString().replace("<td>", "").replace("</td>", ""))
					.tipoVeiculo(dadosVeiculo.get(15).toString().replace("<td>", "").replace("</td>", ""))
					.especieVeiculo(dadosVeiculo.get(16).toString().replace("<td>", "").replace("</td>", ""))
					.passageiros(dadosVeiculo.get(17).toString().replace("<td>", "").replace("</td>", ""))

					.build();}

		}
	}
