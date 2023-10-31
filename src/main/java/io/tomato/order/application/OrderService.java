package io.tomato.order.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import static jakarta.transaction.Transactional.TxType.REQUIRES_NEW;

@ApplicationScoped
@Transactional(REQUIRES_NEW)
public class OrderService {
    //    @Inject
    //    OrderRepository repository;
    //
    //    @Transactional(SUPPORTS)
    //    public List<Order> pesquisaPorName(String name) {
    //        List<Order> orders = null;
    //        if (name == null || "".equals(name)) {
    //            orders = repository.listAll();
    //        } else {
    //            orders = repository.pesquisaPorName(name);
    //        }
    //        return orders;
    //    }
    //
    //    @Transactional(SUPPORTS)
    //    public Order findOrderById(Long id) {
    //        Order order = repository.findById(id);
    //
    //        if (order == null) {
    //           // throw new ErroNegocialException(ErrosSistema.BANDEIRA_NAO_ENCONTRADA_PARA_CODIGO.get());
    //        }
    //
    //        return order;
    //    }
    //
    //    @Transactional
    //    public Order persistOrder(@Valid Order order) {
    //        repository.persist(order);
    //        return order;
    //    }
    //
    //    @Transactional
    //    public Order updateOrder(@Valid Order order) {
    //        Order entity = repository.findById(order.getId());
    //
    //        if (entity == null) {
    //            //throw new ErroNegocialException(ErrosSistema.BANDEIRA_NAO_ENCONTRADA.get());
    //        }
    //        return entity;
    //    }
    //
    //    public void deleteOrder(Long id) {
    //        Order order = repository.findById(id);
    //
    //        if (order == null) {
    //            //throw new ErroNegocialException(ErrosSistema.BANDEIRA_NAO_ENCONTRADA.get());
    //        }
    //
    //        repository.delete(order);
    //    }
}
