package com.teste.estudo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.teste.estudo.model.Produto;
import com.teste.estudo.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository_old{
    
    //Simulando o banco de dados
    private List <Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;
    
    /**
     * Metodo para retorna uma lista de produtos
     * @return lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }
    
    /**
     * Metodo para adicionar produto na lista.
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        
        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será localizado.
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional <Produto> obterPorId(Integer id){
        return produtos.stream().filter(produto -> produto.getId() == id).findFirst();
    }

    /**
     * Metodo para deletar o produtor por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @return Retorna o produto após atualizar a lista.
     */
    public Produto atualizar(Produto produto){
        //Encontrar o produto na lista.
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId()); 
        
        if(produtoEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Produto não encontrado");
        }
        
        //Remover o produto antigo da lista.
        deletar(produto.getId());
        
        //Depois adicionar o novo produto atualizado na lista.
        produtos.add(produto); //Não usar o metodo já criado pois ele modifica o id.
        
        return produto;
    }

}
