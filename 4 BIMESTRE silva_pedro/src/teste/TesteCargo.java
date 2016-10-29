package teste;

import dao.DAOCargo;
import pojo.Cargo;

public class TesteCargo {
    
    public static void main(String[]args){
    Cargo cargo1 = new Cargo();
    cargo1.setNome("TESTE");
    
    
    DAOCargo dao1 = new DAOCargo();
    dao1.cadastrar(cargo1);
    }
    
}
