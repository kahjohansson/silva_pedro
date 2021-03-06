package dao;
import java.util.ArrayList;
import java.util.List;
import pojo.Membro;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pojo.Cargo;
import pojo.Ministerio;
import pojo.MinisterioCargo;

public class DAOMembro {
    
public List<Membro>buscar(){
    List<Membro> membros = new ArrayList<Membro>();
    try(Connection conn = Conexao.get()){
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM membro_s");
        ps.executeQuery();
        ResultSet rs = ps.executeQuery();
        Membro membro;
        while(rs.next()){
            membro = new Membro();
            membro.setId(rs.getInt("id_p"));
            membro.setNome(rs.getString("nome_p"));
            membro.setEndereco(rs.getString("endereco_p"));
            membro.setCpf(rs.getString("cpf_p"));
            membro.setCidade(rs.getString("cidade_p"));
            membro.setTelefone(rs.getString("telefone_p"));
            membro.setCelular(rs.getString("celular_p"));
            membro.setUsuario(rs.getString("usuario_p"));
            membro.setSenha(rs.getString("senha_p"));
            membro.setDataNascimento(rs.getString("data_nasc_p"));
            membros.add(membro);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    return membros;
}

public List<Membro>buscar(String nome){
    List<Membro> membros = new ArrayList<Membro>();
    try(Connection conn = Conexao.get()){
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM membro_s WHERE nome_p LIKE ?");
        ps.setString(1, "%"+nome+"%");
        ps.executeQuery();
        ResultSet rs = ps.executeQuery();
        Membro membro;
        while(rs.next()){
            membro = new Membro();
            membro.setId(rs.getInt("id_p"));
            membro.setNome(rs.getString("nome_p"));
            membro.setEndereco(rs.getString("endereco_p"));
            membro.setCpf(rs.getString("cpf_p"));
            membro.setTelefone(rs.getString("telefone_p"));
            membro.setCelular(rs.getString("celular_p"));
            membro.setUsuario(rs.getString("usuario_p"));
            membro.setSenha(rs.getString("senha_p"));
            membro.setDataNascimento(rs.getString("data_nascimento_p"));
            membros.add(membro);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    return membros;
}

public Membro salvar(Membro membro){
    try(Connection conn = Conexao.get()){
        PreparedStatement ps = conn.prepareStatement("INSERT INTO membro_s(nome_p,endereco_p,cpf_p,cidade_p,sexo_p,telefone_p,celular_p,usuario_p,senha_p,data_nascimento_p) VALUES(?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, membro.getNome());
        ps.setString(2, membro.getEndereco());
        ps.setString(3, membro.getCpf());
        ps.setString(4, membro.getCidade());
        ps.setString(5, membro.getSexo());
        ps.setString(6, membro.getTelefone());
        ps.setString(7, membro.getCelular());
        ps.setString(8, membro.getUsuario());
        ps.setString(9, membro.getSenha());
        ps.setString(10, membro.getDataNascimento());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                membro.setId(rs.getInt(1));
            }
        
    }catch(Exception e){
        e.printStackTrace();
    }   
    return membro;
}

public void salvarCargoMuitos(Membro membro, List <Ministerio> listaMinisterio, List <Cargo> listaCargo){
          Cargo cargo;
    try {
            Connection conn = Conexao.get();
            
            for(Ministerio ministerio : listaMinisterio){
            /*ministerio e cargo são cadastrados ao mesmo tempo, mas em listas diferentes
                Quando cadastra-se por exemplo, idMembro=1, idCargo=2 e idMinisterio=4 
                e depois idMembro=1, idCargo=4 e idMinisterio=5
                A lista listaCargo será assim {2,4}, e a lista listaMinisterio será {4,5}
                Com isso, se chamarmos listaCargo.get(1) obteremos o valor 2
                e se chamarmos listaMinisterio.get(1) obteremos o valor 4
                
                Com isso, se obtivermos somente a listaMinisterio, e soubermos em qual objeto
                estamos percorrendo, pegamos a posição desde objeto e a posição do cargo associado será
                o mesmo.*/
             cargo = listaCargo.get(listaMinisterio.indexOf(ministerio));   
             
             
            PreparedStatement ps = conn.prepareStatement("INSERT INTO min_carg_memb_s (min_id_p,cargo_id_p, membro_id_p) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, ministerio.getId());
            ps.setInt(2, cargo.getId());
            ps.setInt(3, membro.getId());
            ps.executeUpdate();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
}

public boolean salvarCargo(Membro membro, Cargo cargo, Ministerio ministerio){
        try(Connection conn = Conexao.get()){
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ministerio_cargo_membro_s (id_ministerio_p,id_cargo_p, id_membro_p) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ministerio.getId());
            ps.setInt(2, cargo.getId());
            ps.setInt(3, membro.getId());
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

public boolean salvarCargo(Cargo cargo, Ministerio ministerio){
        try(Connection conn = Conexao.get()){
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ministerio_cargo_membro_s (id_ministerio_p,id_cargo_p, id_membro_p) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ministerio.getId());
            ps.setInt(2, cargo.getId());
            ps.setInt(3, -1);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Membro membro){
        try(Connection conn = Conexao.get()){
            PreparedStatement ps = conn.prepareStatement("UPDATE membro_s SET nome_p=?, endereco_p=?, cidade_p, cpf_p, sexo_p, telefone_p=?, celular_p=?, usuario_p=?, senha_p=?, data_nascimento_p=? WHERE id_p=?");
            ps.setString(1, membro.getNome());
            ps.setString(2, membro.getEndereco());
            ps.setString(3, membro.getCidade());
            ps.setString(4, membro.getCpf());
            ps.setString(5, membro.getSexo());
            ps.setString(6, membro.getTelefone());
            ps.setString(7, membro.getCelular());
            ps.setString(8, membro.getUsuario());
            ps.setString(9, membro.getSenha());
            ps.setString(10, membro.getDataNascimento());
            ps.setInt(11, membro.getId());
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean excluir(int id){
        try(Connection conn=Conexao.get()){
            PreparedStatement ps = conn.prepareStatement("DELETE FROM membro_s WHERE id_p=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Membro buscaId(int id){
        Membro membro = new Membro();
        try(Connection conn = Conexao.get()){
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM membro_s WHERE id_p=?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            membro.setId(rs.getInt("id_p"));
            membro.setNome(rs.getString("nome_p"));
            membro.setEndereco(rs.getString("endereco_p"));
            membro.setCpf(rs.getString("cpf_p"));
            membro.setCidade(rs.getString("cidade_p"));
            membro.setSexo(rs.getString("sexo_p"));
            membro.setTelefone(rs.getString("telefone_p"));
            membro.setCelular(rs.getString("celular_p"));
            membro.setUsuario(rs.getString("usuario_p"));
            membro.setSenha(rs.getString("senha_p"));
            membro.setDataNascimento(rs.getString("data_nascimento_p"));        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return membro;
    }
    
}
    

