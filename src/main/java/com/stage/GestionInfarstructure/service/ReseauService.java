package com.stage.GestionInfarstructure.service;


import java.util.Collection;

import com.stage.GestionInfarstructure.mapping.ReseauMapping;
import com.stage.GestionInfarstructure.domain.Reseau;
import com.stage.GestionInfarstructure.dto.ReseauDTO;
import com.stage.GestionInfarstructure.repository.ReseauRepository;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReseauService {

    private final ReseauRepository reseauRepository;

    public ReseauService( ReseauRepository reseauRepository) {
        this.reseauRepository = reseauRepository;
    }



    @Transactional(readOnly = true)
    public Reseau findOne(Integer id) {
        return reseauRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Collection<ReseauDTO> findAll() {
        Collection<Reseau> result = reseauRepository.findAll();
        return ReseauMapping.reseausToSousReseauDTOs(result);
    }

    public ReseauDTO add(ReseauDTO reseauDTO) {
        Reseau reseau = ReseauMapping.reseauDTOTOReseau(reseauDTO);
        reseau = reseauRepository.save(reseau);
        return ReseauMapping.reseauTOreseauDTO(reseau);
    }

    public ReseauDTO update(ReseauDTO reseauDTO) {
        Reseau reseauInBase = reseauRepository.findById(reseauDTO.getIdReseau()).orElse(null);
        Preconditions.checkArgument(reseauInBase != null, "Reseau has been deleted");

        Reseau reseau = ReseauMapping.reseauDTOTOReseau(reseauDTO);
        reseau = reseauRepository.save(reseau);
        return ReseauMapping.reseauTOreseauDTO(reseau);
    }

    public void deleteReseau(Integer id) {

        reseauRepository.deleteById(id);
    }
}

