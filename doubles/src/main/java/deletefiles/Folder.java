package deletefiles;

import java.util.List;

public interface Folder {

	List<File> getFiles();

	void removeFile(File f);

}
