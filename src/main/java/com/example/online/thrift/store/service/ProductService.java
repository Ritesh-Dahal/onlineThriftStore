package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.ProductRequest;
import com.example.online.thrift.store.dto.response.ProductResponse;
import com.example.online.thrift.store.entity.Product;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public void saveProduct(ProductRequest productRequest, MultipartFile imageFile)throws Exception{

        // this is the path where the image is stored

        String uploadDir = "C:\\Users\\user\\Desktop\\ThriftStoreImageDatabase";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate a random unique file name to avoid overwriting

        String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);


        //Save the file to the uploads folder i.e imagedatabase

        Files.copy(imageFile.getInputStream(), filePath);

        Product product = new Product(productRequest);
        product.setImagePath(filePath.toString());

        productRepository.save(product);

    }


    public List<ProductResponse> getAllProduct(){

        List<Product> productList = productRepository.findAll();
        List<ProductResponse> responseList = productList.stream().map(ProductResponse::new).toList();
        return responseList;

    }

    public ProductResponse getSingleProduct(Long id) {

        Product product = productRepository.findById(id).orElseThrow(()-> new NotFoundException("Product with id "+ id +" not found"));
        ProductResponse response = new ProductResponse(product);
        return response;
    }



    public void deleteProduct(Long id){

        productRepository.findById(id).orElseThrow(()-> new NotFoundException("Product with id "+id +" not found"));
        productRepository.deleteById(id);
    }



}
