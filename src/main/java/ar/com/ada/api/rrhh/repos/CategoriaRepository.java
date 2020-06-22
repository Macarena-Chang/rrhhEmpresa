package ar.com.ada.api.rrhh.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.rrhh.entities.Categoria;

//2do par <> debe ser un obj primary key(Integer)
//NO ESCRIBIREMOS METODOS PORQUE USAREMOS DIRECTAMENTE LOS DEL CRUDREPOSITORY
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    


}