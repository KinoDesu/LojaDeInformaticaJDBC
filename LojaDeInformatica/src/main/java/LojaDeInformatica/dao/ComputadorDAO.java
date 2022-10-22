/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LojaDeInformatica.dao;

import LojaDeInformatica.model.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fujimura
 */
public class ComputadorDAO {
    
    public static String url = "jdbc:mysql://localhost:3306/lojainformatica";
    public static String login = "root";
    public static String senha = "";

    public static boolean salvar(Computador obj) {
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("INSERT INTO computador (marca,hd,processador) VALUES(?,?,?); "
                    , Statement.RETURN_GENERATED_KEYS );
            
            comandoSQL.setString(1, obj.getMarca());
            comandoSQL.setString(2, obj.getHd());
            comandoSQL.setString(3, obj.getProcessador());
            
            //4º passo - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
                retorno = true;
                
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if(rs != null){
                    if(rs.next()){
                        obj.setId(rs.getInt(1));
                    }
                }
                
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return retorno;
    }

    public static ArrayList<Computador> listar() {
        Connection conexao = null;
        ArrayList<Computador> lista = new ArrayList<Computador>();
        
        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("SELECT * FROM computador;");
            
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){
               
                while(rs.next()){
                    Computador objNovo = new Computador();
                    objNovo.setId(rs.getInt("Id"));
                    objNovo.setMarca(rs.getString("Marca"));
                    objNovo.setHd(rs.getString("Hd"));
                    objNovo.setProcessador(rs.getString("Processador"));
                    
                    lista.add(objNovo);
                
                }
                
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return lista;
    }

    public static Computador buscarPorID(int id) {
        Connection conexao = null;
        Computador obj = new Computador();
        
        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("SELECT * FROM computador WHERE id = ?;");
            comandoSQL.setInt(1, id);
            
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){
               
                while(rs.next()){
                    
                    obj.setId(rs.getInt("Id"));
                    obj.setMarca(rs.getString("Marca"));
                    obj.setHd(rs.getString("Hd"));
                    obj.setProcessador(rs.getString("Processador"));
                    
                
                }
                
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return obj;
    }

    public static Computador buscarPorProcessador(String processador) {
        Connection conexao = null;
        Computador obj = new Computador();
        
        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("SELECT * FROM computador WHERE processador like ?;");
            comandoSQL.setString(1, processador);
            
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){
               
                while(rs.next()){
                    
                    obj.setId(rs.getInt("Id"));
                    obj.setMarca(rs.getString("Marca"));
                    obj.setHd(rs.getString("Hd"));
                    obj.setProcessador(rs.getString("Processador"));
                    
                
                }
                
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return obj;
    }
    
    public static boolean alterar(Computador obj){
        
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("UPDATE computador SET hd=? ,processador=? WHERE id =?; ");
            
            comandoSQL.setString(1, obj.getHd());
            comandoSQL.setString(2, obj.getProcessador());
            comandoSQL.setInt(3, obj.getId());
            
            //4º passo - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
                retorno = true;
                
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return retorno;
    }

    public static boolean excluir(int id) {
            
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("DELETE FROM computador WHERE id = ?; ");
            
            comandoSQL.setInt(1, id);
            
            
            //4º passo - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
                retorno = true;
                
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return retorno;
    }
    
}
