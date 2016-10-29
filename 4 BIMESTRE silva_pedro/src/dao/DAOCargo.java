package dao;

import java.util.ArrayList;
import java.util.List;
import pojo.Cargo;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOCargo {
    
public List<Cargo>buscar(){
    List<Cargo> cargos = new ArrayList<Cargo>();
    try(Connection conn = Conexao.get()){
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM cargo_s");
        ps.executeQuery();
        ResultSet rs = ps.executeQuery();
        Cargo cargo;
        while(rs.next()){
            cargo = new Cargo();
            cargo.setId(rs.getInt("id_p"));
            cargo.setNome(rs.getString("nome_p"));
            cargos.add(cargo);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    return cargos;
}
public Cargo cadastrar(Cargo cargo){
    try(Connection conn = Conexao.get()){
        PreparedStatement ps = conn.prepareStatement("INSERT INTO cargo_s(nome_p)VALUES(?)",Statement.RETURN_GENERATED_KEYS);
       ps.setString(1, cargo.getNome());
       ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            cargo.setId(rs.getInt(1));
        }
    }catch(Exception e){
        e.printStackTrace();
    }   
    return cargo;
}
    public boolean alterar(Cargo cargo){
        try(Connection conn = Conexao.get()){
            PreparedStatement ps = conn.prepareStatement("UPDATE cargo_s SET nome_p=? WHERE id_p=?");
            ps.setString(1, cargo.getNome());
            ps.setInt(2, cargo.getId());
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean excluir(int id){
        try(Connection conn=Conexao.get()){
            PreparedStatement ps = conn.prepareStatement("DELETE FROM cargo_s WHERE id_p=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Cargo buscaId(int id){
        Cargo cargo = new Cargo();
        try(Connection conn = Conexao.get()){
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM cargo_s WHERE id_p=?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            cargo.setId(rs.getInt("id_p"));
            cargo.setNome(rs.getString("nome_p"));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cargo;
    }

   
    
}
    


