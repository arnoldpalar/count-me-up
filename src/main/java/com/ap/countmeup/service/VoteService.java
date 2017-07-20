package com.ap.countmeup.service;

import com.ap.countmeup.dto.VoteRequest;
import com.ap.countmeup.exception.InvalidVoteException;
import com.ap.countmeup.repository.VoteRepo;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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

        Set<Long> votes = voteRepo.getVotes(voteRequest.getVoterId());

        if(votes == null || (votes.size() < 3 && !votes.contains(voteRequest.getCandidateId()))) {
            this.castAndSave(voteRequest);
        } else {
            throw new InvalidVoteException(voteRequest);
        }
    }

    @Async
    private void castAndSave(VoteRequest voteRequest) {
        try {
            this.syncCast(voteRequest);
            this.syncSave(voteRequest);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO a better failure resolver here
        }
    }

    @Synchronized
    private void syncCast(VoteRequest voteRequest) throws Exception {
        voteRepo.cast(voteRequest);
    }

    @Synchronized
    private void syncSave(VoteRequest voteRequest) throws Exception {
        voteRepo.save(voteRequest);
    }

}