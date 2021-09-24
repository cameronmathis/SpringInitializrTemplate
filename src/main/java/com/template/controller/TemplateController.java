package com.template.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.template.exception.ResourceNotFoundException;
import com.template.model.Template;
import com.template.repository.TemplateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TemplateController {

	@Autowired
    private TemplateRepository templateRepository;

    @GetMapping("/templates")
    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }

    @GetMapping("/templates/{id}")
    public ResponseEntity<Template> getTemplateById(@PathVariable(value = "id") Long templateId)
        throws ResourceNotFoundException {
        Template template = templateRepository.findById(templateId)
          .orElseThrow(() -> new ResourceNotFoundException("Template not found for this id :: " + templateId));
        return ResponseEntity.ok().body(template);
    }
    
    @PostMapping("/templates")
    public Template createTemplate(@Valid @RequestBody Template template) {
        return templateRepository.save(template);
    }

    @PutMapping("/templates/{id}")
    public ResponseEntity<Template> updateTemplate(@PathVariable(value = "id") Long templateId,
         @Valid @RequestBody Template templateDetails) throws ResourceNotFoundException {
        Template template = templateRepository.findById(templateId)
        .orElseThrow(() -> new ResourceNotFoundException("Template not found for this id :: " + templateId));

        template.setTemplateCharacteristic(templateDetails.getTemplateCharacteristic());
        final Template updatedTemplate = templateRepository.save(template);
        return ResponseEntity.ok(updatedTemplate);
    }

    @DeleteMapping("/templates/{id}")
    public Map<String, Boolean> deleteTemplate(@PathVariable(value = "id") Long templateId)
         throws ResourceNotFoundException {
        Template template = templateRepository.findById(templateId)
       .orElseThrow(() -> new ResourceNotFoundException("Template not found for this id :: " + templateId));

        templateRepository.delete(template);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
