package acceso.myshop.services;

import java.util.List;

import acceso.myshop.models.Juego;

public interface JuegoService {
	List<Juego> findAll();
	   Juego findByNombre(String nombre);
	   

}
