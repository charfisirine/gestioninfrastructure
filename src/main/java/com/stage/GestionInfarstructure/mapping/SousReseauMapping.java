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

        if (!isValidIpRange(sousReseauDTO.getIpRange())) {
            throw new IllegalArgumentException("Invalid IP Range format");
        }

        if (!isValidIpAddress(sousReseauDTO.getGateway())) {
            throw new IllegalArgumentException("Invalid Gateway format");
        }

        if (!isValidIpAddress(sousReseauDTO.getMasqueSousReseau())) {
            throw new IllegalArgumentException("Invalid Subnet Mask format");
        }

        if (!isValidCIDRNotation(sousReseauDTO.getCIDRnotation())) {
            throw new IllegalArgumentException("Invalid CIDR notation format");
        }

        sousReseau.setIdSousReseau(sousReseauDTO.getIdSousReseau());
        sousReseau.setCIDRnotation(sousReseauDTO.getCIDRnotation());
        sousReseau.setMasqueSousReseau(sousReseauDTO.getMasqueSousReseau());
        sousReseau.setIpRange(sousReseauDTO.getIpRange());
        sousReseau.setGateway(sousReseauDTO.getGateway());

        // Handling the association with Reseau
        if (sousReseauDTO.getIdReseau() != null) {
            Reseau reseau = new Reseau();
            reseau.setIdReseau(sousReseauDTO.getIdReseau());
            sousReseau.setReseau(reseau);
        }

        return sousReseau;
    }

    private static boolean isValidIpRange(String ipRange) {
        String ipPattern = "^([0-9]{1,3}\\.){3}[0-9]{1,3}(\\/([1-9]|[1-2][0-9]|3[0-2]))?$";
        return ipRange != null && ipRange.matches(ipPattern);
    }

    private static boolean isValidIpAddress(String ipAddress) {
        String ipPattern = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$";
        return ipAddress != null && ipAddress.matches(ipPattern);
    }

    private static boolean isValidCIDRNotation(String cidrNotation) {
        String cidrPattern = "^([0-9]{1,3}\\.){3}[0-9]{1,3}\\/([1-9]|[1-2][0-9]|3[0-2])$";
        return cidrNotation != null && cidrNotation.matches(cidrPattern);
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
        for (SousReseau sousReseau : sousReseaus) {
            SousReseauDTO sousReseauDTO = sousReseauTOSousReseauDTO(sousReseau);
            sousReseauDTOs.add(sousReseauDTO);
        }
        return sousReseauDTOs;
    }
}
