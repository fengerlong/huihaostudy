package com.example.hitalesdemo.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataCenterConnectorConfiguration {

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        Connector connector = new Connector();
        connector.setPort(13333);
        connector.setMaxPostSize(500 * 1024 * 1024);
        tomcat.addAdditionalTomcatConnectors(connector);
        return tomcat;
    }
}