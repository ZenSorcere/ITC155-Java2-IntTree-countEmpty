import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class IntTreeTest {

	@Test
	void testLargeTree() {
	// Creates Int Tree with 12 nodes
    // Prints Sideways IntTree structure, shows how many empty branches 
		IntTree test1 = new IntTree(12);
        System.out.println("Large Tree structure:");
        test1.printSideways();
        System.out.println();
        System.out.println("Empty Branches: " + test1.countEmpty());
        System.out.println();
    // Asserts that test result equals 13
        assertEquals(test1.countEmpty(), 13);
	}
	
	@Test
	void testSmallTree() {
	// Creates Int Tree with 3 nodes
	// Prints Sideways IntTree structure, shows how many empty branches 
		IntTree test2 = new IntTree(3);
		System.out.println("Small Tree structure:");
        test2.printSideways();
        System.out.println();
        System.out.println("Empty Branches: " + test2.countEmpty());
        System.out.println();
    // Asserts that test result equals 4
        assertEquals(test2.countEmpty(), 4);
	}
	
	@Test
	void testSingleNodeTree() {
	// Creates Int Tree with just 1 node (a root)
	// Prints Sideways IntTree structure, shows how many empty branches 
		IntTree test3 = new IntTree(1);
		System.out.println("SingleNode Tree structure:");
        test3.printSideways();
        System.out.println();
        System.out.println("Empty Branches: " + test3.countEmpty());
        System.out.println();
    // Asserts that test result equals 2
        assertEquals(test3.countEmpty(), 2);
	}
	
	@Test
	void testNullTree() {
		IntTree test4 = new IntTree();
	// Creates Empty IntTree
	// Prints Sideways IntTree structure, shows how many empty branches 
		System.out.println("Null Tree structure:");
	    test4.printSideways();
	    System.out.println();
	    System.out.println("Empty Branches: " + test4.countEmpty());
	    System.out.println();
	// Asserts that test result equals 1 (1 for the empty IntTree)
		assertEquals(test4.countEmpty(), 1);
	}
	
	

}
