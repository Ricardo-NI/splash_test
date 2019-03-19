package com.example.externalconnection;

public class ScriptSQL {

    static String getCreateTreinos(){

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS CONTATO (" );
        sqlBuilder.append(" ID     INTEGER    PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sqlBuilder.append(" nome  VARCHAR (100),");
        sqlBuilder.append(" email VARCHAR (100))");

        return sqlBuilder.toString();
    }
}
