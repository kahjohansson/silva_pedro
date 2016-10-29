package teste;

import DAO.DAOMinisterioCargo;
import pojo.Cargo;
import pojo.Ministerio;

public class TesteMinisterioCargo {

    public static void main(String[] args){
        Cargo cargo = new Cargo();
        cargo.setId(2);
        Ministerio ministerio= new Ministerio();
        ministerio.setId(3);
        DAOMinisterioCargo dao = new DAOMinisterioCargo();
        //dao.salvar(ministerio, cargo);
        dao.alterar(ministerio, cargo, 4, 2);
        
        
    }
    
}
