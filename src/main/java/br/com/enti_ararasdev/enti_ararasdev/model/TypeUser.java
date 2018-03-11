/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enti_ararasdev.enti_ararasdev.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Michel
 */
@Entity
@Table(name = "type_user")
public class TypeUser implements Serializable {

    @Id
    private String id;
    @Column(name = "function_operator")
    private String functionOperator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFunctionOperator() {
        return functionOperator;
    }

    public void setFunctionOperator(String functionOperator) {
        this.functionOperator = functionOperator;
    }

}
