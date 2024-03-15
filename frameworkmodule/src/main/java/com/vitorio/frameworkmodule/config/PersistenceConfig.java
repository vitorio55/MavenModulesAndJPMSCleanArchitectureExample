package com.vitorio.frameworkmodule.config;

import com.vitorio.dataprovidernosqlmodule.NoSqlDataProvider;
import com.vitorio.usecasemodule.persistence.DataAccessInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {

    @Bean
    public DataAccessInterface dataAccessInterface() {
        return new NoSqlDataProvider();
        //return new SqlDataProvider();
    }
}
