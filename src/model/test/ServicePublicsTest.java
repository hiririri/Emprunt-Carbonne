package model.test;

import model.consoCarbone.ServicePublics;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ServicePublics Tester. 
* 
* @author <Authors name> 
* @since <pre>20/12/2022</pre>
* @version 1.0 
*/ 
public class ServicePublicsTest {
    private ServicePublics test = null;

    @Before
    public void before() throws Exception {
        test = ServicePublics.creatServicePublics();
    }

    @After
    public void after() throws Exception {
        test = null;
    }

    /**
    *
    * Method: creatServicePublics()
    *
    */
    @Test
    public void CreatServicePublics_createNewServicePublics_returnsNullObject() throws Exception {
        //TODO: Test goes here...
        Assert.assertNull(test);
    }
} 
