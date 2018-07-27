package com.higgsup.config;

import com.higgsup.service.DevelopStudentService;
import com.higgsup.service.IStudentService;
import com.higgsup.service.ProductionStudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DevelopProfileConfig.class, ProductionProfileConfig.class})
public class AppConfig {

    @Bean("iStudentService")
    @Conditional(DevConditionConfig.class)
    public IStudentService iStudentServiceDev(){
        return new DevelopStudentService();
    }

    @Bean("iStudentService")
    @Conditional(ProdConditionConfig.class)
    public IStudentService iStudentServiceProd(){
        return new ProductionStudentService();
    }
}
