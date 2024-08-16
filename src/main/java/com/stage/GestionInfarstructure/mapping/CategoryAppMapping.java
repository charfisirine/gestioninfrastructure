package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.CategoryApp;
import com.stage.GestionInfarstructure.dto.CategoryAppDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class CategoryAppMapping {

    // Convertir CategoryAppDTO en CategoryApp
    public static CategoryApp categoryAppDTOToCategoryApp(CategoryAppDTO categoryAppDTO) {
        if (categoryAppDTO == null) {
            return null;
        }
        CategoryApp categoryApp = new CategoryApp();
        categoryApp.setId(categoryAppDTO.getId());
        categoryApp.setName(categoryAppDTO.getName());
        categoryApp.setDescription(categoryAppDTO.getDescription());
        return categoryApp;
    }

    // Convertir CategoryApp en CategoryAppDTO
    public static CategoryAppDTO categoryAppToCategoryAppDTO(CategoryApp categoryApp) {
        if (categoryApp == null) {
            return null;
        }
        CategoryAppDTO categoryAppDTO = new CategoryAppDTO();
        categoryAppDTO.setId(categoryApp.getId());
        categoryAppDTO.setName(categoryApp.getName());
        categoryAppDTO.setDescription(categoryApp.getDescription());
        return categoryAppDTO;
    }

    // Convertir une Collection de CategoryApp en Collection de CategoryAppDTO
    public static Collection<CategoryAppDTO> categoryAppsToCategoryAppDTOs(Collection<CategoryApp> categoryApps) {
        if (categoryApps == null) {
            return null;
        }
        return categoryApps.stream()
                .map(CategoryAppMapping::categoryAppToCategoryAppDTO)
                .collect(Collectors.toList());
    }
}
