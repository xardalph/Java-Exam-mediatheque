package com.formation.mediatheque.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogToFile {
    public Logger Log;
    public LogToFile(String logPath) throws IOException {

        FileHandler handler = new FileHandler(logPath, true );
        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);

        Logger logger = Logger.getLogger("com.formation.mediatheque");
        logger.addHandler(handler);

        Log = logger;
        Log.info("Openning Log File.");


    }
}
