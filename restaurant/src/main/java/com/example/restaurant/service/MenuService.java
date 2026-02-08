package com.example.restaurant.service;

import com.example.restaurant.model.MenuItem;
import com.example.restaurant.patterns.LoggerSingleton;
import com.example.restaurant.patterns.MenuItemFactory;
import com.example.restaurant.repository.CrudRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {
    private final CrudRepository<MenuItem> repository;
    private final LoggerSingleton logger = LoggerSingleton.getInstance();

    public MenuService(CrudRepository<MenuItem> repository) { this.repository = repository; }

    public void createItem(String type, String name, double price, boolean attr) {
        MenuItem item = MenuItemFactory.createItem(type, name, price, attr);
        repository.save(item);
        logger.log("Created item: " + name);
    }

    public int updateItem(int id, MenuItem item) {
        int rows = repository.update(id, item);
        logger.log("Updated item ID " + id + ". Success: " + (rows > 0));
        return rows;
    }

    public List<MenuItem> getAll() { return repository.findAll(); }
    public void delete(int id) { repository.delete(id); logger.log("Deleted ID: " + id); }
}