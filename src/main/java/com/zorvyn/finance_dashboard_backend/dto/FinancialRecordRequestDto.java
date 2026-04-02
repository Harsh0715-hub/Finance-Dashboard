package com.zorvyn.finance_dashboard_backend.dto;

import com.zorvyn.finance_dashboard_backend.enums.RecordType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FinancialRecordRequestDto {
    private Double amount;
    private RecordType type;
    private String category;
    private LocalDate date;
    private String notes;
}