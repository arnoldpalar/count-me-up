package com.ap.countmeup.controller;

import com.ap.countmeup.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/count")
public class CountController {
    private CountService countService;

    @Autowired
    public CountController(CountService countService) {
        this.countService = countService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Long, Long>> getCount() {
        return ResponseEntity.ok(countService.count());
    }
}