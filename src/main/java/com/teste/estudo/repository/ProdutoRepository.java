package com.teste.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.estudo.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>  {
    
}
