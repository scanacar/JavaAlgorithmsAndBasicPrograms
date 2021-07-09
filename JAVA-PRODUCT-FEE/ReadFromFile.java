import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromFile {
	
	public static String[] readFile(String path) { // Dosya okuma
		
		try {
			int i = 0;
			int length = Files.readAllLines(Paths.get(path)).size();
			String[] result = new String[length];
			
			for(String line : Files.readAllLines(Paths.get(path))) {
				result[i++] = line;
			}
			return result;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
