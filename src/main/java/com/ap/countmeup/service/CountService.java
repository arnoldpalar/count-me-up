package com.ap.countmeup.service;

import com.ap.countmeup.dto.CountResponse;
import com.ap.countmeup.repository.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class CountService {
    private VoteRepo voteRepo;

    @Autowired
    public CountService(VoteRepo voteRepo) {
        this.voteRepo = voteRepo;
    }

    public Map<Long, Long> getCount() {
        Set<Long> candidates = voteRepo.getCandidates();

        return null;
    }
}
