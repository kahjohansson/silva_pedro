package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import pojo.Ministerio;
import Conexao.Conexao;

public class DAOMinisterio {

    public List<Ministerio> buscar() {
        List<Ministerio> ministerios = new ArrayList<Ministerio>();
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ministerio_s");
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            Ministerio ministerio;
            while (rs.next()) {
                ministerio = new Ministerio();
                ministerio.setId(rs.getInt("id_p"));
                ministerio.setNome(rs.getString("nome_p"));
                ministerios.add(ministerio);
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ministerios;
    }

    public Ministerio salvar(Ministerio ministerio) {
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ministerio_s(nome_p)VALUES(?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ministerio.getNome());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ministerio.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ministerio;
    }

    public boolean alterar(Ministerio ministerio) {
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE ministerio_s SET nome_p=? WHERE id_p=?");
            ps.setString(1, ministerio.getNome());
            ps.setInt(2, ministerio.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean excluir(int id) {
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM ministerio_s WHERE id_p=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Ministerio buscaId(int id) {
        Ministerio ministerio = new Ministerio();
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ministerio_s WHERE id_p=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ministerio.setId(rs.getInt("id_p"));
                ministerio.setNome(rs.getString("nome_p"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ministerio;
    }
}
