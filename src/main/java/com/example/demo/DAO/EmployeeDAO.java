package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.example.demo.entities.EmployeeEntity;

@RepositoryDefinition(idClass = Integer.class , domainClass = EmployeeEntity.class)
public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Integer>{
	
}
