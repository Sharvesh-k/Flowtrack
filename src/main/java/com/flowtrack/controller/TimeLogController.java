package com.flowtrack.controller;

import com.flowtrack.dto.TimeLogDTO;
import com.flowtrack.google.GoogleSheetsService;
import com.flowtrack.google.GoogleSheetsWriter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeLogController {

    private final GoogleSheetsService googleSheetsService;
    private final GoogleSheetsWriter googleSheetsWriter;

    public TimeLogController(
            GoogleSheetsService googleSheetsService,
            GoogleSheetsWriter googleSheetsWriter) {

        this.googleSheetsService = googleSheetsService;
        this.googleSheetsWriter = googleSheetsWriter;
    }

    @GetMapping("/api/timelogs")
    public List<TimeLogDTO> getTimeLogs() throws Exception {

        return googleSheetsService.getTimeLogs();
    }

    @GetMapping("/api/timelogs/pending")
    public List<TimeLogDTO> getPendingTimeLogs() throws Exception {

        return googleSheetsService.getPendingTimeLogs();
    }

    @PostMapping("/api/timelogs")
    public String addTimeLog(@RequestBody TimeLogDTO dto) throws Exception {

        googleSheetsWriter.addTimeLog(dto);

        return "Time log added successfully";
    }
}