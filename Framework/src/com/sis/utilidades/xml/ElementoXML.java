/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.xml;

import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Node;

/**
 *
 * @author sergio
 */
public class ElementoXML implements IElementoXML{
    
    private final Node node;
    private final String nombre;
    private final HashMap<String, String> valores;
    private final ArrayList<IElementoXML> elementos;

    public ElementoXML(Node node) {
        this.node = node;
        this.nombre = node.getNodeName();
        this.valores = new HashMap<>();
        this.elementos = new ArrayList<>();
    }

    @Override
    public Node getNode() {
        return node;
    }    

    @Override
    public String getNombre() {
        return nombre;
    }      
    
    @Override
    public void addValor(String nombre, String valor){
        this.valores.put(nombre, valor);
    }
    
    @Override
    public String getValor(String nombre){
        return this.valores.get(nombre);
    }
    
    @Override
    public void addElemento(IElementoXML elementoXML){
        this.elementos.add(elementoXML);
    }
    
    @Override
    public IElementoXML[] getElementos(){
        return this.elementos.toArray(new IElementoXML[this.elementos.size()]);
    }
    
    @Override
    public IElementoXML getElementoXML(String nombre){
        IElementoXML[] elementosXML = getElementos();
        for(IElementoXML elemento : elementosXML){
            if(elemento.getNombre().equals(nombre)){
                return elemento;
            }
        }
        return null;
    }

    @Override
    public IElementoXML[] getElementos(String nombre) {
        ArrayList<IElementoXML> items = new ArrayList<>();
        IElementoXML[] elementosXML = getElementos();
        for(IElementoXML elemento : elementosXML){
            if(elemento.getNombre().equals(nombre)){
                items.add(elemento);
            }
        }
        return items.toArray(new IElementoXML[items.size()]);
    }
}
