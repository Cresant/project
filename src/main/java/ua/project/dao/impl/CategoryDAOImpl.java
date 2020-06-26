package ua.project.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ua.project.dao.CategoryDAO;
import ua.project.model.good.Category;


@Repository
public class CategoryDAOImpl extends AbstractDAO implements CategoryDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDAOImpl.class);

    public CategoryDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Category getCategoryById(Integer id) {
        Category category = (Category) getSession().createCriteria(Category.class).add(Restrictions.eq("id", id)).uniqueResult();
        LOGGER.info("Category loaded: {}", category);
        return category;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Category> getAllCategory() {
        List<Category> category= getSession().createCriteria(Category.class).list();
        return new HashSet<>(category);
    }
}
