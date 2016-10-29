package teste;

import dao.DAOMembro;
import java.util.List;
import pojo.Membro;

public class TesteMembro {
    public static void main(String[] args){
    Membro membro = new Membro();
    membro.setNome("Passos da Silva");
    membro.setEndereco("Rua Primo Dambrós, 560");
    membro.setCidade("Paranavai");
    membro.setSexo("M");
    membro.setCelular("(44)9159-5998");
    membro.setTelefone("(44)3045-2454");
    membro.setUsuario("onpedro");
    membro.setSenha("asdfghjkl123");
    membro.setCpf("10975109995");
    membro.setDataNascimento("1999-9-27");
    
DAOMembro dao = new DAOMembro();
    dao.salvar(membro);
    //dao.excluir(2);
    //dao.alterar(membro);
    }
}
