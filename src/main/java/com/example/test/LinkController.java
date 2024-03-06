package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "v1")
public class LinkController {

    @PostMapping(value = "/link")
    public void saveLinkage() {
    }

}
