package com.stage.GestionInfarstructure.service;

import com.google.common.base.Preconditions;
import com.stage.GestionInfarstructure.domain.ServeurApplication;
import com.stage.GestionInfarstructure.dto.ServeurApplicationDTO;
import com.stage.GestionInfarstructure.mapping.ServeurApplicationMapping;
import com.stage.GestionInfarstructure.repository.ServeurApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service  // Annoter cette classe pour en faire un bean Spring de type service
public class ServeurApplicationService {

    private final ServeurApplicationRepository serveurApplicationRepository;

    public ServeurApplicationService(ServeurApplicationRepository serveurApplicationRepository) {
        this.serveurApplicationRepository = serveurApplicationRepository;
    }

    @Transactional(readOnly = true)
    public ServeurApplication findOne(Integer id) {
        return serveurApplicationRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Collection<ServeurApplicationDTO> findAll() {
        Collection<ServeurApplication> result = serveurApplicationRepository.findAll();
        return ServeurApplicationMapping.serveurApplicationsToServeurApplicationDTOs(result);
    }

    public ServeurApplicationDTO add(ServeurApplicationDTO serveurApplicationDTO) {
        ServeurApplication serveurApplication = ServeurApplicationMapping.serveurApplicationDTOToServeurApplication(serveurApplicationDTO);
        serveurApplication = serveurApplicationRepository.save(serveurApplication);
        return ServeurApplicationMapping.serveurApplicationToServeurApplicationDTO(serveurApplication);
    }

    public ServeurApplicationDTO update(ServeurApplicationDTO serveurApplicationDTO) {
        ServeurApplication serveurApplicationInBase = serveurApplicationRepository.findById(serveurApplicationDTO.getId()).orElse(null);
        Preconditions.checkArgument(serveurApplicationInBase != null, "ServeurApplication has been deleted");

        ServeurApplication serveurApplication = ServeurApplicationMapping.serveurApplicationDTOToServeurApplication(serveurApplicationDTO);
        serveurApplication = serveurApplicationRepository.save(serveurApplication);
        return ServeurApplicationMapping.serveurApplicationToServeurApplicationDTO(serveurApplication);
    }

    public void deleteServeurApplication(Integer id) {
        serveurApplicationRepository.deleteById(id);
    }
}
