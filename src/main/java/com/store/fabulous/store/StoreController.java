package com.store.fabulous.store;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {

    private final StoreService service;

    public StoreController(StoreService service) {
        this.service = service;
    }

    @GetMapping("/store/{id}")
    public ResponseEntity<StoreDTO> getStore(@PathVariable Long id) {
        return new ResponseEntity<>(service.getStore(id), HttpStatus.OK);
    }

    @PostMapping("/store")
    public ResponseEntity<StoreDTO> newStore(@RequestBody StoreDTO storeDTO) {
        return new ResponseEntity<>(service.saveStore(storeDTO), HttpStatus.OK);
    }

    @PutMapping("/store")
    public ResponseEntity<StoreDTO> editStore(@RequestBody StoreDTO storeDTO) {
        return new ResponseEntity<>(service.saveStore(storeDTO), HttpStatus.OK);
    }

    @DeleteMapping("/store/{id}")
    public void deletePerson(@PathVariable Long id) {
        service.deleteStore(id);
    }
}
