/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangle;

import static java.lang.Math.sqrt;
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
public class TriangleTest {
    
    public TriangleTest() {
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
     * Test of kind method, of class Triangle.
     */
    @Test
    public void testKind1() {
        System.out.println("Not A Triangle ");
        float a=5,b=3,c=1;
        Triangle instance = new Triangle();
        int expResult = 0;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind2() {
        System.out.println("Not A Triangle");
        float a=5,b=9,c=3;
        Triangle instance = new Triangle();
        int expResult = 0;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind3() {
        System.out.println("Not A Triangle");
        float a=5,b=2,c=8;
        Triangle instance = new Triangle();
        int expResult = 0;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind4() {
        System.out.println("Equilateral");
        float a=3,b=3,c=3;
        Triangle instance = new Triangle();
        int expResult = 3;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind5() {
        System.out.println("Isosceles");
        float a=3,b=3,c=2;
        Triangle instance = new Triangle();
        int expResult = 2;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind6() {
        System.out.println("isosceles right ");
        float a=1,b=1,c=(float)sqrt(2);
        Triangle instance = new Triangle();
        int expResult = 5;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind7() {
        System.out.println("Isosceles");
        float a=5,b=6,c=5;
        Triangle instance = new Triangle();
        int expResult = 2;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind8() {
        System.out.println("isosceles right ");
        float a=1,b=(float) sqrt(2),c=1;
        Triangle instance = new Triangle();
        int expResult = 5;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind9() {
        System.out.println("Isosceles");
        float a=7,b=5,c=5;
        Triangle instance = new Triangle();
        int expResult = 2;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind10() {
        System.out.println("isosceles right ");
        float a=(float) sqrt(2),b=1,c=1;
        Triangle instance = new Triangle();
        int expResult = 5;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind11() {
        System.out.println("Scalene");
        float a=3,b=5,c=6;
        Triangle instance = new Triangle();
        int expResult = 1;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind12() {
        System.out.println("right");
        float a=3,b=4,c=5;
        Triangle instance = new Triangle();
        int expResult = 4;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind13() {
        System.out.println("right");
        float a=3,b=5,c=4;
        Triangle instance = new Triangle();
        int expResult = 4;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testKind14() {
        System.out.println("right");
        float a=5,b=3,c=4;
        Triangle instance = new Triangle();
        int expResult = 4;
        int result = instance.kind(a,b,c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
