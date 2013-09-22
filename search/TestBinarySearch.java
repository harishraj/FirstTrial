import org.junit.* ;
import static org.junit.Assert.* ;

public class TestBinarySearch {

   int[] list;
   
   @Before
   public void setup() {
	    list = new int[10];
        for (int i = 0; i < 10; i++) {
            list[i] = 2*i;         // populates the array with 0, 2, 4, 6…
          }  
   }
	
   @Test
   public void testSearch() {
      System.out.println("Test if Search matches.") ;
      
      int index;
      int sought=2;
      index = BinarySearch.seekValue(list, sought);
      
      assertTrue(index == 1) ;
   }

}
