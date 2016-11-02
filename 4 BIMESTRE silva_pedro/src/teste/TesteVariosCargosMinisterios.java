package teste;

import dao.DAOMembro;
import java.util.ArrayList;
import java.util.List;
import pojo.Cargo;
import pojo.Membro;
import pojo.Ministerio;

public class TesteVariosCargosMinisterios {
    
    public static void main(String[] args){
    
        Membro membro = new Membro();
        DAOMembro daoMembro = new DAOMembro();
        List <Ministerio> listaMinisterio = new ArrayList<Ministerio>();
        
        List <Cargo> listaCargo = new ArrayList<Cargo>();
        Ministerio m1 = new Ministerio();
        Ministerio m2 = new Ministerio();
        m1.setId(1);
        listaMinisterio.add(m1);
        m2.setId(2);
        listaMinisterio.add(m2);
               
        Cargo c1 = new Cargo();
        Cargo c2 = new Cargo();
        c1.setId(1);
        c1.setNome("Cargo 1");
        listaCargo.add(c1);
        c2.setId(2);
        c2.setNome("Cargo 2");
        listaCargo.add(c2);
        
        membro.setId(1);
        daoMembro.salvarCargoMuitos(membro, listaMinisterio, listaCargo);
    }
}
