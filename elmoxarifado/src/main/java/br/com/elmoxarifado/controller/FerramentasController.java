package br.com.elmoxarifado.controller;

import br.com.elmoxarifado.model.Ferramenta;
import br.com.elmoxarifado.model.Funcionario;
import br.com.elmoxarifado.service.FerramentaService;
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
@RequestMapping("/ferramentas")
public class FerramentasController {
   
    @Autowired
    FerramentaService ferramentaService;
    
    @RequestMapping(method=RequestMethod.POST, value="/cadastrar", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> cadastrar(@RequestBody Ferramenta ferramenta) {        
        return new ResponseEntity<>(ferramentaService.cadastrar(ferramenta), HttpStatus.CREATED);   
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/buscar")
    public ResponseEntity<Collection> buscar() {
        return new ResponseEntity<>(ferramentaService.buscar(), HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/buscarDisponiveis")
    public ResponseEntity<Collection> buscarDisponiveis() {
        return new ResponseEntity<>(ferramentaService.buscarDisponiveis(), HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/buscar/{codFerramenta}")
    public ResponseEntity<Ferramenta> buscar(@PathVariable int codFerramenta) {
        return new ResponseEntity<>(ferramentaService.buscar(codFerramenta), HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/editar")
    public ResponseEntity<Ferramenta> editar(@RequestBody Ferramenta ferramenta) {
        return new ResponseEntity<>(ferramentaService.editar(ferramenta), HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/deletar")
    public ResponseEntity<Ferramenta> deletar(@RequestBody Ferramenta ferramenta) {
        ferramentaService.deletar(ferramenta);
        return new ResponseEntity(HttpStatus.OK);
    }
    
}
