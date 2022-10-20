package br.com.sancode.sancodesiriusapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class SancodeSiriusApiApplication {

    @Value("${MSG_BV}")
    private String msgBv;

    public static void main(String[] args) {
        SpringApplication.run(SancodeSiriusApiApplication.class, args);
    }

    @GetMapping
    public String get(){
        return msgBv;
    }
}