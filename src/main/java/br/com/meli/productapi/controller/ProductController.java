package br.com.meli.productapi.controller;

import br.com.meli.productapi.dto.ProductDTO;
import br.com.meli.productapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product")
@Slf4j
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductDTO dto) {
        log.info("Request to create product");
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        log.info("Request to list all products");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/name")
    public ResponseEntity<List<ProductDTO>> findAllWithFilters(@RequestParam("name") String name) {
        log.info("Request to list all products by filters");
        return ResponseEntity.ok(service.findByName(name));
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@Valid @RequestBody ProductDTO dto) {
        log.info("Request to update product");
        return ResponseEntity.ok(service.save(dto));
    }

    @PatchMapping
    public ResponseEntity<ProductDTO> partialUpdate(@Valid @RequestBody ProductDTO dto) {
        log.info("Request to update specifics fields of product");
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        log.info("Request to delete specific product");
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
