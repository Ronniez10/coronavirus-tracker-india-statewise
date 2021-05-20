package com.neelav.coronavirousindiastatewisetracker.service;



import com.neelav.coronavirousindiastatewisetracker.models.CoronaData;
import com.sun.net.httpserver.Headers;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import java.util.List;

@Service
public class CoronaDataService {

    private static String VIRUS_DATA_URL ="https://api.covid19india.org/csv/latest/state_wise.csv";


    private List<CoronaData> stateData ;

    public List<CoronaData> getStateData() {
        return stateData;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVirusData() throws IOException, InterruptedException {

        List<CoronaData> statewiseData = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();


        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        StringReader csvBodyReader = new StringReader(httpResponse.body());

       // System.out.println(httpResponse.body());

        //Converting the String response into CSV Records using Apache Commons Library
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);


        for (CSVRecord record : records) {

            if(!record.get("State").equals("State Unassigned")) {
                CoronaData coronaStats = new CoronaData();

                coronaStats.setState(record.get("State"));
                coronaStats.setConfirmed(Integer.parseInt(record.get("Confirmed")));
                coronaStats.setActive(Integer.parseInt(record.get("Active")));
                coronaStats.setDeaths(Integer.parseInt(record.get("Deaths")));
                coronaStats.setRecovered(Integer.parseInt(record.get("Recovered")));
                coronaStats.setNewCasesToday(record.get("Delta_Confirmed"));
                coronaStats.setDeathsToday(record.get("Delta_Deaths"));
                coronaStats.setRecoveredToday(record.get("Delta_Recovered"));


                statewiseData.add(coronaStats);
            }

        }


        this.stateData=statewiseData;
    }
}
