package com.example.online.thrift.store.controller;

import com.example.online.thrift.store.dto.request.CategoryRequest;
import com.example.online.thrift.store.dto.response.CategoryResponse;
import com.example.online.thrift.store.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/category")

    public ResponseEntity<?> addCategory(@RequestBody CategoryRequest categoryRequest){
        categoryService.addCategory(categoryRequest);
        return BaseController.successResponse("Category Added Successfully","{ }");

    }

        @GetMapping("/categories")
    public ResponseEntity<?> getAllCategory(){

        List<CategoryResponse> categoryResponse = categoryService.getCategory();
        return BaseController.successResponse("Category Details",categoryResponse);

    }

    @DeleteMapping("/category")

    public ResponseEntity<?> deleteCategory(@PathVariable Long id){

        categoryService.deleteCategory(id);
        return BaseController.successResponse("User Deleted Successfully","{ }");

    }


}
