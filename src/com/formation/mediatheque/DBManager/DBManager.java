package com.formation.mediatheque.DBManager;

import com.formation.mediatheque.abstraite.commonEntity;
import com.formation.mediatheque.utils.CommandLineParameters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBManager {
    String ConnexionString = "jdbc:mysql://localhost:3306/structures?useSSL=false";
    Connection connexion;
    Statement state;
    Map<String, List<String>> Tables = new HashMap<>();

    public DBManager(CommandLineParameters parameters) throws SQLException {

        InitializeTables();

        this.connexion = DriverManager.getConnection(
                parameters.getParameters(CommandLineParameters.DB_URL_KEY),
                parameters.getParameters(CommandLineParameters.DB_USER_KEY),
                parameters.getParameters(CommandLineParameters.DB_PASSWORD_KEY)
        );
    }


    public void create(commonEntity object) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        StringBuilder sqlCreate = new StringBuilder();
        sqlCreate.append("INSERT INTO ");
        sqlCreate.append(getClassName(object));
        sqlCreate.append(" (");

        String ListMethodString = String.join(", ", getListMethod(object));
        sqlCreate.append(ListMethodString);

        sqlCreate.append(") VALUES (?,?,?,?,?) ");
        String SqlStatement = sqlCreate.toString();

        PreparedStatement Prepare = addAllParameter(SqlStatement, object);
        Prepare.executeQuery();


    }
    public void update(int updateID, commonEntity object) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        List<String> ListMethodString =  getListMethod(object);
        List<String> listMethodStringUpdate = new ArrayList<>();

        for(int i = 0; i < ListMethodString.size(); i++){
             listMethodStringUpdate.add(i, ListMethodString.get(i) + " = ? ");
        }

        StringBuilder sqlUpdate = new StringBuilder();
        sqlUpdate.append("UPDATE ");
        sqlUpdate.append(getClassName(object));
        sqlUpdate.append(" SET ");
        sqlUpdate.append(String.join(", ", listMethodStringUpdate));
        sqlUpdate.append("WHERE id = ").append(updateID);

        String SqlStatement = sqlUpdate.toString();

        PreparedStatement Prepare = addAllParameter(SqlStatement, object);

        Prepare.executeQuery();



    }


    private String getClassName(commonEntity object){
        String[] ClassFullName = object.getClass().getName().split("\\.");
        return ClassFullName[ClassFullName.length - 1];
    }

    private List<String> getListMethod(commonEntity object){
        return Tables.get(getClassName(object) );
    }


    private static String ucfirst(String chaine) {
        return chaine.substring(0, 1).toUpperCase() + chaine.substring(1);
    }

    /**
     * Prepare a sql request from a string, and add every object from an arbitraty object given as parameter
     * @param sqlString Sql statement to use in prepareStatement
     * @param object object to inject in the sql statment
     * @return PreparedStatement
     * @throws SQLException SQL Error
     * @throws InvocationTargetException Error with object getters
     * @throws IllegalAccessException permission problem
     * @throws NoSuchMethodException shitty problem
     */
    private PreparedStatement addAllParameter(String sqlString, commonEntity object) throws SQLException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        List<String> ListMethod = getListMethod(object);

        PreparedStatement Prepare = connexion.prepareStatement(sqlString);
        for (int i = 0; i < ListMethod.size(); i++) {
            String MethodName = "get" + ucfirst(ListMethod.get(i));
            Method method = object.getClass().getMethod(MethodName);

            if (MethodName.equals("getBorrow")) {
                Prepare.setString(i + 1, String.valueOf(method.invoke(object)));
            } else {
                Prepare.setString(i + 1, (String) method.invoke(object));
            }
        }
        return Prepare;
    }


    private void InitializeTables() {
        ArrayList<String> cd = new ArrayList<>();
        cd.add("titre");
        cd.add("reference");
        cd.add("genreMusic");
        cd.add("label");
        cd.add("borrow");
        Tables.put("Cd", cd);

        ArrayList<String> dvd = new ArrayList<>();
        dvd.add("titre");
        dvd.add("reference");
        dvd.add("genreFilm");
        dvd.add("prod");
        dvd.add("borrow");

        ArrayList<String> livre = new ArrayList<>();
        livre.add("titre");
        livre.add("reference");
        livre.add("authorName");
        livre.add("editor");
        livre.add("borrow");

        ArrayList<String> magazine = new ArrayList<>();
        magazine.add("titre");
        magazine.add("reference");
        magazine.add("marque");
        magazine.add("role");

        Tables.put("Cd", cd);
        Tables.put("Dvd", dvd);
        Tables.put("Livre", livre);
        Tables.put("magazine", magazine);
    }

}