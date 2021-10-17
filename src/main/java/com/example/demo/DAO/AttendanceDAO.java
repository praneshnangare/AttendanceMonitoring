package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.example.demo.entities.AttendanceEntity;

@RepositoryDefinition(idClass = Integer.class , domainClass = AttendanceEntity.class)
public interface AttendanceDAO extends JpaRepository<AttendanceEntity, Integer>{
	
}
