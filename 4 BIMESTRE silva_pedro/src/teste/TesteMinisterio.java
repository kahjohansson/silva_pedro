package teste;

import dao.DAOMembro;
import DAO.DAOMinisterio;
import java.util.List;
import pojo.Ministerio;

public class TesteMinisterio {

public static void main(String[] args){
    
    Ministerio ministerio = new Ministerio();
    ministerio.setNome("CLAM");
    DAOMinisterio dao = new DAOMinisterio();
    //dao.salvar(ministerio);
    //dao.alterar(ministerio);
    dao.buscar();
    List<Ministerio> ministerios = dao.buscar();
        for (Ministerio m: ministerios) {
            System.out.println(m.getNome());
        }
    
}    
}
