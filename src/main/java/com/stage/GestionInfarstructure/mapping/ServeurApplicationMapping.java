package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.ServeurApplication;
import com.stage.GestionInfarstructure.dto.ServeurApplicationDTO;
import com.stage.GestionInfarstructure.domain.Serveur;
import com.stage.GestionInfarstructure.domain.Application;
import com.stage.GestionInfarstructure.dto.ServeurDTO;
import com.stage.GestionInfarstructure.dto.ApplicationDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ServeurApplicationMapping {

    // Convert ServeurApplicationDTO to ServeurApplication
    public static ServeurApplication serveurApplicationDTOToServeurApplication(ServeurApplicationDTO serveurApplicationDTO) {
        ServeurApplication serveurApplication = new ServeurApplication();
        serveurApplication.setId(serveurApplicationDTO.getId());
        serveurApplication.setPurpose(serveurApplicationDTO.getPurpose());
        serveurApplication.setLienAcces(serveurApplicationDTO.getLienAcces());

        if (serveurApplicationDTO.getServeur() != null) {
            Serveur serveur = ServeurMapping.serveurDTOTOServeur(serveurApplicationDTO.getServeur());
            serveurApplication.setServeur(serveur);
        }

        if (serveurApplicationDTO.getApplication() != null) {
            Application application = ApplicationMapping.applicationDTOToApplication(serveurApplicationDTO.getApplication());
            serveurApplication.setApplication(application);
        }

        return serveurApplication;
    }

    // Convert ServeurApplication to ServeurApplicationDTO
    public static ServeurApplicationDTO serveurApplicationToServeurApplicationDTO(ServeurApplication serveurApplication) {
        if (serveurApplication != null) {
            ServeurApplicationDTO serveurApplicationDTO = new ServeurApplicationDTO();
            serveurApplicationDTO.setId(serveurApplication.getId());
            serveurApplicationDTO.setPurpose(serveurApplication.getPurpose());
            serveurApplicationDTO.setLienAcces(serveurApplication.getLienAcces());

            if (serveurApplication.getServeur() != null) {
                ServeurDTO serveurDTO = ServeurMapping.serveurTOServeurDTO(serveurApplication.getServeur());
                serveurApplicationDTO.setServeur(serveurDTO);
            }

            if (serveurApplication.getApplication() != null) {
                ApplicationDTO applicationDTO = ApplicationMapping.applicationToApplicationDTO(serveurApplication.getApplication());
                serveurApplicationDTO.setApplication(applicationDTO);
            }

            return serveurApplicationDTO;
        } else {
            return null;
        }
    }

    // Convert ServeurApplication to ServeurApplicationDTO with minimal fields
    public static ServeurApplicationDTO lazyServeurApplicationToServeurApplicationDTO(ServeurApplication serveurApplication) {
        if (serveurApplication != null) {
            ServeurApplicationDTO serveurApplicationDTO = new ServeurApplicationDTO();
            serveurApplicationDTO.setId(serveurApplication.getId());
            serveurApplicationDTO.setPurpose(serveurApplication.getPurpose());
            serveurApplicationDTO.setLienAcces(serveurApplication.getLienAcces());
            return serveurApplicationDTO;
        } else {
            return null;
        }
    }

    // Convert a collection of ServeurApplication entities to a collection of ServeurApplicationDTOs
    public static Collection<ServeurApplicationDTO> serveurApplicationsToServeurApplicationDTOs(Collection<ServeurApplication> serveurApplications) {
        List<ServeurApplicationDTO> serveurApplicationDTOs = new ArrayList<>();
        for (ServeurApplication serveurApplication : serveurApplications) {
            ServeurApplicationDTO serveurApplicationDTO = lazyServeurApplicationToServeurApplicationDTO(serveurApplication);
            serveurApplicationDTOs.add(serveurApplicationDTO);
        }
        return serveurApplicationDTOs;
    }
}
