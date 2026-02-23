package acceso.myshop.services;

import java.util.List;
import java.util.Set;

import acceso.myshop.models.Equipo;

public interface EquipoService {

	 List<Equipo> findAll();
	 public Equipo findByNombre(String nombre);
	 Set<Equipo> findByRegion(String region);
	 public Equipo createEquipo(Equipo equipo);
	 public void deleteEquipo(Equipo equipo);
	 public Equipo updateregionEquipo(String nombre, Equipo equipo);
	 
}
