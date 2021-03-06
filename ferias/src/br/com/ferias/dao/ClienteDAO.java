
package br.com.ferias.dao;


import br.com.ferias.jdbc.ConnectionFactory;
import br.com.ferias.model.Cliente;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDAO {
    private Connection con;
    
    //CONSTRUTOR
     public ClienteDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
     
     public void salvarCliente(Cliente cli){
        try {
            String sql = "insert into tb_clientes(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)" +
                  " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getRg());
            stmt.setString(3, cli.getCpf());
            stmt.setString(4, cli.getEmail());
            stmt.setString(5, cli.getTelefone());
            stmt.setString(6, cli.getCelular());
            stmt.setString(7, cli.getCep());
            stmt.setString(8, cli.getEndereco());
            stmt.setInt(9, cli.getNumero());
            stmt.setString(10, cli.getComplemento());
            stmt.setString(11, cli.getBairro());
            stmt.setString(12, cli.getCidade());
            stmt.setString(13, cli.getEstado());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo aconteceu: "+e);
        }
        
    }
     
      public void editarCliente(Cliente cli){
        try {
            String sql = "UPDATE tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, "
                    + "celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?"
                    + " WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getRg());
            stmt.setString(3, cli.getCpf());
            stmt.setString(4, cli.getEmail());
            stmt.setString(5, cli.getTelefone());
            stmt.setString(6, cli.getCelular());
            stmt.setString(7, cli.getCep());
            stmt.setString(8, cli.getEndereco());
            stmt.setInt(9, cli.getNumero());
            stmt.setString(10, cli.getComplemento());
            stmt.setString(11, cli.getBairro());
            stmt.setString(12, cli.getCidade());
            stmt.setString(13, cli.getEstado());
            
            stmt.setInt(14, cli.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo aconteceu: "+e);
        }
    
    
    }
      
       public void excluirCliente(Cliente cli){
        try {
            String sql = "DELETE FROM tb_clientes WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, cli.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente exclu??do com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo aconteceu: "+e);
        }
    
    }
       
           public List<Cliente> listarClientes(){
     try{
         List<Cliente> clientes = new ArrayList<>(); 
         
         //ESSE COMANDO VAI NO BANCO DE DADOS E PEGA TODOS OS DADOS DA tb_clientes
         String sql = "SELECT * FROM tb_clientes";
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
         
         while(rs.next()){
             Cliente cli = new Cliente();
             cli.setId(rs.getInt("id"));
             cli.setNome(rs.getString("nome"));
             cli.setRg(rs.getString("rg"));
             cli.setCpf(rs.getString("cpf"));
             cli.setEmail(rs.getString("email"));
             cli.setTelefone(rs.getString("telefone"));
             cli.setCelular(rs.getString("celular"));
             cli.setCep(rs.getString("cep"));
             cli.setEndereco(rs.getString("endereco"));
             cli.setNumero(rs.getInt("numero"));
             cli.setComplemento(rs.getString("complemento"));
             cli.setBairro(rs.getString("bairro"));
             cli.setCidade(rs.getString("cidade"));
             cli.setEstado(rs.getString("estado"));
             
             clientes.add(cli);
         }
         
         return clientes;
         
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao executar consulta: "+e);
            return null;

      }
    }
           
    public List<Cliente> buscarClientePorNome(String nome){
        try{
         List<Cliente> clientes = new ArrayList<>(); 
         
         //ESSE COMANDO VAI NO BANCO DE DADOS E PEGA TODOS OS DADOS DA tb_cliente
         String sql = "SELECT * FROM tb_clientes WHERE nome LIKE ?";
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(1, nome);
         
         ResultSet rs = stmt.executeQuery();
         
         
         while(rs.next()){
             Cliente cli = new Cliente();
             cli.setId(rs.getInt("id"));
             cli.setNome(rs.getString("nome"));
             cli.setRg(rs.getString("rg"));
             cli.setCpf(rs.getString("cpf"));
             cli.setEmail(rs.getString("email"));
             cli.setTelefone(rs.getString("telefone"));
             cli.setCelular(rs.getString("celular"));
             cli.setCep(rs.getString("cep"));
             cli.setEndereco(rs.getString("endereco"));
             cli.setNumero(rs.getInt("numero"));
             cli.setComplemento(rs.getString("complemento"));
             cli.setBairro(rs.getString("bairro"));
             cli.setCidade(rs.getString("cidade"));
             cli.setEstado(rs.getString("estado"));
             
             clientes.add(cli);
         }
         
         return clientes;
         
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao executar consulta: "+e);
            return null;

      }  
    } 
    
        public Cliente consultarCliente (String nome){
         try{
         
         //ESSE COMANDO VAI NO BANCO DE DADOS E PEGA TODOS OS DADOS DA tb_clientes
         String sql = "SELECT * FROM tb_clientes WHERE nome = ?";
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(1, nome);
         
         ResultSet rs = stmt.executeQuery();
         Cliente cli = new Cliente();
         
         if(rs.next()){
          
             cli.setId(rs.getInt("id"));
             cli.setNome(rs.getString("nome"));
             cli.setRg(rs.getString("rg"));
             cli.setCpf(rs.getString("cpf"));
             cli.setEmail(rs.getString("email"));
             cli.setTelefone(rs.getString("telefone"));
             cli.setCelular(rs.getString("celular"));
             cli.setCep(rs.getString("cep"));
             cli.setEndereco(rs.getString("endereco"));
             cli.setNumero(rs.getInt("numero"));
             cli.setComplemento(rs.getString("complemento"));
             cli.setBairro(rs.getString("bairro"));
             cli.setCidade(rs.getString("cidade"));
             cli.setEstado(rs.getString("estado"));
             
           
         }
         
         return cli;
         
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao executar consulta: "+e);
            return null;

      }  
    
    }
}
