/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.caches;

import com.sis.utilidades.caches.xml.XMLEntidad;
import com.sis.utilidades.caches.xml.XMLEntidades;
import java.util.HashMap;

/**
 *
 * @author sergio
 */
public class AbstractCache implements ICache{

    private final String codigo;
    private final XMLEntidades xmlEntidades;
    private final HashMap<String, XMLEntidad> entidades;
    private final HashMap<String, Object> almacen;

    public AbstractCache(String codigo, XMLEntidades xmlEntidades) {
        this.codigo = codigo;
        this.xmlEntidades = xmlEntidades;
        this.entidades = new HashMap<>();
        this.almacen = new HashMap<>();
    }
    
    @Override
    public void inicializar(){
        XMLEntidad[] entidadesXML = this.xmlEntidades.getEntidades();
        for(XMLEntidad entidadXML : entidadesXML){
            String className = entidadXML.getClassName();
            this.entidades.put(className, entidadXML);
        }
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public XMLEntidades getXmlEntidades() {
        return xmlEntidades;
    }      
    
    public XMLEntidad getXMLEntidad(String className){
        return this.entidades.get(className);
    }
    
    @Override
    public boolean existeEntidad(String className){
        XMLEntidad entidad = getXMLEntidad(className);
        return entidad != null;
    }

    @Override
    public Object getObjeto(String key) {
        return almacen.get(key);
    }

    @Override
    public void setObjeto(String key, Object value) {
        this.almacen.put(key, value);
    }
}
