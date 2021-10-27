
package com.cvs.spoms.externalize.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cvs.spoms.externalize.entity.Application;
import com.cvs.spoms.externalize.model.ApplicationDto;
import com.cvs.spoms.externalize.repo.ApplicationRepo;

@Component
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationRepo applicationRepo;


    @Override
    public List<ApplicationDto> retrieveApplications() {
        List<Application> applicationList = applicationRepo.findAll();
        List<ApplicationDto> applicationDtos = new ArrayList<>();
        applicationList.stream().forEach(application -> {
            ApplicationDto applicationDto = new ApplicationDto();
            BeanUtils.copyProperties(application,applicationDto);
            applicationDtos.add(applicationDto);
        });
        return applicationDtos;
    }

    @Override
    public ApplicationDto saveApplication(ApplicationDto applicationDto) {
        Application application = new Application();
        BeanUtils.copyProperties(applicationDto, application);
        Application response = applicationRepo.save(application);
        ApplicationDto responseDto = new ApplicationDto();
        BeanUtils.copyProperties(response,responseDto);
        return responseDto;
    }

    @Override
    public void deleteApplication(ApplicationDto applicationDto) {
        Application application = new Application();
        BeanUtils.copyProperties(applicationDto, application);
        applicationRepo.delete(application);
    }

}
