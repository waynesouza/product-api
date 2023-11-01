package br.com.meli.productapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Product implements Serializable {

    @Id
    @UuidGenerator
    private UUID id;

    private String name;

    private String description;

    private String category;

    private BigDecimal price;

}
