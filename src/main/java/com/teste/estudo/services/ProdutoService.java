package com.teste.estudo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.estudo.model.Produto;
import com.teste.estudo.model.exception.ResourceNotFoundException;
import com.teste.estudo.shared.ProdutoDTO;
import com.teste.estudo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    /**
     * Metodo para retornar uma lista de produtos
     * @return Lista de produtos.
     */
    public List<ProdutoDTO> obterTodos(){
        //Colocar regra aqui caso tenha.
        //return produtoRepository_old.obterTodos();
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
            .map(produto -> new ModelMapper()
            .map(produto, ProdutoDTO.class)
            ).collect(Collectors.toList());
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será localizado.
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional <ProdutoDTO> obterPorId(Integer id){
        //return produtoRepository_old.obterPorId(id);
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Produto com id "+
            id+" não encontrado");
        }
        ProdutoDTO dto = new ModelMapper()
        .map(produto.get(), ProdutoDTO.class);
        return Optional.of(dto);
    }

    /**
     * Metodo para adicionar produto na lista.
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista.
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDto){
        //Poderia ter alguma regra de negócio aqui para validar o produto.
        //return produtoRepository_old.adicionar(produto);
        produtoDto.setId(null);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper
        .map(produtoDto, Produto.class);
        produto = produtoRepository.save(produto);
        produtoDto.setId(produto.getId());
        return produtoDto;
    }

    /**
     * Metodo para deletar o produtor por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        //Aqui poderia ter alguma lógica de validação.
        //produtoRepository_old.deletar(id);
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Não encontrado id "+id);
        }
        produtoRepository.deleteById(id);
    }


    public void deletarAll(){
        produtoRepository.deleteAll();
    }

    /**
     * Metodo para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @return Retorna o produto após atualizar a lista.
     */
    public ProdutoDTO atualizar(ProdutoDTO produtoDto, Integer id){
        
        //Poderia ter alguma validação no ID
        produtoDto.setId(id);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);
        produtoRepository.save(produto);

         return produtoDto;
        //return produtoRepository_old.atualizar(produto);
    }
}
