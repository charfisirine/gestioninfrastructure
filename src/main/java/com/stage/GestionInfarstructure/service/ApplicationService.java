package com.stage.GestionInfarstructure.service;

import com.google.common.base.Preconditions;
import com.stage.GestionInfarstructure.mapping.ApplicationMapping;
import com.stage.GestionInfarstructure.domain.Application;
import com.stage.GestionInfarstructure.dto.ApplicationDTO;
import com.stage.GestionInfarstructure.repository.ApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service  // Add this annotation to make the class a Spring service bean
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Transactional(readOnly = true)
    public Application findOne(Integer id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Collection<ApplicationDTO> findAll() {
        Collection<Application> result = applicationRepository.findAll();
        return ApplicationMapping.applicationsToApplicationDTOs(result);
    }

    public ApplicationDTO add(ApplicationDTO applicationDTO) {
        Application application = ApplicationMapping.applicationDTOToApplication(applicationDTO);
        application = applicationRepository.save(application);
        return ApplicationMapping.applicationToApplicationDTO(application);
    }

    public ApplicationDTO update(ApplicationDTO applicationDTO) {
        Application applicationInBase = applicationRepository.findById(applicationDTO.getApplicationId()).orElse(null);
        Preconditions.checkArgument(applicationInBase != null, "Application has been deleted");

        Application application = ApplicationMapping.applicationDTOToApplication(applicationDTO);
        application = applicationRepository.save(application);
        return ApplicationMapping.applicationToApplicationDTO(application);
    }

    public void deleteApplication(Integer id) {
        applicationRepository.deleteById(id);
    }
}
