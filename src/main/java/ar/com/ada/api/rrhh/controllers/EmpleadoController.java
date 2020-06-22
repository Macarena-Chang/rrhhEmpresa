package ar.com.ada.api.rrhh.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.models.requests.InfoBasicaEmpleadoRequest;
import ar.com.ada.api.models.responses.GenericResponse;
import ar.com.ada.api.rrhh.entities.Empleado;
import ar.com.ada.api.rrhh.services.CategoriaService;
import ar.com.ada.api.rrhh.services.EmpleadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    CategoriaService categoriaService; 

    //en vez de devolverle todo el objeto empelado solo le devolvemos el empleadoId
    //pasamos atributos de obj info para crear un nuevo objeto empleado
    @PostMapping("/empleados")
    public ResponseEntity<?> crearEmpelados(@RequestBody InfoBasicaEmpleadoRequest info){
        Empleado empleado = new Empleado();
        empleado.setNombre(info.nombre);
        empleado.setEdad(info.edad);
        empleado.setSueldo(info.sueldo);
        empleado.setCategoria(categoriaService.buscarCategoriaPorId(info.categoriaId));
        empleado.setFechaAlta(new Date());
        empleado.setEstadoId(1);
        empleadoService.crearEmpleado(empleado);
      

          
        GenericResponse resp = new GenericResponse();
        resp.isOk = true;
        resp.id = empleado.getEmpleadoId();
        resp.message = "Empleado generado con exito";

        return ResponseEntity.ok(resp);


    }

    @GetMapping("/empleados")
    public ResponseEntity<?> listarEmpleados() {
       
        return ResponseEntity.ok(empleadoService.listarEmpleados()); 
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<?> buscarEmpleadoPorId(@PathVariable int id){

        Empleado empleado = empleadoService.traerEmpleadoPorId(id);

    
        if (empleado != null) {
            return ResponseEntity.ok(empleado);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    

    
}