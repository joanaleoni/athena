package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Nícolas
 */
public class DateFormat {
    
    public static LocalDate converterDataSQL(String data){
            LocalDate dataConvertida = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return dataConvertida;    

    }
    
    public static String converterDataString(String data){
        String[] dataArray = data.split("-");
        String ano = dataArray[0];
        String mes = dataArray[1];
        String dia = dataArray[2];
        
        return dia + "/" + mes + "/" + ano;        
    }

}
