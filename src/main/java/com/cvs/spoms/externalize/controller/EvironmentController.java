package com.cvs.spoms.externalize.controller;


import com.cvs.spoms.externalize.model.AppEnvironmentDto;
import com.cvs.spoms.externalize.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/somsconfig")
public class EvironmentController {

    @Autowired
    private EnvironmentService service;

    @GetMapping("/searchEnvironment")
    public List<AppEnvironmentDto> searchEnvironment() {
        return service.retrieveEnvironments();
    }

    @PostMapping("/addEnvironment")
    public AppEnvironmentDto addEnvironment(@RequestBody AppEnvironmentDto appEnvironmentDto) {
        return service.saveEnvironment(appEnvironmentDto);
    }

    @PutMapping("/updateEnvironment")
    public AppEnvironmentDto updateEnvironment(@RequestBody AppEnvironmentDto appEnvironmentDto) {
        return service.updateEnvironment(appEnvironmentDto);
    }

    @PutMapping("/deleteEnvironment")
    public void deleteEnvironment(@RequestBody AppEnvironmentDto appEnvironmentDto) {
        service.deleteEnvironment(appEnvironmentDto);
    }
}
