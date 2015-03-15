/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.caches;

import com.sis.utilidades.caches.xml.XMLCaches;

/**
 *
 * @author sergio
 */
public interface ICaches {

    public void inicializar();
    
    public void generarCaches()  throws Exception;
    
    public XMLCaches getXMLCaches();
    
    public ICache getICache(Class clase);
}
