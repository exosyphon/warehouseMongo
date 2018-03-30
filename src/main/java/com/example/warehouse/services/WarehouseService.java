package com.example.warehouse.services;

import com.example.warehouse.models.Warehouse;
import com.example.warehouse.repos.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    private WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> getThemAll() {
        return warehouseRepository.findAll();
    }
}
