package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.CategoryApp;
import com.stage.GestionInfarstructure.dto.CategoryAppDTO;

public class CategoryAppMapping {

    // Convert CategoryAppDTO to CategoryApp
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

    // Convert CategoryApp to CategoryAppDTO
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
}
