package org.example.footballmanagerdn.controllers;

import org.example.footballmanagerdn.models.DTO.PlayerSalaryReport;
import org.example.footballmanagerdn.services.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private IReportService reportService;

    @GetMapping("/player-salary")
    public ResponseEntity<?> playerSalary() {
        Iterable<PlayerSalaryReport> report = reportService.getPlayerSalaryReport();
        // Implement logic to generate report
        return new ResponseEntity<>(report, HttpStatus.OK);

    }
}
