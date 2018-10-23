package com.gml.cursomc.config;

import com.gml.cursomc.services.DBService;
import com.gml.cursomc.services.EmailService;
import com.gml.cursomc.services.SmtpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevtConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDataBase() throws ParseException{

        if(!strategy.equals("create") || !strategy.equals("create-drop")){
            return false;
        } else{
            //dbService.instantiateTestDatabase();
            return true;
        }
    }

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }
}
