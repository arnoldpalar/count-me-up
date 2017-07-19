package com.ap.countmeup.config;

import com.ap.countmeup.repository.HashMapVoteRepo;
import com.ap.countmeup.repository.VoteRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountMeAppConfig {

    @Bean
    public VoteRepo voteRepo() {
        return new HashMapVoteRepo();
    }

}
