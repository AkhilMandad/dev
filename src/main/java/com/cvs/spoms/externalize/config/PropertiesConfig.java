package com.cvs.spoms.externalize.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties("specialty-order-download")
@Component
public class PropertiesConfig {

}
