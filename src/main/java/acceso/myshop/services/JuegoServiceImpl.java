package acceso.myshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acceso.myshop.models.Juego;
import acceso.myshop.repositories.JuegoRepositorio;
@Service
public class JuegoServiceImpl implements JuegoService{
	@Autowired
	private JuegoRepositorio repo;
	@Override
	public List<Juego> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Juego findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return repo.findByNombre(nombre);
	}

}
