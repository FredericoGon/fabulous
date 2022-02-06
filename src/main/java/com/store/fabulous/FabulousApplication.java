package com.store.fabulous;

import com.store.fabulous.store.StoreEntity;
import com.store.fabulous.store.StoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class FabulousApplication {

	@Autowired
	public StoreRepository storeRepository;

	private static final Logger log = LoggerFactory.getLogger(FabulousApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FabulousApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		List<StoreEntity> allStores = this.storeRepository.findAll();
		log.info("Number of customers: " + allStores.size());

		StoreEntity newStore = new StoreEntity();
		newStore.setId(1L);
		newStore.setName("First Store");
		log.info("Saving new customer...");
		this.storeRepository.save(newStore);

		allStores = this.storeRepository.findAll();
		log.info("Number of customers: " + allStores.size());
	}
}
