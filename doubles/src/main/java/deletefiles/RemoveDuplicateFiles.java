package deletefiles;

import java.util.*;

/**
 * Busca todos los ficheros a partir de un directorio dado y borra los duplicados.
 * Considera que un fichero es duplicado si coincide nombre y tanaño
 * @author Javier
 *
 */
public class RemoveDuplicateFiles {

	Map<String, Integer> fileCache;
	List<Folder> folders;
	
	public RemoveDuplicateFiles() {
		fileCache = new HashMap<>();
		folders = new ArrayList<>();
	}
	
	public void remove(Folder initFolder) {
		folders.add(initFolder);
		while(!folders.isEmpty()) {
			Folder next = folders.remove(0);
			removeFiles(next);
		}
	}
	
	private void removeFiles(Folder folder) {
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
