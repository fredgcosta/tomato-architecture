package io.tomato.customer.application;

import io.tomato.customer.infra.Customer;
import io.tomato.customer.infra.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRES_NEW;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRES_NEW)
public class CustomerService {
    @Inject
    CustomerRepository repository;

    @Transactional(SUPPORTS)
    public List<Customer> findAllCustomers(String name) {
        List<Customer> customers = null;
        if (name == null || "".equals(name)) {
            customers = repository.listAll();
        } else {
            customers = repository.pesquisarPorName(name);
        }
        return customers;
    }

    @Transactional(SUPPORTS)
    public Customer findCustomerById(Long id) {
        Customer customer = repository.findById(id);

        if (customer == null) {
            //throw new ErroNegocialException(ErrosSistema.BANDEIRA_NAO_ENCONTRADA_PARA_CODIGO.get());
        }

        return customer;
    }

    @Transactional
    public Customer persistCustomer(@Valid Customer customer) {
        repository.persist(customer);
        return customer;
    }

    @Transactional
    public Customer updateCustomer(@Valid Customer customer) {
        Customer entity = repository.findById(customer.getId());

        if (entity == null) {
            //throw new ErroNegocialException(ErrosSistema.BANDEIRA_NAO_ENCONTRADA.get());
        }

        entity.setName(customer.getName());

        return entity;
    }

    public void deleteCustomer(Long id) {
        Customer customer = repository.findById(id);

        if (customer == null) {
            //throw new ErroNegocialException(ErrosSistema.BANDEIRA_NAO_ENCONTRADA.get());
        }

        repository.delete(customer);
    }

}
