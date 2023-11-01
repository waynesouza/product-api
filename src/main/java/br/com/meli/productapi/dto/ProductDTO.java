package br.com.meli.productapi.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class ProductDTO implements Serializable {

    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String category;

    @NotNull
    private BigDecimal price;

}
