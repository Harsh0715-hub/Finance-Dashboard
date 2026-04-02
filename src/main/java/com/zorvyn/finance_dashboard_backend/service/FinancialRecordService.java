package com.zorvyn.finance_dashboard_backend.service;

import com.zorvyn.finance_dashboard_backend.dto.DashboardSummaryDto;
import com.zorvyn.finance_dashboard_backend.dto.FinancialRecordRequestDto;
import com.zorvyn.finance_dashboard_backend.entity.FinancialRecord;
import com.zorvyn.finance_dashboard_backend.enums.RecordType;
import com.zorvyn.finance_dashboard_backend.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialRecordService {

    private final FinancialRecordRepository financialRecordRepository;

    public FinancialRecord createRecord(FinancialRecordRequestDto dto) {
        FinancialRecord record = FinancialRecord.builder()
                .amount(dto.getAmount())
                .type(dto.getType())
                .category(dto.getCategory())
                .date(dto.getDate())
                .notes(dto.getNotes())
                .build();

        return financialRecordRepository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return financialRecordRepository.findAll();
    }

    public List<FinancialRecord> getByType(String type) {
        return financialRecordRepository.findByType(RecordType.valueOf(type));
    }

    public void deleteRecord(Long id) {
        financialRecordRepository.deleteById(id);
    }

    public DashboardSummaryDto getDashboardSummary() {
        double totalIncome = financialRecordRepository.findByType(RecordType.INCOME)
                .stream()
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        double totalExpense = financialRecordRepository.findByType(RecordType.EXPENSE)
                .stream()
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        return DashboardSummaryDto.builder()
                .totalIncome(totalIncome)
                .totalExpense(totalExpense)
                .balance(totalIncome - totalExpense)
                .totalTransactions(financialRecordRepository.count())
                .build();
    }
}
