package org.st6.oms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.st6.oms.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    Product save(Product product);

    Page<Product> findAllByNameContains(String name, Pageable pageable);
}
