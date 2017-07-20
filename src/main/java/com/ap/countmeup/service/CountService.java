package com.ap.countmeup.service;

import com.ap.countmeup.repository.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class CountService {
    private VoteRepo voteRepo;

    @Autowired
    public CountService(VoteRepo voteRepo) {
        this.voteRepo = voteRepo;
    }

    public Map<Long, Long> count() {
        Set<Long> candidates = voteRepo.getCandidates();
        Map<Long, Long> res = new HashMap<>();

        for (Long candidateId :
                candidates) {
            res.put(candidateId, voteRepo.count(candidateId));
        }

        return res;
    }
}
