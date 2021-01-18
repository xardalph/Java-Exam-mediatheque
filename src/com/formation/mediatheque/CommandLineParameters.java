package com.formation.mediatheque;

import java.util.Map;

public class CommandLineParameters {
    public static final String IMPORT_KEY = "--import";
    public static final String EXPORT_KEY = "--export";
    public static final String DB_FILE_KEY = "--db";
    public static final String LOG_KEY = "--log";

    public final Map<String, String> parameters;


    public CommandLineParameters(String[] args) {
        //need to take every parameter to parameter property
        this.parameters = null;
    }

}
