/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.dto;

import model.dms.LineService;
import model.dms.ServiceType;

/**
 *
 * @author G0042204
 */
public class LineServiceDTO {

    private String desc, key, nome;

    private ServiceType tipo;

    public LineServiceDTO() {
    }

    public LineServiceDTO(String desc, String key, ServiceType tipo, String name) {
        this.desc = desc;
        this.key = key;
        this.tipo = tipo;
        this.nome = name;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public ServiceType getTipo() {
        return tipo;
    }

    public void setTipo(ServiceType tipo) {
        this.tipo = tipo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object obj) {
        LineServiceDTO l = (LineServiceDTO) obj;
        return l.getKey().equalsIgnoreCase(key);
    }

    public LineService toEnum() {
        return LineService.findByKey(key);
    }

}
