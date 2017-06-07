package br.com.elmoxarifado.DAO;

import br.com.elmoxarifado.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    
    public void cadastrar(Funcionario func, String senha) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;  
        ResultSet rs;
        try {
            stm = con.prepareStatement("INSERT INTO USUARIO (LOGIN,SENHA,E_MAIL) VALUES(?,?,?) RETURNING id_user");
            stm.setString(1, func.getLogin());
            stm.setString(2, senha);
            stm.setString(3, func.getEmail());            
            
            rs = stm.executeQuery();
            rs.next();
            int idUser = rs.getInt(1);
            
            stm.clearParameters();
            
            stm = con.prepareStatement("INSERT INTO FUNCIONARIO (MATRICULA,NOME,SETOR,RAMAL,ID_USUARIO) VALUES(?,?,?,?,?)");
            stm.setInt(1, func.getMatricula());
            stm.setString(2, func.getNome());
            stm.setString(3, func.getSetor());
            stm.setString(4, func.getRamal());
            stm.setInt(5, idUser);
            stm.executeUpdate();
            
            ConnectionFactory.closeConnection(con, stm, rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    } 
    
    public List buscar() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario func = null;
        try {
            stm = con.prepareStatement("SELECT * FROM Funcionario f, Usuario u where f.id_usuario = u.id_user");
            rs = stm.executeQuery();
            while (rs.next()) {
                func = new Funcionario();
                func.setMatricula(rs.getInt("matricula"));
                func.setNome(rs.getString("nome"));
                func.setLogin(rs.getString("login"));
                func.setRamal(rs.getString("ramal"));
                func.setSetor(rs.getString("setor"));
                func.setEmail(rs.getString("e_mail"));              
                funcionarios.add(func);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
            return funcionarios;
        }
    }
    
    public Funcionario buscar(int matricula) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;        
        Funcionario funcionario = new Funcionario();
        try {
            stm = con.prepareStatement("SELECT * FROM Funcionario f, Usuario u where f.id_usuario = u.id_user and matricula = ?");
            stm.setInt(1, matricula);
            rs = stm.executeQuery();
            rs.next();
            funcionario.setMatricula(rs.getInt("matricula"));
            funcionario.setLogin(rs.getString("login"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setRamal(rs.getString("ramal"));            
            funcionario.setEmail(rs.getString("e_mail"));            
            funcionario.setSetor(rs.getString("setor"));            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
            return funcionario;
        }
    }
    
    public void editar(Funcionario funcionario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;          
        
        try {
            stm = con.prepareStatement("UPDATE Funcionario SET NOME = ?, SETOR = ?, RAMAL = ? WHERE matricula = ?");
            stm.setString(1, funcionario.getNome());                                               
            stm.setString(2, funcionario.getSetor());                                               
            stm.setString(3, funcionario.getRamal());                                               
            stm.setInt(4, funcionario.getMatricula());                                               
            stm.executeUpdate();          
         
            ConnectionFactory.closeConnection(con, stm);            
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }       
    }
    
    public void resetarSenha(Funcionario funcionario, String novaSenha) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;          
        
        try {
            stm = con.prepareStatement("SELECT CHANGEPASSWORD(?,?)");
            stm.setInt(1, funcionario.getMatricula());                                               
            stm.setString(2, novaSenha);                                               
            stm.executeQuery();          
         
            ConnectionFactory.closeConnection(con, stm);            
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }   
    }
}
