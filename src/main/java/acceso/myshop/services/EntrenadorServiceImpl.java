package acceso.myshop.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acceso.myshop.models.Entrenador;
import acceso.myshop.repositories.EntrenadorRepositorio;
import exceptions.EntrenadorNotFoundException;
@Service
public class EntrenadorServiceImpl implements EntrenadorService {
	@Autowired
	private EntrenadorRepositorio repoentre;
	
	@Override
	public List<Entrenador> findAll() {
		// TODO Auto-generated method stub
		return repoentre.findAll();
	}

	@Override
	public Set<Entrenador> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return repoentre.findByNombre(nombre);
	}

	@Override
	public Entrenador createEntrenador(Entrenador e) {
		// TODO Auto-generated method stub
		return repoentre.save(e);
	}

	@Override
	public Entrenador findEntrenadorById(long id) {
		// TODO Auto-generated method stub
		Optional<Entrenador> entrenadoropt = repoentre.findById(id);
		return entrenadoropt.orElseThrow(() -> new EntrenadorNotFoundException(id));
	}

	@Override
	public Entrenador updatenameEntrenador(long id, Entrenador entrenador) {
		// TODO Auto-generated method stub
		Entrenador ent = this.findEntrenadorById(id);
		ent.setNombre(entrenador.getNombre());
		return repoentre.save(ent);
	}

}
