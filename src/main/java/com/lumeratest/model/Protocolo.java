package com.lumeratest.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.lumeratest.model.enums.NaturezaProtocolo;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Protocolo {

    // O ID seria também o número do protocolo, já que é pra ser um identificador único, numérico e sequencial
    // Se fosse para ser um campo separado, utilizaria o @GeneratedValue com sequence
    // Ou se fosse para fazer na mão, colocaria uma tabela separa de regras sequenciais
    // Aonde guardaria a regra em si (caso fosse personalizável), um identificador e o valor atual
    // Ao criar o protocolo faria lock na tabela, pegaria o valor, faria o incremento e liberaria o lock
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataCriacao;

    @Column(name = "natureza")
    private Integer natureza;

    private LocalDate dataVencimento;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDate.now();
        this.dataVencimento = calcularDataVencimento(NaturezaProtocolo.fromValue(this.natureza));
    }

    private LocalDate calcularDataVencimento(NaturezaProtocolo natureza) {
        if (natureza == NaturezaProtocolo.FINANCEIRO) {
            return dataCriacao.plus(10, ChronoUnit.DAYS); // Adjust to business days if needed
        } else if (natureza == NaturezaProtocolo.JURIDICO) {
            return dataCriacao.plusDays(20);
        } else if (natureza == NaturezaProtocolo.ADMINISTRATIVO) {
            return dataCriacao.plusDays(30);
        }
        return dataCriacao;
    }
}
