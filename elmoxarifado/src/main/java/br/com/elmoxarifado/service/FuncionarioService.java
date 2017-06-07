package br.com.elmoxarifado.service;

import br.com.elmoxarifado.DAO.FuncionarioDAO;
import br.com.elmoxarifado.model.Ferramenta;
import br.com.elmoxarifado.model.Funcionario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {    
    
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public String cadastrar(Funcionario funcionario) {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date = new Date();        
        String senha = dateFormat.format(date);
        funcionarioDAO.cadastrar(funcionario, senha);
        return senha;
    }

    public List<Funcionario> buscar() {
        return funcionarioDAO.buscar();        
    }
    
    public Funcionario buscar(int matricula) {
        return funcionarioDAO.buscar(matricula);        
    }
    
    public Funcionario editar(Funcionario funcionario) {                       
        funcionarioDAO.editar(funcionario);
        return funcionario;
    }
    
    public String resetarSenha(Funcionario funcionario) {     
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date = new Date();        
        String novaSenha = dateFormat.format(date);
        funcionarioDAO.resetarSenha(funcionario, novaSenha); 
        return novaSenha;
    }
}
