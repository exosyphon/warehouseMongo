package com.example.warehouse.repos;

import com.example.warehouse.models.Warehouse;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
public class WarehouseRepositoryTest {
  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private WarehouseRepository warehouseRepository;

  @After
  public void tearDown() {
    warehouseRepository.deleteAll();
  }

  @Test
  public void testShouldWork() throws Exception {
    warehouseRepository.save(new Warehouse(null, "name"));

    List<Warehouse> actual = warehouseRepository.findAll();

    assertEquals(1, actual.size());
    assertEquals("name", actual.get(0).getName());
  }
}
