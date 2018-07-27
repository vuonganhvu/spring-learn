package com.higgsup.config;

import com.higgsup.service.DevServiceImpl;
import com.higgsup.service.IService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DevelopProfileConfig {
    @Bean("iService")
    @Profile("dev")
    public IService iService(){
        return new DevServiceImpl();
    }
}
