package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.CategoryRequest;
import com.example.online.thrift.store.dto.response.CategoryResponse;
import com.example.online.thrift.store.entity.Category;
import com.example.online.thrift.store.exception.AlreadyExistException;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;


    public void addCategory(CategoryRequest categoryRequest){

       categoryRepository.findByName(categoryRequest.getName())
               .ifPresent(category-> {throw new AlreadyExistException("Category Already Exist");});


    }

    public List<CategoryResponse> getCategory(){

        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = categoryList.stream().map(CategoryResponse::new).toList();
        return categoryResponses;

    }

    public void deleteCategory(Long id ){
        categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Category With Provided id not found"));
        categoryRepository.deleteById(id);
    }


}
