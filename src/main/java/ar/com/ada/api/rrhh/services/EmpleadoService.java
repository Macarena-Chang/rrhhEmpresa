package ar.com.ada.api.rrhh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.rrhh.entities.Empleado;
import ar.com.ada.api.rrhh.repos.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepo;

    public void crearEmpleado(Empleado empleado) {
        empleadoRepo.save(empleado);
    }

    public List<Empleado> listarEmpleados() {
        return empleadoRepo.findAll();
    }

    // metodo findById necesita un objeto de tipo Optional, porque ese es el tipo de
    // obj que devuelve.
    //si el optional esta presente devuelve el obj dentro del optional
    public Empleado traerEmpleadoPorId(int empleadoId){
        Optional<Empleado> optionalEmpleado = empleadoRepo.findById(empleadoId);
       
        if(optionalEmpleado.isPresent()){
            return optionalEmpleado.get();
        }
        return null; 
    }



}