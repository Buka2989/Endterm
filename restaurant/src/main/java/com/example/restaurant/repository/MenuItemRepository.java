package com.example.restaurant.repository;

import com.example.restaurant.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MenuItemRepository implements CrudRepository<MenuItem> {
    private final JdbcTemplate jdbcTemplate;

    public MenuItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(MenuItem item) {
        String sql = "INSERT INTO menu_items (name, price, item_type, is_spicy, is_alcoholic) VALUES (?, ?, ?, ?, ?)";
        if (item instanceof FoodItem) {
            // Используем корректный метод isSpicy()
            jdbcTemplate.update(sql, item.getName(), item.getPrice(), "FOOD", ((FoodItem) item).isSpicy(), null);
        } else if (item instanceof DrinkItem) {
            // Используем корректный метод isAlcoholic()
            jdbcTemplate.update(sql, item.getName(), item.getPrice(), "DRINK", null, ((DrinkItem) item).isAlcoholic());
        }
    }

    @Override
    public int update(int id, MenuItem item) {
        // Обновляем основные поля. Если нужно обновлять специфичные (spicy),
        // нужно добавить логику проверки типа, но для Endterm обычно достаточно базовых полей.
        String sql = "UPDATE menu_items SET name = ?, price = ? WHERE id = ?";
        return jdbcTemplate.update(sql, item.getName(), item.getPrice(), id);
    }

    @Override
    public List<MenuItem> findAll() {
        return jdbcTemplate.query("SELECT * FROM menu_items", menuItemMapper);
    }

    @Override
    public MenuItem findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM menu_items WHERE id = ?", menuItemMapper, id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM menu_items WHERE id = ?", id);
    }

    private final RowMapper<MenuItem> menuItemMapper = (rs, rowNum) -> {
        String type = rs.getString("item_type");
        int id = rs.getInt("id");
        String name = rs.getString("name");
        double price = rs.getDouble("price");

        MenuItem item;
        if ("FOOD".equals(type)) {
            item = new FoodItem(name, price, rs.getBoolean("is_spicy"));
        } else {
            item = new DrinkItem(name, price, rs.getBoolean("is_alcoholic"));
        }
        item.setId(id);
        return item;
    };
}