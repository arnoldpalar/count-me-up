package com.ap.countmeup.dto;

import lombok.*;

import java.util.Map;

@Getter @Setter @AllArgsConstructor @Builder
public class CountResponse {

    Map<Long, Double> resMap;

}
