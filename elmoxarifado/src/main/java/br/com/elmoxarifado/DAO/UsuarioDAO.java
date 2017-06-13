package br.com.elmoxarifado.DAO;

import br.com.elmoxarifado.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    private static UsuarioDAO usuarioDAO;
    public static UsuarioDAO getInstance() {
        if(usuarioDAO == null)
            usuarioDAO = new UsuarioDAO();
        return usuarioDAO;
    }
    
    private UsuarioDAO() {}
    
    public boolean verificarUsuario(Usuario usuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;          
        ResultSet rs;
        boolean userIsValid = false;
        
        try {
            stm = con.prepareStatement("SELECT * FROM USUARIO WHERE login = ? and senha = ?");
            stm.setString(1, usuario.getUsuario());                                               
            stm.setString(2, usuario.getSenha());                                                                                             
            rs = stm.executeQuery();   
            
            if(rs.next()) {
                userIsValid = true;
            }
         
            ConnectionFactory.closeConnection(con, stm, rs);            
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }   
        return userIsValid;
    }
}
