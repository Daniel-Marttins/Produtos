package com.vendas.produtos.main;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotBlank(message = "Codigo é Obrigatorio!")
    @Column(name = "Codigo")
    private String codigo;

    @NotBlank(message = "Nome é Obrigatorio!")
    @Column(name = "Nome_Produto")
    private String nomeProduto;

    @Column(name = "Data")
    private String data;

    @NotNull(message = "Deve Conter 1 Unidade!")
    @Column(name = "Quantidade")
    private Integer quantidade;

    @NotNull(message = "Valor é Obrigatorio!")
    @Column(name = "Valor")
    private Integer valor;

}
