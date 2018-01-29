package org.st6.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.st6.oms.entity.Product;
import org.st6.oms.repository.ProductRepository;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @GetMapping("/products/list-paged")
    public Page<Product> findAllByNameContainsPaged(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        Page<Product> pagedProducts = repo.findAll(
                new PageRequest(page, size)
        );
        return pagedProducts;
    }

    @GetMapping("/products/find-paged")
    public Page<Product> findAllByNameContainsPaged(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        Page<Product> allByNameContains = repo.findAllByNameContains(
                name,
                new PageRequest(page, size)
        );
        return allByNameContains;
    }

    @PostMapping("/products/save")
    Long save(@RequestBody Product product) {
        return repo.save(product).getId();
    }

    @GetMapping("/products/delete/{productId}")
    boolean delete(@PathVariable Long productId) {
        repo.delete(productId);
        return true;
    }

}
