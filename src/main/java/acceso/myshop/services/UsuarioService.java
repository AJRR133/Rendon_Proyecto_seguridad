package acceso.myshop.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import acceso.myshop.models.Usuario;

public interface UsuarioService {
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	public boolean existsByNombre(String nombre);
	public void saveUsuario(Usuario u);
}

