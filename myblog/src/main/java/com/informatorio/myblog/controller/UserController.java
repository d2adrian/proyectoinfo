package com.informatorio.myblog.controller;

import com.informatorio.myblog.model.Post;
import com.informatorio.myblog.model.User;
import com.informatorio.myblog.repository.PostRepository;
import com.informatorio.myblog.repository.UserRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    //private Map<Integer, String> postRepository = inicializarRepo();
    @Autowired
    private UserRepository userRepository;

    //GET Todos los POST
    @GetMapping 
    public ResponseEntity<?> getUser() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
    
     @GetMapping("/dateFilter/{date}")
    public List<User> getUserDate(@PathVariable(value = "date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return userRepository.findAllByCreatedDateIsAfter(date);
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        return new ResponseEntity<>(userRepository.findById(userId), HttpStatus.OK);
    }
    
    @GetMapping("/filtro/{ciudad}")
    public List<User> getAllUserCiudad(@PathVariable(value = "ciudad")String ciudad) {
        return userRepository.findAllByCiudad(ciudad);
    }

    //POST Crear un POST

    /**
     *
     * @param usuario
     * @return
     */
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User usuario) {
        return new ResponseEntity<>(userRepository.save(usuario), HttpStatus.CREATED);
    }

    //PUT para modificar un POST segun ID
    @PutMapping("/{userId}")
     public ResponseEntity<?> editUser(@PathVariable  Long userId, @RequestBody User usuario) {
        User userEdit = userRepository.findById(userId).get();
        userEdit.setName(usuario.getName());
        userEdit.setApellido(usuario.getApellido());
        userEdit.setEmail(usuario.getEmail());
        userEdit.setPassword(usuario.getPassword());
        userEdit.setCiudad(usuario.getCiudad());
        userEdit.setProvincia(usuario.getProvincia());
         userEdit.setPais(usuario.getPais());
        return new ResponseEntity<>(userRepository.save(userEdit), HttpStatus.OK);
        
    }
   

    //DELETE Borrar un Post segun el ID
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long postId) {
        User postDelete = userRepository.getOne(postId);
        userRepository.delete(postDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
}
