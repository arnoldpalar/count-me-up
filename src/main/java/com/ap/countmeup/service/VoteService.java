package com.ap.countmeup.service;

import com.ap.countmeup.dto.VoteRequest;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.*;

@Service
public class VoteService {

    public void vote(VoteRequest voteRequest) throws Exception {
        notNull(voteRequest, "voteRequest cannot be null");
    }
}