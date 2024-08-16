package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.CategoryServeur;
import com.stage.GestionInfarstructure.dto.CategoryServeurDTO;

public class CategoryServeurMapping {

    // Convert CategoryServeurDTO to CategoryServeur
    public static CategoryServeur categoryServeurDTOTOCategoryServeur(CategoryServeurDTO categoryServeurDTO) {
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
    public static CategoryServeurDTO categoryServeurTOCategoryServeurDTO(CategoryServeur categoryServeur) {
        if (categoryServeur == null) {
            return null;
        }
        CategoryServeurDTO categoryServeurDTO = new CategoryServeurDTO();
        categoryServeurDTO.setId(categoryServeur.getId());
        categoryServeurDTO.setName(categoryServeur.getName());
        categoryServeurDTO.setDescription(categoryServeur.getDescription());
        return categoryServeurDTO;
    }
}
