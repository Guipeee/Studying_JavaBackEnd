package com.teste.estudo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.estudo.model.Produto;
import com.teste.estudo.repository.ProdutoRepository_old;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository_old produtoRepository;
    
    /**
     * Metodo para retornar uma lista de produtos
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos(){
        //Colocar regra aqui caso tenha.
        return produtoRepository.obterTodos();
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será localizado.
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional <Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

    /**
     * Metodo para adicionar produto na lista.
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        //Poderia ter alguma regra de negócio aqui para validar o produto.
        return produtoRepository.adicionar(produto);
    }

    /**
     * Metodo para deletar o produtor por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        //Aqui poderia ter alguma lógica de validação.
        produtoRepository.deletar(id);
    }

    /**
     * Metodo para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @return Retorna o produto após atualizar a lista.
     */
    public Produto atualizar(Produto produto, Integer id){
        
        //Poderia ter alguma validação no ID
        produto.setId(id);
        
        return produtoRepository.atualizar(produto);
    }
}
