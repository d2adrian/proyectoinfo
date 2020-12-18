package com.informatorio.myblog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.TimeZone;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    

   
    
    @Column(nullable = false)
 
    @Size(min = 3)
    private String name;
    
    @Column(nullable = false)
  
    @Size(min = 3)
    private String apellido;
    
    @Column(nullable = false)
   
    @Size(min = 3)
    private String email;
    
    @Column(nullable = false)
  
    @Size(min = 8)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
   
    @Column(updatable = false)
   @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdDate;

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate registDate) {
        this.createdDate = registDate;
    }

  

   
    
    @Column(nullable = false)
  
    @Size(min = 3)
    private String ciudad;
     
    @Column(nullable = false)

    @Size(min = 3)
    private String provincia;
     
    @Column(nullable = false)

    @Size(min = 3)
    private String pais;

    public void setId(Long id) {
        this.id = id;
    }

  

    public void setName(String Name) {
        this.name = Name;
    }

    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

  

    public String getName() {
        return name;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

   

    public String getCiudad() {
        return ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getPais() {
        return pais;
    
    }
    
}
    
        
