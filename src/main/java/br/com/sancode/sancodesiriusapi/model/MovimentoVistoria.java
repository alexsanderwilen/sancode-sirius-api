package br.com.sancode.sancodesiriusapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MovimentoVistoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Associacao associacao;

    @ManyToOne
    private TipoAutomovel tipoAutomovel;

    private LocalDateTime dataHoraVistoria;

    @ManyToOne
    private Status status;
}
