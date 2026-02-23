package acceso.myshop.services;

import java.util.List;
import java.util.Set;

import acceso.myshop.models.Entrenador;

public interface EntrenadorService {

	List<Entrenador> findAll();
	Set<Entrenador> findByNombre(String nombre);
	public Entrenador createEntrenador(Entrenador e);
	public Entrenador findEntrenadorById(long id);
	public Entrenador updatenameEntrenador(long id, Entrenador entrenador);
}
