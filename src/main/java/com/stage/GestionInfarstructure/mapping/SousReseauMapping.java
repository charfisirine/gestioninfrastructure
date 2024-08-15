package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.Reseau;
import com.stage.GestionInfarstructure.domain.SousReseau;
import com.stage.GestionInfarstructure.dto.SousReseauDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class SousReseauMapping {
    public static SousReseau sousReseauDTOTOSousReseau(SousReseauDTO sousReseauDTO) {
        SousReseau sousReseau = new SousReseau();
        sousReseau.setIdSousReseau(sousReseauDTO.getIdSousReseau());
        sousReseau.setCIDRnotation(sousReseauDTO.getCIDRnotation());
        sousReseau.setMasqueSousReseau(sousReseauDTO.getMasqueSousReseau());
        sousReseau.setIpRange(sousReseauDTO.getIpRange());
        sousReseau.setGateway(sousReseauDTO.getGateway());

        if (sousReseauDTO.getIdReseau() != null) {
            Reseau reseau = new Reseau();
            reseau.setIdReseau(sousReseauDTO.getIdReseau());
            sousReseau.setReseau(reseau);
        }


        return sousReseau;
    }

    public static SousReseauDTO sousReseauTOSousReseauDTO(SousReseau sousReseau) {
        if (sousReseau != null) {
            SousReseauDTO sousReseauDTO = new SousReseauDTO();
            sousReseauDTO.setIdSousReseau(sousReseau.getIdSousReseau());
            sousReseauDTO.setCIDRnotation(sousReseau.getCIDRnotation());
            sousReseauDTO.setMasqueSousReseau(sousReseau.getMasqueSousReseau());
            sousReseauDTO.setIpRange(sousReseau.getIpRange());
            sousReseauDTO.setGateway(sousReseau.getGateway());

            if (sousReseau.getReseau() != null) {
                sousReseauDTO.setIdReseau(sousReseau.getReseau().getIdReseau());
            }


            return sousReseauDTO;
        } else {
            return null;
        }
    }

    public static List<SousReseauDTO> sousReseausToSousReseauDTOs(Collection<SousReseau> sousReseaus) {
        List<SousReseauDTO> sousReseauDTOs = new ArrayList<>();
        for (SousReseau stock : sousReseaus) {
            SousReseauDTO stockDTO = sousReseauTOSousReseauDTO(stock);
            sousReseauDTOs.add(stockDTO);
        }
        return sousReseauDTOs;
    }


}






