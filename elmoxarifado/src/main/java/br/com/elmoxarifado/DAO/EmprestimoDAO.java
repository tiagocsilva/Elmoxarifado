package br.com.elmoxarifado.DAO;

import br.com.elmoxarifado.model.Emprestimo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmprestimoDAO {
    
    private static EmprestimoDAO emprestimoDAO;
    public static EmprestimoDAO getInstance() {
        if(emprestimoDAO == null)
            emprestimoDAO = new EmprestimoDAO();
        return emprestimoDAO;
    }
    
    private EmprestimoDAO(){}
    
    public void novo(Emprestimo emprestimo) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;  
        ResultSet rs;
        
        try {          
            stm = con.prepareStatement("SELECT * FROM Usuario where cod_func = ?");
            stm.setInt(1, emprestimo.getMatriculaFuncionario());
            rs = stm.executeQuery();     
            rs.next();
            int idFunc = rs.getInt("id_user");
            
            stm.clearParameters();
            
            stm = con.prepareStatement("INSERT INTO EMPRESTIMO VALUES(?,?,?,?)");
            stm.setInt(1, idFunc);
            stm.setInt(2, emprestimo.getFerramentaId());
            stm.setDate(3, new Date(emprestimo.getInicio()));
            stm.setDate(4, new Date(emprestimo.getValidade()));        
            
            stm.executeUpdate();   
            stm.clearParameters();
            
            stm = con.prepareStatement("UPDATE FERRAMENTA SET disponibilidade = false WHERE codigo = ?");
            stm.setInt(1, emprestimo.getFerramentaId());
            stm.executeUpdate();   
            
            ConnectionFactory.closeConnection(con, stm, rs);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);      
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    } 
    
    public void devolver(int ferramentaId) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;          
        
        try {          
            stm = con.prepareStatement("DELETE FROM EMPRESTIMO WHERE ferramenta_id = ?");
            stm.setInt(1,ferramentaId);
            stm.executeUpdate();                 
            
            stm.clearParameters();
            
            stm = con.prepareStatement("UPDATE FERRAMENTA SET disponibilidade = true WHERE codigo = ?");
            stm.setInt(1, ferramentaId);            
            
            stm.executeUpdate();   

            ConnectionFactory.closeConnection(con, stm);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);      
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    } 
    
    public List buscar() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Emprestimo> emprestimos = new ArrayList<>();
        Emprestimo emprestimo = null;
        try {
            stm = con.prepareStatement("SELECT inicio,validade,ferramenta_id, matricula FROM EMPRESTIMO e, Usuario u, Funcionario f where e.usuario_id = u.id_user and f.matricula = u.cod_func;");
            rs = stm.executeQuery();
            while (rs.next()) {
                emprestimo = new Emprestimo();
                emprestimo.setInicio(rs.getDate("inicio").getTime());
                emprestimo.setValidade(rs.getDate("validade").getTime());
                emprestimo.setFerramentaId(rs.getInt("ferramenta_id"));             
                emprestimo.setMatriculaFuncionario(rs.getInt("matricula"));             
                emprestimos.add(emprestimo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
            return emprestimos;
        }
    }   
    
}
