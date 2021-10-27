package com.cvs.spoms.externalize.controller;


import com.cvs.spoms.externalize.model.AppEnvConfigDto;
import com.cvs.spoms.externalize.service.AppEnvConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/somsconfig")
public class AppEnvConfigController {

    @Autowired
    private AppEnvConfigService service;

    @GetMapping("/searchEnvConfig")
    public List<AppEnvConfigDto> fetchExternalizedProperties() {
        return service.retrieveProperties();
    }

    @PostMapping("/addEnvConfig")
    public AppEnvConfigDto addEnvConfig(@RequestBody AppEnvConfigDto appEnvConfigDto) {
        return service.saveEnvConfig(appEnvConfigDto);
    }

    @PutMapping("/updateEnvConfig")
    public AppEnvConfigDto updateEnvConfig(@RequestBody AppEnvConfigDto appEnvConfigDto) {
        return service.saveEnvConfig(appEnvConfigDto);
    }

    @PutMapping("/deleteEnvConfig")
    public void deleteEnvConfig(@RequestBody AppEnvConfigDto appEnvConfigDto) {
        service.deleteEnvConfig(appEnvConfigDto);
    }
}
