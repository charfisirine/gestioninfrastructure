package com.stage.GestionInfarstructure.service;

import java.util.Collection;

import com.stage.GestionInfarstructure.mapping.ServeurMapping;
import com.stage.GestionInfarstructure.domain.Serveur;
import com.stage.GestionInfarstructure.dto.ServeurDTO;
import com.stage.GestionInfarstructure.repository.ServeurRepository;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServeurService {

    private final ServeurRepository serveurRepository;

    public ServeurService(ServeurRepository serveurRepository) {
        this.serveurRepository = serveurRepository;
    }

    @Transactional(readOnly = true)
    public Serveur findOne(Integer id) {
        return serveurRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Collection<ServeurDTO> findAll() {
        Collection<Serveur> result = serveurRepository.findAll();
        return ServeurMapping.serveursToServeurDTOs(result);
    }

    public ServeurDTO add(ServeurDTO serveurDTO) {
        Serveur serveur = ServeurMapping.serveurDTOTOServeur(serveurDTO);
        serveur = serveurRepository.save(serveur);
        return ServeurMapping.serveurTOServeurDTO(serveur);
    }

    public ServeurDTO update(ServeurDTO serveurDTO) {
        Serveur serveurInBase = serveurRepository.findById(serveurDTO.getServeurId()).orElse(null);
        Preconditions.checkArgument(serveurInBase != null, "Serveur has been deleted");

        Serveur serveur = ServeurMapping.serveurDTOTOServeur(serveurDTO);
        serveur = serveurRepository.save(serveur);
        return ServeurMapping.serveurTOServeurDTO(serveur);
    }

    public void deleteServeur(Integer id) {
        serveurRepository.deleteById(id);
    }
}
