package ua.project.service;

import java.util.Set;

import ua.project.model.good.Category;


public interface CategoryService {

    Category getCategoryById(Integer id);

    Set<Category> getAllCategory();
}
