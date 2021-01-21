package com.formation.mediatheque.DBManager;

import com.formation.mediatheque.abstraite.commonEntity;
import com.formation.mediatheque.utils.CommandLineParameters;
import com.formation.mediatheque.data.Dvd;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

        //est-ce qu'on fait une méthode pour créer la base de données ?

    }
    public void create(commonEntity object) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String ClassName = object.getClass().getName();
        Method method = DBManager.class.getDeclaredMethod("create" + ClassName);
        PreparedStatement Prepare = (PreparedStatement) method.invoke(object);

        Prepare.executeQuery();

    }
    protected PreparedStatement createDvd(Dvd object) throws SQLException {
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