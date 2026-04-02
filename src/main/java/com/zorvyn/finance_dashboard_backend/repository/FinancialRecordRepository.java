package com.zorvyn.finance_dashboard_backend.repository;

import com.zorvyn.finance_dashboard_backend.entity.FinancialRecord;
import com.zorvyn.finance_dashboard_backend.enums.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

    List<FinancialRecord> findByType(RecordType type);

    List<FinancialRecord> findByCategory(String category);

    long countByType(RecordType type);
}