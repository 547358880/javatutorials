package com.ericaShy.java8.annotations.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {

    public static void main(String[] args) {
        Class<Member> cl = Member.class;
        String className = cl.getSimpleName();
        DBTable dbTable = cl.getAnnotation(DBTable.class);
        System.out.println(cl.getName());
        System.out.println(cl.getSimpleName());
        if (dbTable == null) {
            System.out.println("No dbTable cnnotations in class " + cl.getSimpleName());
        }

        String tableName = dbTable.name();
        if (tableName.length() < 1) {
            tableName = cl.getName().toUpperCase();
        }
        List<String> columnDefs = new ArrayList<>();
        for (Field field : cl.getDeclaredFields()) {
            String columnName = null;
            Annotation[] anns = field.getDeclaredAnnotations();
            System.out.println(field.getName() + ": " + anns.length);
            if (anns.length < 1) {
                continue;
            }
            if (anns[0] instanceof SQLInteger) {
                SQLInteger sInt = (SQLInteger) anns[0];
                if (sInt.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                } else {
                    columnName = sInt.name();
                }
                columnDefs.add(columnName + " int" + getConstraints(sInt.constraints()));
            }
            if (anns[0] instanceof SQLString) {
                SQLString sString = (SQLString) anns[0];
                if (sString.name().length() < 1) {
                    columnName = field.getName().toLowerCase();
                } else {
                    columnName = sString.name();
                }
                columnDefs.add(columnName + " varchar(" + sString.value() + ")" + getConstraints(sString.constraints()));
            }

            StringBuilder createCommand = new StringBuilder("create table " + tableName + "(");
            for (String columnDef : columnDefs) {
                createCommand.append("\n " + columnDef + ",");
            }
            String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";

            System.out.println("Table Creation SQL for " + className + " is:\n" + tableCreate);
        }
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " not null";
        }
        if (con.primaryKey()) {
            constraints += " primary key";
        }
        if (con.unqie()) {
            constraints += " unique";
        }
        return constraints;
    }
}
