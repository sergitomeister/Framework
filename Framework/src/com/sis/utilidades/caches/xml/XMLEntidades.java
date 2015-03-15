/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.caches.xml;

import com.sis.utilidades.xml.IElementoXML;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class XMLEntidades {
    
    public static final String ROOT = "ENTIDADES";        
    
    private final XMLEntidad[] entidades;

    public XMLEntidades(IElementoXML elemento) {
        IElementoXML[] elementos = elemento.getElementos(XMLEntidad.ROOT);
        ArrayList<XMLEntidad> items = new ArrayList<>();
        for(IElementoXML elementoXML : elementos){
            XMLEntidad xmlEntidad = new XMLEntidad(elementoXML);
            items.add(xmlEntidad);
        }
        this.entidades = items.toArray(new XMLEntidad[items.size()]);
    }       

    public XMLEntidad[] getEntidades() {
        if(entidades == null)
            return new XMLEntidad[0];
        return entidades;
    }
    
    public XMLEntidad getEntidad(String nombre){
        if(entidades != null && entidades.length > 0){
            for(XMLEntidad entidad : entidades){
                if(entidad.getNombre().equals(nombre)){
                    return entidad;
                }
            }
        }
        return null;
    }
}
