package ar.com.ada.api.rrhh.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.rrhh.entities.Categoria;
import ar.com.ada.api.rrhh.entities.Empleado;
import ar.com.ada.api.rrhh.repos.CategoriaRepository;

//CategoriaService funcion:  CREA CATEGORIA. LISTA CATEGORIA
@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepo ;

    //pasar un objeto categoria (entidad que queremos guardar para crear categoria
    public void crearCategoria(Categoria categoria){
        categoriaRepo.save(categoria); 
    }

    //devuelve una lista de categorias
    public List<Categoria> listarCategorias(){
        //este metodo devuelve una lista.
        return  categoriaRepo.findAll();     

    } 
    // optional.get() ---> devuelve objeto categoria
    // optional.get().getEmpleados --> podemos acceder a atributos de categoria
    public List<Empleado> buscarEmpleadosPorCat(int categoriaId){
       List <Empleado> lista = new ArrayList<>(); 
        Optional<Categoria> optional = categoriaRepo.findById(categoriaId);
        if(optional.isPresent()){
            return optional.get().getEmpleados();  
        }

        return lista;


    }

    public Categoria buscarCategoriaPorId (int categoriaId){
        Optional<Categoria> cOptional = categoriaRepo.findById(categoriaId);
        if(cOptional.isPresent()){
            return cOptional.get(); 
        }

        return null; 
    }

    

}