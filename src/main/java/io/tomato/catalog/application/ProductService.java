package io.tomato.catalog.application;

import io.tomato.catalog.application.mappers.ProductMapper;
import io.tomato.catalog.infra.Category;
import io.tomato.catalog.infra.Product;
import io.tomato.catalog.infra.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRES_NEW;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRES_NEW)
public class ProductService {
    @Inject
    ProductRepository repository;

    @Inject
    ProductMapper mapper;

    @Transactional(SUPPORTS)
    public List<io.tomato.catalog.domain.Product> findAllProducts(String name) {
        List<Product> products = null;
        if (name == null || "".equals(name)) {
            products = repository.listAll();
        } else {
            products = repository.filterByName(name);
        }
        return mapper.entityListToDomainList(products);
    }

    @Transactional(SUPPORTS)
    public List<io.tomato.catalog.domain.Product> findProductByCategory(Category category) {
        List<Product> products = null;
        if (category == null) {
            products = repository.listAll();
        } else {
            products = repository.filterByCategory(category);
        }
        return mapper.entityListToDomainList(products);
    }

    @Transactional(SUPPORTS)
    public io.tomato.catalog.domain.Product findProductById(Long id) throws Exception {
        Product product = repository.findById(id);

        if (product == null) {
            throw new Exception(); //TODO criar exceções de negócio
        }

        return mapper.entityToDomain(product);
    }

    @Transactional
    public io.tomato.catalog.domain.Product persistProduct(@Valid io.tomato.catalog.domain.Product product) {
        Product entity = mapper.domainToEntity(product);
        repository.persist(entity);

        return mapper.entityToDomain(entity);
    }

    @Transactional
    public io.tomato.catalog.domain.Product updateProduct(@Valid io.tomato.catalog.domain.Product product) throws Exception {
        Product entity = mapper.domainToEntity(product);

        entity = repository.findById(entity.getId());

        if (entity == null) {
            throw new Exception(); //TODO criar exceções de negócio
        }

        entity.setName(product.getName());

        return mapper.entityToDomain(entity);
    }

    public void deleteProduct(Long id) throws Exception {
        Product product = repository.findById(id);

        if (product == null) {
            throw new Exception(); //TODO criar exceções de negócio
        }

        repository.delete(product);
    }
}
