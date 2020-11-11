package com.kalli;

import com.kalli.model.Profiles;
import javafx.application.Application;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class Main {
//    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
//        Profiles profile = new Profiles("test");
//
//        profile.devMethod();
        SpringApplication.run(Main.class, args);

    }
}

