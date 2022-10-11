package ng.com.createsoftware.manytomany.service;

import ng.com.createsoftware.manytomany.dto.request.CategoryRequestDto;
import ng.com.createsoftware.manytomany.dto.response.CategoryResponseDto;
import ng.com.createsoftware.manytomany.model.Category;

import java.util.List;

public interface CategoryService  {

    Category getCategory(Long categoryId);

    CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);

    CategoryResponseDto getCategoryById(Long categoryId);

    List<CategoryResponseDto> getCategories();

    CategoryResponseDto deleteCategory(Long categoryId);

    CategoryResponseDto editCategory(Long categoryId, CategoryRequestDto categoryRequestDto);

}
