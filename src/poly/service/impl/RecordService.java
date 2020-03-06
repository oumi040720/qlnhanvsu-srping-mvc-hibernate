package poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poly.dao.IRecordDAO;
import poly.entity.Record;
import poly.service.IRecordService;

@Service
public class RecordService implements IRecordService {

	@Autowired
	IRecordDAO recordDAO;
	
	@Override
	@Transactional
	public List<Record> findAll(Integer offset, Integer limit) {
		return recordDAO.findAll(offset, limit);
	}

	@Override
	@Transactional
	public Long getTotalItems() {
		return recordDAO.getTotalItems();
	}

	@Override
	@Transactional
	public List<String> getAllYear() {
		return recordDAO.getAllYear();
	}
	
	@Override
	@Transactional
	public Long getTotalItemsByYear(Integer year) {
		return recordDAO.getTotalItemsByYear(year);
	}
	
	@Override
	@Transactional
	public List<Record> findAllByYear(Integer year, Integer offset, Integer limit) {
		return recordDAO.findAllByYear(year, offset, limit);
	}
	
	@Override
	@Transactional
	public List<Object[]> findAllStaffReport(Integer offset, Integer limit) {
		return recordDAO.findAllStaffReport(offset, limit);
	}
	
	@Override
	@Transactional
	public List<Object[]> findAllStaffReportByYear(Integer year, Integer offset, Integer limit) {
		return recordDAO.findAllStaffReportByYear(year, offset, limit);
	}

	@Override
	@Transactional
	public Long getTotalStaffReportItems() {
		return recordDAO.getTotalStaffReportItems();
	}
	
	@Override
	@Transactional
	public Long getTotalStaffReportItemsByYear(Integer year) {
		return recordDAO.getTotalStaffReportItemsByYear(year);
	}
	
	@Override
	@Transactional
	public List<Object[]> findExcellentStaff() {
		return recordDAO.findExcellentStaff();
	}
	
	@Override
	@Transactional
	public List<Object[]> findExcellentStaffByYear(Integer year) {
		return recordDAO.findExcellentStaffByYear(year);
	}
	
	@Override
	@Transactional
	public List<Object[]> findAllDepartReport(Integer offset, Integer limit) {
		return recordDAO.findAllDepartReport(offset, limit);
	}
	
	@Override
	@Transactional
	public List<Object[]> findAllDepartReportByYear(Integer year, Integer offset, Integer limit) {
		return recordDAO.findAllDepartReportByYear(year, offset, limit);
	}

	@Override
	@Transactional
	public Long getTotalDepartReportItems() {
		return recordDAO.getTotalDepartReportItems();
	}
	
	@Override
	public Long getTotalDepartReportItemsByYear(Integer year) {
		return recordDAO.getTotalDepartReportItemsByYear(year);
	}
	
	@Override
	@Transactional
	public Record findOne(Long id) {
		return recordDAO.findOne(id);
	}

	@Override
	@Transactional
	public boolean saveOrUpdate(Record record) {
		return recordDAO.saveOrUpdate(record);
	}

	@Override
	@Transactional
	public boolean delete(Long id) {
		return recordDAO.delete(id);
	}

}
