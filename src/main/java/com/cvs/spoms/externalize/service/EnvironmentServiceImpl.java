
package com.cvs.spoms.externalize.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cvs.spoms.externalize.entity.AppEnvironment;
import com.cvs.spoms.externalize.model.AppEnvironmentDto;
import com.cvs.spoms.externalize.repo.AppEnvironmentRepo;

@Component
public class EnvironmentServiceImpl implements EnvironmentService {

    @Autowired
    AppEnvironmentRepo appEnvironmentRepo;


    @Override
    public List<AppEnvironmentDto> retrieveEnvironments() {
        List<AppEnvironment> appEnvironments = appEnvironmentRepo.findAll();
        List<AppEnvironmentDto> appEnvironmentDtos = new ArrayList<>();
        appEnvironments.stream().forEach(application -> {
        	AppEnvironmentDto applicationDto = new AppEnvironmentDto();
        	applicationDto.setUpdateDate(application.getUpdateDate());
        	applicationDto.setUpdateBy(application.getUpdateBy());
        	applicationDto.setCreatedDate(application.getCreateDate().toString());
        	applicationDto.setCreatedBy(application.getCreateBy());
             
            BeanUtils.copyProperties(application,applicationDto);
            appEnvironmentDtos.add(applicationDto);
        });
        return appEnvironmentDtos;
    }

    @Override
    public AppEnvironmentDto saveEnvironment(AppEnvironmentDto appEnvironmentDto) {
        AppEnvironment application = new AppEnvironment();
        BeanUtils.copyProperties(appEnvironmentDto, application);
        application.setCreateDate(Timestamp.from(Instant.now()));
       // System.out.println(appEnvironmentDto.getCreatedBy());
        application.setCreateBy(appEnvironmentDto.getCreatedBy());
        AppEnvironment response = appEnvironmentRepo.save(application);
        AppEnvironmentDto responseDto = new AppEnvironmentDto();
        BeanUtils.copyProperties(response,responseDto);
        return responseDto;
    }
    
    @Override
    public AppEnvironmentDto updateEnvironment(AppEnvironmentDto appEnvironmentDto) {
    	 AppEnvironment response = null;
        Optional<AppEnvironment> application1= appEnvironmentRepo.findById(appEnvironmentDto.getEnvId());
        if(application1.isPresent())
        {
        	AppEnvironment application = application1.get();
        application.setUpdateDate(Timestamp.from(Instant.now()));
        application.setEnvName(appEnvironmentDto.getEnvName());
        application.setActiveInd(appEnvironmentDto.getActiveInd());
        application.setUpdateBy(appEnvironmentDto.getUpdateBy());
         response = appEnvironmentRepo.save(application);
        }
        AppEnvironmentDto responseDto = new AppEnvironmentDto();
        BeanUtils.copyProperties(response,responseDto);
        
        return responseDto;
        
    }

    @Override
    public void deleteEnvironment(AppEnvironmentDto appEnvironmentDto) {
        AppEnvironment appEnvironment = new AppEnvironment();
        BeanUtils.copyProperties(appEnvironmentDto, appEnvironment);
        appEnvironmentRepo.delete(appEnvironment);
    }

}
