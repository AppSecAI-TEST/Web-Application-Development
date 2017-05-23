<%@page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%> 

<%@page language="java" import="com.google.gson.*" %>
<%@page language="java" import="dbUtils.*" %>

<% 
    /* 
    Note (in the 1st line of this file) that Web API JSP pages have a different contentType 
    (application/json). A JSP page would have contentType "text/html"

    The com.google.gson import line (line 3 above) references the GSON that should 
    have been added as a jar file to your project Libraries. 
    */
    
    SelectOptionList episodeList = new SelectOptionList();
    episodeList.addOption(new SelectOption("0", "Select Episode"));
    episodeList.addOption(new SelectOption("3", "Bamm Bamm falls for Pebbles"));
    episodeList.addOption(new SelectOption("4", "Two Men on a Dinosaur"));
    episodeList.addOption(new SelectOption("9", "My Fair Freddy"));

    Gson gson = new Gson();
    out.print(gson.toJson(episodeList).trim());
%>