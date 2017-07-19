package com.ap.countmeup.dto;

import lombok.*;

import java.util.Date;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor @Builder
public class VoteRequest {
    private Long userId;
    private Long candidateId;
    private Date voteOn = new Date();
}
