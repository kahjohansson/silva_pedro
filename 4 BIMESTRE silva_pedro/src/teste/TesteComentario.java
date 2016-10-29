package teste;

import pojo.Comentario;

public class TesteComentario {
    public static void main(String[]args){
    Comentario comentario = new Comentario();
    comentario.setTexto("Este fim de semana ocorrerá a reunião de adoração.");
        System.out.println("Comentário: "+comentario.getTexto());
        System.out.println("Data e Hora: "+comentario.getDataHora());
        
    }
    
}
