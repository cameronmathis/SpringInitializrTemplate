package com.template.RestServiceApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.template.RestServiceApplication.model.Template;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long>{

}
