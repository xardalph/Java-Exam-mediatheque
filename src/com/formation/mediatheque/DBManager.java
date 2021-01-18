package com.formation.mediatheque;

import java.sql.*;

public class DBManager {
    String url = "jdbc:mysql://localhost:3306/structures?useSSL=false";
    Connection connexion = null;
    Statement state = null;
    PreparedStatement ps =  null;
    ResultSet result = null;

}

/*
public class StructuresJDBC {

    public static void main(String[] args) {
        // useSSL=false pour �viter le warning
        // Pour MySQL
        String url = "jdbc:mysql://localhost:3306/structures?useSSL=false";
        // SQL Server avec pr�cision de l'instance et du port d'�coute
        //String url = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=structures";
        // SQL Server avec instance et port d'�coute par d�faut
        //String url = "jdbc:sqlserver://localhost;databaseName=structures";
        /*String user = "structuser";
        String mdp = "structuser";*/
        //String user = "root";
        //String mdp = "";
/*
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

            int nbRows = state.executeUpdate("INSERT INTO SECTEUR(LIBELLE) VALUES ('Sant�')");
            System.out.println("Nombre de lignes ins�r�es=" + nbRows);

            nbRows=state.executeUpdate("INSERT INTO SECTEUR(LIBELLE) VALUES ('A�ronautique'),('A�rospatial')",
                    Statement.RETURN_GENERATED_KEYS);
            System.out.println("\nNombre de lignes ins�r�es=" + nbRows);

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
**/