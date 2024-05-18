package br.com.promocoes_api.api.models;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "promocoes")
public class Promocao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "titulo", nullable = false, length = 100)
  private String titulo;

  @Column(name = "desconto", nullable = false, precision = 5, scale = 2)
  private int desconto;

  @Column(name = "data_inicio_promo", nullable = false)
  private LocalDate dataInicioPromo;

  @Column(name = "data_fim_promo", nullable = false)
  private LocalDate dataFimPromo;

}
