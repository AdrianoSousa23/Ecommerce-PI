package com.ecommerce.ecommerceInimigosCodigo.controller;

import com.ecommerce.ecommerceInimigosCodigo.service.UsuarioService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListaUsuarios {

    private final UsuarioService usuarioService;

    public ListaUsuarios(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar-usuarios")
    public String showUserListPage(Model model) {
        model.addAttribute("usuarios", usuarioService.listaUsuarios());
        return "listar-usuario";
    }
}