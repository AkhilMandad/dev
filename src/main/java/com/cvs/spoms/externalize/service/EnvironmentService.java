package com.cvs.spoms.externalize.service;


import com.cvs.spoms.externalize.model.AppEnvironmentDto;
import com.cvs.spoms.externalize.model.ApplicationDto;

import java.util.List;

public interface EnvironmentService {
    List<AppEnvironmentDto> retrieveEnvironments();

    AppEnvironmentDto saveEnvironment(AppEnvironmentDto appEnvironmentDto);

    void deleteEnvironment(AppEnvironmentDto appEnvironmentDto);
    
    AppEnvironmentDto updateEnvironment(AppEnvironmentDto appEnvironmentDto);
}
