package com.iqmsoft.boot.jasper.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iqmsoft.boot.jasper.model.Employee;
import com.iqmsoft.boot.jasper.reports.EmployeeReport;
import com.iqmsoft.boot.jasper.repository.EmployeeRepository;
import com.iqmsoft.boot.jasper.service.ReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
@RequestMapping("/")
public class ReportController {

	private final EmployeeRepository employeeRepository;
	private final ReportService reportService;

	@Autowired
	public ReportController(final EmployeeRepository employeeRepository, final ReportService reportService){
		this.employeeRepository = employeeRepository;
		this.reportService = reportService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHome(){
		return "redirect:/employeeReport.pdf";
	}

	@RequestMapping(value = "/employeeReport.pdf", method = RequestMethod.GET, produces = "application/pdf")
	public void getEmployeeReportPdf(final HttpServletResponse response) throws JRException, IOException, ClassNotFoundException {
		
		EmployeeReport report = new EmployeeReport(employeeRepository.findAll());
		JasperPrint jp = report.getReport();

		reportService.writePdfReport(jp, response, "employeeReport");
		return;
	}
	
	@RequestMapping(value = "/employeeReport.xlsx", method = RequestMethod.GET, produces = "application/pdf")
	public void getEmployeeReportXlsx(final HttpServletResponse response) throws JRException, IOException, ClassNotFoundException {
		EmployeeReport report = new EmployeeReport(employeeRepository.findAll());
		JasperPrint jp = report.getReport();

		reportService.writeXlsxReport(jp, response, "employeeReport");
		return;
	}

	
}
