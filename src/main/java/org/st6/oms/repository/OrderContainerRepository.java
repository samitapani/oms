package org.st6.oms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.st6.oms.entity.OrderContainer;

public interface OrderContainerRepository extends PagingAndSortingRepository<OrderContainer, Long> {

    OrderContainer save(OrderContainer orderContainer);

    Page<OrderContainer> findAllByNameContains(String name, Pageable pageable);

}

