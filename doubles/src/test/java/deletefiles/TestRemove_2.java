package deletefiles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.Test;

public class TestRemove_2 {

	@Test
	public void borraDuplicados() {
		// Arrange
		File duplicateFile = mock(File.class);
		when(duplicateFile.name()).thenReturn("filename");
		when(duplicateFile.size()).thenReturn(10);
		
		Folder folder = mock(Folder.class);
		when(folder.getFiles()).thenReturn(Arrays.asList(duplicateFile, duplicateFile));
		
		// Act
		RemoveDuplicateFiles rdf = new RemoveDuplicateFiles();
		rdf.remove(folder);
		
		// Assert
		verify(folder).removeFile(duplicateFile);
	}

	@Test
	public void shouldEnterSubfolders() {

		Folder son = mock(Folder.class);
		Folder parent = mock(Folder.class);
		when(parent.getAllFolders()).thenReturn(Arrays.asList(son));

		
		// Act
		RemoveDuplicateFiles rdf = new RemoveDuplicateFiles();
		rdf.remove(parent);
		
		
		verify(son).getFiles();
	}
	
	@Test
	public void shouldDeleteduplicatsInDiferentFolders() {

		Folder son = mock(Folder.class);
		Folder parent = mock(Folder.class);
		when(parent.getAllFolders()).thenReturn(Arrays.asList(son));

		
		File duplicateFile = mock(File.class);
		when(duplicateFile.name()).thenReturn("filename");
		when(duplicateFile.size()).thenReturn(10);
		
		when(parent.getFiles()).thenReturn(Arrays.asList(duplicateFile));
		when(son.getFiles()).thenReturn(Arrays.asList(duplicateFile));

		
		// Act
		RemoveDuplicateFiles rdf = new RemoveDuplicateFiles();
		rdf.remove(parent);
		
		// Assert
		//verify(parent).removeFile(duplicateFile);
		verify(son).removeFile(duplicateFile);

	}
	
}








