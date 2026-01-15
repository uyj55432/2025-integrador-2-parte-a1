package es.upm.grise.profundizacion.file;

import java.util.ArrayList;
import java.util.List;
import es.upm.grise.profundizacion.file.InvalidContentException;
import es.upm.grise.profundizacion.file.FileUtils;

public class File {

    private FileType type;
    private List<Character> content;

	/*
	 * Constructor
	 */
    public File() {
        content = new ArrayList<>();
    }

	/*
	 * Method to code / test
	 */
    public void addProperty(char[] newcontent) {
		if(newcontent == null){
			throw new InvalidContentException("");
		}

		if(this.type == FileType.IMAGE){
			throw new WrongFileTypeException("");
		}

		for(char c: newcontent){
			this.content.add(c);
		}

    }

	/*
	 * Method to code / test
	 */
    public long getCRC32() {

		byte[] content_byte = new byte[this.content.size()];

		if(content_byte.length == 0)
			return 0L;

		for(int i = 0; i < content_byte.length; i++){
			content_byte[i] = (byte) (this.content.get(i) & 0x00FF);
		}

		return FileUtils.calculateCRC32(content_byte);
    }
    
    
	/*
	 * Setters/getters
	 */
    public void setType(FileType type) {
    	
    	this.type = type;
    	
    }
    
    public List<Character> getContent() {
    	
    	return content;
    	
    }
    
}
