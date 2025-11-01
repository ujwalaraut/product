package org.example;

public interface ProductDao {
    ProductEntity save(ProductEntity product);

    ProductEntity getProductById(Long id);

    ProductEntity getProductByName(String name);

    void deleteProductById(Long id);
}
