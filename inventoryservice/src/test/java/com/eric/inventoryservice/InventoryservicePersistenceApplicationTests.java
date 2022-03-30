package com.eric.inventoryservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.eric.inventoryservice.models.Catalog;
import com.eric.inventoryservice.repositories.CatalogRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class InventoryservicePersistenceApplicationTests {
    @Autowired
	private TestEntityManager entityManager;
	@Autowired
    private CatalogRepository catalogRepository;
   
    //pending
    @ParameterizedTest
    @CsvFileSource(resources ="./Catalog.csv",numLinesToSkip = 1 )
    @DisplayName("Persist CSV Data Test")
    @Transactional
	public void testCatalogPersistenceUsingCSV(long id,String name) {
    	//catalog.setCatalogId(id);
    	Catalog catalogObj=new Catalog();
		catalogObj.setCatalogName(name);
		entityManager.persist(catalogObj);
		entityManager.flush();
		assertTrue(this.catalogRepository.findById(102L)!=null);
	}
    
	
}
