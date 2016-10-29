package teste;
public class TesteSubstring {
    public static void main(String [] args){
        String ano, mes, dia, date;
        date = "1999-12-10";
        ano = date.substring(0, 4);
        mes = date.substring(5,7);
        dia = date.substring(8,10);
        //System.out.println(dia+"/"+mes+"/"+ano);
        //System.out.println(ano);
        System.out.println(dia);
        System.out.println(mes);
        System.out.println(ano);
               
    }
}
