package LinkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CDLinkedListTest {
	CDLinkedList l1 = new CDLinkedList();

	@Before
	public void setUp() throws Exception {
		l1 = new CDLinkedList();
	}

	@Test
	public void testSortEmptyList() throws Exception {
        l1 = new CDLinkedList();
		l1.sort();
		assertTrue(l1.isEmpty());
	}
	
	@Test 
	public void testSortListOneData() throws Exception {
        l1 = new CDLinkedList();
		l1.insert(0, new DListIterator(l1.header));
		l1.sort();
		assertEquals(0,l1.header.nextNode.data);
		assertEquals(1,l1.size);
	
	}
	
	@Test
	public void testSortListEvenData() throws Exception {
        l1 = new CDLinkedList();
		l1.insert(0, new DListIterator(l1.header));
		l1.insert(1, new DListIterator(l1.header));
		l1.insert(3, new DListIterator(l1.header));
		l1.insert(2, new DListIterator(l1.header));
		l1.insert(4, new DListIterator(l1.header));
		l1.insert(6, new DListIterator(l1.header));
		l1.sort();
		DListIterator itr = new DListIterator(l1.header.nextNode);
        assertEquals(0,itr.currentNode.data);
        assertEquals(1,itr.next());
        assertEquals(2,itr.next());
        assertEquals(3,itr.next());
        assertEquals(4,itr.next());
        assertEquals(6,itr.next());
        
	}
	
	@Test
	public void testSortListEvenDataReverse() throws Exception {
        l1 = new CDLinkedList();
		l1.insert(0, new DListIterator(l1.header));
		l1.insert(1, new DListIterator(l1.header));
		l1.insert(2, new DListIterator(l1.header));
		l1.insert(3, new DListIterator(l1.header));
		l1.insert(4, new DListIterator(l1.header));
		l1.insert(5, new DListIterator(l1.header));
		l1.insert(6, new DListIterator(l1.header));
		l1.insert(7, new DListIterator(l1.header));
		
		l1.sort();
		DListIterator itr = new DListIterator(l1.header.nextNode);
        assertEquals(0,itr.currentNode.data);
        assertEquals(1,itr.next());
        assertEquals(2,itr.next());
        assertEquals(3,itr.next());
        assertEquals(4,itr.next());
        assertEquals(5,itr.next());
        assertEquals(6,itr.next());
        assertEquals(7,itr.next());
	}
	
	@Test
	public void testSortListOddData() throws Exception {
        l1 = new CDLinkedList();
		l1.insert(6, new DListIterator(l1.header));
		l1.insert(7, new DListIterator(l1.header));
		l1.insert(5, new DListIterator(l1.header));
		l1.insert(2, new DListIterator(l1.header));
		l1.insert(4, new DListIterator(l1.header));
	
		l1.sort();
		DListIterator itr = new DListIterator(l1.header.nextNode);
        assertEquals(2,itr.currentNode.data);
        assertEquals(4,itr.next());
        assertEquals(5,itr.next());
        assertEquals(6,itr.next());
        assertEquals(7,itr.next());
		
	}
	
	@Test
	public void testSortListOddDataReverse() throws Exception {
        l1 = new CDLinkedList();
		l1.insert(0, new DListIterator(l1.header));
		l1.insert(1, new DListIterator(l1.header));
		l1.insert(2, new DListIterator(l1.header));
		l1.insert(3, new DListIterator(l1.header));
		l1.insert(4, new DListIterator(l1.header));
		l1.insert(5, new DListIterator(l1.header));
		l1.insert(6, new DListIterator(l1.header));
		l1.insert(7, new DListIterator(l1.header));
		l1.insert(8, new DListIterator(l1.header));
		
		l1.sort();
		DListIterator itr = new DListIterator(l1.header.nextNode);
        assertEquals(0,itr.currentNode.data);
        assertEquals(1,itr.next());
        assertEquals(2,itr.next());
        assertEquals(3,itr.next());
        assertEquals(4,itr.next());
        assertEquals(5,itr.next());
        assertEquals(6,itr.next());
        assertEquals(7,itr.next());
        assertEquals(8,itr.next());
		
	}
	
	@Test
	public void testSortListAlreadySorted() throws Exception {
        l1 = new CDLinkedList();
		l1.insert(8, new DListIterator(l1.header));
		l1.insert(7, new DListIterator(l1.header));
		l1.insert(6, new DListIterator(l1.header));
		l1.insert(5, new DListIterator(l1.header));
		l1.insert(4, new DListIterator(l1.header));
		l1.insert(3, new DListIterator(l1.header));
		l1.insert(2, new DListIterator(l1.header));
		l1.insert(1, new DListIterator(l1.header));
		l1.insert(0, new DListIterator(l1.header));
		
		l1.sort();
		DListIterator itr = new DListIterator(l1.header.nextNode);
        assertEquals(0,itr.currentNode.data);
        assertEquals(1,itr.next());
        assertEquals(2,itr.next());
        assertEquals(3,itr.next());
        assertEquals(4,itr.next());
        assertEquals(5,itr.next());
        assertEquals(6,itr.next());
        assertEquals(7,itr.next());
        assertEquals(8,itr.next());
		
	}
	
	




	

}
