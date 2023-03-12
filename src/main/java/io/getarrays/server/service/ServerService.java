package io.getarrays.server.service;

import io.getarrays.server.model.Product;

import java.io.IOException;
import java.util.Collection;

public interface ServerService {
    Product create(Product product);
    Collection<Product> list(int limit);
    Product get(Long id);
    Product update(Product product);
    Boolean delete(Long id);
}
