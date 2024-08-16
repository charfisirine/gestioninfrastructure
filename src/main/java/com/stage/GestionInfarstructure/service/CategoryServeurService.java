package com.stage.GestionInfarstructure.service;

import com.stage.GestionInfarstructure.domain.CategoryServeur;
import com.stage.GestionInfarstructure.dto.CategoryServeurDTO;
import com.stage.GestionInfarstructure.mapping.CategoryServeurMapping;
import com.stage.GestionInfarstructure.repository.CategoryServeurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class CategoryServeurService {

    private final CategoryServeurRepository categoryServeurRepository;

    public CategoryServeurService(CategoryServeurRepository categoryServeurRepository) {
        this.categoryServeurRepository = categoryServeurRepository;
    }

    @Transactional(readOnly = true)
    public CategoryServeurDTO findOne(Integer id) {
        CategoryServeur categoryServeur = categoryServeurRepository.findById(id).orElse(null);
        return CategoryServeurMapping.categoryServeurToCategoryServeurDTO(categoryServeur);
    }

    @Transactional(readOnly = true)
    public Collection<CategoryServeurDTO> findAll() {
        Collection<CategoryServeur> categoryServeurs = categoryServeurRepository.findAll();
        return CategoryServeurMapping.categoryServeursToCategoryServeurDTOs(categoryServeurs);
    }

    public CategoryServeurDTO add(CategoryServeurDTO categoryServeurDTO) {
        CategoryServeur categoryServeur = CategoryServeurMapping.categoryServeurDTOToCategoryServeur(categoryServeurDTO);  // Corrected method name
        categoryServeur = categoryServeurRepository.save(categoryServeur);
        return CategoryServeurMapping.categoryServeurToCategoryServeurDTO(categoryServeur);
    }

    public CategoryServeurDTO update(CategoryServeurDTO categoryServeurDTO) {
        CategoryServeur categoryServeur = CategoryServeurMapping.categoryServeurDTOToCategoryServeur(categoryServeurDTO);  // Corrected method name
        categoryServeur = categoryServeurRepository.save(categoryServeur);
        return CategoryServeurMapping.categoryServeurToCategoryServeurDTO(categoryServeur);
    }

    public void deleteCategoryServeur(Integer id) {
        categoryServeurRepository.deleteById(id);
    }
}
