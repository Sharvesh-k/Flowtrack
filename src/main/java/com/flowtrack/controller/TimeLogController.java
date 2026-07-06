package com.flowtrack.controller;

import com.flowtrack.dto.TimeLogDTO;
import com.flowtrack.google.GoogleSheetsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class TimeLogController {

    private final GoogleSheetsService googleSheetsService;

    public TimeLogController(GoogleSheetsService googleSheetsService) {
        this.googleSheetsService = googleSheetsService;
    }

    @GetMapping("/api/timelogs")
    public List<TimeLogDTO> getTimeLogs() throws Exception {
        return googleSheetsService.getTimeLogs();
    }
    @PostMapping("/api/timelogs")
    public String addTimeLog(@RequestBody TimeLogDTO dto) throws Exception {

        googleSheetsService.addTimeLog(dto);

        return "Time log added successfully";
    }
}