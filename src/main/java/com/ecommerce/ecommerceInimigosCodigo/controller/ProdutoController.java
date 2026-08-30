package com.ecommerce.ecommerceInimigosCodigo.controller;

import com.ecommerce.ecommerceInimigosCodigo.dto.ProdutoForm;
import com.ecommerce.ecommerceInimigosCodigo.model.Produto;
import com.ecommerce.ecommerceInimigosCodigo.service.ProdutoService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/lista-produtos")
    public String listaProdutos(Model model) {
        model.addAttribute("produtos", produtoService.listarProdutos());
        return "lista-produtos";
    }

    @GetMapping("/cadastrar-produtos")
    public String showCadastroProdutoPage(Model model) {
        model.addAttribute("produtoForm", new ProdutoForm());
        return "cadastro-produtos";
    }

    @PostMapping("/salvar-produto")
    public String salvarProduto(@Valid @ModelAttribute("produtoForm") ProdutoForm form,
                                BindingResult result) {

        if (result.hasErrors()) {
            return "cadastro-produtos";
        }

        produtoService.cadastrarProduto(form);
        return "redirect:/lista-produtos";
    }

    @GetMapping("/editar-produto/{id}")
    public String showEditarProdutoPage(@PathVariable Long id, Model model) {
        Produto produto = produtoService.buscarPorId(id);

        ProdutoForm form = new ProdutoForm();
        form.setNome(produto.getNome());
        form.setPreco(produto.getPreco());
        form.setQuantidade(produto.getQuantidade());
        form.setDescricao(produto.getDescricao());
        form.setImagem(produto.getImagem());
        form.setAvaliacao(produto.getAvaliacao());

        model.addAttribute("produtoForm", form);
        model.addAttribute("produtoId", id);
        return "cadastro-produtos";
    }

    @PostMapping("/editar-produto/{id}")
    public String editarProduto(@PathVariable Long id,
                                @Valid @ModelAttribute("produtoForm") ProdutoForm form,
                                BindingResult result) {

        if (result.hasErrors()) {
            return "cadastro-produtos";
        }

        produtoService.editarProduto(id, form);
        return "redirect:/lista-produtos";
    }

    @PostMapping("/deletar-produto/{id}")
    public String deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return "redirect:/lista-produtos";
    }
}