package com.nexters.neighborhood.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class NeighborhoodRootContext {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource realDataSource() {
        return DataSourceBuilder.create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.getUsername())
                .password(this.dataSourceProperties.getPassword())
                .build();
    }

    @Bean
    @Primary
    @Autowired
    public DataSource dataSource(DataSource realDataSource) {
        return new Log4jdbcProxyDataSource(realDataSource);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
