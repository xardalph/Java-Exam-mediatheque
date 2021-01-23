package com.formation.mediatheque.DBManager;

import com.formation.mediatheque.abstraite.commonEntity;
import com.formation.mediatheque.utils.CommandLineParameters;
import com.formation.mediatheque.data.Dvd;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBManager {
    String ConnexionString = "jdbc:mysql://localhost:3306/structures?useSSL=false";
    Connection connexion = null;
    Statement state = null;
    Map<String, List<String>> Tables = new HashMap<String, List<String>>();

    public DBManager(CommandLineParameters parameters) throws SQLException {

        InitializeTables();

        this.connexion = DriverManager.getConnection(
                parameters.getParameters(CommandLineParameters.DB_URL_KEY),
                parameters.getParameters(CommandLineParameters.DB_USER_KEY),
                parameters.getParameters(CommandLineParameters.DB_PASSWORD_KEY)
        );

        state = connexion.createStatement();
        ResultSet result = state.executeQuery("SELECT * FROM dvd");
    }

    private void InitializeTables() {
        ArrayList<String> cd =  new ArrayList<String>();
        cd.add("titre");
        cd.add("reference");
        cd.add("genreMusic");
        cd.add("label");
        cd.add("borrow");
        Tables.put("Cd", cd);

        ArrayList<String> dvd =  new ArrayList<String>();
        dvd.add("titre");
        dvd.add("reference");
        dvd.add("genreFilm");
        dvd.add("prod");
        dvd.add("borrow");

        ArrayList<String> livre =  new ArrayList<String>();
        livre.add("titre");
        livre.add("reference");
        livre.add("authorName");
        livre.add("editor");
        livre.add("borrow");

        ArrayList<String> magazine =  new ArrayList<String>();
        magazine.add("titre");
        magazine.add("reference");
        magazine.add("marque");
        magazine.add("role");

        Tables.put("Cd", cd);
        Tables.put("Dvd", dvd);
        Tables.put("Livre", livre);
        Tables.put("magazine", magazine);
    }

    public void Initialize() throws SQLException {
        state = connexion.createStatement();
        ResultSet result = state.executeQuery("SELECT * FROM secteur");

        //est-ce qu'on fait une méthode pour créer la base de données ?

    }

    public void create(commonEntity object) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String[] ClassFullName = object.getClass().getName().split("\\.");
        String ClassName = ClassFullName[ClassFullName.length - 1];

        List<String> ListMethod = Tables.get(ClassName);
        Class c = object.getClass();

        StringBuilder sqlCreate = new StringBuilder();
        sqlCreate.append("INSERT INTO ");
        sqlCreate.append(ClassName);
        sqlCreate.append(" (");

        for (String column : ListMethod){
            sqlCreate.append(column + ", ");
        }
        sqlCreate.append(") VALUES (?,?,?,?,?) ");
        String CreateStatement = sqlCreate.toString();
        PreparedStatement Prepare = connexion.prepareStatement(CreateStatement);
        String paramValue;
        for (int i = 0; i < ListMethod.size(); i++){
            String MethodName = "get" + ucfirst(ListMethod.get(i));
            Method method = c.getMethod(MethodName);

            paramValue = (String) method.invoke(object);
            Prepare.setString(i, paramValue);
        }


        Method[] methods = c.getMethods();

        Method method = c.getMethod("getReference");

        String tata = (String) method.invoke(object);


        //Method method = DBManager.class.getDeclaredMethod("create" + ClassName);

        //PreparedStatement Prepare = (PreparedStatement) method.invoke(object);

       // Prepare.executeQuery();

    }
    private static String ucfirst(String chaine){
        return chaine.substring(0, 1).toUpperCase()+ chaine.substring(1).toLowerCase();
    }
    public PreparedStatement createDvd(Dvd object) throws SQLException {
        PreparedStatement Prepare = connexion.prepareStatement("INSERT INTO dvd(titre,reference,genreFilm,prod) VALUES ('?','?','?','?')");
        Prepare.setString(1, object.getTitre());
        Prepare.setString(2, object.getReference());
        Prepare.setString(3, object.getGenreFilm());
        Prepare.setString(4, object.getProd());

        return Prepare;
//INSERT INTO dvd(titre,reference,genreFilm,prod) VALUES ("Rio","123AD123","Animation","CenturyFox");
    }


}

/*

public class StructuresJDBC {

    public static void main(String[] args) {
        // useSSL=false pour éviter le warning
        // Pour MySQL
        String url = "jdbc:mysql://localhost:3306/structures?useSSL=false";
        // SQL Server avec précision de l'instance et du port d'écoute
        //String url = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=structures";
        // SQL Server avec instance et port d'écoute par défaut
        //String url = "jdbc:sqlserver://localhost;databaseName=structures";
        String user = "structuser";
        String mdp = "structuser";
        //String user = "root";
        //String mdp = "";

        Connection connexion = null;
        Statement state = null;
        PreparedStatement ps =  null;
        ResultSet result = null;

        try {

            connexion = DriverManager.getConnection(url, user, mdp);
            state = connexion.createStatement();
            result = state.executeQuery("SELECT * FROM secteur");

            while (result.next()) {
                int id = result.getInt("ID");
                String libelle = result.getString("LIBELLE");
                System.out.println("ID=" + id + ", " + "LIBELLE=" + libelle);
            }
            result.close();

            int nbRows = state.executeUpdate("INSERT INTO SECTEUR(LIBELLE) VALUES ('Santé')");
            System.out.println("Nombre de lignes insérées=" + nbRows);

            nbRows=state.executeUpdate("INSERT INTO SECTEUR(LIBELLE) VALUES ('Aéronautique'),('Aérospatial')",
                    Statement.RETURN_GENERATED_KEYS);
            System.out.println("\nNombre de lignes insérées=" + nbRows);

            result=state.getGeneratedKeys();
            System.out.println("Identifiants:");
            while (result.next()) {
                int id = result.getInt(1);
                System.out.println(id);
            }
            result.close();

            System.out.println("Saisissez le nom d'une ville pour lister ses structures:");
            Scanner sc = new Scanner(System.in);
            String ville = sc.nextLine();
            sc.close();

            ps = connexion.prepareStatement("SELECT * FROM STRUCTURE WHERE VILLE = ?");

            ps.setString(1, ville);
            result = ps.executeQuery();
            while (result.next()) {
                String nom = result.getString("NOM");
                System.out.println("Nom : " + nom);
            }
            result.close();

            result = state.executeQuery(
                    "SELECT NOM, ID_STRUCTURE, COUNT(*) AS 'Nb_secteurs_activites' " +
                            "FROM STRUCTURE, SECTEUR, SECTEURS_STRUCTURES " +
                            "WHERE SECTEUR.ID = ID_SECTEUR " +
                            "AND ID_STRUCTURE = STRUCTURE.ID " +
                            "GROUP BY ID_STRUCTURE, NOM");

            while (result.next()) {
                String nom = result.getString("NOM");
                int id = result.getInt("ID_STRUCTURE");
                int nbSecteurs = result.getInt("Nb_secteurs_activites");
                System.out.println("NOM=" + nom + ", ID=" + id + ", " + "nb secteurs=" + nbSecteurs);
            }
            result.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null)
                    result.close();
                if (state != null)
                    state.close();
                if (ps != null)
                    ps.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
*/