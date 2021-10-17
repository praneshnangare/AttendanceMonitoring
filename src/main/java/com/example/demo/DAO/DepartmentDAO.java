package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.example.demo.entities.DepartmentEntity;

@RepositoryDefinition(idClass = Integer.class , domainClass = DepartmentEntity.class)
public interface DepartmentDAO extends JpaRepository<DepartmentEntity, Integer>{

	List<DepartmentEntity> findByProjectId(Integer projectId);

}