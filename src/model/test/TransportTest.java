package model.test;

import model.consoCarbone.Taille;
import model.consoCarbone.Transport;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Transport Tester. 
* 
* @author <Authors name>
* @since <pre>12ÔÂ 20, 2022</pre> 
* @version 1.0 
*/ 
public class TransportTest {
    private Transport test = null;

    @Before
    public void before() throws Exception {
        test = new Transport();
    }

    @After
    public void after() throws Exception {
        test = null;
    }

    /**
    *
    * Method: isPossede()
    *
    */
    @Test
    public void testIsPossede() throws Exception {
        //TODO: Test goes here...
        Assert.assertFalse(test.isPossede());
    }

    /**
    *
    * Method: setPossede(boolean possede)
    *
    */
    @Test
    public void testSetPossede() throws Exception {
        //TODO: Test goes here...
        test.setPossede(true);
    }

    /**
    *
    * Method: getTaille()
    *
    */
    @Test
    public void testGetTaille() throws Exception {
        //TODO: Test goes here...
        Assert.assertEquals(Taille.G, test.getTaille());
    }

    /**
    *
    * Method: setTaille(Taille taille)
    *
    */
    @Test
    public void testSetTaille() throws Exception {
        //TODO: Test goes here...
        test.setTaille(Taille.P);
    }

    /**
    *
    * Method: getKilomAnnee()
    *
    */
    @Test
    public void testGetKilomAnnee() throws Exception {
        //TODO: Test goes here...
        Assert.assertEquals(0,test.getKilomAnnee());
    }

    /**
    *
    * Method: setKilomAnnee(int kilomAnnee)
    *
    */
    @Test
    public void testSetKilomAnnee() throws Exception {
        //TODO: Test goes here...
        test.setKilomAnnee(1000);
    }

    /**
    *
    * Method: getAmortissement()
    *
    */
    @Test
    public void testGetAmortissement() throws Exception {
        //TODO: Test goes here...
        Assert.assertEquals(1,test.getAmortissement());
    }

    /**
    *
    * Method: setAmortissement(int amortissement)
    *
    */
    @Test
    public void testSetAmortissement() throws Exception {
        //TODO: Test goes here...
        test.setAmortissement(6);
    }

    /**
    *
    * Method: calculImpact()
    *
    */
    @Test
    public void testCalculImpact() throws Exception {
        //TODO: Test goes here...
        test.calculImpact();
    }

    /**
     *
     * Method: getImpact()
     *
     */
    @Test
    public void testGetImpact() throws Exception {
        //TODO: Test goes here...
        Assert.assertEquals(1225.19,test.getImpact(), 1225.19);
    }
} 
