package br.com.promocoes_api.api.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private int preco;

    @Column(name = "data_validade", nullable = false)
    private LocalDate dataValidade;

    @Column(name = "data_ultima_atualizacao_preco", nullable = false)
    private LocalDate dataUltimaAtualizacaoPreco = LocalDate.now();

    @Column(name = "marca", nullable = false, length = 100)
    private String marca;

    @Column(name = "categoria", nullable = false, length = 100)
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "id_secao", nullable = false)
    private Secao secao;

    @OneToOne
    @JoinColumn(name = "id_promocao")
    private Promocao promocao;

}