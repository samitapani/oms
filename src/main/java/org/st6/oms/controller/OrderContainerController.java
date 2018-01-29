package org.st6.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.st6.oms.entity.OrderContainer;
import org.st6.oms.repository.OrderContainerRepository;

@RestController
public class OrderContainerController {

    @Autowired
    private OrderContainerRepository repo;

    @PostMapping("/orders/save")
    long save(@RequestBody OrderContainer orderContainer) {
        return repo.save(orderContainer).getId();
    }


    @GetMapping("/orders/find-paged")
    public Page<OrderContainer> findAllByNameContainsPaged(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        Page<OrderContainer> allByNameContains = repo.findAllByNameContains(
                name,
                new PageRequest(page, size)
        );
        return allByNameContains;
    }

    @GetMapping("/orders/list-paged")
    public Page<OrderContainer> findAllByNameContainsPaged(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        Page<OrderContainer> allByNameContains = repo.findAll(
                new PageRequest(page, size)
        );
        return allByNameContains;
    }

    @GetMapping("/orders/delete/{orderContainerId}")
    boolean delete(@PathVariable Long orderContainerId) {
        repo.delete(orderContainerId);
        return true;
    }

}
