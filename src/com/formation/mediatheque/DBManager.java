package com.formation.mediatheque;

import com.formation.mediatheque.abstraite.toto;

import java.lang.reflect.Field;
import java.sql.*;

public class DBManager {
    String ConnexionString = "jdbc:mysql://localhost:3306/structures?useSSL=false";
    Connection connexion = null;
    Statement state = null;


    public DBManager(CommandLineParameters parameters) throws SQLException {

        this.connexion = DriverManager.getConnection(
                parameters.getParameters(CommandLineParameters.DB_URL_KEY),
                parameters.getParameters(CommandLineParameters.DB_USER_KEY),
                parameters.getParameters(CommandLineParameters.DB_PASSWORD_KEY)
        );
    }
    public void Initialize() throws SQLException {
        state = connexion.createStatement();
        ResultSet result = state.executeQuery("SELECT * FROM secteur");

        // est-ce qu'on fait une méthode pour créer la base de données ?

    }
    public void create(Dvd object) throws SQLException, IllegalAccessException {

        String toto = getPropertyNameList(object);


        String ClassName = object.getClass().getName();

        PreparedStatement Prepare = connexion.prepareStatement("INSERT INTO ? ()");
        Prepare.setString(1, ClassName);

    }

    public String getPropertyNameList(Dvd instance) throws IllegalAccessException {
        Class clazz = instance.getClass();
        StringBuilder output = new StringBuilder();

        for (Field f : instance.getClass().getDeclaredFields()) {
            System.out.println(f.getName());
            //System.out.println(f.get(instance));
        }
        return output.toString();

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