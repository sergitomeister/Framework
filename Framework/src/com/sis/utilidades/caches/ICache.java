/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.caches;

import com.sis.utilidades.caches.xml.XMLEntidades;

/**
 *
 * @author sergio
 */
public interface ICache {
    
    public String getCodigo();

    public XMLEntidades getXmlEntidades();
    
    public void inicializar();
    
    public boolean existeEntidad(String className);
    
    public Object getObjeto(String key);
    
    public void setObjeto(String key, Object value);
}
