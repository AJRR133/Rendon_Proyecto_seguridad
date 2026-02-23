package acceso.myshop.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.myshop.models.Equipo;

@Repository
public interface EquipoRepositorio extends JpaRepository<Equipo, Long> { 
	
	   List<Equipo> findAll();
	   public Equipo findByNombre(String nombre);
	   Set<Equipo> findByRegion(String region);


}
