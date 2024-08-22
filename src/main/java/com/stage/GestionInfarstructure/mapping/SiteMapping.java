package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.Site;
import com.stage.GestionInfarstructure.dto.SiteDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class SiteMapping {

    // Convertir SiteDTO en Site
    public static Site siteDTOToSite(SiteDTO siteDTO) {
        if (siteDTO == null) {
            return null;
        }
        Site site = new Site();
        site.setId(siteDTO.getId());
        site.setDesignation(siteDTO.getDesignation());
        return site;
    }

    // Convertir Site en SiteDTO
    public static SiteDTO siteToSiteDTO(Site site) {
        if (site == null) {
            return null;
        }
        SiteDTO siteDTO = new SiteDTO();
        siteDTO.setId(site.getId());
        siteDTO.setDesignation(site.getDesignation());
        return siteDTO;
    }

    // Convertir une Collection de Site en Collection de SiteDTO
    public static Collection<SiteDTO> sitesToSiteDTOs(Collection<Site> sites) {
        if (sites == null) {
            return null;
        }
        return sites.stream()
                .map(SiteMapping::siteToSiteDTO)
                .collect(Collectors.toList());
    }
}
