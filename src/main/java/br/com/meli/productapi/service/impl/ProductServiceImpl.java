package br.com.meli.productapi.service.impl;

import br.com.meli.productapi.dto.ProductDTO;
import br.com.meli.productapi.model.Product;
import br.com.meli.productapi.repository.ProductRepository;
import br.com.meli.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public ProductDTO save(ProductDTO dto) {
        log.info("Saving product {}", dto.getName());
        return ProductDTO.toDto(repository.save(toEntity(dto)));
    }

    @Override
    public List<ProductDTO> findAll() {
        log.info("Finding all products");
        return repository.findAll().stream().map(ProductDTO::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByName(String name) {
        log.info("Finding all products filtering by specifics fields");
        return repository.findByName(name)
                .stream().map(ProductDTO::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        log.info("Deleting product with id {}", id);
        repository.deleteById(id);
    }

    private Product toEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setCategory(dto.getCategory());
        entity.setPrice(dto.getPrice());
        return entity;
    }

}
