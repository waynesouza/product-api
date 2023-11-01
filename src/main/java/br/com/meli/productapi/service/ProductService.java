package br.com.meli.productapi.service;


import br.com.meli.productapi.dto.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductDTO save(ProductDTO dto);

    List<ProductDTO> findAll();

    ProductDTO findById(UUID id);

    List<ProductDTO> findByName(String name);

    void deleteById(UUID id);

}
