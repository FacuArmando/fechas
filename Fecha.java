
/**
 * Fecha: clase cuyos objetos representan fechas calendarias, para el 
 * calendario gregoriano. Esta clase implementa una variedad de 
 * funcionalidades sobre fechas, como comparaciones, cómputos de días,
 * etc.
 * 
 * @author N. Aguirre 
 * @version 0.1
 */
public class Fecha
{
    // dia de la fecha
    private int dia;
    
    // mes de la fecha
    private int mes;
    
    // año de la fecha
    private int anho;
    
    /**
     * Constructor por defecto, para la clase fecha.
     * Crea como fecha por defecto la fecha inicial del 
     * calendario gregoriano (15/10/1582)
     * 
     * Precondición: True
     * Postcondición: Corroborar si dia=15, mes=10 y anho=1582
     */
    public Fecha()
    {
        dia = 15;
        mes = 10;
        anho = 1582;
        assert(dia==15 && mes==10 && anho==1582): "Los valores ingresados de dia, mes y anho no son correctos"; //Postcondición
    }

    /**
     * Constructor de la clase Fecha, que recibe la fecha a 
     * crear como parámetro. La fecha no puede ser previa
     * al 15/10/1582. Debe tenerse en cuenta la creación de
     * fechas válidas, en relación a número de días en los
     * meses, años bisiestos, etc.
     * 
     * Precondición: Para ser una fecha valida, se deben ingresar dias, meses y anhos validos existentes, y pueden ser fechas posteriores
     a las del calendario postGregoriano 
     * Postcondición: Se corrobora si se almaceno un dia, mes y anho correcto
     * 
     */
    public Fecha(int nuevoDia, int nuevoMes, int nuevoAnho)
    {
        // Implementar este constructor
        assert(diaValido(nuevoDia, nuevoMes, nuevoAnho) && (postGregoriano(nuevoDia,nuevoMes,nuevoAnho))); //Precondición
        dia = nuevoDia;
        mes = nuevoMes;
        anho = nuevoAnho;
        assert(dia==nuevoDia && mes==nuevoMes && anho==nuevoAnho): "No se almaceno un dia, mes y anho correcto"; //Postcondición
    }
    
    /**
     * 
     * Metodo que nos devuelve verdadero o falso cuando las fechas ingresadas sean validas
     * 
     * Precondición: Assert que corrobora que las fechas sean validas, y que el mes y el anho ingresado sean validos
     * Postcondición: True
     * 
     */
    private boolean diaValido(int d, int m, int a){      
        assert((m>=1 && m<=12) && (a>=1582)):"Mes y año invalidos"; //Precondición
        if((d>=1 && d<=31) || (d>=1 && d<=30) || (esBisiesto(a) && (d>=1 && d<=29)) || (!esBisiesto(a) && (d>=1 && d<=28))){
            return true;
        }else{
            return false;
        }
    }
               
    /**
     * 
     * Metodo que nos retorna las fechas posteriores al Calendario Gregoriano
     * 
     * Precondición: Corrobora si la fecha ingresada es valida
     * Postcondición: True
     * 
     */
    private boolean postGregoriano(int d, int m, int a){
        assert(diaValido(d, m, a)); //Precondición
        if((a<1582) || (a==1582 && m<10) || (a==1582 && m==10 && d<=14)){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * Retorna el dia de la fecha
     * 
     * Precondición: True
     * Postcondición: True
     * 
     */
    public int obtenerDia() {
        // Implementar este método, reemplazando la línea siguiente
        return dia;
    }
    
    /**
     * Retorna el mes de la fecha
     * 
     * Precondición: True
     * Postcondición: True
     * 
     */
    public int obtenerMes() {
        // Implementar este método, reemplazando la línea siguiente
        return mes;
    }
    
    /**
     * Retorna el año de la fecha
     * 
     * Precondición: True
     * Postcondición: True
     * 
     */
    public int obtenerAnho() {
        // Implementar este método, reemplazando la línea siguiente
        return anho;
    }
    
    /**
     * Cambia el día de la fecha. El nuevo día debe ser válido
     * para el mes y año actuales.
     * 
     * Precondición: Corrobora que el dia no sea un numero negativo
     * Postcondición: True
     * 
     */
    public void cambiarDia(int nuevoDia) {
        assert(nuevoDia>=1): "El dia ingresado no es valido"; //Precondición
        //Implementar este método
        if((nuevoDia>=1 && nuevoDia<31) || (nuevoDia>=1 && nuevoDia<30) || (nuevoDia>=1 && nuevoDia<28) || (nuevoDia>=1 && nuevoDia<29)){
            dia = nuevoDia+1;
        }else{
            dia = 1;
        }
    }
    
    /**
     * Cambia el mes de la fecha. El nuevo mes debe ser válido
     * para el día y año actuales.
     * 
     * Precondición: Corrobora que el mes no sea un numero mayor a 12
     * Postcondición: True
     * 
     */
    public void cambiarMes(int nuevoMes) {
        //Implementar este método
        assert(nuevoMes<=12): "Mes no valido"; //Precondición
        if(nuevoMes>=1 && nuevoMes<=12){
            if(nuevoMes>=1 && nuevoMes<12){
                mes = nuevoMes+1;
            }else{
                if(nuevoMes==12){
                    mes = 1;
                }
            }
        }
    }
    
    /**
     * Cambia el año de la fecha. El nuevo año debe ser válido
     * para el día y mes actuales.
     * 
     * Precondición: Corrobora que el mes no sea un numero mayor a 12
     * Postcondición: True
     * 
     */
    public void cambiarAnho(int nuevoAnho, int nuevoMes) {
        //Implementar este método
        assert(nuevoMes<=12): "Mes no valido"; //Precondición
        if(nuevoMes>=1 && nuevoMes<=12){
            if(nuevoMes>=1 && nuevoMes<12){
                anho = nuevoAnho;
            }else{
                if(nuevoMes==12){
                    anho = nuevoAnho+1;
                }
            }
        }
    }
    
    /**
     * 
     * Retorna la fecha con la siguiente estructura "dia/mes/anho"
     * Precondición: True
     * Postcondición: True
     * 
     */
    public String toString(){
       return(""+ dia + "/" + mes + "/" + anho + "");    
    }
    
    /**
     * Chequea si la fecha es igual a otra fecha dada
     * 
     * Precondición: Comprueba si la fecha ingresada es valida
     * Postcondición: True
     * 
     */
    public boolean equals(Fecha otraFecha) {
        assert(diaValido(otraFecha.dia, otraFecha.mes, otraFecha.anho)): "Los dias, meses o anhos ingresados no son validos"; //Precondición
        // Implementar este método, reemplazando la línea siguiente
        if(dia == otraFecha.obtenerDia() && mes == otraFecha.obtenerMes() && anho == otraFecha.obtenerAnho()){
            return true;
        }else{
            return false;
        }
        
    }
    
    /**
     * Chequea si la fecha es anterior a otra fecha dada
     * 
     * Precondición: Comprueba si la fecha ingresada es valida
     * Postcondición: True 
     * 
     */
    public boolean esAnterior(Fecha otraFecha) {
        assert(diaValido(otraFecha.dia, otraFecha.mes, otraFecha.anho)): "Los dias, meses o anhos ingresados no son validos"; //Precondición
        // Implementar este método, reemplazando la línea siguiente
        if(this.obtenerAnho() < otraFecha.obtenerAnho()){
          return true;
        }else{
            if(obtenerAnho() > otraFecha.obtenerAnho()){
               return false;
            }else{ // tiene el mismo año
                if(mes < otraFecha.obtenerMes()){
                   return true;
                }else{
                     if(mes > otraFecha.obtenerMes()){
                       return false;
                    }else{  //tienen el mismo mes 
                         if(dia < otraFecha.obtenerDia()){
                            return true;
                        }else{
                            if(dia > otraFecha.obtenerDia()){
                                return false;
                            }else{
                                 System.out.println("La fecha ingresada es la misma");
                                 return false;
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Computa distancia en días entre dos fechas.
     * El parámetro otraFecha debe corresponder a una fecha igual o 
     * posterior a la fecha del objeto.
     */
    public int cantidad(Fecha otraFecha) {
        // Implementar este método, reemplazando la línea siguiente
        return 0;
    }
    
    /**
     * Computa la cantidad de días de un mes dado. El parámetro
     * debe corresponder a un mes válido.
     * 
     * Precondición: Corrobora si el mes ingresado es valido y que el anho no sea bisiesto
     * Postcondicióń: True
     * 
     */
    private int cantDias(int unMes, int unAnho) 
    {
        // Implementar este método, reemplazando la línea siguiente
        assert(unMes>=1 && unMes<=12 && esBisiesto(unAnho)):"Mes invalido"; //Precondición
        if(unMes==1 || unMes==3 || unMes==5 || unMes==7 || unMes==8 || unMes==10 || unMes==12){
             return 31;    
        }else{
            if(unMes==4 || unMes==6 || unMes==9 || unMes==11){
               return 30;    
            }else{
                if(unMes==2){
                      return 28;
                }else{
                      return 29;
                }
            }
        }
    }
    
    /**
     * Decide si un año dado es bisiesto o no. Un año es bisiesto
     * si es múltiplo de 4, salvo los múltiplos de 100 que no son 
     * múltiplos de 400.
     * El parámetro debe corresponder a un año válido.
     * 
     * Precondición: Corrobora si el anho ingresado es valido o no
     * Postcondicióń: True
     * 
     */
    private boolean esBisiesto(int unAnho) 
    {
        // Implementar este método, reemplazando la línea siguiente
        assert(unAnho>=1582):"Año invalido"; //Precondición
        if(((unAnho%4==0) && (unAnho%100!=0) || (unAnho%100==0) && (unAnho%400==0))){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * 
     * Retorna la distancia entre una fecha y otra
     * 
     * Precondición: Corrobora que la fecha ingresada sea valida
     * Postcondición: Corrobora que la distancia entre una fecha y otra sea valida
     * 
     */
    public int distancia(Fecha otraFecha)
    {
        assert diaValido(otraFecha.dia, otraFecha.mes, otraFecha.anho): "La fecha ingresada no es valida"; //Precondición
        Fecha auxFecha = new Fecha(dia, mes, anho);
        
        int distancia = 0;
        while (!auxFecha.equals(otraFecha)){
            if(auxFecha.dia <= auxFecha.cantDias(auxFecha.mes, auxFecha.anho)){
               auxFecha.dia++;
            }else{
                auxFecha.dia = 1;
            }
            
            if(auxFecha.mes < 12){
                auxFecha.mes++;
            }else{
                auxFecha.mes = 1;
                auxFecha.anho++;
            }
            
            distancia++;
        }
        int dist = distancia;
        assert(dist == distancia): "No se asigno correctamente la distancia entre una fecha y otra"; //Postcondición
        return distancia;
    }
    
    
    /**
     * 
     * repOK(): Chequea el estado del objeto
     * 
     */
    public boolean repOK(){
        if((dia>0 && dia<32) && (mes>0 && mes<13) && (anho>=1582)){
            return true;
        }else{
            return false;
        }
    }
}
