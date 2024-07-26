package com.iiht.storeproject.Resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.storeproject.Services.BreadService;
import com.iiht.storeproject.Services.EggService;
import com.iiht.storeproject.Services.MilkService;

@RestController
@RequestMapping("/store/Items")
public class ItemsController {
	
	@Autowired
	BreadService bservice;
	@Autowired
	EggService eservice;
	@Autowired
	MilkService mservice;

	 @GetMapping
	    public ResponseEntity<List<List<?>>> getAllItems() {
	        List<List<?>> allItems = new ArrayList<>();
	        allItems.add(mservice.fetchAllMilks());
	        allItems.add(bservice.fetchAllBreads());
	        allItems.add(eservice.fetchAllEggs());
	        
	        return ResponseEntity.ok(allItems);
	    }
}
