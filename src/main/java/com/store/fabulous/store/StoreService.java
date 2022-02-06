package com.store.fabulous.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    public StoreRepository repository;

    public StoreService(StoreRepository repository) {
        this.repository = repository;
    }

    private static final Logger log = LoggerFactory.getLogger(StoreService.class);

    public StoreDTO getStore(Long id) {
        return new StoreDTO(repository.getById(id));
    }

    public StoreDTO saveStore(StoreDTO storeDTO) {
        return new StoreDTO(repository.save(new StoreEntity(storeDTO)));
    }

    public void deleteStore(Long id) {
        log.info("Product with id: " + id + " deleted.");
        repository.deleteById(id);
    }

}
