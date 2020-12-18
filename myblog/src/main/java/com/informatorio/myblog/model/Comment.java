package com.informatorio.myblog.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  
    
   
   @ManyToOne
   @JoinColumn(referencedColumnName = "id")
   private User autor;
     
    @Column(nullable = false)
  
    @Size(min = 4)
    private String fecha;
     
    @Column(nullable = false)
   
    @Size(min = 4)
    private String comentario; 

    public void setId(Long id) {
        this.id = id;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }

    public User getAutor() {
        return autor;
    }

    
    

  


  


    

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

 

  

    public String getFecha() {
        return fecha;
    }

    public String getComentario() {
        return comentario;
    }
 
}