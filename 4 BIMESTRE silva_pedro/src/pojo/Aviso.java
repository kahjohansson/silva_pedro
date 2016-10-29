package pojo;

import java.util.Calendar;
import java.util.TimeZone;

public class Aviso {
    protected int id, idAutor;
    protected String titulo;
    protected String texto;
    protected String dataHora;
    protected boolean permissaoVisualizar;
    protected boolean permissaoEditar;
    
    public Aviso(){
         Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH)+1; // O mês vai de 0 a 11.
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public boolean isPermissaoVisualizar() {
        return permissaoVisualizar;
    }

    public void setPermissaoVisualizar(boolean permissaoVisualizar) {
        this.permissaoVisualizar = permissaoVisualizar;
    }

    public boolean isPermissaoEditar() {
        return permissaoEditar;
    }

    public void setPermissaoEditar(boolean permissaoEditar) {
        this.permissaoEditar = permissaoEditar;
    }
    public void setIdAutor (int idAutor){
        this.idAutor=idAutor;
    }
    public int getIdAutor(){
        return idAutor;
    }
    
}
