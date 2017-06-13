package br.com.elmoxarifado.service;

import br.com.elmoxarifado.DAO.UsuarioDAO;
import br.com.elmoxarifado.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {    
    
    UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();

    public boolean verificarUsuario(Usuario usuario) {               
        return usuarioDAO.verificarUsuario(usuario);
    }      
}
