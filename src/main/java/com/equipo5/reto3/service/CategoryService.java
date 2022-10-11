package com.equipo5.reto3.service;

import com.equipo5.reto3.entities.Category;
import com.equipo5.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save (Category category) {
        if(category.getId()== null) {
            if(category.getName().length()<=45 && category.getDescription().length()<=250) {
                return categoryRepository.save(category);
            } else {
                return  category;
            }
        } else {
            Optional<Category> categoryFound = categoryRepository.getCategory(category.getId());
            if(categoryFound.isEmpty()){
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

//    public Category update (Category category) {
//        if(category.getId() != null) {
//            Optional<Category> categoryFound = categoryRepository.getCategory(category.getId());
//            if(!categoryFound.isEmpty()) {
//                if(category.getDescription() != null){
//                    categoryFound.get().setDescription(category.getDescription());
//                }
//                if(category.getName() != null){
//                    categoryFound.get().setName(category.getName());
//                }
//                return categoryRepository.save(categoryFound.get());
//            }
//        }
//        return category;
//    }

//    public boolean delete(int id) {
//        Boolean resultado = getCategory(id).map(element -> {
//            categoryRepository.delete(element);
//            return true;
//        }).orElse(false);
//        return resultado;
//    }



}
