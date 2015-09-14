/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate;

import org.hibernate.dialect.function.SQLFunctionTemplate;
import java.util.Date;
import org.hibernate.type.StandardBasicTypes;

/**
 *
 * @author User
 */
public class Dialect extends org.hibernate.dialect.H2Dialect{
    
    public Dialect(){
        super();        
        registerFunction("date_add_interval", new SQLFunctionTemplate(  StandardBasicTypes.DATE, "DATE_ADD(?1, INTERVAL ?2 ?3)"));
    }
    
}
