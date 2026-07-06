package com.flowtrack.google;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.flowtrack.dto.TimeLogDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoogleSheetsWriter {

    private final Sheets sheets;

    public GoogleSheetsWriter(Sheets sheets) {
        this.sheets = sheets;
    }public void addTimeLog(TimeLogDTO dto) throws Exception {

        List<Object> row = List.of(
                dto.getEmployee(),
                dto.getDate(),
                dto.getProject(),
                dto.getTask(),
                dto.getHours(),
                dto.getStatus(),
                dto.getProjectId(),
                dto.getTaskId(),
                dto.getSyncStatus(),
                dto.getZohoLogId(),
                dto.getRemarks()
        );

        ValueRange body = new ValueRange()
                .setValues(List.of(row));

        sheets.spreadsheets().values()
                .append(
                        GoogleSheetConstants.SPREADSHEET_ID,
                        "Sheet1!A:K",
                        body
                ) 
                .setValueInputOption("RAW")
                .execute();
    }

}