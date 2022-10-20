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
public class Vistoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80)
    private String associado;

    @Column(length = 8)
    private String placa;

    private LocalDateTime dataVistoria;

    @Column(length = 30)
    private String Status;
}
