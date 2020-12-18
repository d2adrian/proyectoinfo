package com.informatorio.myblog.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)

    @Size(min = 4)
    private String title;
    
    @Column(nullable = false)

    @Size(min = 4)
    private String descripcion;
     
    @Column(nullable = false)

    @Size(min = 4)
    private String contenido;
     
    @Column(nullable = false)
 
    @Size(min = 4)
    private String fecha;
     
    @Column(nullable = false)

    @Size(min = 4)
    private String autor;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPublicado(String publicado) {
        this.publicado = publicado;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public String getAutor() {
        return autor;
    }

    public String getPublicado() {
        return publicado;
    }
     
    @Column(nullable = false)

    @Size(min = 4)
    private String publicado; 
     

 
}
