package list;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class TestList {

	@Test
	public void testStub() {
		
		@SuppressWarnings("unchecked")
		List<String> listStub = mock(List.class);
		
		when(listStub.get(0)).thenReturn("first");
		when(listStub.get(1)).thenReturn("second");
		 
		for(int i = 0; i < 1000; i++) {
			assertEquals("first", listStub.get(0));
			assertEquals("second", listStub.get(1));
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testMock() {
		List<Integer> l = Mockito.mock(List.class);
		
		l.size();
		l.get(0);
		l.get(100000);
		l.clear();
		//l.isEmpty();
		
		verify(l).size();
		verify(l, never()).isEmpty();
		verify(l, times(2)).get(anyInt());
	}
	
	@Test
	public void testSpy() {
		List<Integer> l = new ArrayList<Integer>();
		List<Integer> spy =	spy(l);
		
		spy.add(1);
		spy.clear();

		assertEquals(0, l.size());
		verify(spy).clear();
	}


}
