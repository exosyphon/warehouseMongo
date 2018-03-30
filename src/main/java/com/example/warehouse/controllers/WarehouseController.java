package com.example.warehouse.controllers;

import com.example.warehouse.models.Warehouse;
import com.example.warehouse.services.WarehouseService;
import com.example.warehouse.viewmodels.WarehouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
@CrossOrigin
public class WarehouseController {

  private WarehouseService warehouseService;

  @Autowired
  public WarehouseController(WarehouseService warehouseService) {
    this.warehouseService = warehouseService;
  }

  @RequestMapping("/")
  public ResponseEntity<List<WarehouseResponse>> index() {
    List<Warehouse> themAll = warehouseService.getThemAll();
    Warehouse warehouse1 = themAll.get(0);
    Warehouse warehouse2 = themAll.get(1);

    return ResponseEntity.ok(asList(
        new WarehouseResponse(warehouse1.getId(), warehouse1.getName()),
        new WarehouseResponse(warehouse2.getId(), warehouse2.getName())
    ));
  }
}
