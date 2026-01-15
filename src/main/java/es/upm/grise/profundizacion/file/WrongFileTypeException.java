package es.upm.grise.profundizacion.file;

public class WrongFileTypeException extends RuntimeException {
    
    public WrongFileTypeException(String mensaje){
        super(mensaje);
    }
}
