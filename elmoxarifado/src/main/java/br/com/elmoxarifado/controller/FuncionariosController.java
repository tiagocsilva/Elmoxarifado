package br.com.elmoxarifado.controller;

import br.com.elmoxarifado.model.Ferramenta;
import br.com.elmoxarifado.model.Funcionario;
import br.com.elmoxarifado.service.FuncionarioService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge= 3600)
@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {
   
    @Autowired
    FuncionarioService funcionarioService;
    
    @CrossOrigin
    @RequestMapping(method=RequestMethod.POST, value="/cadastrar", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> cadastrar(@RequestBody Funcionario funcionario) {        
        return new ResponseEntity<>("\"" + funcionarioService.cadastrar(funcionario) + "\"", HttpStatus.CREATED);   
    }   
    
    @RequestMapping(method=RequestMethod.GET, value="/buscar")
    public ResponseEntity<Collection> buscar() {
        return new ResponseEntity<>(funcionarioService.buscar(), HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/buscar/{matricula}")
    public ResponseEntity<Funcionario> buscar(@PathVariable int matricula) {
        return new ResponseEntity<>(funcionarioService.buscar(matricula), HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/editar")
    public ResponseEntity<Funcionario> editar(@RequestBody Funcionario funcionario) {
        return new ResponseEntity<>(funcionarioService.editar(funcionario), HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/resetarSenha")
    public ResponseEntity<String> resetarSenha(@RequestBody Funcionario funcionario) {        
        return new ResponseEntity<>("\"" + funcionarioService.resetarSenha(funcionario) + "\"", HttpStatus.OK);           
    }    
}
