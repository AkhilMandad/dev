package com.cvs.spoms.externalize.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class AppEnvConfigDto extends BaseDto {
    @JsonProperty("configId")
    private Long configId;
    @JsonProperty("application")
    private ApplicationDto application;
    @JsonProperty("environment")
    private AppEnvironmentDto environment;
    @JsonProperty("ekey")
    private String ekey;
    @JsonProperty("value")
    private String value;

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getEkey() {
        return ekey;
    }

    public void setEkey(String ekey) {
        this.ekey = ekey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ApplicationDto getApplication() {
        return application;
    }

    public void setApplication(ApplicationDto application) {
        this.application = application;
    }

    public AppEnvironmentDto getEnvironment() {
        return environment;
    }

    public void setEnvironment(AppEnvironmentDto environment) {
        this.environment = environment;
    }

}
