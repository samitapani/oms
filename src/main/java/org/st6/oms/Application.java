package org.st6.oms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.st6.oms.entity.OrderContainer;
import org.st6.oms.entity.OrderItem;
import org.st6.oms.entity.Product;
import org.st6.oms.repository.OrderContainerRepository;
import org.st6.oms.repository.ProductRepository;

import java.util.Arrays;
import java.util.Date;


@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initData(OrderContainerRepository orderContainerRepository, ProductRepository productRepository) {
        return (args) -> {

            // products
            Product rod = productRepository.save(new Product("Rod", 99.99D));
            Product hook = productRepository.save(new Product("Hook", 1.99D));
            Product reel = productRepository.save(new Product("Reel", 29.99D));
            Product worm = productRepository.save(new Product("Worm", 0.29D));

            orderContainerRepository.save(
                    new OrderContainer(
                            "Fishing set.",
                            Arrays.asList(
                                    new OrderItem(1L, rod),
                                    new OrderItem(1L, reel),
                                    new OrderItem(10L, hook),
                                    new OrderItem(10L, worm)
                            ),
                            new Date()
                    )
            );

            orderContainerRepository.save(
                    new OrderContainer(
                            "More worms, for Fishing set.",
                            Arrays.asList(new OrderItem(10L, worm)),
                            new Date())
            );

            orderContainerRepository.save(
                    new OrderContainer(
                            "Rod broken",
                            Arrays.asList(new OrderItem(1L, rod)),
                            new Date())
            );


        };
    }

}
