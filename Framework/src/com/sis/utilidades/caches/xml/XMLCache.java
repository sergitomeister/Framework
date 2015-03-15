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
public class XMLCache {
    
    public static final String ROOT = "CACHE";
    
    public static final String CODIGO = "CODIGO";
    public static final String CLASSNAME = "CLASSNAME";
    
    private final String codigo;
    private final String className;
    private final XMLEntidades entidades;

    public XMLCache(IElementoXML elemento) {
        this.codigo = elemento.getValor(CODIGO);
        this.className = elemento.getValor(CLASSNAME);
        IElementoXML element = elemento.getElementoXML(XMLEntidades.ROOT);        
        this.entidades = new XMLEntidades(element);                            
    }       

    public String getCodigo() {
        return codigo;
    }

    public String getClassName() {
        return className;
    }       

    public XMLEntidades getEntidades() {
        return entidades;
    }        
}
