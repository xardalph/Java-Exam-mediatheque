/*package com.formation.mediatheque.abstraite;

public class DBManager {
    private DBManager() {
    }

    public static IDbConnection GetSQLConnection(string connectionString) {
        try {
            IDbConnection dbConnection = null;
            dbConnection = new SqlConnection(connectionString);
            try {
                dbConnection.Open();
            } catch (SqlException sqlEx) {
                CustomSqlException exCustSql = new CustomSqlException(string.Concat("Error occurred while connecting to the SQL database. Server Name: ",
                        ((SqlConnection) dbConnection).DataSource, ". Exception Message : ", sqlEx.Message));
                throw exCustSql;
            }

            return dbConnection;
        } catch (Exception ex) {
            throw ;
        }
    }

    public static IDbDataParameter CreateSQLDataParameter(IDbCommand idbCommand,
                                                          string parameterName, object parameterValue, DbType dbType) {
        return CreateSQLDataParameter(idbCommand, parameterName, parameterValue, dbType, -1);
    }

    public static IDbDataParameter CreateSQLDataParameter(IDbCommand idbCommand, string parameterName,

                                                          object parameterValue, DbType dbType, int size) {
        IDbDataParameter param = idbCommand.CreateParameter();
        param.ParameterName = parameterName;
        param.DbType = dbType;
        if (size != -1) {
            param.Size = size;
        }
        param.Value = parameterValue;

        return param;
    }

    public static DataSet GetFilledDataSet(IDbCommand idbCommand) {
        IDataAdapter iDataAdapter = DBManager.CreateSQLDataAdapter(idbCommand);
        DataSet dataset = new DataSet();
        iDataAdapter.Fill(dataset);
        return dataset;
    }

    public static IDataAdapter CreateSQLDataAdapter(IDbCommand idbCommand) {
        if (idbCommand is SqlCommand)
        {
            return new SqlDataAdapter((SqlCommand) idbCommand);
        }
        else
        {
            throw new NotSupportedException("Command Type " + idbCommand.GetType().FullName +

                    " are not supported!");
        }
    }
}*/