package model.test;

import model.consoCarbone.ServicePublics;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

/**
 * ServicePublics Tester.
 *
 * @author Qinming JIANG
 * @version 1.0
 * @since <pre>20/12/2022</pre>
 */
public class ServicePublicsTest {
    private ServicePublics test = null;

    /**
     * Before.
     *
     * @throws Exception the exception
     */
    @Before
    public void before() throws Exception {
        test = ServicePublics.creatServicePublics();
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
     * Method: creatServicePublics()
     *
     * @throws Exception the exception
     */
    @Test
    public void CreatServicePublics_createNewServicePublics_returnsNullObject() throws Exception {
        //TODO: Test goes here...
        Assert.assertNull(test);
    }
} 
