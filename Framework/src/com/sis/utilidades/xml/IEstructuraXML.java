/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.xml;

/**
 *
 * @author sergio
 */
public interface IEstructuraXML {
    
    public void generarEstructura(String tag);
    
    public void tratarElemento(ElementoXML elementoXML);
    
    public IElementoXML getRoot();
}
