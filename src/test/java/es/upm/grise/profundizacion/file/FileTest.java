package es.upm.grise.profundizacion.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileTest {

    File f;

    @BeforeEach
    public void setup(){
        f = new File();
    }

    @Test
    public void testInvalidContentException(){
        assertThrows(InvalidContentException.class, () -> f.addProperty(null));
    }

    @Test
    public void testWrongFileTypeException(){
        f.setType(FileType.IMAGE);
        assertThrows(WrongFileTypeException.class, () -> f.addProperty(new char[]{}));
    }

    @Test
    public void testAddProperty(){
        f.setType(FileType.PROPERTY);
        f.addProperty(new char[]{'a'});

        assertEquals(1, f.getContent().size());
        assertEquals('a', f.getContent().get(0));
    }

    @Test
    public void testGetCRC32ZeroLong(){
        assertEquals(0L, f.getCRC32());
    }

    @Test
    public void testGetCRC32(){
        f.addProperty(new char[]{'a'});
        assertEquals(0L, f.getCRC32());
    }

}
