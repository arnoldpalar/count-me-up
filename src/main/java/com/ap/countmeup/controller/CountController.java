package com.ap.countmeup.controller;

import com.ap.countmeup.dto.CountResponse;
import com.ap.countmeup.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/count")
public class CountController {

    private Environment env;
    private CountService countService;

    @Autowired
    public CountController(Environment env, CountService countService) {
        this.env = env;
        this.countService = countService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountResponse> getCount() {
        return ResponseEntity.ok(countService.getCount());
    }
}