package com.flowtrack.google;

import com.flowtrack.dto.TimeLogDTO;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleSheetsService {

    private final Sheets sheets;

    public GoogleSheetsService(Sheets sheets) {
        this.sheets = sheets;
    }

    public List<TimeLogDTO> getTimeLogs() throws Exception {

        ValueRange response = sheets.spreadsheets().values()
                .get(GoogleSheetConstants.SPREADSHEET_ID,
                        GoogleSheetConstants.RANGE)
                .execute();

        List<List<Object>> values = response.getValues();

        List<TimeLogDTO> logs = new ArrayList<>();

        if (values == null) {
            return logs;
        }

        for (List<Object> row : values) {

            TimeLogDTO dto = new TimeLogDTO();

            dto.setEmployee(row.get(0).toString());
            dto.setDate(row.get(1).toString());
            dto.setProject(row.get(2).toString());
            dto.setTask(row.get(3).toString());
            dto.setHours(Double.parseDouble(row.get(4).toString()));
            dto.setStatus(row.get(5).toString());

            dto.setProjectId(row.size() > 6 ? row.get(6).toString() : "");
            dto.setTaskId(row.size() > 7 ? row.get(7).toString() : "");
            dto.setSyncStatus(row.size() > 8 ? row.get(8).toString() : "");
            dto.setZohoLogId(row.size() > 9 ? row.get(9).toString() : "");
            dto.setRemarks(row.size() > 10 ? row.get(10).toString() : "");

            logs.add(dto);
        }

        return logs;
    }

    public List<TimeLogDTO> getPendingTimeLogs() throws Exception {

        List<TimeLogDTO> allLogs = getTimeLogs();
        List<TimeLogDTO> pendingLogs = new ArrayList<>();

        for (TimeLogDTO log : allLogs) {

            if ("Pending".equalsIgnoreCase(log.getSyncStatus())) {
                pendingLogs.add(log);
            }
        }

        return pendingLogs;
    }
}