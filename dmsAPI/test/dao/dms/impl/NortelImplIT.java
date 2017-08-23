/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.enums.SwitchesEnum;
import exception.LinhaNaoPertenceCentralException;
import model.dms.ConfiguracaoDMS;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class NortelImplIT {

    private NortelImpl instance = new NortelImpl(SwitchesEnum.GOGNA_DOS01);

    public NortelImplIT() {
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
     * Test of consultar method, of class NortelImpl.
     */
    @Test
    public void testConsultar() {
        System.out.println("consultar");
        try {
            String instancia = "4876237846";
//            String instancia = "6230957133";

            ConfiguracaoDMS result = instance.consultarPorDn(instancia);
            System.out.println("Resultado: " + GsonUtil.serialize(result));
            assertTrue("qdn", result != null);
            assertTrue("qlen", instance.consultarPorLen(result.getLen()) != null);
        } catch (Exception e) {
            instance.desconectar();
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testLinhaNaoPertenceCentralException() {
        System.out.println("consultar");
        try {
            String instancia = "4130222839";
            ConfiguracaoDMS result = instance.consultarPorDn(instancia);
            System.out.println("Retono: " + GsonUtil.serialize(result));
        } catch (Exception e) {
            assertTrue(e instanceof LinhaNaoPertenceCentralException);
        }finally{
            instance.desconectar();
        }
    }

}
