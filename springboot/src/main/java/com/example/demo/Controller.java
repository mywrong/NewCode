package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired

    private WorkImpl work;
    @GetMapping("/test")
    public void test() throws Exception {
        work.doWork();
    }
}
