package com.exampleoauth2.demo.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "MATCHS")
public class YourOutputObject {
    public MatchData matchData;
    public ArrayList<StatsPlayer> statsPlayer;
    public ArrayList<StatsMatchAll> statsMatch_all;
    public ArrayList<StatsMatchFirst> statsMatch_first;
    public ArrayList<StatsMatchSecond> statsMatch_second;
    public ArrayList<StatsMtachThirst> statsMtach_thirst;
    public ArrayList<StatsMtachFour> statsMtach_four;
    public Object statsMtach_five;
    public ArrayList<PointByPoint> pointByPoint;
    public ArrayList<PointByPointFirst> pointByPoint_first;
    public ArrayList<PointByPointSecond> pointByPoint_second;
    public ArrayList<PointByPointThirst> pointByPoint_thirst;

}
