
package teste;

import pojo.Aviso;

public class TesteAviso {
    public static void main(String[] args){
    Aviso aviso = new Aviso();
    aviso.setTitulo("Reunião do Min. Infantil");
    aviso.setTexto("Na próxima terça (30) às 20 h ocorrerá Reunião do Min. Infantil");
    System.out.println("aviso: "+aviso.getTitulo());
    System.out.println("texto: "+aviso.getTexto());
    System.out.println("dataHora: "+aviso.getDataHora());
    }
}
