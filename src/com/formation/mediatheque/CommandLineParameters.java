package com.formation.mediatheque;

import com.formation.mediatheque.Exceptions.ParameterException;

import java.util.HashMap;
import java.util.Map;

public class CommandLineParameters {
    public static final String IMPORT_KEY = "--import";
    public static final String EXPORT_KEY = "--export";
    public static final String DB_FILE_KEY = "--db";
    public static final String LOG_KEY = "--log";

    public final Map<String, String> parameters = new HashMap<>();


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


    public String getDbString() {
        return "ttei";
    }
}

