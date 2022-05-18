package BST;


import static org.junit.Assert.*;

import org.junit.Test;


public class TestBSTRecursive {

	@Test
	public void testisAVLEmptyTree() {
		BSTRecursive t = new BSTRecursive(null, 0);
		assertTrue(t.isAVL());

	}

	@Test
	public void testisAVLOneMemberTree() {

		BSTNode r = new BSTNode(7);
		BSTRecursive t = new BSTRecursive(r, 1);
		assertTrue(t.isAVL());
	}

	@Test
	public void testisAVLNONCase1() {
		BSTNode r = new BSTNode(1);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(2);
		t.insert(3);
		assertFalse(t.isAVL());
		
	}
	
	@Test
	public void testisAVLNONCase2() {
		BSTNode r = new BSTNode(3);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(2);
		t.insert(1);
		assertFalse(t.isAVL());
		
	}
	
	@Test
	public void testisAVLNONCase3() {
		BSTNode r = new BSTNode(3);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(1);
		t.insert(2);
		assertFalse(t.isAVL());
		
	}
	
	@Test
	public void testisAVLNONCase4() {
		BSTNode r = new BSTNode(1);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(3);
		t.insert(2);
		assertFalse(t.isAVL());
	}
	
	@Test
	public void testisAVLNONCase5() {
		BSTNode r = new BSTNode(31);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(25);
		t.insert(36);
		t.insert(11);
		t.insert(5);
		t.insert(32);
		t.insert(34);
		assertFalse(t.isAVL());
	}
	
	@Test
	public void testisAVLNONCase6() {
		BSTNode r = new BSTNode(40);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(35);
		t.insert(22);
		t.insert(11);
		t.insert(50);
		t.insert(45);
		t.insert(57);
		assertFalse(t.isAVL());
	}
	
	@Test
	public void testisAVLNONCase7() {
		BSTNode r = new BSTNode(40);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(50);
		t.insert(20);
		t.insert(10);
		t.insert(30);
		t.insert(25);
		t.insert(35);
		assertFalse(t.isAVL());
	}
	
	@Test
	public void testisAVLCase1() {
		BSTNode r = new BSTNode(26);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(31);
		assertTrue(t.isAVL());
	}
	
	@Test
	public void testisAVLCase2() {
		BSTNode r = new BSTNode(31);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(25);
		t.insert(36);
		t.insert(11);
		assertTrue(t.isAVL());
	}
	
	@Test
	public void testisAVLCase3() {
		BSTNode r = new BSTNode(40);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(33);
		t.insert(19);
		t.insert(50);
		t.insert(45);
		t.insert(57);
		t.insert(48);
		assertTrue(t.isAVL());
	}
    @Test
    public void testSortedArrayToAVL(){
        
        int[] arr = {-1,1,3,4,5,7,9,23,65,87,123};
        BSTRecursive r = new BSTRecursive( BSTRecursive.sortedArrayToAVL(arr, 0, arr.length-1), 0);
        assertTrue(r.isAVL());
        
        
    }
	
	
	
	

}
