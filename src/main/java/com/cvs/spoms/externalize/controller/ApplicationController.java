package com.cvs.spoms.externalize.controller;


import com.cvs.spoms.externalize.entity.Application;
import com.cvs.spoms.externalize.model.AppEnvConfigDto;
import com.cvs.spoms.externalize.model.ApplicationDto;
import com.cvs.spoms.externalize.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/somsconfig")
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @GetMapping("/searchApplication")
    public List<ApplicationDto> searchApplication() {
        return service.retrieveApplications();
    }

    @PostMapping("/addApplication")
    public ApplicationDto addApplication(@RequestBody ApplicationDto applicationDto) {
        return service.saveApplication(applicationDto);
    }

    @PutMapping("/updateApplication")
    public ApplicationDto updateApplication(@RequestBody ApplicationDto appEnvConfigDto) {
        return service.saveApplication(appEnvConfigDto);
    }

    @DeleteMapping("/deleteApplication")
    public void deleteApplication(@RequestBody ApplicationDto applicationDto) {
        service.deleteApplication(applicationDto);
    }
}
