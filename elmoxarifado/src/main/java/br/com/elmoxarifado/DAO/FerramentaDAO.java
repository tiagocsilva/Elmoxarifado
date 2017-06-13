package br.com.elmoxarifado.DAO;

import br.com.elmoxarifado.model.Ferramenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FerramentaDAO {
    
    private static FerramentaDAO ferramentaDAO;
    public static FerramentaDAO getInstance() {
        if(ferramentaDAO == null)
            ferramentaDAO = new FerramentaDAO();
        return ferramentaDAO;
    }
    
    private FerramentaDAO() {}
    
    public int cadastrar(Ferramenta ferramenta) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;  
        ResultSet rs;
        
        try {
            stm = con.prepareStatement("INSERT INTO FERRAMENTA (DESCRICAO,FABRICANTE,VALOR) VALUES(?,?,?) RETURNING CODIGO");
            stm.setString(1, ferramenta.getDescricao());            
            stm.setString(2, ferramenta.getFabricante());            
            stm.setDouble(3, ferramenta.getValor());         
                   
            rs = stm.executeQuery();
            rs.next();
            int codFerramenta = rs.getInt(1);            
           
            ConnectionFactory.closeConnection(con, stm, rs);            
            return codFerramenta;            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
        return -1;
    } 
    
    public List buscar() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Ferramenta> ferramentas = new ArrayList<>();
        Ferramenta ferramenta = null;
        try {
            stm = con.prepareStatement("SELECT * FROM Ferramenta");
            rs = stm.executeQuery();
            while (rs.next()) {
                ferramenta = new Ferramenta();
                ferramenta.setCodigo(rs.getInt("codigo"));
                ferramenta.setDescricao(rs.getString("descricao"));
                ferramenta.setFabricante(rs.getString("fabricante"));
                ferramenta.setValor(rs.getDouble("valor"));             
                ferramentas.add(ferramenta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
            return ferramentas;
        }
    }
    
    public List buscarDisponiveis() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Ferramenta> ferramentas = new ArrayList<>();
        Ferramenta ferramenta = null;
        try {
            stm = con.prepareStatement("SELECT * FROM Ferramenta WHERE disponibilidade = TRUE");
            rs = stm.executeQuery();
            while (rs.next()) {
                ferramenta = new Ferramenta();
                ferramenta.setCodigo(rs.getInt("codigo"));
                ferramenta.setDescricao(rs.getString("descricao"));
                ferramenta.setFabricante(rs.getString("fabricante"));
                ferramenta.setValor(rs.getDouble("valor"));             
                ferramentas.add(ferramenta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
            return ferramentas;
        }
    }
    
    public Ferramenta buscar(int codFerramenta) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;        
        Ferramenta ferramenta = new Ferramenta();
        try {
            stm = con.prepareStatement("SELECT * FROM Ferramenta where codigo = ?");
            stm.setInt(1, codFerramenta);
            rs = stm.executeQuery();
            rs.next();
            ferramenta.setCodigo(rs.getInt("codigo"));
            ferramenta.setDescricao(rs.getString("descricao"));
            ferramenta.setFabricante(rs.getString("fabricante"));
            ferramenta.setValor(rs.getDouble("valor"));            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
            return ferramenta;
        }
    }
    
    public void editar(Ferramenta ferramenta) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;          
        
        try {
            stm = con.prepareStatement("UPDATE Ferramenta SET DESCRICAO = ?, FABRICANTE = ?, VALOR = ? WHERE codigo = ?");
            stm.setString(1, ferramenta.getDescricao());                                               
            stm.setString(2, ferramenta.getFabricante());                                               
            stm.setDouble(3, ferramenta.getValor());                                               
            stm.setInt(4, ferramenta.getCodigo());                                               
            stm.executeUpdate();          
         
            ConnectionFactory.closeConnection(con, stm);            
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }        
    } 
    
    public void deletar(Ferramenta ferramenta) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;          
        
        try {
            stm = con.prepareStatement("DELETE FROM Ferramenta WHERE codigo = ?");
            stm.setInt(1, ferramenta.getCodigo());                                               
            stm.executeUpdate();          
         
            ConnectionFactory.closeConnection(con, stm);            
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }        
    }    
    
}
