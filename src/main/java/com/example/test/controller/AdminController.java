package com.example.test.controller;

import com.example.test.model.PartnerMaster;
import com.example.test.model.ProductMaster;
import com.example.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/load/products")
    public ResponseEntity<String> loadProductMaster(@RequestBody List<String> products) {
        adminService.loadProductMaster(products);
        return ResponseEntity.ok("Product Master loaded successfully");
    }

    @PostMapping("/load/partners")
    public ResponseEntity<String> loadPartnerMaster(@RequestBody List<String> partners) {
        adminService.loadPartnerMaster(partners);
        return ResponseEntity.ok("Partner Master loaded successfully");
    }

    @PostMapping("/create/product-partner-map")
    public ResponseEntity<String> loadProdPartnerMap() {
        adminService.loadProdPartnerMap();
        return ResponseEntity.ok("Product Partner Map loaded successfully");
    }
}
