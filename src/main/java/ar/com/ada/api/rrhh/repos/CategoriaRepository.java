package ar.com.ada.api.rrhh.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.rrhh.entities.Categoria;

//2do par <> debe ser un obj primary key(Integer)
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
}