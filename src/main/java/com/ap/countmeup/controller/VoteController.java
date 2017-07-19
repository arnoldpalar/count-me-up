package com.ap.countmeup.controller;

import com.ap.countmeup.dto.VoteRequest;
import com.ap.countmeup.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/vote")
public class VoteController {

    private Environment env;
    private VoteService voteService;

    @Autowired
    VoteController(Environment env, VoteService voteService) {
        this.env = env;
        this.voteService = voteService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity submit(@RequestBody VoteRequest voteRequest) {

        try {
            voteService.vote(voteRequest);
        } catch (Exception e) {
            //TODO a better error handler/resolver later
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok().build();
    }

}