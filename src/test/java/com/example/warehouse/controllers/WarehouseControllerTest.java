package com.example.warehouse.controllers;

import com.example.warehouse.models.Warehouse;
import com.example.warehouse.services.WarehouseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class WarehouseControllerTest {

  @Mock
  private WarehouseService mockWarehouseService;

  @InjectMocks
  private WarehouseController warehouseController;

  private MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {
    mockMvc = standaloneSetup(warehouseController).build();
  }

  @Test
  public void testIndex() throws Exception {
    when(mockWarehouseService.getThemAll()).thenReturn(
        asList(
            new Warehouse("1234fqsfasfd", "Avengers Weapon Supply"),
            new Warehouse("qsfasfd", "Batman Vehicles"))
    );

    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().json("[{'id': '1234fqsfasfd', 'name': 'Avengers Weapon Supply'}, {'id': 'qsfasfd', 'name': 'Batman Vehicles'}]"));

    verify(mockWarehouseService).getThemAll();
  }
}
