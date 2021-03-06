import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Busca todos los ficheros a partir de un directorio dado y borra los duplicados.
 * Considera que un fichero es duplicado si coincide nombre y tana�o
 * @author Javier
 *
 */
public class DeteleFiles  {

	Map<String, Integer> fileCache;
	List<Folder> folders;
	

	public void remove(Folder initFolder) {
		fileCache = new HashMap<>();
		folders = new ArrayList<>();
		
		folders.add(initFolder);
		while(!folders.isEmpty()) {
			Folder next = folders.remove(0);
			searchForRepeatedFiles(next);
			folders.addAll(next.getAllFolders());
		}
	}
	
	private void searchForRepeatedFiles(Folder folder) {
		for(File f: folder.getFiles()) {
			if (isRepeated(f)) {
				folder.removeFile(f);
			} else {
				updateFile(f);
			}
		}
	}
	
	private boolean isRepeated(File file) {
		Integer size = this.fileCache.get(file.name());
		if (size != null) {
			return size == file.size();
		}
		return false;
	}
	

	private void updateFile(File file) {
		this.fileCache.put(file.name(), file.size());
	}

	
}
