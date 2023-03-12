package io.getarrays.server.service.implementation;

import io.getarrays.server.model.Product;
import io.getarrays.server.repo.ProductRepo;
import io.getarrays.server.service.ServerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;
import java.util.Random;


import static java.lang.Boolean.TRUE;
import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j

public class ServerServiceImpl implements ServerService {
    private final ProductRepo productRepo;
    @Override
    public Product create(Product product) {
        log.info("Saving new Product: {}", product.getName());
        return productRepo.save(product);
    }

    @Override
    public Collection<Product> list(int limit) {
        log.info("Fetching All Products.");
        return productRepo.findAll(of( 0, limit)).toList();
    }

    @Override
    public Product get(Long id) {
        log.info("Fetching Product by Id: {}.", id);
        return productRepo.findById(id).get();
    }

    @Override
    public Product update(Product product) {
        log.info("Updating Product: {}", product.getName());
        return productRepo.save(product);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Product by Id: {}", id);
        productRepo.deleteById(id);
        return TRUE;
    }

    private String setServerImageURL() {

        String[] imageNames = {"server1.png","server2.png","server3.png","server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[new Random().nextInt(4)]).toUriString();
    }
}
