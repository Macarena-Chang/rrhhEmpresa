package ar.com.ada.api.rrhh.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import org.hibernate.annotations.NaturalId;



@Entity
@Table(name = "empleado")
public class Empleado {

    //atributos
    @Id
    @Column(name = "empleado_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empleadoId;
    private String nombre; 
    private int edad; 
    private BigDecimal sueldo;
    private int estado; 
    
    private Categoria categoriaId; 
    //faltan 3




    
}