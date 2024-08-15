package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.Reseau;
import com.stage.GestionInfarstructure.domain.SousReseau;
import com.stage.GestionInfarstructure.dto.ReseauDTO;
import com.stage.GestionInfarstructure.dto.SousReseauDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class ReseauMapping {
    public static Reseau reseauDTOTOReseau(ReseauDTO reseauDTO) {
        Reseau reseau = new Reseau();
        reseau.setIdReseau(reseauDTO.getIdReseau());
        reseau.setName(reseauDTO.getName());
        reseau.setIpRange(reseauDTO.getIpRange());
        reseau.setTypeReseau(reseauDTO.getTypeReseau());

        Collection<SousReseau> sousreseaus = new ArrayList<>();
        for (SousReseauDTO sousReseauDTO : reseauDTO.getSousReseaux()) {
            SousReseau sousreseau = SousReseauMapping.sousReseauDTOTOSousReseau(sousReseauDTO);
            sousreseaus.add(sousreseau);
            sousreseau.setReseau(reseau);
        }
        reseau.setSousReseaux(sousreseaus);
        return reseau;
    }

    public static ReseauDTO reseauTOreseauDTO(Reseau reseau) {
        if (reseau != null) {
            ReseauDTO reseauDTO = new ReseauDTO();
            reseauDTO.setIdReseau(reseau.getIdReseau());
            reseauDTO.setName(reseau.getName());
            reseauDTO.setIpRange(reseau.getIpRange());
            reseauDTO.setTypeReseau(reseau.getTypeReseau());
            reseauDTO.setSousReseaux(SousReseauMapping.sousReseausToSousReseauDTOs(reseau.getSousReseaux()));
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









