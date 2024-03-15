package com.example.test.service;

import com.example.test.model.PartnerMaster;
import com.example.test.model.PartnerProductMap;
import com.example.test.model.ProductMaster;
import com.example.test.repository.PartnerMasterRepository;
import com.example.test.repository.PartnerProductMapRepository;
import com.example.test.repository.ProductMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private PartnerMasterRepository partnerMasterRepository;

    @Autowired
    private ProductMasterRepository productMasterRepository;

    @Autowired
    private PartnerProductMapRepository partnerProductMapRepository;

    public void loadProductMaster(List<String> products) {
        List<ProductMaster> productMasterList = new ArrayList<>();
        products.forEach(product -> {
            ProductMaster productMaster = new ProductMaster();
            productMaster.setProductCode(product);
            productMasterList.add(productMaster);
        });
        productMasterRepository.saveAll(productMasterList);
    }

    public void loadPartnerMaster(List<String> partners) {
        List<PartnerMaster> partnerMasterList = new ArrayList<>();

        partners.forEach(partner -> {
            PartnerMaster partnerMaster = new PartnerMaster();
            partnerMaster.setPartnerCode(partner);
            partnerMaster.setPartnerName(partner);
            partnerMasterList.add(partnerMaster);
        });

        partnerMasterRepository.saveAll(partnerMasterList);
    }

    public void loadProdPartnerMap() {
        List<PartnerMaster> partnerMasters = partnerMasterRepository.findAll();
        List<ProductMaster> productMasters = productMasterRepository.findAll();

        List<PartnerProductMap> partnerProductMaps = new ArrayList<>();

        for (PartnerMaster partnerMaster : partnerMasters) {
            for (ProductMaster productMaster : productMasters) {
                PartnerProductMap partnerProductMap = new PartnerProductMap();
                partnerProductMap.setPartnerMaster(partnerMaster);
                partnerProductMap.setProductMaster(productMaster);
                partnerProductMaps.add(partnerProductMap);
            }
        }

        partnerProductMapRepository.saveAll(partnerProductMaps);
    }
}
