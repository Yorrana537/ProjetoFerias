
package br.com.ferias.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
    
     public Connection getConnection(){
    /* "try catch" SERVE PARA TRATAMENTO DE CÓDIGOS QUE PODEM NÃO 
      SER TOTALMENTE ATENDIDOS E GERAREM ALGUMA EXCEÇÃO/ERRO */    
        try{
            /*
            ORGANIZAÇÃO DO MÉTODO getConnection("Driver que será utilizado:banco que será conectado://em que servidor está o banco de dados:porta que o Mysql está conectado(olhar no XAMPP)/banco de dados que vou fazer a conexão","usuário(observar no banco de dados)","senha (observar no banco de dados)");
      
            */
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3312/BDFERIAS","ferias","123");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
    }
}
