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
public class XMLCaches {
    
    public static final String ROOT = "CACHES";        
    
    private final XMLCache[] caches;

    public XMLCaches(IElementoXML elemento) {
        IElementoXML[] elementos = elemento.getElementos(XMLCache.ROOT);
        ArrayList<XMLCache> items = new ArrayList<>();
        for(IElementoXML elementoXML : elementos){
            XMLCache xmlEntidad = new XMLCache(elementoXML);
            items.add(xmlEntidad);
        }
        this.caches = items.toArray(new XMLCache[items.size()]);
    }       

    public XMLCache[] getCaches() {
        if(caches == null)
            return new XMLCache[0];
        return caches;
    }
    
    public XMLCache getCache(String nombre){
        if(caches != null && caches.length > 0){
            for(XMLCache cache : caches){
                if(cache.getCodigo().equals(nombre)){
                    return cache;
                }
            }
        }
        return null;
    }
}
