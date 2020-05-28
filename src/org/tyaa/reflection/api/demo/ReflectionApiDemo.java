/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.reflection.api.demo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yurii
 */
public class ReflectionApiDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // Создать объект желаемого типа
        SecureClass sc = new SecureClass();
        // System.out.println(sc.id);
        // List<String> strings = new ArrayList<>();
        // Получить объект-отражение, описывающий все содержимое типа SecureClass
        Class<?> scReflection = sc.getClass();
        // Из объекта-отражения типа получаем объект-отражение поля
        // с любым модификатором доступа и именем id
        Field idField = scReflection.getDeclaredField("id");
        // Открываем доступ к чтению и записи в поле id
        // любого экземпляра (объекта) типа SecureClass
        idField.setAccessible(true);
        // Просим у объект-отражения поля зайти в объект типа SecureClass
        // через переменную sc и вернуть из него значение поля id
        // System.out.println(idField.get(sc));
        
        /* Получим список отражений всех полей типа SecureClass */
        Field[] scFields =
            scReflection.getDeclaredFields();



        for (Field scField : scFields) {
            scField.setAccessible(true);
            if (scField.get(sc) instanceof String) {
                scField.set(sc, (scField.get(sc) + "Мир!"));
                System.out.printf("new %s = %s\n", scField.getName(), scField.get(sc));
        }


//        for (Field scField : scFields) {
//            scField.setAccessible(true);
//            //System.out.printf("old %s = %s\n", scField.getName(), scField.get(sc));
//            if (scField.get(sc) instanceof String) {
//                scField.set(sc, (scField.get(sc) + "Мир!"));
//                System.out.printf("new %s = %s\n", scField.getName(), scField.get(sc));
//            }
//
//            //System.out.printf("new %s = %s\n", scField.getName(), scField.get(sc));
//        }
    }





    
}
