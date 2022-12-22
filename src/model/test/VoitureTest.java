package model.test;

import model.consoCarbone.TailleVoiture;
import model.consoCarbone.Voiture;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Voiture Tester.
* 
* @author Qinming JIANG
* @since <pre>20/12/2022</pre>
* @version 1.0 
*/ 
public class VoitureTest {

    /**
     * Instance Voiture
     */
    private Voiture test = null;

    /**
     * Before.
     *
     * @throws Exception the exception
     */
    @Before
    public void before() throws Exception {
        test = new Voiture();
    }

    /**
     * After.
     *
     * @throws Exception the exception
     */
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
    public void isPossede_testPossedeIsFalseDefault_returnsFalse() throws Exception {
        //TODO: Test goes here...
        Assert.assertFalse(test.isPossede());
    }

    /**
    *
    * Method: setPossede(boolean possede)
    *
    */
    @Test
    public void setPossede_testSetPossedeFunction_possedeWillBeTrueAfter() throws Exception {
        //TODO: Test goes here...
        test.setPossede(true);
        Assert.assertTrue(test.isPossede());
    }

    /**
    *
    * Method: getTaille()
    *
    */
    @Test
    public void getTaille_testGetTailleFunction_returnsDefaultCarSizeOfObjectTransport() throws Exception {
        //TODO: Test goes here...
        Assert.assertEquals(TailleVoiture.G, test.getTailleVoiture());
    }

    /**
    *
    * Method: setTaille(Taille taille)
    *
    */
    @Test
    public void setTaille_testSetTailleFunction_resetCarSizeIntoSmall() throws Exception {
        //TODO: Test goes here...
        test.setTailleVoiture(TailleVoiture.P);
        Assert.assertEquals(TailleVoiture.P, test.getTailleVoiture());
    }

    /**
    *
    * Method: getKilomAnnee()
    *
    */
    @Test
    public void getKilomAnnee_testGetKilomAnneeFunction_returnsDefaultKilometerOfObjectTransport() throws Exception {
        //TODO: Test goes here...
        Assert.assertEquals(0,test.getKilomAnnee());
    }

    /**
    *
    * Method: setKilomAnnee(int kilomAnnee)
    *
    */
    @Test
    public void setKilomAnnee_testSetKilomAnneeFunction_resetKilometerOfObjectTransportInto1000() throws Exception {
        //TODO: Test goes here...
        test.setKilomAnnee(1000);
        Assert.assertEquals(1000,test.getKilomAnnee());
    }

    /**
    *
    * Method: getAmortissement()
    *
    */
    @Test
    public void getAmortissement_testGetAmortissementFunction_returnsDefaultAmortissementOfObjectTransport() throws Exception {
        //TODO: Test goes here...
        Assert.assertEquals(1,test.getAmortissement());
    }

    /**
    *
    * Method: setAmortissement(int amortissement)
    *
    */
    @Test
    public void setAmortissement_testSetAmortissementFunction_resetAmortissementOfObjectTransportInto6() throws Exception {
        //TODO: Test goes here...
        test.setAmortissement(6);
        Assert.assertEquals(6,test.getAmortissement());
    }

    /**
     *
     * Method: getImpact()
     *
     */
    @Test
    public void calculImpact_testCalculImpactFunction_returnsNewImpactAfterCalculate() throws Exception {
        //TODO: Test goes here...
        test.calculImpact();
        Assert.assertEquals(0.893,test.getImpact(), 0.893);
    }
} 
