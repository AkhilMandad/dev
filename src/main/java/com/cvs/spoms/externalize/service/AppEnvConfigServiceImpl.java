
package com.cvs.spoms.externalize.service;

import com.cvs.spoms.externalize.entity.AppEnvConfig;
import com.cvs.spoms.externalize.model.AppEnvConfigDto;
import com.cvs.spoms.externalize.repo.AppEnvConfigRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppEnvConfigServiceImpl implements AppEnvConfigService {

    @Autowired
    AppEnvConfigRepo externalizedPropertiesRepo;


    @Override
    public List<AppEnvConfigDto> retrieveProperties() {
        List<AppEnvConfig> appEnvConfigList = externalizedPropertiesRepo.findAll();
        List<AppEnvConfigDto> appEnvConfigDtos = new ArrayList<>();
        BeanUtils.copyProperties(appEnvConfigList,appEnvConfigDtos);
        return appEnvConfigDtos;
    }

    @Override
    public AppEnvConfigDto saveEnvConfig(AppEnvConfigDto appEnvConfigDto) {
        AppEnvConfig appEnvConfig = new AppEnvConfig();
        BeanUtils.copyProperties(appEnvConfigDto, appEnvConfig);
        AppEnvConfig response = externalizedPropertiesRepo.save(appEnvConfig);
        AppEnvConfigDto responseDto = new AppEnvConfigDto();
        BeanUtils.copyProperties(response,responseDto);
        return responseDto;
    }

    @Override
    public void deleteEnvConfig(AppEnvConfigDto appEnvConfigDto) {
        AppEnvConfig appEnvConfig = new AppEnvConfig();
        BeanUtils.copyProperties(appEnvConfigDto, appEnvConfig);
        externalizedPropertiesRepo.delete(appEnvConfig);
    }

}
