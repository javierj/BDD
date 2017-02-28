package deletefiles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestRemoveDuplicateFilesWithMockito {

	//*****************************************************
	//** Mockito
	
	@Test
	public void shouldDeleteDuplicateFiles() {
		
		// File Stub
		File file = mock(File.class);

		//stubbing
		when(file.name()).thenReturn("filename");
		when(file.size()).thenReturn(10);
		
		List<File> files = Arrays.asList(file, file);
		
		// Mock
		Folder initFolder = mock(Folder.class);
		when(initFolder.getFiles()).thenReturn(files);
		
		// Test
		RemoveDuplicateFiles removeDups = new RemoveDuplicateFiles();
		removeDups.remove(initFolder);
		
		
		verify(initFolder, times(1)).removeFile(file);
	}
	
	
	@Test
	public void shouldNotDeleteDuplicateFiles() {
		
		// File Stub
		File file_org = mock(File.class);

		//stubbing
		when(file_org.name()).thenReturn("filename");
		when(file_org.size()).thenReturn(10);

		File file_samename = mock(File.class);

		//stubbing
		when(file_samename.name()).thenReturn("filename");
		when(file_samename.size()).thenReturn(20);

		
		File file_samesize = mock(File.class);

		//stubbing
		when(file_samesize.name()).thenReturn("filename2");
		when(file_samesize.size()).thenReturn(10);

		
		List<File> files = Arrays.asList(file_org, file_samename, file_samesize);
		
		// Mock
		Folder initFolder = mock(Folder.class);
		when(initFolder.getFiles()).thenReturn(files);
		
		// Test
		RemoveDuplicateFiles removeDups = new RemoveDuplicateFiles();
		removeDups.remove(initFolder);
		
		
		verify(initFolder, never()).removeFile(any(File.class));
	}


	//*****************************************************
	//** EasyMock
	

}
