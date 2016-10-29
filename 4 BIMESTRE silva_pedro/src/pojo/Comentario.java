package pojo;

import java.util.Calendar;
import java.util.TimeZone;

public class Comentario {
    private int id;
    private String texto;
    private String dataHora;
    
    public Comentario(){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minuto = calendar.get(Calendar.MINUTE);
        int segundo = calendar.get(Calendar.SECOND);
        dataHora = ano+"-"+mes+"-"+dia+" "+hora+":"+minuto+":"+segundo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
    

}
