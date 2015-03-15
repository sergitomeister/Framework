/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.caches;

import com.sis.utilidades.caches.xml.XMLCache;
import com.sis.utilidades.caches.xml.XMLCaches;
import com.sis.utilidades.caches.xml.XMLEntidades;
import com.sis.utilidades.reflexion.Reflexion;
import java.util.HashMap;

/**
 *
 * @author sergio
 */
public abstract class AbstractCaches implements ICaches {

    private final HashMap<String, ICache> almacen;

    protected AbstractCaches() {
        this.almacen = new HashMap<>();
    }

    public static ICaches getInstance(Class clase) throws Exception {
        if (clase == null) {
            clase = CachesDefault.class;
        }        
        ICaches iCaches = (ICaches) Reflexion.newInstance(clase, null, null);
        iCaches.inicializar();        
        iCaches.generarCaches();
        return iCaches;
    }
    
    @Override
    public void generarCaches() throws Exception{
        XMLCaches xmlCaches = getXMLCaches();
        XMLCache[] caches = xmlCaches.getCaches();
        for(XMLCache cache : caches){
            String codigo = cache.getCodigo();
            String className = cache.getClassName();
            Class[] tipos = { String.class, XMLEntidades.class };
            Object[] argumentos = { codigo, cache.getEntidades() };
            ICache iCache = (ICache) Reflexion.newInstance(className, tipos, argumentos);
            iCache.inicializar();
            this.almacen.put(codigo, iCache);
        }
    }    
    
    @Override
    public ICache getICache(Class clase){
        ICache cache = null;
        ICache[] iCaches = almacen.values().toArray(new ICache[almacen.size()]);
        for(ICache iCache : iCaches){
            if(iCache.existeEntidad(clase.getName()))
                cache = iCache;
        }
        if(cache == null){
            
        }
        return cache;
    }
}
