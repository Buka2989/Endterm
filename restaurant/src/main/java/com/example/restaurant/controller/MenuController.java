package com.example.restaurant.controller;

import com.example.restaurant.model.FoodItem;
import com.example.restaurant.model.MenuItem;
import com.example.restaurant.service.MenuService;
import com.example.restaurant.utils.ReflectionUtil;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuService service;

    public MenuController(MenuService service) { this.service = service; }

    @GetMapping
    public List<MenuItem> getMenu() { return service.getAll(); }

    @PostMapping("/create")
    public String create(@RequestParam String type, @RequestParam String name, @RequestParam double price, @RequestParam boolean attr) {
        service.createItem(type, name, price, attr);
        return "Created via Factory";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody FoodItem item) {
        int res = service.updateItem(id, item);
        return res > 0 ? "Updated successfully" : "Item not found";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Deleted";
    }
    @GetMapping("/inspect")
    public String inspectServiceArchitecture() {
        return ReflectionUtil.inspectClass(service);
    }
}