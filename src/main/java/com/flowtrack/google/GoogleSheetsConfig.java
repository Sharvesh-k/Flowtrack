package com.flowtrack.google;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.Collections;

@Configuration
public class GoogleSheetsConfig {

    private static final String APPLICATION_NAME = "FlowTrack";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    @Bean
    public Sheets sheetsService() throws Exception {

        final NetHttpTransport httpTransport =
                GoogleNetHttpTransport.newTrustedTransport();

        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream("credentials/credentials.json");

        GoogleCredentials credentials = GoogleCredentials
                .fromStream(inputStream)
                .createScoped(Collections.singleton(
                        "https://www.googleapis.com/auth/spreadsheets"));

        return new Sheets.Builder(
                httpTransport,
                JSON_FACTORY,
                new HttpCredentialsAdapter(credentials))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
}