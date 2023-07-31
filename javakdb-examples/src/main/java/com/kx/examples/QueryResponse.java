package com.kx.examples;

import com.kx.c;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Instructs the remote KDB+ process to execute 'q' code (KDB+ native language) and
 * receives the result. The same principle can be used to execute q functions
 */
public class QueryResponse {
    private static final Logger LOGGER = Logger.getLogger(QueryResponse.class.getName());

    private QueryResponse() {
    }

    /**
     * Runs a calcuation on remote KDB+ server and prints result to console
     * Requires a KDB+ server running on port 5001 on your machine i.e. q -p 5001
     *
     * @param args not used
     */
    public static void main(String[] args) {
        c c = null;
        try {
            c = new c("localhost", 5001, "");
            Object result = c.k("2+3");
            LOGGER.log(Level.INFO, "result is {0}", result);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString());
        } finally {
            try {
                if (c != null) c.close();
            } catch (java.io.IOException e) {
                // ingnore exception
            }
        }
    }
}
