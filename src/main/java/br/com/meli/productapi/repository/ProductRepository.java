package br.com.meli.productapi.repository;

import br.com.meli.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("select p from Product p " +
            "where coalesce(:name, null) is null or lower(p.name) like concat('%', lower(:name), '%')")
    List<Product> findByName(@Param("name") String name);

}
