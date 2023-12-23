package com.exampleoauth2.demo.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats{
    @JsonProperty("TEAM") 
    public String tEAM;
    @JsonProperty("PTS") 
    public String pTS;
    @JsonProperty("REB") 
    public String rEB;
    @JsonProperty("AST") 
    public String aST;
    @JsonProperty("MIN") 
    public String mIN;
    @JsonProperty("FGM") 
    public String fGM;
    @JsonProperty("FGA") 
    public String fGA;
    @JsonProperty("2PM") 
    public String _2PM;
    @JsonProperty("2PA") 
    public String _2PA;
    @JsonProperty("3PM") 
    public String _3PM;
    @JsonProperty("3PA") 
    public String _3PA;
    @JsonProperty("FTM") 
    public String fTM;
    @JsonProperty("FTA") 
    public String fTA;
    @JsonProperty("+/-")
    public String masXmenos;
    @JsonProperty("OR")
    public String oR;
    @JsonProperty("DR") 
    public String dR;
    @JsonProperty("PF") 
    public String pF;
    @JsonProperty("ST") 
    public String sT;
    @JsonProperty("TO") 
    public String tO;
    @JsonProperty("BS") 
    public String bS;
    @JsonProperty("BA") 
    public String bA;
    @JsonProperty("TFS") 
    public String tFS;
}
