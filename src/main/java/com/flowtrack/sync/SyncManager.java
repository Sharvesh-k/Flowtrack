package com.flowtrack.sync;

import com.flowtrack.google.GoogleSheetsService;
import com.flowtrack.dto.TimeLogDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyncManager {

    private final GoogleSheetsService googleSheetsService;

    public SyncManager(GoogleSheetsService googleSheetsService) {
        this.googleSheetsService = googleSheetsService;
    }

    public void syncPendingLogs() throws Exception {

        List<TimeLogDTO> pendingLogs = googleSheetsService.getPendingTimeLogs();

        System.out.println("Pending Logs Found : " + pendingLogs.size());

        for (TimeLogDTO log : pendingLogs) {

            System.out.println("-------------------------");
            System.out.println("Employee : " + log.getEmployee());
            System.out.println("Project  : " + log.getProject());
            System.out.println("Task     : " + log.getTask());
            System.out.println("Hours    : " + log.getHours());
            System.out.println("-------------------------");
        }
    }
}