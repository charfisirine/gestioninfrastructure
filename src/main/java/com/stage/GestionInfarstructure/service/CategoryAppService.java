package com.stage.GestionInfarstructure.service;

import com.stage.GestionInfarstructure.domain.CategoryApp;
import com.stage.GestionInfarstructure.dto.CategoryAppDTO;
import com.stage.GestionInfarstructure.mapping.CategoryAppMapping;
import com.stage.GestionInfarstructure.repository.CategoryAppRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class CategoryAppService {

    private final CategoryAppRepository categoryAppRepository;

    public CategoryAppService(CategoryAppRepository categoryAppRepository) {
        this.categoryAppRepository = categoryAppRepository;
    }

    @Transactional(readOnly = true)
    public CategoryAppDTO findOne(Integer id) {
        CategoryApp categoryApp = categoryAppRepository.findById(id).orElse(null);
        return CategoryAppMapping.categoryAppToCategoryAppDTO(categoryApp);
    }

    @Transactional(readOnly = true)
    public Collection<CategoryAppDTO> findAll() {
        Collection<CategoryApp> categoryApps = categoryAppRepository.findAll();
        return CategoryAppMapping.categoryAppsToCategoryAppDTOs(categoryApps);
    }

    public CategoryAppDTO add(CategoryAppDTO categoryAppDTO) {
        CategoryApp categoryApp = CategoryAppMapping.categoryAppDTOToCategoryApp(categoryAppDTO);
        categoryApp = categoryAppRepository.save(categoryApp);
        return CategoryAppMapping.categoryAppToCategoryAppDTO(categoryApp);
    }

    public CategoryAppDTO update(CategoryAppDTO categoryAppDTO) {
        // Récupérer l'entité existante
        CategoryApp existingCategoryApp = categoryAppRepository.findById(categoryAppDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("CategoryApp non trouvé"));

        // Mettre à jour les attributs de l'entité existante
        existingCategoryApp.setName(categoryAppDTO.getName());
        existingCategoryApp.setDescription(categoryAppDTO.getDescription());
        // Conserver les applications existantes
        // Si vous souhaitez gérer les applications, ajoutez ici la logique nécessaire

        existingCategoryApp = categoryAppRepository.save(existingCategoryApp);
        return CategoryAppMapping.categoryAppToCategoryAppDTO(existingCategoryApp);
    }


    public void deleteCategoryApp(Integer id) {
        categoryAppRepository.deleteById(id);
    }
}
