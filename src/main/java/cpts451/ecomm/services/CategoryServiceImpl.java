package cpts451.ecomm.services;

import cpts451.ecomm.entities.Category;
import cpts451.ecomm.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Find category by id.
     * @param id the category id.
     * @return category.
     */
    @Override
    public Category find(int id){ return categoryRepository.findById(id).orElse(null); }

    /**
     * finds all categories.
     * @return a collection of categories.
     */
    @Override
    public Iterable<Category> findAll() { return categoryRepository.findAll(); }

    /**
     * saves category to category repository.
     * @param category product to save.
     * @return the category we just saved.
     */
    @Override
    public Category save(Category category) { return categoryRepository.save(category); }
}
