/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.caches;

import com.sis.constantes.KCaches;
import com.sis.utilidades.caches.xml.XMLCaches;
import com.sis.utilidades.xml.EstructuraXML;
import com.sis.utilidades.xml.IElementoXML;
import com.sis.utilidades.xml.IEstructuraXML;
import java.io.File;

/**
 *
 * @author sergio
 */
public class CachesDefault extends AbstractCaches {
    
    private XMLCaches xmlCaches;

    protected CachesDefault() {
        super();
    }
        
    @Override
    public void inicializar(){
        File file = new File(KCaches.FILE_CACHES);
        IEstructuraXML estructuraXML = EstructuraXML.getInstance(file);
        estructuraXML.generarEstructura("ROOT");
        IElementoXML elementoXML = estructuraXML.getRoot();
        IElementoXML elemento = elementoXML.getElementoXML(XMLCaches.ROOT);
        xmlCaches = new XMLCaches(elemento);
    }

    @Override
    public XMLCaches getXMLCaches() {
        return xmlCaches;
    }
}
