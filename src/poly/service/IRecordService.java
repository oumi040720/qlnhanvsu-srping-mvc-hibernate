package poly.service;

import java.util.List;

import poly.entity.Record;

public interface IRecordService {

public List<Record> findAll(Integer offset, Integer limit);
	
	public Long getTotalItems();
	
	public List<String> getAllYear();
	
	public Long getTotalItemsByYear(Integer year);
	
	public List<Record> findAllByYear(Integer year, Integer offset, Integer limit);
	
	public List<Object[]> findAllStaffReport(Integer offset, Integer limit);
	
	public List<Object[]> findAllStaffReportByYear(Integer year,Integer offset, Integer limit);

	public Long getTotalStaffReportItems();
	
	public Long getTotalStaffReportItemsByYear(Integer year);
	
	public List<Object[]> findExcellentStaff();
	
	public List<Object[]> findExcellentStaffByYear(Integer year);
	
	public List<Object[]> findAllDepartReport(Integer offset, Integer limit);
	
	public List<Object[]> findAllDepartReportByYear(Integer year, Integer offset, Integer limit);
	
	public Long getTotalDepartReportItems();
	
	public Long getTotalDepartReportItemsByYear(Integer year);
	
	public Record findOne(Long id);

	public boolean saveOrUpdate(Record record);
	
	public boolean delete(Long id);
	
}
