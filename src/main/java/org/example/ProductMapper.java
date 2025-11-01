package org.example;

public class ProductMapper {
    //  DTO to Entity

    public static ProductEntity toEntity(ProductDTORequest dtoRequest){
        ProductEntity product = new ProductEntity();

        product.setName(dtoRequest.getName());
        product.setDescription(dtoRequest.getDescription());
        product.setPrice(dtoRequest.getPrice());
        product.setCategory(dtoRequest.getCategory());
        product.setBrand(dtoRequest.getBrand());
        product.setQuantity(dtoRequest.getQuantity());

        return product;
    }

    // Entity to ResponseDTO
    public static ProductDTOResponse toDtoResponse(ProductEntity product){
        ProductDTOResponse dtoResponse = new ProductDTOResponse();

        dtoResponse.setId(product.getId());
        dtoResponse.setName(product.getName());
        dtoResponse.setDescription(product.getDescription());
        dtoResponse.setPrice(product.getPrice());
        dtoResponse.setCategory(product.getCategory());
        dtoResponse.setBrand(product.getBrand());
        dtoResponse.setQuantity(product.getQuantity());
        dtoResponse.setCreatedAt(product.getCreatedAt());
        dtoResponse.setUpdatedAt(product.getUpdatedAt());

        return dtoResponse;
    }

}
