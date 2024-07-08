package org.example.footballmanagerdn.services;

import org.example.footballmanagerdn.models.DTO.PlayerSalaryReport;

public interface IReportService {
    Iterable<PlayerSalaryReport> getPlayerSalaryReport();
}
