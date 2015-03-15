/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.caches;

import com.sis.utilidades.caches.xml.IObjetoCache;

/**
 *
 * @author sergio
 */
public abstract class AbstractObjetoCache implements IObjetoCache{
    
    private final ICaches iCaches;

    public AbstractObjetoCache() throws Exception {
        this.iCaches = AbstractCaches.getInstance(null);        
    }        
    
    public Object getObjetoCache(Class clase, Object...parms){
        ICache iCache = this.iCaches.getICache(clase);
        String key = getKey(clase, parms);
        return iCache.getObjeto(key);
    }
    
    public void setObjetoCache(Class clase, Object instance, Object...parms){
        ICache iCache = this.iCaches.getICache(clase);
        String key = getKey(clase, parms);
        iCache.setObjeto(key, instance);
    }
    
    @Override
    public String getKey(Class clase, Object...parms){
        StringBuilder sb = new StringBuilder();
        sb.append(clase.getName());
        if(parms != null && parms.length > 0){
            for (Object parm : parms) {
                sb.append("#");
                sb.append(parm);
            }
        }
        return sb.toString();
    }    
}
