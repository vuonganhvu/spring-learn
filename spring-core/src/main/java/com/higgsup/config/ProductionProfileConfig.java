package com.higgsup.config;

import com.higgsup.service.IService;
import com.higgsup.service.ProdServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProductionProfileConfig {

    @Bean("iService")
    @Profile("prod")
    public IService iService() {
        return new ProdServiceImpl();
    }
}
