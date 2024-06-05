package Assignment_1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ellagregory
 */


public class UserTest {

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addScore method, of class User.
     */
    @Test
    public void testAddScore() {
        System.out.println("addScore");
        int points = 10; 
        User instance = new User("TestUser"); 
        instance.addScore(points); 
        assertEquals(10, instance.getScore()); 
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User("TestUser"); 
        String expResult = "TestUser"; 
        String result = instance.getName(); 
        assertEquals(expResult, result); 
    }

    /**
     * Test of getScore method, of class User.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        User instance = new User("TestUser"); 
        int expResult = 0; 
        int result = instance.getScore(); 
        assertEquals(expResult, result); 
    }

}
