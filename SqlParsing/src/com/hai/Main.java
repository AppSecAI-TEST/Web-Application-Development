package com.hai;

public class Main {

    public static void main(String[] args) {
        String query = "select customer_id, firstName as first, lastName as last, cus_loginName as email, "
                + "cus_password as password, cus_username as username, cus_DOB as DOB, user_role as role "
                + "from sp17_3308_tug25055.customer, sp17_3308_tug25055.user_role "
                + "where customer.user_role_id = user_role.user_role_id order by lastName, firstName";
        //getTableName(query);
        String[] columns = getColumnNames(query);
        System.out.println("this is the result");
        for(String c: columns){
            System.out.println(c);
        }
        getColumnQuery(query);

    }

    public static String getTableName(String sql){
        //String parse[] = sql.split("\\s");
        String result;
        /*
        for(int i = 0; i < parse.length; i++){
            System.out.println(parse[i]);
        }/*
        */
        String sqlFrom = "from";
        String sqlWhere= "where";
        String query = sql.toLowerCase();
        //start of From
        int indexOfFrom = query.indexOf(sqlFrom);
        //check if user puts no from clause

        //If the statement has a where clause
        int indexOfEnd = query.indexOf("where");
        //If the statement has no where clause
        if(indexOfEnd < 0){
            System.out.println("IndexofEnd: " + indexOfEnd);
            indexOfEnd = query.length();
        }
        System.out.println("query: " + indexOfFrom + " " + indexOfEnd);

        String tableName = query.substring(indexOfFrom + sqlFrom.length(), indexOfEnd);
        System.out.println(tableName);
        return tableName;

    }

    public static String[] getColumnNames(String sql){
        String sqlSelect= "select ";
        String sqlFrom = "from";
        String alias = " as ";
        //start from end of select tag
        int indexStart = sqlSelect.length();
        //to beginning of from tag
        int indexEnd = sql.indexOf(sqlFrom);
        //Get the column labels
        String columns = sql.substring(indexStart, indexEnd);
        System.out.println("columns: " + columns);
        String columnNames[] = columns.split(",");
        for(int i = 0; i < columnNames.length; i++){
            //check if it has alias and replace column names
            if(columnNames[i].contains(alias)){
                indexStart = columnNames[i].indexOf(alias) + alias.length();
                indexEnd = columnNames[i].length();
                columnNames[i] = columnNames[i].substring(indexStart, indexEnd);
            }
            System.out.println(i + " " + columnNames[i]);
        }
        return columnNames;
    }

    public static String getColumnQuery(String sql){
        String sqlSelect= "select ";
        String sqlFrom = "from";
        String query = sql.toLowerCase();
        //If the statement has a where clause
        int indexOfEnd = query.indexOf("where");
        //If the statement has no where clause
        if(indexOfEnd < 0){
            System.out.println("IndexofEnd: " + indexOfEnd);
            indexOfEnd = query.length();
        }
        System.out.println("query: " + 0 + " " + indexOfEnd);

        String columnQuery = query.substring(0, indexOfEnd);
        System.out.println(columnQuery);
        return columnQuery;
    }
}
