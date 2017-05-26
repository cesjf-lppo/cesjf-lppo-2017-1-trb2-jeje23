
package br.cesjf.lppo.dao;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.Leitura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ColetaELeituraDAO {
     private final PreparedStatement opNovaColeta;
     private final PreparedStatement opListarColeta;
     private final PreparedStatement opNovaLeitura;
     //private final PreparedStatement opListarLeitura;
     
     
       public ColetaELeituraDAO ()throws Exception{
            Connection conexao = ConnectionFactory.createConnection();
                
                opNovaColeta  = conexao.prepareStatement("INSERT INTO coleta (descricao) VALUES(?)");
                opListarColeta = conexao.prepareStatement("SELECT * FROM coleta");
                opNovaLeitura = conexao.prepareStatement("INSERT INTO leitura (coleta, unidade, local) VALUES(?, ?, ?)");
                //opListarLeitura = conexao.prepareStatement("SELECT * FROM leitura");
            
                
               
     }
       public void criaColeta(Coleta novaColeta) throws Exception {
        try{
        opNovaColeta.clearParameters();
        opNovaColeta.setString(1, novaColeta.getDescricao());
        opNovaColeta.executeUpdate();
        
        }catch (Exception ex){
            throw new Exception("Erro ao inserir a coleta", ex);
        }
    }
     public List<Coleta> listAll() throws Exception{
        try {
            List<Coleta> coletas = new ArrayList<>();
            
            
            ResultSet resultado = opListarColeta.executeQuery();
                while(resultado.next()){
                    Coleta novaColeta = new Coleta();
                    novaColeta.setId(resultado.getLong("id"));
                    novaColeta.setDescricao(resultado.getString("descricao"));
                    novaColeta.setData(resultado.getTimestamp("data"));
                    
                    coletas.add(novaColeta);
                }
            
            
            return coletas;
        } catch (SQLException ex){
            throw new Exception("Erro ao listar pedidos no banco", ex);
        }
    }
      public void criaLeitura(Leitura novaLeitura) throws Exception {
        try{
        opNovaLeitura.clearParameters();
        opNovaLeitura.setInt(1, novaLeitura.getColeta());
        opNovaLeitura.setString(2, novaLeitura.getUnidade());
        opNovaLeitura.setString(3, novaLeitura.getLocal());
        opNovaColeta.executeUpdate();
        
        }catch (Exception ex){
            throw new Exception("Erro ao inserir a coleta", ex);
        }
    }

 }

