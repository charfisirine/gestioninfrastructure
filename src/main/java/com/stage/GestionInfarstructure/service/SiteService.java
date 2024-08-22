package com.stage.GestionInfarstructure.service;

import com.stage.GestionInfarstructure.domain.Site;
import com.stage.GestionInfarstructure.dto.SiteDTO;
import com.stage.GestionInfarstructure.mapping.SiteMapping;
import com.stage.GestionInfarstructure.repository.SiteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class SiteService {

    private final SiteRepository siteRepository;

    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    @Transactional(readOnly = true)
    public SiteDTO findOne(Integer id) {
        Site site = siteRepository.findById(id).orElse(null);
        return SiteMapping.siteToSiteDTO(site);
    }

    @Transactional(readOnly = true)
    public Collection<SiteDTO> findAll() {
        Collection<Site> sites = siteRepository.findAll();
        return SiteMapping.sitesToSiteDTOs(sites);
    }

    public SiteDTO add(SiteDTO siteDTO) {
        Site site = SiteMapping.siteDTOToSite(siteDTO);
        site = siteRepository.save(site);
        return SiteMapping.siteToSiteDTO(site);
    }

    public SiteDTO update(SiteDTO siteDTO) {
        // Récupérer l'entité existante
        Site existingSite = siteRepository.findById(siteDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Site non trouvé"));

        // Mettre à jour les attributs de l'entité existante
        existingSite.setDesignation(siteDTO.getDesignation());

        existingSite = siteRepository.save(existingSite);
        return SiteMapping.siteToSiteDTO(existingSite);
    }

    public void deleteSite(Integer id) {
        siteRepository.deleteById(id);
    }
}
