package com.flowtrack.zoho;

import com.flowtrack.sync.SyncManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sync")
public class ZohoController {

    private final SyncManager syncManager;

    public ZohoController(SyncManager syncManager) {
        this.syncManager = syncManager;
    }

    @PostMapping
    public String sync() throws Exception {

        syncManager.syncPendingLogs();

        return "Sync Started";
    }
}