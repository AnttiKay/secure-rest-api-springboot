package com.example.securerestapispringboot;

import java.util.ArrayList;
import java.util.List;

import com.example.securerestapispringboot.entities.Item;
import com.example.securerestapispringboot.entities.Order;
import com.example.securerestapispringboot.repositories.ItemRepository;
import com.example.securerestapispringboot.repositories.OrderRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ItemRepository itemRepo, OrderRepository orderRepo) {

        return args -> {
            log.info("Preloading hardcoded API items.");
            Order order = orderRepo.save(new Order(null, "First order"));
            List<Item> itemList = new ArrayList<>();
            itemList.add(itemRepo.save(new Item(10, "Item1", "manufacturer 1")));
            itemList.add(itemRepo.save(new Item(15, "Item2", "manufacturer 1")));
            itemList.add(itemRepo.save(new Item(100, "NEW TV", "manufacturer 2")));
            itemList.add(itemRepo.save(new Item(15, "Newer TV", "manufacturer 2")));

            order.setOrderedItems(itemList);

            orderRepo.save(order);
            log.info("Preloading complete.");

        };

    }
}
