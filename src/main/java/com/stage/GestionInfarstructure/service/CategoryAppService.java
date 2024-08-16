package com.stage.GestionInfarstructure.service;

import com.stage.GestionInfarstructure.domain.CategoryApp;
import com.stage.GestionInfarstructure.dto.CategoryAppDTO;
import com.stage.GestionInfarstructure.mapping.CategoryAppMapping;
import com.stage.GestionInfarstructure.repository.CategoryAppRepository;
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
        CategoryApp categoryApp = CategoryAppMapping.categoryAppDTOToCategoryApp(categoryAppDTO);
        categoryApp = categoryAppRepository.save(categoryApp);
        return CategoryAppMapping.categoryAppToCategoryAppDTO(categoryApp);
    }

    public void deleteCategoryApp(Integer id) {
        categoryAppRepository.deleteById(id);
    }
}
