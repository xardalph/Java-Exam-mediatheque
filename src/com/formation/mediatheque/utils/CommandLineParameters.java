package com.formation.mediatheque.utils;

import com.formation.mediatheque.Exceptions.InvalidConfigurationFileException;
import com.formation.mediatheque.Exceptions.ParameterException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandLineParameters {


    public String getImportKey() {
        return parameters.get(IMPORT_KEY);
    }

    public String getExportKey() {
        return parameters.get(EXPORT_KEY);
    }

    public String getDbFileKey() {
        return parameters.get(DB_FILE_KEY);
    }

    public String getLogKey() {
        return parameters.get(LOG_KEY);
    }

    public String getDbUrlKey() {
        return parameters.get(DB_URL_KEY);
    }

    public String getDbUserKey() {
        return parameters.get(DB_USER_KEY);
    }

    public String getDbPasswordKey() {
        return parameters.get(DB_PASSWORD_KEY);
    }

    public static final String IMPORT_KEY = "--import";
    public static final String EXPORT_KEY = "--export";
    public static final String DB_FILE_KEY = "--db";
    public static final String LOG_KEY = "--log";
    public static final String DB_URL_KEY = "db.url";
    public static final String DB_USER_KEY = "db.username";
    public static final String DB_PASSWORD_KEY = "db.password";

    protected final Map<String, String> parameters = new HashMap<>();


    public CommandLineParameters(String[] args) {
        String lastKey = null;
        for (String arg : args) {
            if (arg != null && arg.startsWith("-")) {
                lastKey = arg;
                this.parameters.put(lastKey, "");
                continue;
            }
            this.parameters.replace(lastKey, arg);
        }


    }
    public final Map<String, String> getParametersMap(){
        return this.parameters;
    }

    public String getParameters(String key) {
        return parameters.get(key);
    }

    public void assertParametersAreValid() throws ParameterException{
        if (!assertParameterIsPresent(DB_FILE_KEY) || !assertParameterIsPresent(LOG_KEY) ){
            throw new ParameterException("DB file AND log file are required");
        }

        if (assertParameterIsPresent(IMPORT_KEY) && assertParameterIsPresent(EXPORT_KEY)){
            throw new ParameterException("You can't use --export and --import at the same time, remove one of them");
        }


    }

    protected boolean assertParameterIsPresent(String key) {
        if (parameters.containsKey(key) && parameters.get(key).length() > 1){
            return true;
        }
        else{
            return false;
        }
    }


    public void GetConfiguration() throws IOException, InvalidConfigurationFileException {

        InputStream input = new FileInputStream(this.getParameters(CommandLineParameters.DB_FILE_KEY));
        Properties prop = new Properties();
        prop.load(input);

        if (!prop.containsKey(DB_URL_KEY) || !prop.containsKey(DB_USER_KEY) || !prop.containsKey(DB_PASSWORD_KEY)){
            throw new InvalidConfigurationFileException("Invalid database file, please check. required property are : "
                    + DB_URL_KEY + ", " + DB_USER_KEY + ", " + DB_PASSWORD_KEY);
        }

        this.parameters.put(DB_URL_KEY, prop.getProperty(DB_URL_KEY));
        this.parameters.put(DB_USER_KEY, prop.getProperty(DB_USER_KEY));
        this.parameters.put(DB_PASSWORD_KEY, prop.getProperty(DB_PASSWORD_KEY));


    }
}

