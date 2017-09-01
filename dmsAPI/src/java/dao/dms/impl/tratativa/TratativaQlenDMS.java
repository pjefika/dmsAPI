/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.tratativa;

import model.dms.ConfiguracaoDMS;
import model.dms.LineService;
import util.Regex;

public class TratativaQlenDMS implements Tratativa<ConfiguracaoDMS> {

    @Override
    public ConfiguracaoDMS parse(String blob) throws Exception {
        System.out.println("Blob:" + blob);
        ConfiguracaoDMS conf = new ConfiguracaoDMS();

        String prefixPattern = "(?:LINESNPA:\\s{0,5}(\\d{1,10}))";
        String dnPattern = "(?:DIRECTORY NUMBER:\\s{0,10}(\\d{1,10}))";
        String custGrpPattern = "(?:STATIONCUSTGRP:\\s{0,20}(\\w{6,10}))";
        String ncosPattern = "(?:NCOS:\\s{0,1}(\\d{1,5}))";
        String servPattern = "(?:OPTIONS:)(.{0,50})[^-]";
        
        String prefix = Regex.capture(blob, prefixPattern).trim();
        String dn = Regex.capture(blob, dnPattern).trim();

        conf.setDn(prefix.concat(dn));
        conf.setCustGrp(Regex.capture(blob, custGrpPattern).trim());
        conf.setNcos(new Integer(Regex.capture(blob, ncosPattern)));

        String servs = Regex.capture(blob, servPattern).trim();

        for (String key : servs.split(" ")) {
            LineService serv = LineService.findByKey(key);
            if (serv != null) {
                conf.add(serv);
            }
        }

        return conf;
    }

}