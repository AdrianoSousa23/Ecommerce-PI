package com.ecommerce.ecommerceInimigosCodigo.controller;

import com.ecommerce.ecommerceInimigosCodigo.dto.UsuarioForm;
import com.ecommerce.ecommerceInimigosCodigo.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastrarController {

    private final UsuarioService usuarioService;

    public CadastrarController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/cadastrar-usuarios")
    public String showCadastroPage(Model model) {
        model.addAttribute("usuarioForm", new UsuarioForm());
        return "cadastro-usuarios";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@Valid @ModelAttribute("usuarioForm") UsuarioForm form,
                                BindingResult result,
                                Model model) {

        if (result.hasErrors()) {
            return "cadastro-usuarios";
        }

        try {
            usuarioService.cadastrarUsuario(form);
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            model.addAttribute("erroBanco", e.getMessage());
            return "cadastro-usuarios";
        }
    }
}