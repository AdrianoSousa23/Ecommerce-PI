package com.ecommerce.ecommerceInimigosCodigo.dto;

import com.ecommerce.ecommerceInimigosCodigo.model.UserRole;

public class ListaUsuarioDTO {

    private String nome;
    private String email;
    private String grupo;
    private String status;

    public ListaUsuarioDTO(String nome, String email, UserRole grupo, String status) {
    }
}
