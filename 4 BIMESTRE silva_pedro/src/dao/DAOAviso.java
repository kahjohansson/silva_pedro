package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Aviso;
import conexao.Conexao;

public class DAOAviso {
    
    public Aviso salvar(Aviso aviso) {
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO aviso_s (titulo_p, texto_p, data_p, id_autor_p) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, aviso.getTitulo());
            ps.setString(2, aviso.getTexto());
            ps.setString(3, aviso.getDataHora());
            ps.setInt(4, aviso.getIdAutor());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                aviso.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aviso;
    }

    public List<Aviso> buscar() {
        List<Aviso> avisos = new ArrayList<Aviso>();
        //esse try somente funciona a partir do java 8
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM aviso_s");
            ResultSet rs = ps.executeQuery();
            Aviso aviso;
            while (rs.next()) {
                aviso = new Aviso();
                aviso.setId(rs.getInt("id_p"));
                aviso.setTitulo(rs.getString("titulo_p"));
                aviso.setTexto(rs.getString("texto_p"));
                aviso.setDataHora(rs.getString("data_p"));
                aviso.setIdAutor(rs.getInt("id_autor_p"));
                avisos.add(aviso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avisos;
    }

    public Aviso buscarPorId(int id) {
        Aviso aviso;
        aviso = new Aviso();
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM aviso_s WHERE id_p=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){     
            aviso.setId(rs.getInt("id_p"));
            aviso.setTitulo(rs.getString("titulo_p"));
            aviso.setTexto(rs.getString("texto_p"));
            aviso.setDataHora(rs.getString("data_p"));
            aviso.setIdAutor(rs.getInt("id_autor_p"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return aviso;
    }

    public boolean alterar(Aviso aviso) {
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE aviso_s SET titulo_p=?,texto_p=?,data_hora_p=? WHERE id=?");
            ps.setString(1, aviso.getTitulo());
            ps.setString(2, aviso.getTexto());
            ps.setString(3, aviso.getDataHora());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {
        try (Connection conn = Conexao.get()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM aviso_s WHERE id_p=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
