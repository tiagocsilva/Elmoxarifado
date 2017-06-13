package br.com.elmoxarifado.service;

import br.com.elmoxarifado.DAO.FerramentaDAO;
import br.com.elmoxarifado.model.Emprestimo;
import br.com.elmoxarifado.model.Ferramenta;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FerramentaService {    
    
    FerramentaDAO ferramentaDAO = FerramentaDAO.getInstance();

    public int cadastrar(Ferramenta ferramenta) {               
        ferramenta.codigo = ferramentaDAO.cadastrar(ferramenta);
        return ferramenta.codigo;
    }
    
    public List<Ferramenta> buscar() {                       
        return ferramentaDAO.buscar();
    }
    
    public List<Emprestimo> buscarDisponiveis() {               
        return ferramentaDAO.buscarDisponiveis();
    }
    
    public Ferramenta buscar(int codFerramenta) {                       
        return ferramentaDAO.buscar(codFerramenta);
    }
    
    public Ferramenta editar(Ferramenta ferramenta) {                       
        ferramentaDAO.editar(ferramenta);
        return ferramenta;
    }
    
    public void deletar(Ferramenta ferramenta) {               
        ferramentaDAO.deletar(ferramenta);        
    }
}
