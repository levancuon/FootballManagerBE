package org.example.footballmanagerdn.services.iml;

import org.example.footballmanagerdn.models.DTO.PlayerSalaryReport;
import org.example.footballmanagerdn.repositories.ISalaryRepo;
import org.example.footballmanagerdn.services.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService implements IReportService {
    @Autowired
    private ISalaryRepo salaryRepo;
    @Override
    public Iterable<PlayerSalaryReport> getPlayerSalaryReport() {
        return salaryRepo.getPlayerSalaryReport();
    }
}
