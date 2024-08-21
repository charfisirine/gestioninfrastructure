package com.stage.GestionInfarstructure.service;

import com.stage.GestionInfarstructure.domain.CategoryServeur;
import com.stage.GestionInfarstructure.dto.CategoryServeurDTO;
import com.stage.GestionInfarstructure.mapping.CategoryServeurMapping;
import com.stage.GestionInfarstructure.repository.CategoryServeurRepository;
import jakarta.persistence.EntityNotFoundException;
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
        // Récupérer l'entité existante
        CategoryServeur existingCategoryServeur = categoryServeurRepository.findById(categoryServeurDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("CategoryServeur non trouvé"));

        // Mettre à jour les attributs de l'entité existante
        existingCategoryServeur.setName(categoryServeurDTO.getName());
        existingCategoryServeur.setDescription(categoryServeurDTO.getDescription());
        // Conserver les autres attributs ou gérer la logique nécessaire ici

        // Enregistrer les modifications
        existingCategoryServeur = categoryServeurRepository.save(existingCategoryServeur);

        // Convertir l'entité mise à jour en DTO
        return CategoryServeurMapping.categoryServeurToCategoryServeurDTO(existingCategoryServeur);
    }


    public void deleteCategoryServeur(Integer id) {
        categoryServeurRepository.deleteById(id);
    }
}
