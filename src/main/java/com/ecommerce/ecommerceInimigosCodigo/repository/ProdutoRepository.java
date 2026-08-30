package com.ecommerce.ecommerceInimigosCodigo.repository;

import com.ecommerce.ecommerceInimigosCodigo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}