package br.com.elmoxarifado.controller;

import br.com.elmoxarifado.model.Usuario;
import br.com.elmoxarifado.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge= 3600)
@RestController
public class LoginController {
   
    @Autowired
    UsuarioService usuarioService;
    
    @CrossOrigin
    @RequestMapping(method=RequestMethod.POST, value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {        
        usuarioService.verificarUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.CREATED);   
    } 
}
