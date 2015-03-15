/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.caches.xml;

import com.sis.utilidades.xml.IElementoXML;

/**
 *
 * @author sergio
 */
public class XMLEntidad {

    public static final String ROOT = "ENTIDAD";
    
    public static final String NOMBRE = "NOMBRE";
    public static final String CLASSNAME = "CLASSNAME";
    
    private final String nombre;
    private final String className;

    public XMLEntidad(IElementoXML elemento) {
        this.nombre = elemento.getValor(NOMBRE);
        this.className = elemento.getValor(CLASSNAME);
    }      

    public String getNombre() {
        return nombre;
    }        

    public String getClassName() {
        return className;
    }        
}
