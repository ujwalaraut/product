package org.example;

public interface ProductService {

    ProductDTOResponse addProduct(ProductDTORequest product);

    ProductDTOResponse getProduct(Long id);

    ProductDTOResponse updateProduct(Long id, ProductDTORequest product);

    void deleteProduct(Long id);
}
