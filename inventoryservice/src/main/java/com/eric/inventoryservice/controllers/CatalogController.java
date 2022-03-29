package com.eric.inventoryservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.inventoryservice.models.Catalog;
import com.eric.inventoryservice.services.CatalogService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {
    @Autowired
	private CatalogService catalogService;
    
    private  Gson gson;
    //add category
    //http://localhost:7070/catalogs/v1.0
    @PostMapping({"/v1.0"})
    public ResponseEntity<String> saveCatalog(@RequestBody Catalog catalog){
    	Catalog catalogObj=this.catalogService.addCatalog(catalog);
    	gson=new Gson();
    	if(catalogObj!=null) 
    		return ResponseEntity.status(HttpStatus.CREATED).body(gson.toJson(catalogObj));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Catalog not created");	
    	}
    
    
    //select all
    @GetMapping({"/v1.0"})
    public List<Catalog> getAllCatalogs(){
    	return this.catalogService.getAllCatalogs();
    }
    
    
    //select by id
    @GetMapping({"/v1.0/{catalogId}"})
    public ResponseEntity<String> getCatalogById(@PathVariable("catalogId") long catalogId) {
    	gson=new Gson();
    	Catalog catalogObj=this.catalogService.getCatalogById(catalogId);
    	if(catalogObj!=null) {
    		
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body(gson.toJson(catalogObj));
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Catalog not found");	
    	}
    }
    
    @DeleteMapping({"/v1.0"})
    public ResponseEntity<String> deleteCatalogById(@PathVariable("catalogId") long catalogId) {
    	
    	boolean status=this.catalogService.deleteCatalog(catalogId);
    	if(status) {
    		
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Catalog Deleted");
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Catalog not found");	
    	}
    }
    @PutMapping({"/v1.0/{catalogId}/{catalogName}"})
    public ResponseEntity<String> updateCatalog(@PathVariable("catalogId") long catalogId,
    		@PathVariable("catalogName") String catalogName){
    	Catalog catalogObj=this.catalogService.updateCatalog(catalogId, catalogName);
    	gson=new Gson();
    	if(catalogObj!=null) 
    		return ResponseEntity.status(HttpStatus.CREATED).body(gson.toJson(catalogObj));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Catalog not could not be updated");	
    	}
    
    }


   
    
	
	

