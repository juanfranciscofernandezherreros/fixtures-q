package com.exampleoauth2.demo.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "matchId",
        "eventTime",
        "homeTeam",
        "awayTeam"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "FIXTURES")
public class MatchsDTO {

    @JsonProperty("matchId")
    private String matchId;
    @JsonProperty("eventTime")
    private String eventTime;
    @JsonProperty("homeTeam")
    private String homeTeam;
    @JsonProperty("awayTeam")
    private String awayTeam;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("matchId")
    public String getMatchId() {
        return matchId;
    }

    @JsonProperty("matchId")
    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    @JsonProperty("eventTime")
    public String getEventTime() {
        return eventTime;
    }

    @JsonProperty("eventTime")
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    @JsonProperty("homeTeam")
    public String getHomeTeam() {
        return homeTeam;
    }

    @JsonProperty("homeTeam")
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    @JsonProperty("awayTeam")
    public String getAwayTeam() {
        return awayTeam;
    }

    @JsonProperty("awayTeam")
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public MatchsDTO(String matchId, String eventTime, String homeTeam, String awayTeam) {
        this.matchId = matchId;
        this.eventTime = eventTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return "FixturesDAO{" +
                "matchId='" + matchId + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
