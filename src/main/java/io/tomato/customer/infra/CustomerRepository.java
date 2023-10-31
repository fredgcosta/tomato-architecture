package io.tomato.customer.infra;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
    public List<Customer> pesquisarPorName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "%" + name + "%");
        return this.find("name LIKE :name", params).list();
    }
}
