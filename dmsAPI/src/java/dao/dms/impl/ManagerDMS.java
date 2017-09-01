/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.enums.SwitchesEnum;
import model.dms.ConfiguracaoDMS;

/**
 *
 * @author G0042204
 */
public interface ManagerDMS {

    public ConfiguracaoDMS consultarPorDn(String instancia) throws Exception;

    public ConfiguracaoDMS consultarPorLen(String len) throws Exception;

    public Boolean isSameSwitch(SwitchesEnum sw);

    public Boolean isSamePrefix(String prefix);

    public Boolean isSameIP(String ip);

}