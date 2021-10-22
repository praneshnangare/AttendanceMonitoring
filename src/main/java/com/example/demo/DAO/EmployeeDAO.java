package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.example.demo.beans.EmployeeBean;
import com.example.demo.entities.EmployeeEntity;

@RepositoryDefinition(idClass = Integer.class , domainClass = EmployeeEntity.class)
public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Integer>{

	List<EmployeeEntity> findByStatus(Integer i);
	
}
