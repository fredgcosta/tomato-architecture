package io.tomato.catalog.infra;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {
    public List<Category> filterByName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "%" + name + "%");
        return this.find("name LIKE :name", params).list();
    }

    public List<Category> pesquisarPorCategory(Category categoryParent) {
        return this.find("parent", categoryParent).list();
    }
}
