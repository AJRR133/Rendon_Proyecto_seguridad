package acceso.myshop.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acceso.myshop.models.Equipo;
import acceso.myshop.repositories.EquipoRepositorio;

@Service
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	private EquipoRepositorio repoequipo; 
	
	@Override
	public List<Equipo> findAll() {
		// TODO Auto-generated method stub
		return repoequipo.findAll();
	}

	@Override
	public Equipo findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return repoequipo.findByNombre(nombre);
	}

	@Override
	public Set<Equipo> findByRegion(String region) {
		// TODO Auto-generated method stub
		return repoequipo.findByRegion(region);
	}

	@Override
	public Equipo createEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		return repoequipo.save(equipo);
	}

	@Override
	public void deleteEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		 repoequipo.delete(equipo);
	}

	@Override
	public Equipo updateregionEquipo(String nombre, Equipo equipo) {
		// TODO Auto-generated method stub
		Equipo equi1 = this.findByNombre(nombre);
		equi1.setNombre(equipo.getNombre());
		return repoequipo.save(equipo);
	}

	
}
