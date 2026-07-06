package com.flowtrack.google;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.flowtrack.dto.TimeLogDTO;
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
                .get(GoogleSheetConstants.SPREADSHEET_ID, GoogleSheetConstants.RANGE)
                .execute();

        List<List<Object>> values = response.getValues();

        List<TimeLogDTO> logs = new ArrayList<>();

        if (values == null)
            return logs;

        for (List<Object> row : values) {

            TimeLogDTO dto = new TimeLogDTO();

            dto.setEmployee(row.get(0).toString());
            dto.setDate(row.get(1).toString());
            dto.setProject(row.get(2).toString());
            dto.setTask(row.get(3).toString());
            dto.setHours(Double.parseDouble(row.get(4).toString()));
            dto.setStatus(row.get(5).toString());

            logs.add(dto);
        }

        return logs;
    }
}