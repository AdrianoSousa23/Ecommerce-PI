package com.ecommerce.ecommerceInimigosCodigo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoForm {

    @NotBlank(message = "O nome do produto é obrigatório")
    private String nome;

    @NotNull(message = "O preço do produto é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private BigDecimal preco;

    @Positive(message = "A quantidade deve ser maior que zero")
    private Integer quantidade;

    private String descricao;

    private String imagem;

    @Min(value = 1, message = "A avaliação mínima é 1")
    @Max(value = 5, message = "A avaliação máxima é 5")
    private Integer avaliacao;
}