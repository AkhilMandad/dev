package com.cvs.spoms.externalize.service;


import com.cvs.spoms.externalize.entity.AppEnvConfig;
import com.cvs.spoms.externalize.model.AppEnvConfigDto;

import java.util.List;

public interface AppEnvConfigService {
    List<AppEnvConfigDto> retrieveProperties();

    AppEnvConfigDto saveEnvConfig(AppEnvConfigDto appEnvConfigDto);

    void deleteEnvConfig(AppEnvConfigDto appEnvConfigDto);
}
