import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PersonTest {

   Person person1;
   Person person2;
   Person person3;

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      person1 = new Person("John Smith", "Rondebosch", "1234567");
      person2 = new Person("Michael Dell", "Newlands", "7654321");
      person3 = new Person("Max Price", "Claremont", "9876543");
   }


//    /** A test that always fails. **/
//    @Test public void defaultTest() {
//       Assert.assertEquals("Default test added by jGRASP. Delete "
//             + "this test once you have added your own.", 0, 1);
//    }
   
   /** Testing a name (Pass) **/
   @Test public void nameTest() {
      Assert.assertEquals("John Smith", person1.getName());
      Assert.assertNotEquals("Rod", person2.getName());    
   }
   
   /** Testing a name (Fail) **/
   @Test public void nameTestFail() {
      Assert.assertEquals("James Band", person1.getName());
      Assert.assertNotEquals("Michael Dell", person2.getName());    
   }
   
   /** Testing an address (Pass) **/
   @Test public void addressTest() {
      Assert.assertEquals("Newlands", person2.getAddress());
      Assert.assertNotEquals("Muizenberg", person3.getAddress());    
   }
   
   /** Testing an address (Fail) **/
   @Test public void addressTestFail() {
      Assert.assertEquals("Rondebosch", person2.getAddress());
      Assert.assertNotEquals("Claremont", person3.getAddress());    
   }
   
   /** Testing a number (Pass) **/
   @Test public void numberTest() {
      Assert.assertEquals("9876543", person3.getNumber());
      Assert.assertNotEquals("9747097", person1.getNumber());    
   }
   
   /** Testing a number (Fail) **/
   @Test public void numberTestFail() {
      Assert.assertEquals("1463725", person3.getNumber());
      Assert.assertNotEquals("1234567", person1.getNumber());    
   }
}
