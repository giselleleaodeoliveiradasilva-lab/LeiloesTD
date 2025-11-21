/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {

        conn = new conectaDAO().connectDB();
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        try {
            prep = conn.prepareStatement(sql);

            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());

            prep.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto" + e.getMessage());
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    prep.close();
                }
            } catch (SQLException ex) {

            }

        }

    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        listagem.clear();
       conn = new conectaDAO().connectDB();
       String sql = "SELECT*FROM produtos";
       
       try{
           prep = conn.prepareStatement(sql);
           resultset = prep.executeQuery();
           
           while(resultset.next()){
               ProdutosDTO produto = new ProdutosDTO();
               produto.setId(resultset.getInt("id"));
               produto.setNome(resultset.getString("nome"));
               produto.setValor(resultset.getInt("valor"));
               produto.setStatus(resultset.getString("status"));
               
               listagem.add(produto);
           }
           
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Erro ao listar produtos"+e.getMessage());
       }finally{
           try{
               if(resultset != null) resultset.close();
                if(prep != null) prep.close();
                if(conn != null) conn.close();
               
           }catch(SQLException ex){
       }

      
    }
         return listagem;
    }
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        // Limpa a lista para garantir que só terá produtos vendidos
        listagem.clear(); 
        
        conn = new conectaDAO().connectDB();
        // **SQL com filtro WHERE**: Seleciona apenas produtos com status 'Vendido'
        String sql = "SELECT * FROM produtos WHERE status = 'Vendido'"; 
        
        try {
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();
            
            while(resultset.next()){
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));
                
                listagem.add(produto);
            }
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos vendidos: " + e.getMessage());
        } finally {
            try {
                if(resultset != null) resultset.close();
                if(prep != null) prep.close();
                if(conn != null) conn.close(); // Fechar a conexão
                
            } catch(SQLException ex) {
                // Tratar exceção de fechamento
            }
        }
        return listagem;
    }
    
    // Método para alterar o status do produto para 'Vendido'
    public void venderProduto(int id) {
        conn = new conectaDAO().connectDB();
        // Comando SQL para atualizar o status baseado no ID
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?"; 

        try {
            prep = conn.prepareStatement(sql);
            prep.setInt(1, id); // Define o ID
            prep.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + e.getMessage());
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                // Tratar exceção de fechamento
            }
        }
    }
}


