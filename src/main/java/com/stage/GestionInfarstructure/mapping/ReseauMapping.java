package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.Reseau;
import com.stage.GestionInfarstructure.domain.Serveur;
import com.stage.GestionInfarstructure.domain.SousReseau;
import com.stage.GestionInfarstructure.dto.ReseauDTO;
import com.stage.GestionInfarstructure.dto.ServeurDTO;
import com.stage.GestionInfarstructure.dto.SiteDTO;
import com.stage.GestionInfarstructure.dto.SousReseauDTO;
import com.stage.GestionInfarstructure.mapping.SiteMapping; // Ajoutez cette importation

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReseauMapping {

    public static Reseau reseauDTOTOReseau(ReseauDTO reseauDTO) {
        Reseau reseau = new Reseau();
        reseau.setIdReseau(reseauDTO.getIdReseau());
        reseau.setName(reseauDTO.getName());

        // Validate ipRange before setting it
        if (isValidIpRange(reseauDTO.getIpRange())) {
            reseau.setIpRange(reseauDTO.getIpRange());
        } else {
            throw new IllegalArgumentException("Invalid IP range format.");
        }

        reseau.setTypeReseau(reseauDTO.getTypeReseau());

        // Handle sous-reseaux
        Collection<SousReseau> sousreseaux = new ArrayList<>();
        for (SousReseauDTO sousReseauDTO : reseauDTO.getSousReseaux()) {
            SousReseau sousreseau = SousReseauMapping.sousReseauDTOTOSousReseau(sousReseauDTO);
            sousreseaux.add(sousreseau);
            sousreseau.setReseau(reseau);
        }
        reseau.setSousReseaux(sousreseaux);

        // Handle site
        if (reseauDTO.getSite() != null) {
            reseau.setSite(SiteMapping.siteDTOToSite(reseauDTO.getSite()));
        }

        return reseau;
    }

    // Add the isValidIpRange method here
    public static boolean isValidIpRange(String ipRange) {
        String ipPattern = "^([0-9]{1,3}\\.){3}[0-9]{1,3}(\\/([1-9]|[1-2][0-9]|3[0-2]))?$";
        return ipRange != null && ipRange.matches(ipPattern);
    }


    public static ReseauDTO reseauTOreseauDTO(Reseau reseau) {
        if (reseau != null) {
            ReseauDTO reseauDTO = new ReseauDTO();
            reseauDTO.setIdReseau(reseau.getIdReseau());
            reseauDTO.setName(reseau.getName());
            reseauDTO.setIpRange(reseau.getIpRange());
            reseauDTO.setTypeReseau(reseau.getTypeReseau());
            reseauDTO.setSousReseaux(SousReseauMapping.sousReseausToSousReseauDTOs(reseau.getSousReseaux()));

            // Mapper le site
            if (reseau.getSite() != null) {
                reseauDTO.setSite(SiteMapping.siteToSiteDTO(reseau.getSite())); // Mapper le site
            }

            return reseauDTO;
        } else {
            return null;
        }
    }

    public static ReseauDTO lazyReseauTOreseauDTO(Reseau reseau) {
        if (reseau != null) {
            ReseauDTO reseauDTO = new ReseauDTO();
            reseauDTO.setIdReseau(reseau.getIdReseau());
            reseauDTO.setName(reseau.getName());
            reseauDTO.setIpRange(reseau.getIpRange());
            reseauDTO.setTypeReseau(reseau.getTypeReseau());

            if (reseau.getSite() != null) {
                SiteDTO siteDTO = new SiteDTO();
                siteDTO.setId(reseau.getSite().getId());
                siteDTO.setDesignation(reseau.getSite().getDesignation());
                reseauDTO.setSite(siteDTO);
            } else {
                reseauDTO.setSite(null);
            }

            if (reseau.getSousReseaux() != null && !reseau.getSousReseaux().isEmpty()) {
                List<SousReseauDTO> sousReseauxDTOs = new ArrayList<>();
                for (SousReseau sousReseau : reseau.getSousReseaux()) {
                    SousReseauDTO sousReseauDTO = new SousReseauDTO();
                    sousReseauDTO.setIdSousReseau(sousReseau.getIdSousReseau());
                    sousReseauDTO.setIdReseau(sousReseau.getIdReseau());
                    sousReseauDTO.setIpRange(sousReseau.getIpRange());
                    sousReseauDTO.setGateway(sousReseau.getGateway());
                    sousReseauDTO.setCIDRnotation(sousReseau.getCIDRnotation());
                    sousReseauDTO.setMasqueSousReseau(sousReseau.getMasqueSousReseau());
                    if (sousReseau.getServeurs() != null && !sousReseau.getServeurs().isEmpty()) {
                        List<ServeurDTO> serveurDTOs = new ArrayList<>();
                        for (Serveur serveur : sousReseau.getServeurs()) {
                            ServeurDTO serveurDTO = new ServeurDTO();
                            serveurDTO.setServeurId(serveur.getServeurId());
                            serveurDTO.setHostName(serveur.getHostName());
                            serveurDTO.setAdresseIp(serveur.getAddressIp());
                            serveurDTOs.add(serveurDTO);
                        }
                        sousReseauDTO.setServeurs(serveurDTOs);
                    } else {
                        sousReseauDTO.setServeurs(Collections.emptyList());
                    }
                    sousReseauxDTOs.add(sousReseauDTO);
                }
                reseauDTO.setSousReseaux(sousReseauxDTOs);
            } else {
                reseauDTO.setSousReseaux(Collections.emptyList());
            }

            return reseauDTO;
        } else {
            return null;
        }
    }

    public static Collection<ReseauDTO> reseausToSousReseauDTOs(Collection<Reseau> reseaus) {
        List<ReseauDTO> reseauDTOs = new ArrayList<>();
        for (Reseau reseau : reseaus) {
            ReseauDTO reseauDTO = lazyReseauTOreseauDTO(reseau);
            reseauDTOs.add(reseauDTO);
        }
        return reseauDTOs;
    }
}
