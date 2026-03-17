package acceso.myshop.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import acceso.myshop.models.Usuario;
import acceso.myshop.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
   public UserDetails loadUserByUsername(String u) throws UsernameNotFoundException {
       Usuario usuario = usuarioRepository.findByUsuario(u);
       if (usuario == null) {
           throw new UsernameNotFoundException("Usuario no encontrado: " + u);
       }
       return new org.springframework.security.core.userdetails.User(usuario.getUsuario(), usuario.getClave(), new ArrayList<>());
   }
	@Override
	public boolean existsByNombre(String nombre) {
		return usuarioRepository.existsByUsuario(nombre);
	}
	public void saveUsuario(Usuario usuario) {
	    usuarioRepository.save(usuario);
	}
}
