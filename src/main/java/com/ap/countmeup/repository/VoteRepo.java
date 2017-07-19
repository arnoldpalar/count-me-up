package com.ap.countmeup.repository;

import com.ap.countmeup.dto.VoteRequest;

import java.util.List;
import java.util.Set;

public interface VoteRepo {

    public void save(VoteRequest voteRequest) throws Exception;
    public void cast(VoteRequest voteRequest) throws Exception;
    public Long count(Long voterId);
    public Set<Long> getVotes(Long voterId);
    public Set<Long> getCandidates();
}