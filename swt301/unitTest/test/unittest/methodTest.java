/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class methodTest {
    
    public methodTest() {
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
     * Test of test method, of class method.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        int x = 0;
        int y = 0;
        method instance = new method();
        int expResult = 0;
        int result = instance.add(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testTest1() {
        System.out.println("test1");
        int x = 1;
        int y = 2;
        method instance = new method();
        int expResult = 0;
        int result = instance.add(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testTest2() {
        System.out.println("test2");
        int x = 2;
        int y = 1;
        method instance = new method();
        int expResult = 3;
        int result = instance.add(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
