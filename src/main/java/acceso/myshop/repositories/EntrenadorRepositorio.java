package acceso.myshop.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.myshop.models.Entrenador;
@Repository
public interface EntrenadorRepositorio extends JpaRepository<Entrenador, Long> { 
	
	List<Entrenador> findAll();
	Set<Entrenador> findByNombre(String nombre);
	
}
