package com.ecommerce.ecommerceInimigosCodigo.service;

import com.ecommerce.ecommerceInimigosCodigo.dto.ProdutoForm;
import com.ecommerce.ecommerceInimigosCodigo.model.Produto;
import com.ecommerce.ecommerceInimigosCodigo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastrarProduto(ProdutoForm form) {
        Produto produto = new Produto();
        produto.setNome(form.getNome());
        produto.setPreco(form.getPreco());
        produto.setQuantidade(form.getQuantidade());
        produto.setDescricao(form.getDescricao());
        produto.setImagem(form.getImagem());
        produto.setAvaliacao(form.getAvaliacao());

        produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }

    public void editarProduto(Long id, ProdutoForm form) {
        Produto produto = buscarPorId(id);
        produto.setNome(form.getNome());
        produto.setPreco(form.getPreco());
        produto.setQuantidade(form.getQuantidade());
        produto.setDescricao(form.getDescricao());
        produto.setImagem(form.getImagem());
        produto.setAvaliacao(form.getAvaliacao());

        produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}