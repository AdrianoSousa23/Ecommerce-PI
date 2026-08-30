package com.ecommerce.ecommerceInimigosCodigo.controller;

import com.ecommerce.ecommerceInimigosCodigo.dto.ListaUsuarioDTO;
import com.ecommerce.ecommerceInimigosCodigo.service.UsuarioService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PrincipalController {

    private final UsuarioService usuarioService;

    public PrincipalController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/principal")
    public String showPrincipalPage() {
        return "principal";
    }

    @GetMapping("/listar-cliente")
    public String redirectToCadastroUsuario() {
        return "redirect:/cadastro-usuarios";
    }

    @GetMapping("/buscar-usuarios")
    @ResponseBody
    public List<ListaUsuarioDTO> buscarUsuarios() {
        return usuarioService.listaUsuarios();
    }
}