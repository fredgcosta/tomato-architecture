package io.tomato.catalog.infra;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
    public List<Product> filterByName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "%" + name + "%");
        return this.find("name LIKE :name", params).list();
    }

    public List<Product> filterByCategory(Category category) {
        return this.find("category", category).list();
    }
}
