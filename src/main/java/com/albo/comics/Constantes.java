package com.albo.comics;

public class Constantes {
    private Constantes() {//
    }

    public static final String RESPONSE_SUCCESS_COLABORATOR = "{\n" +
            "   \"last_sync\":\"Fecha de la última sincronización en dd/mm/yyyy hh:mm:ss\",\n" +
            "   \"editors\":[\n" +
            "      \"Wilson Moss\",\n" +
            "      \"”Andy Smidth”\"\n" +
            "   ],\n" +
            "   \"writers\":[\n" +
            "      \"Ed Brubaker\",\n" +
            "      \"”Ryan North”\"\n" +
            "   ],\n" +
            "   \"colorists\":[\n" +
            "      \"Rico Renzi\"\n" +
            "   ]\n" +
            "}";

    public static final String RESPONSE_BAD_COLABORATOR = "{\n" +
            "        \"exception\": {\n" +
            "            \"detail\": \"personaje_no_encontrado\"\n" +
            "        },\n" +
            "    \"response\": \"error\"\n" +
            "}\n" +
            "";

    public static final String RESPONSE_SUCCESS_CHARACTER = "{\n" +
            "   \"last_sync\":\"Fecha de la última sincronización en dd/mm/yyyy hh:mm:ss\",\n" +
            "   [,\n" +
            "   \"{character\":\"Squirrel Girl\",\n" +
            "      \"Comics:[\"The Unbeateable Squirrel Girl (2015) #38,\"The Unbeateable Squirrel Girl (2015) #39\"]},\n" +
            "   [,\n" +
            "   \"{character\":\"Jocasta\",\n" +
            "      \"Comics:[\"Tony Stark: Iron Man (2018) #2,\"Tony Stark: Iron Man (2018) #3\"]}\n" +
            "}";

    public static final String RESPONSE_BAD_CHARACTER = "{\n" +
            "        \"exception\": {\n" +
            "            \"detail\": \"personaje_no_encontrado\"\n" +
            "        },\n" +
            "    \"response\": \"error\"\n" +
            "}\n" +
            "";
}
