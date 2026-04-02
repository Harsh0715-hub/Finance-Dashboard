package com.zorvyn.finance_dashboard_backend.controller;

import com.zorvyn.finance_dashboard_backend.dto.DashboardSummaryDto;
import com.zorvyn.finance_dashboard_backend.dto.FinancialRecordRequestDto;
import com.zorvyn.finance_dashboard_backend.entity.FinancialRecord;
import com.zorvyn.finance_dashboard_backend.service.FinancialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class FinancialRecordController {

    private final FinancialRecordService financialRecordService;

    @PostMapping
    public FinancialRecord createRecord(@RequestBody FinancialRecordRequestDto dto) {
        return financialRecordService.createRecord(dto);
    }

    @GetMapping
    public List<FinancialRecord> getAllRecords() {
        return financialRecordService.getAllRecords();
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        financialRecordService.deleteRecord(id);
        return "Record deleted successfully";
    }

    @GetMapping("/summary")
    public DashboardSummaryDto getSummary() {
        return financialRecordService.getDashboardSummary();
    }
}
