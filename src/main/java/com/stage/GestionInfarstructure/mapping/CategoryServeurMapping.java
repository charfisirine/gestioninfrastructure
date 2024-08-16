package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.CategoryServeur;
import com.stage.GestionInfarstructure.dto.CategoryServeurDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class CategoryServeurMapping {

    // Convert CategoryServeurDTO to CategoryServeur
    public static CategoryServeur categoryServeurDTOToCategoryServeur(CategoryServeurDTO categoryServeurDTO) {  // Corrected method name
        if (categoryServeurDTO == null) {
            return null;
        }
        CategoryServeur categoryServeur = new CategoryServeur();
        categoryServeur.setId(categoryServeurDTO.getId());
        categoryServeur.setName(categoryServeurDTO.getName());
        categoryServeur.setDescription(categoryServeurDTO.getDescription());
        return categoryServeur;
    }

    // Convert CategoryServeur to CategoryServeurDTO
    public static CategoryServeurDTO categoryServeurToCategoryServeurDTO(CategoryServeur categoryServeur) {
        if (categoryServeur == null) {
            return null;
        }
        CategoryServeurDTO categoryServeurDTO = new CategoryServeurDTO();
        categoryServeurDTO.setId(categoryServeur.getId());
        categoryServeurDTO.setName(categoryServeur.getName());
        categoryServeurDTO.setDescription(categoryServeur.getDescription());
        return categoryServeurDTO;
    }

    // Convert Collection<CategoryServeur> to Collection<CategoryServeurDTO>
    public static Collection<CategoryServeurDTO> categoryServeursToCategoryServeurDTOs(Collection<CategoryServeur> categoryServeurs) {
        return categoryServeurs.stream()
                .map(CategoryServeurMapping::categoryServeurToCategoryServeurDTO)
                .collect(Collectors.toList());
    }
}
