package mx.edu.uacm.progweb.crudsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import mx.edu.uacm.progweb.crudsecurity.dominio.Usuario;
import mx.edu.uacm.progweb.crudsecurity.repository.UsuarioRepository;
import mx.edu.uacm.progweb.crudsecurity.service.MiUsuarioDetails;

public class UsuarioDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String nombreDeUsuario) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioRepository.getUserByUsername(nombreDeUsuario);

		if (usuario == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new MiUsuarioDetails(usuario);
	}

}
