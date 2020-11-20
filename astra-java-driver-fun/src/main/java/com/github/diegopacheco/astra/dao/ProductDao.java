package com.github.diegopacheco.astra.dao;

import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.github.diegopacheco.astra.entity.Product;

import java.util.UUID;

@Dao
public interface ProductDao {

    @Select
    Product findById(UUID productId);

    @Insert
    void save(Product product);

    @Delete
    void delete(Product product);

}