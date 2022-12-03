package com.vendas.produtos.sql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vendas.produtos.main.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query(value = "select * from produtos where codigo = :dados or nome_produto = :dados", nativeQuery = true)
    public Optional<Produto> buscarProduto(@Param(value = "dados") String dados);

}
