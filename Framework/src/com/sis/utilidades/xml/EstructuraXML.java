/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author sergio
 */
public class EstructuraXML implements IEstructuraXML{
    
    private final File file;
    private Document document;
    private ElementoXML root;
    
    private EstructuraXML(File file){
        this.file = file;
    }
    
    public static IEstructuraXML getInstance(File file){
        String nombre = file.getName();
        EstructuraXML estructuraXML = new EstructuraXML(file);
        estructuraXML.inicializar();
        return estructuraXML;
    }
    
    private void inicializar(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            this.document = (Document) db.parse(file);            
        }catch(IOException | ParserConfigurationException | SAXException e){
            
        }
    }
    
    @Override
    public void generarEstructura(String tag){
        NodeList lista = this.document.getElementsByTagName(tag);
        Node node = lista.item(0);
        this.root = new ElementoXML(node);
        tratarElemento(root);
    }

    @Override
    public void tratarElemento(ElementoXML elementoXML) {
        Node node = elementoXML.getNode();
        NodeList lista = node.getChildNodes();
        for(int i=0; i<lista.getLength(); i++){
            Node nodeHijo = lista.item(i);
            ElementoXML elementoXMLHijo = new ElementoXML(nodeHijo);
            if(nodeHijo.getTextContent() == null || nodeHijo.getTextContent().length() == 0){
                tratarElemento(elementoXMLHijo);
            } else {
                String nombre = nodeHijo.getNodeName();
                String value = nodeHijo.getTextContent();
                elementoXMLHijo.addValor(nombre, value);
            }
            elementoXML.addElemento(elementoXMLHijo);
        }
    }

    @Override
    public IElementoXML getRoot() {
        return this.root;
    }
    
}
