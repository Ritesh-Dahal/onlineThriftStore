package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.ProductRequest;
import com.example.online.thrift.store.dto.response.ProductResponse;
import com.example.online.thrift.store.entity.Product;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.ProductRepository;
import com.example.online.thrift.store.util.ImageKitUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ImageKitUtil imageKitUtil;

    public void saveProduct(ProductRequest productRequest, MultipartFile imageFile)throws Exception{

       String filePath = uploadLogo(imageFile);
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

    public void updateProduct(Long id ,ProductRequest productRequest){

      Product product = productRepository.findById(id).get();

        product.setQuantity(productRequest.getQuantity());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());

        productRepository.save(product);


    }


    private String uploadLogo(MultipartFile imageFile) throws Exception {
            String folder = "/thriftstore/";
            String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
            String logoUrl = imageKitUtil.uploadImage(imageFile, folder, fileName);
            return logoUrl;
        }




}
