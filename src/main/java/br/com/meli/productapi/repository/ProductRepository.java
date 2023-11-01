package br.com.meli.productapi.repository;

import br.com.meli.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByCategory(String category);

    List<Product> findAllByNameContains(String nome);

}
