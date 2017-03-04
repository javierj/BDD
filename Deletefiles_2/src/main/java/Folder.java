import java.util.Collection;
import java.util.List;


public interface Folder {

	List<File> getFiles();

	void removeFile(File f);

	Collection<Folder> getAllFolders();

}
