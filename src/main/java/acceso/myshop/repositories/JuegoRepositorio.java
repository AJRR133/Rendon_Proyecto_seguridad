package acceso.myshop.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.myshop.models.Juego;
@Repository
public interface JuegoRepositorio extends JpaRepository<Juego, Long> { 
	
	   List<Juego> findAll();
	   Juego findByNombre(String nombre);
	   


}