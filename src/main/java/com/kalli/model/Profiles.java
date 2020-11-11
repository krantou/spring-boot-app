package com.kalli.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Configuration
//@ConfigurationProperties("spring.datasource")
public class Profiles {

    private String profName;

    public Profiles(String profName) {
        this.profName = profName;
    }

    @Value("${spring.profiles.active}")
    private String springProfilesActive;

    public void checkProfile(){
        System.out.println("in profiles " + springProfilesActive);
    }

    @Profile("prod")
    @Bean
    public void prodMethod(){
        System.out.println("***************Prod profile");
  }

    @Profile("dev")
    @Bean
    public void devMethod(){
        System.out.println("***************DEv profile");
    }
}
