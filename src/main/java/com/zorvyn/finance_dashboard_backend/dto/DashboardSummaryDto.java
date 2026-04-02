package com.zorvyn.finance_dashboard_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardSummaryDto {
    private Double totalIncome;
    private Double totalExpense;
    private Double balance;
    private Long totalTransactions;
}
