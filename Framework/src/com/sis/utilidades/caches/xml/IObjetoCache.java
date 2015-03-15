/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.caches.xml;

/**
 *
 * @author sergio
 */
public interface IObjetoCache {
    
    public String getKey(Class clase, Object...parms);
}
