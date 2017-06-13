package br.com.elmoxarifado.controller;

import br.com.elmoxarifado.model.Emprestimo;
import br.com.elmoxarifado.service.EmprestimoService;
import br.com.elmoxarifado.service.FuncionarioService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
@RequestMapping("/emprestimos")
public class EmprestimosController {
   
    @Autowired
    EmprestimoService emprestimoService;
    
    @CrossOrigin
    @RequestMapping(method=RequestMethod.POST, value="/novo", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> cadastrar(@RequestBody Emprestimo emprestimo) {        
        emprestimoService.novo(emprestimo);
        return new ResponseEntity<>(HttpStatus.CREATED);   
    }   
    
   @RequestMapping(method=RequestMethod.GET, value="/buscar")
    public ResponseEntity<Collection> buscar() {
        return new ResponseEntity<>(emprestimoService.buscar(), HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/devolver/{codFerramenta}")
    public ResponseEntity<Collection> devolver(@PathVariable int codFerramenta) {
        emprestimoService.devolver(codFerramenta);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
