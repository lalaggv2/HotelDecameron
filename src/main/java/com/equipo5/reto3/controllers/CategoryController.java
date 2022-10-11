package com.equipo5.reto3.controllers;

import com.equipo5.reto3.entities.Category;
import com.equipo5.reto3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //  /api/Category/all para traerlos todos
    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

// para traerlos por id
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }

    //el post la ruta es /api/Category/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save (@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save1 (@RequestBody Category category) {
        return categoryService.save(category);
    }

//    //el put  la ruta es /api/Category/update
//    @PutMapping("/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Category update (@RequestBody Category category) {
//        return categoryService.update(category);
//    }

}
