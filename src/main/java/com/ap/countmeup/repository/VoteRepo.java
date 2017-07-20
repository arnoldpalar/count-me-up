package com.ap.countmeup.repository;

import com.ap.countmeup.dto.VoteRequest;

import java.util.Set;

public interface VoteRepo {

    void save(VoteRequest voteRequest) throws Exception;
    void cast(VoteRequest voteRequest) throws Exception;
    Long count(Long candidateId);
    Set<Long> getVotes(Long voterId);
    Set<Long> getCandidates();
    Long total();
}