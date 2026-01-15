package es.upm.grise.profundizacion.file;

public class InvalidContentException extends RuntimeException{
    
    public InvalidContentException(String mensaje){
        super(mensaje);
    }
}
