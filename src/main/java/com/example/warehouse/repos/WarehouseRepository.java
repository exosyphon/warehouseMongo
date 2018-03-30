package com.example.warehouse.repos;

import com.example.warehouse.models.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WarehouseRepository extends MongoRepository<Warehouse, Long> {
}
