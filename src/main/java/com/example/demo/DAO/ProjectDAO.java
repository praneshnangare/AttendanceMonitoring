package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.example.demo.entities.ProjectEntity;

@RepositoryDefinition(idClass = Integer.class , domainClass = ProjectEntity.class)
public interface ProjectDAO extends JpaRepository<ProjectEntity, Integer>{

}
