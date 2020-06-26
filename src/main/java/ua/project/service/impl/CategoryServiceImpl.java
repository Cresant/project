package ua.project.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.project.dao.CategoryDAO;
import ua.project.model.good.Category;
import ua.project.service.CategoryService;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public Category getCategoryById(Integer id) {
        return this.categoryDAO.getCategoryById(id);
    }

    @Override
    public Set<Category> getAllCategory() {
        return categoryDAO.getAllCategory();
    }
}
