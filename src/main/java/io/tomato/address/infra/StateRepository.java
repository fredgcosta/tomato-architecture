package io.tomato.address.infra;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StateRepository implements PanacheRepository<State> {

}
