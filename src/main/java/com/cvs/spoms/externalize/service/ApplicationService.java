package com.cvs.spoms.externalize.service;


import com.cvs.spoms.externalize.model.ApplicationDto;

import java.util.List;

public interface ApplicationService {
    List<ApplicationDto> retrieveApplications();

    ApplicationDto saveApplication(ApplicationDto applicationDto);

    void deleteApplication(ApplicationDto applicationDto);
}
