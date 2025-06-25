/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author onyin
 */
public class MessageAppCore1Test {
    
    public MessageAppCore1Test() {
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
     * Test of nameCheck method, of class MessageAppCore1.
     */
    @Test
    public void testNameCheck() {
        System.out.println("nameCheck");
        MessageAppCore1 instance = null;
        boolean expResult = false;
        boolean result = instance.nameCheck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of passCheck method, of class MessageAppCore1.
     */
    @Test
    public void testPassCheck() {
        System.out.println("passCheck");
        MessageAppCore1 instance = null;
        boolean expResult = false;
        boolean result = instance.passCheck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numCheck method, of class MessageAppCore1.
     */
    @Test
    public void testNumCheck() {
        System.out.println("numCheck");
        MessageAppCore1 instance = null;
        boolean expResult = false;
        boolean result = instance.numCheck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userReg method, of class MessageAppCore1.
     */
    @Test
    public void testUserReg() {
        System.out.println("userReg");
        MessageAppCore1 instance = null;
        String expResult = "";
        String result = instance.userReg();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of authCheck method, of class MessageAppCore1.
     */
    @Test
    public void testAuthCheck() {
        System.out.println("authCheck");
        MessageAppCore1 instance = null;
        boolean expResult = false;
        boolean result = instance.authCheck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class MessageAppCore1.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String user = "";
        String pass = "";
        MessageAppCore1 instance = null;
        String expResult = "";
        String result = instance.login(user, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MessageAppCore1.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MessageAppCore1.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showReport method, of class MessageAppCore1.
     */
    @Test
    public void testShowReport() {
        System.out.println("showReport");
        MessageAppCore1.showReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findLongestMessage method, of class MessageAppCore1.
     */
    @Test
    public void testFindLongestMessage() {
        System.out.println("findLongestMessage");
        String expResult = "";
        String result = MessageAppCore1.findLongestMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
