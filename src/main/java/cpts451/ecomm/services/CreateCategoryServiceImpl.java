package cpts451.ecomm.services;

import cpts451.ecomm.entities.Category;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryServiceImpl implements CreateCategoryService {
    private CategoryRepository categoryRepository;

    public CreateCategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void CreateNewCategory(Category category)
    {
        ValidateNullFields(category);

        categoryRepository.save(category);
    }

    private void ValidateNullFields(Category newCategory)
    {
        if (newCategory.getCategoryName() == null || newCategory.getCategoryName().trim().isEmpty()) {
            throw new MissingFieldException("Category name is required");
        }
    }
}
