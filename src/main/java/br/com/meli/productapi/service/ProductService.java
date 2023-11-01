package br.com.meli.productapi.service;


import br.com.meli.productapi.dto.ProductDTO;
import br.com.meli.productapi.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductDTO save(ProductDTO dto);

    List<ProductDTO> findAll();

    List<ProductDTO> findAllWithFilters();

    void deleteById(UUID id);

}
