package com.stage.GestionInfarstructure.service;


import java.util.Collection;


import com.stage.GestionInfarstructure.domain.SousReseau;
import com.stage.GestionInfarstructure.dto.SousReseauDTO;
import com.stage.GestionInfarstructure.repository.ReseauRepository;
import com.stage.GestionInfarstructure.repository.SousReseauRepository;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.stage.GestionInfarstructure.mapping.SousReseauMapping;

@Service
@Transactional
public class SousReseauService {

    private final ReseauRepository reseauRepository;
    private final SousReseauRepository sousReseauRepository;

    public SousReseauService(ReseauRepository reseauRepository, SousReseauRepository sousReseauRepository) {
        this.reseauRepository = reseauRepository;
        this.sousReseauRepository = sousReseauRepository;

    }

    @Transactional(readOnly = true)
    public SousReseauDTO findOne(Integer id) {
        SousReseau sousReseau = sousReseauRepository.findById(id).orElse(null);
        return SousReseauMapping.sousReseauTOSousReseauDTO(sousReseau);
    }

    @Transactional(readOnly = true)
    public Collection<SousReseauDTO> findAll() {
        Collection<SousReseau> result = sousReseauRepository.findAll();
        return SousReseauMapping.sousReseausToSousReseauDTOs(result);
    }

    public SousReseauDTO add(SousReseauDTO SousReseauDTO) {
        SousReseau sousReseau = SousReseauMapping.sousReseauDTOTOSousReseau(SousReseauDTO);
        sousReseau = sousReseauRepository.save(sousReseau);
        return SousReseauMapping.sousReseauTOSousReseauDTO(sousReseau);
    }

    public SousReseauDTO update(SousReseauDTO SousReseauDTO) {
        SousReseau sousReseauInBase = sousReseauRepository.findById(SousReseauDTO.getIdSousReseau()).orElse(null);
        Preconditions.checkArgument(sousReseauInBase != null, "sous Reseau has been deleted");

        SousReseau sousReseau = SousReseauMapping.sousReseauDTOTOSousReseau(SousReseauDTO);

        sousReseau = sousReseauRepository.save(sousReseau);
        return SousReseauMapping.sousReseauTOSousReseauDTO(sousReseau);
    }

    public void deleteSousReseau(Integer id) {
        sousReseauRepository.deleteById(id);
    }







}
