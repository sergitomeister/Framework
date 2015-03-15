/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utilidades.reflexion;

import java.lang.reflect.Constructor;

/**
 *
 * @author sergio
 */
public class Reflexion {
    
    public static Object newInstance(String className, Class[] tipos, Object[] argumentos) throws Exception{
        Class clase = Class.forName(className);
        return newInstance(clase, tipos, argumentos);
    }
    
    public static Object newInstance(Class clase, Class[] tipos, Object[] argumentos) throws Exception{
        Constructor constructor = getConstructor(clase, tipos);
        return constructor.newInstance(argumentos);
    }
    
    private static Constructor getConstructor(Class clase, Class[] tipos) throws Exception{
        return clase.getConstructor(tipos);
    }
}
