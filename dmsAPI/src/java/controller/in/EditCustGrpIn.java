/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.in;

import model.dms.ConsultaDMS;
import model.log.ActionsEnum;
import model.log.GenericLog;

/**
 *
 * @author G0041775
 */
public class EditCustGrpIn extends GenericLog {

    private ConsultaDMS dms;

    private String custGrp;

    public EditCustGrpIn() {
        super(ActionsEnum.EDITAR_CUSTGRP);
    }

    public ConsultaDMS getDms() {
        return dms;
    }

    public void setDms(ConsultaDMS dms) {
        this.dms = dms;
    }

    public String getCustGrp() {
        return custGrp;
    }

    public void setCustGrp(String custGrp) {
        this.custGrp = custGrp;
    }

    @Override
    public Object entrada() {
        return dms;
    }

}
