package com.informatorio.myblog.controller;

import com.informatorio.myblog.model.Comment;
import com.informatorio.myblog.model.User;

import com.informatorio.myblog.repository.CommentRepository;
import com.informatorio.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    //private Map<Integer, String> postRepository = inicializarRepo();
    @Autowired
    private CommentRepository commentRepository;
     @Autowired
    private UserRepository userRepository;
    //GET Todos los POST
    @GetMapping // ~ /api/v1/user
    public ResponseEntity<?> getComment() {
        return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.OK);
        
    }
     @GetMapping("/comment/quantity/{num}") 
    public ResponseEntity<?> getCommentByQuantity(@PathVariable Integer num) {
        List<Comment> lista = commentRepository.findAll().subList(0,num);
        return new ResponseEntity<>(lista, HttpStatus.OK);
        
    }
 
   

    //POST Crear un POST
    @PostMapping("/{userId}/commemt")
    public ResponseEntity<?> createComment(@PathVariable Long userId,@RequestBody Comment comment) {
        User usuario = userRepository.findById(userId).get();
        comment.setAutor(usuario);
        return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.CREATED);
    }

    //PUT para modificar un POST segun ID
   

    //DELETE Borrar un Post segun el ID
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long postId) {
        Comment postDelete = commentRepository.getOne(postId);
        commentRepository.delete(postDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

   
}
