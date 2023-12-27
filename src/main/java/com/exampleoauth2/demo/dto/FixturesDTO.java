package com.exampleoauth2.demo.dto;

import lombok.Data;

@Data
public class FixturesDTO {

    private String matchId;
    private String eventTime;
    private String homeTeam;
    private String awayTeam;
    private String country;
    private String league;
    private String action;
    private Boolean hasExecuted;
}
