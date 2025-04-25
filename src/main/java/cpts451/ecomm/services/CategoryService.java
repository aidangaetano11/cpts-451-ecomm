package cpts451.ecomm.services;

import cpts451.ecomm.entities.Category;

public interface CategoryService {
    Category find(int id);

    Iterable<Category> findAll();

    Category save(Category category);

}
