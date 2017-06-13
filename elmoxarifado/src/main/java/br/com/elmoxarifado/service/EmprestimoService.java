package br.com.elmoxarifado.service;

import br.com.elmoxarifado.DAO.EmprestimoDAO;
import br.com.elmoxarifado.model.Emprestimo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {    
    
    EmprestimoDAO emprestimoDAO = EmprestimoDAO.getInstance();

    public void novo(Emprestimo emprestimo) {               
        emprestimoDAO.novo(emprestimo);
    } 
    
    public void devolver(int codFerramenta) {               
        emprestimoDAO.devolver(codFerramenta);
    } 
    
    public List<Emprestimo> buscar() {               
        return emprestimoDAO.buscar();
    }    
     
}
