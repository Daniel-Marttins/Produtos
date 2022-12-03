package com.vendas.produtos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.produtos.main.Produto;
import com.vendas.produtos.sql.ProdutoRepository;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
@Table(name = "produtos")
public class ProdutoService {

    @Autowired
    public ProdutoRepository repo;

    public Produto salvarProduto(Produto produto) {
        return repo.save(produto);
    }

    public List<Produto> todosProdutos() {
        return repo.findAll();
    }

    public Optional<Produto> buscarProduto(String dados) {
        return repo.buscarProduto(dados);
    }

    public void exluirProduto(Integer id) {
        repo.deleteById(id);
    }

}
