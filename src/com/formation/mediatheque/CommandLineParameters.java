package com.formation.mediatheque;

import com.formation.mediatheque.Exceptions.ParameterException;

import java.util.HashMap;
import java.util.Map;

public class CommandLineParameters {
    public static final String IMPORT_KEY = "--import";
    public static final String EXPORT_KEY = "--export";
    public static final String DB_FILE_KEY = "--db";
    public static final String LOG_KEY = "--log";

    public final Map<String, String> parameters = new HashMap<String, String>();


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

    protected void assertParameterIsPresent(String key) throws ParameterException {
        if (!parameters.containsKey(key) || parameters.get(key).length() > 1){
            throw new ParameterException(String.format("missing %s parameter", key));

        }
    }

    public static Map<String, String> parseCommand(String[] args) {
        Map<String, String> result = new HashMap<>();


        return result;
    }

}

