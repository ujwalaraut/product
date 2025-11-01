package org.example;


import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements  ProductDao{

    @Autowired
    EntityManager entityManager;

    @Override
    public ProductEntity save(ProductEntity product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public ProductEntity getProductByName(String name) {
        return entityManager.find(ProductEntity.class, name);

    }

    @Override
    public ProductEntity getProductById(Long id) {
        return entityManager.find(ProductEntity.class, id);

    }

    @Override
    public void deleteProductById(Long id) {
        ProductEntity product = getProductById(id);
        entityManager.remove(product);
    }
}
