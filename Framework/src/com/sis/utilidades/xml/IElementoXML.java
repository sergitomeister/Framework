/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.xml;

import org.w3c.dom.Node;

/**
 *
 * @author sergio
 */
public interface IElementoXML {
    
    public String getNombre();
    
    public IElementoXML[] getElementos();
    
    public IElementoXML[] getElementos(String tag);
    
    public IElementoXML getElementoXML(String nombre);
    
    public String getValor(String nombre);
    
    public Node getNode();              
    
    public void addValor(String nombre, String valor);     
    
    public void addElemento(IElementoXML elementoXML);
}
