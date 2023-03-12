package io.getarrays.server.repo;

import io.getarrays.server.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findByname(String name);
}
