package com.ap.countmeup.service;

import com.ap.countmeup.dto.VoteRequest;
import com.ap.countmeup.exception.InvalidVoteException;
import com.ap.countmeup.repository.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import static org.springframework.util.Assert.*;

@Service
public class VoteService {
    private VoteRepo voteRepo;

    @Autowired
    public VoteService(VoteRepo voteRepo) {
        this.voteRepo = voteRepo;
    }

    public void vote(VoteRequest voteRequest) throws Exception {
        notNull(voteRequest, "voteRequest cannot be null");

        Set<Long> votes = voteRepo.getVotes(voteRequest.getUserId());

        if(votes.size() < 3 && !votes.contains(voteRequest.getCandidateId())) {
            voteRepo.cast(voteRequest);
            voteRepo.save(voteRequest);
        } else {
            throw new InvalidVoteException(voteRequest);
        }
    }

}