import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BinarySearchTreeTest extends BinarySearchTree{

   BinarySearchTree bst;
   Person person1;
   Person person2;
   Person person3;
   
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      person1 = new Person("James Smith", "Rondebosch", "1234567");
      treeInsert(person1);
      person2 = new Person("Casper Tom", "Claremont", "7398294");
      treeInsert(person1);
   }
   
   
   
   /** Testing if there is no item in the tree. (Fail) **/
   @Test public void treeContainsTestNull() {
         assertNull(bst.treeContains(root, person1.getName()));
   }  
   
   
   /** Testing if there is an item of type Person in the tree (Pass) **/
   @Test public void treeContainsTest() {
      assertNotNull(bst.treeContains(root, person1.getName()));
   }
   
}
