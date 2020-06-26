package ua.project.dao;


import java.util.Set;

import ua.project.model.good.Category;

public interface CategoryDAO {

    Category getCategoryById(Integer id);

    Set<Category> getAllCategory();
}
