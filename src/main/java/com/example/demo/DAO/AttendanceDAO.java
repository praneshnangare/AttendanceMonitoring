package com.example.demo.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import com.example.demo.entities.AttendanceEntity;

@RepositoryDefinition(idClass = Integer.class , domainClass = AttendanceEntity.class)
public interface AttendanceDAO extends JpaRepository<AttendanceEntity, Integer>{

	List<AttendanceEntity> findByEmpId(Integer empId);
	
	List<AttendanceEntity> findByAttendanceDateBetween(Date fromDate, Date toDate);
	
	//@Query("select u from AttendanceEntity u where u.empId = ?1 and u.attendanceDate between ?2 and ?3")
	List<AttendanceEntity> findByEmpIdAndAttendanceDateBetween(Integer empId, Date fromDate, Date toDate);
	
}
