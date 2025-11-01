package org.example;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    ProductDao productDao;

    @Override
    public ProductDTOResponse addProduct(ProductDTORequest productDTORequest) {
        log.info("Adding product: {}", productDTORequest.getName());
        String name = productDTORequest.getName().toLowerCase();

//        if(productDao.getProductByName(name) != null) {
//            log.error("Error while adding product: {}", productDTORequest.getName());
//            throw new ResourceAlreadyExistException("Product Already Exist with name: "+name);
//        }

        ProductEntity product = ProductMapper.toEntity(productDTORequest);
        ProductEntity savedProduct = productDao.save(product);
        return ProductMapper.toDtoResponse(savedProduct);
    }

    @Override
    public ProductDTOResponse getProduct(Long id) {
        log.info("Retrieving product with id: {}", id);
        ProductEntity product = productDao.getProductById(id);
        if(product!= null){
            return ProductMapper.toDtoResponse(product);
        }else{
            log.error("Error while retrieving product: {}", product.getName());
            throw new ResourceNotFoundException("Product not found with id: "+id);
        }
    }

    public ProductDTOResponse updateProduct(Long id, ProductDTORequest product){
        ProductEntity existingProduct = productDao.getProductById(id);

        if(existingProduct == null){
            log.error("Error while updating product with id: {}", id);
            throw new UpdateFailedException("Cannot update product not found with id: "+id);
        }

        log.info("Updating product with id: {}", existingProduct.getId());
        existingProduct.setName(product.getName());
//        if(productDao.getProductByName(name) != null) {
//            System.out.println("Product with given name already exists");
//            return null;
//        }

        existingProduct.setBrand(product.getBrand());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setSku(product.getSku());
        // oldProduct.setUpdatedAt(currentTime);

        ProductEntity savedProduct = productDao.save(existingProduct);
        return ProductMapper.toDtoResponse(savedProduct);
    }

    public void deleteProduct(Long id){
        if(getProduct(id) !=null) {
            log.info("Deleting product with id: {}", id);
            productDao.deleteProductById(id);
        }else{
            log.error("Error while deleting product with id: {}", id);
            throw new ResourceNotFoundException("Product not found with id: "+id);
        }
    }
}
