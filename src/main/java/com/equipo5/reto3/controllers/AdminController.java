package com.equipo5.reto3.controllers;

import com.equipo5.reto3.entities.Admin;
import com.equipo5.reto3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //  /api/Admin/all para traerlos todos
    @GetMapping("/all")
    public List<Admin> getAll() {
        return adminService.getAll();
    }

// para traerlos por id
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int id){
        return adminService.getAdmin(id);
    }

    //el post la ruta es /api/Admin/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save (@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save1 (@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    //el put  la ruta es /api/Admin/update
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update (@RequestBody Admin admin) {
        return adminService.update(admin);
    }

    //para el delete la ruta es /api/Admin/delete
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable ("id") int id) {
        return adminService.deleteAdmin(id);
    }


}
