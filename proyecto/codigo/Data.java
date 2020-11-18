package me.DavidLake.Entrega1;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    /*
    0: estu_consecutivo.1
    1: estu_exterior
    2: periodo
    3: estu_tieneetnia
    4: estu_tomo_cursopreparacion
    5: estu_cursodocentesies
    6: estu_cursoiesapoyoexterno
    7: estu_cursoiesexterna
    8: estu_simulacrotipoicfes
    9: estu_actividadrefuerzoareas
    10: estu_actividadrefuerzogeneric
    11: fami_trabajolaborpadre
    12: fami_trabajolabormadre
    13: fami_numlibros
    14: estu_inst_cod_departamento
    15: estu_tipodocumento.1
    16: estu_nacionalidad.1
    17: estu_genero.1
    18: estu_fechanacimiento.1
    19: periodo.1
    20: estu_estudiante.1
    21: estu_pais_reside.1
    22: estu_depto_reside.1
    23: estu_cod_reside_depto.1
    24: estu_mcpio_reside.1
    25: estu_cod_reside_mcpio.1
    26: estu_areareside
    27: estu_valorpensioncolegio
    28: fami_educacionpadre.1
    29: fami_educacionmadre.1
    30: fami_ocupacionpadre.1
    31: fami_ocupacionmadre.1
    32: fami_estratovivienda.1
    33: fami_nivelsisben
    34: fami_pisoshogar
    35: fami_tieneinternet.1
    36: fami_tienecomputador.1
    37: fami_tienemicroondas
    38: fami_tienehorno
    39: fami_tieneautomovil.1
    40: fami_tienedvd
    41: fami_tiene_nevera.1
    42: fami_tiene_celular.1
    43: fami_telefono.1
    44: fami_ingresofmiliarmensual
    45: estu_trabajaactualmente
    46: estu_antecedentes
    47: estu_expectativas
    48: cole_codigo_icfes
    49: cole_cod_dane_establecimiento
    50: cole_nombre_establecimiento
    51: cole_genero
    52: cole_naturaleza
    53: cole_calendario
    54: cole_bilingue
    55: cole_caracter
    56: cole_cod_dane_sede
    57: cole_nombre_sede
    58: cole_sede_principal
    59: cole_area_ubicacion
    60: cole_jornada
    61: cole_cod_mcpio_ubicacion
    62: cole_mcpio_ubicacion
    63: cole_cod_depto_ubicacion
    64: cole_depto_ubicacion
    65: punt_lenguaje
    66: punt_matematicas
    67: punt_biologia
    68: punt_quimica
    69: punt_fisica
    70: punt_ciencias_sociales
    71: punt_filosofia
    72: punt_ingles
    73: desemp_ingles
    74: profundiza
    75: puntaje_prof
    76: desemp_prof
    77: exito
     */

    public static final ArrayList<String[]> vDataList = new ArrayList<>();
    private static final String vPathName = "Train.csv";
    public static final ArrayList<String> vConditions = new ArrayList<>();

    public static void readData(){

        File vDataFile = new File(vPathName);

        try {

            FileReader vFileReader = new FileReader(vDataFile);
            BufferedReader vBufferedReader = new BufferedReader(vFileReader); //Puede causar excepciones al leer ciertos archivos sin UNICODE-8
            String vLine;
            String[] vFirstLine = vBufferedReader.readLine().split(";");

            vConditions.addAll(Arrays.asList(vFirstLine));

            while ((vLine = vBufferedReader.readLine())!=null) {

                Data.addToList(Data.vDataList, vLine.split(";"));
            }

        } catch (IOException vException) {

            System.out.println(vException.getMessage());
        }
    }

    public static void addToList(List<String[]> vFinalList, String[] vData){

        vFinalList.add(vData);
    }

    public static ArrayList<String[]> getDataList(){

        return Data.vDataList;
    }

    public static String convertStringToNumberString(String vString){

        char[] vArray = vString.toCharArray();
        StringBuilder vTemp = new StringBuilder();

        for(char a : vArray){

            switch (a){

                case '1','2','3','4','5','6','7','8','9','0', '.' -> vTemp.append(a);
            }
        }

        return vTemp.toString();
    }

    public static String convertirCadenaANota(String cadena){

        if(cadena.isEmpty()) return "";

        float vFloat = Float.parseFloat(cadena);

        if(vFloat > 0 && vFloat < 21) return "Mayor a 0 y menor a 21";
        if(vFloat > 20 && vFloat < 41) return "Mayor a 20 y menor a 41";
        if(vFloat > 40 && vFloat < 61) return "Mayor a 40 y menor a 61";
        if(vFloat > 60 && vFloat < 81) return "Mayor a 60 y menor a 81";
        if(vFloat > 80 && vFloat < 101) return "Mayor a 80 y menor a 101";

        return "";
    }
}