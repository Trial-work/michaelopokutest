package com.michaelopoku.ipoquetest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michaelopoku.ipoquetest.model.MovieInfo;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

@Service
public class MovieInfoRetrievalServiceImpl implements MovieInfoRetrievalService {

    private String searchUrl = "https://swapi.dev/api/films/";

    public Optional<MovieInfo> retrieveMovieInfo(String name) {

        try {
            URL obj = new URL(searchUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("search", name);
            int responseCode = con.getResponseCode();
            System.out.println("code " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String apiResponse = "";
                StringBuilder jsonString = new StringBuilder();
                while ((apiResponse = br.readLine()) != null) {
                    jsonString.append(apiResponse);
                }
                br.close();

                return Optional.of(mapJsonToMovieInfo(jsonString.toString()));
            } else {
                System.out.println("Didn't work...");
            }
        } catch (IOException e) {

        }
        return Optional.empty();
    }

    public MovieInfo mapJsonToMovieInfo(String json) throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, MovieInfo.class);
    }
}