package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import pojo.Ministerio;
import conexao.Conexao;
import pojo.Cargo;

public class DAOMinisterioCargo {

    public boolean salvar(Ministerio ministerio, Cargo cargo) {
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ministerio_cargo_s (ministerio_id_p,cargo_id_p)VALUES(?,?)");
            ps.setInt(1, ministerio.getId());
            ps.setInt(2, cargo.getId());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }

    public boolean alterar(Ministerio ministerio, Cargo cargo, int id1, int id2) {
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE ministerio_cargo_s SET ministerio_id_p=?, cargo_id_p=? WHERE ministerio_id_p=? AND cargo_id_p=?");
            ps.setInt(1, ministerio.getId());
            ps.setInt(2, cargo.getId());
            ps.setInt(3, id1);
            ps.setInt(4, id2);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean excluir(int id) {
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM ministerio_cargo_s WHERE ministerio_id_p=? AND cargo_id_p=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean buscarId(int idMinisterio, int idCargo) {
        Ministerio ministerio = new Ministerio();
        Cargo cargo = new Cargo();
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ministerio_cargo_s WHERE ministerio_id_p=? AND cargo_id_p=?");
            ps.setInt(1, idMinisterio);
            ps.setInt(2, idCargo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ministerio.setId(rs.getInt("id_p"));
                ministerio.setNome(rs.getString("nome_p"));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
        
        public List<Integer> buscar() {
        List<Integer> ministeriosCargos = new ArrayList<Integer>();
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ministerio_cargo_s");
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            Ministerio ministerio;
            Cargo cargo;
            while (rs.next()) {
                ministerio = new Ministerio();
                cargo = new Cargo();
                ministerio.setId(rs.getInt("ministerio_id_p"));
                cargo.setId(rs.getInt("cargo_id_p"));
                ministeriosCargos.add(ministerio.getId());
                ministeriosCargos.add(cargo.getId());
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ministeriosCargos;
    }
}


