package com.eric.inventoryservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.eric.inventoryservice.models.Catalog;
import com.eric.inventoryservice.services.CatalogService;
import org.hamcrest.Matchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class InventoryControllerTests {
    @Autowired 
	MockMvc mockMvc;
    @MockBean
    private CatalogService catalogService;
    
    @Test
    public void testGetAllMockedCatalogs() throws Exception {
    	Mockito.when(this.catalogService.getAllCatalogs()).thenReturn(getFakedCatalogList());
    	
    	mockMvc.perform(get("/catalogs/v1.0")).andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(5)))
		.andExpect(jsonPath("$[1].catalogName", Matchers.startsWith("Home Appliances")));
    	
    }
    
    
    //fake method
    List<Catalog> getFakedCatalogList(){
    	
    	List<Catalog> catalogList=new ArrayList<Catalog>();
    	catalogList.add(new Catalog(1,"Electronics"));
    	catalogList.add(new Catalog(2,"Home Appliances"));
    	catalogList.add(new Catalog(3,"Computer Accessories"));
    	catalogList.add(new Catalog(4,"Western Wear"));
    	catalogList.add(new Catalog(5,"Watches"));
    	return catalogList;
    }
    
	
	
}
