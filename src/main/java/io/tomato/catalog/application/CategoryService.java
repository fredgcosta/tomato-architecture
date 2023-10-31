package io.tomato.catalog.application;

import io.tomato.catalog.application.mappers.CategoryMapper;
import io.tomato.catalog.infra.Category;
import io.tomato.catalog.infra.CategoryRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRES_NEW;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRES_NEW)
public class CategoryService {
    @Inject
    CategoryRepository repository;

    @Inject
    CategoryMapper mapper;

    @Transactional(SUPPORTS)
    public List<io.tomato.catalog.domain.Category> findAllCategories(String name) {
        List<Category> categories = null;
        if (name == null || "".equals(name)) {
            categories = repository.listAll();
        } else {
            categories = repository.filterByName(name);
        }
        return mapper.entityListToDomainList(categories);
    }

    @Transactional(SUPPORTS)
    public io.tomato.catalog.domain.Category findCategoryById(Long id) throws Exception {
        Category category = repository.findById(id);

        if (category == null) {
            throw new Exception(); //TODO criar exceções de negócio
        }
        return mapper.entityToDomain(category);
    }

    @Transactional
    public io.tomato.catalog.domain.Category persistCategory(@Valid io.tomato.catalog.domain.Category category) {
        Category entity = mapper.domainToEntity(category);
        repository.persist(entity);
        return mapper.entityToDomain(entity);
    }

    @Transactional
    public io.tomato.catalog.domain.Category updateCategory(@Valid io.tomato.catalog.domain.Category category)
            throws Exception {
        Category input = mapper.domainToEntity(category);
        Category entity = repository.findById(input.getId());

        if (entity == null) {
            throw new Exception(); //TODO criar exceções de negócio
        }

        entity.setName(category.getName());

        return mapper.entityToDomain(entity);
    }

    public void deleteCategory(Long id) throws Exception {
        Category entity = repository.findById(id);

        if (entity == null) {
            throw new Exception(); //TODO criar exceções de negócio
        }

        repository.delete(entity);
    }
}
