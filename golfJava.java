/**
 * @author: Marcelo Yévenes Moreno
 * @version: 1.0 04 de diciembre del 2020
 */

public class golfJava {

    public static void main(String[] args) {

        /*
         * Esta matriz representa la tabla que se debe extraer de la base de datos que
         * por motivos practivos se utiliza una matriz para evitar utilizar una bd, se
         * usara una matriz de int para poder llenar cada valor según corresponda
         */

         

        // [Cielo][Temperatura][Humedad][Viento][Se jugó]
        int[][] matrizValores = { 
                { 3, 1, 1, 2, 2},
                { 3, 1, 1, 1, 2}, 
                { 2, 1, 1, 2, 1},
                { 1, 2, 1, 2, 1}, 
                { 1, 3, 2, 2, 1},
                { 1, 3, 2, 1, 2},
                { 2, 3, 2, 1, 1},
                { 3, 2, 1, 2, 2}, 
                { 3, 3, 2, 2, 1},
                { 1, 2, 2, 2, 1}, 
                { 3, 2, 2, 1, 1},
                { 2, 2, 1, 1, 1}, 
                { 2, 1, 2, 2, 1},
                { 1, 2, 1, 1, 2}, 
            };

        // Parámetros que debe indicar el usuario que serán los que quiere averiguar
        int paramCielo = 3;
        int paramTemp = 3;
        int paramHumedad = 1;
        int paramViento = 1;

        // Probabilidad de jugar y no jugar
        int cantidadSi;
        int cantidadNo;
        int i, j;

        double probabilidadJugar;
        double probabilidadNoJugar;

        cantidadSi = calcularJugados(matrizValores);
        cantidadNo = matrizValores.length - cantidadSi;

        probabilidadJugar = Double.valueOf(cantidadSi) / Double.valueOf(matrizValores.length);
        probabilidadNoJugar = Double.valueOf(cantidadNo) / Double.valueOf(matrizValores.length);

        System.out.printf("La probabilida actual que se juege es: %f \n", probabilidadJugar);
        System.out.printf("La probabilida actual que NO se juege es: %f \n", probabilidadNoJugar);

        /* 
        // Calculo de matrices de frecuencia para si y no

        double[][] matrizFrecuenciaCielo = new double[3][2];
        double[][] matrizFrecuenciaHumendad = new double[2][2];
        double[][] matrizFrecuenciaTemperatura = new double[3][2];
        double[][] matrizFrecuenciaViento = new double[2][2];

        // Cielo - Si se juega
        double contadorSoleadoSi = 0.0;
        double contadorNubladoSi = 0.0;
        double contadorLluviosSi = 0.0;

        // Cielo - No se juega
        double contadorSoleadoNo = 0.0;
        double contadorNubladoNo = 0.0;
        double contadorLluviosNo = 0.0;

        // Humedad - Si se juega
        double contadorAltaSi = 0.0;
        double contadorNormalSi = 0.0;

        // Humedad - No se juega
        double contadorAltaNo = 0.0;
        double contadorNormalNo = 0.0;

        // Temperatura - Si se juega
        double contadorCalorSi = 0.0;
        double contadorTempladoSi = 0.0;
        double contadorFrioSi = 0.0;

        // Temperatura - No se juega
        double contadorCalorNo = 0.0;
        double contadorTempladoNo = 0.0;
        double contadorFrioNo = 0.0;

        // Viento - Si se juega
        double contadorHayVientoSi = 0.0;
        double contadorHayVientoNo = 0.0;

        // Viento - No Se juega
        double contadorNoHayVientoSi = 0.0;
        double contadorNoHayVientoNo = 0.0;

        for (i = 0; i < matrizValores.length; i++) {

            // -----Cielo-----
            // Soleado - Si se juega
            if (matrizValores[i][0].equals("Soleado") && matrizValores[i][4].equals("Si")) {
                contadorSoleadoSi++;
            }

            // Soleado - No se juega
            if (matrizValores[i][0].equals("Soleado") && matrizValores[i][4].equals("No")) {
                contadorSoleadoNo++;
            }

            // Nublado - Si se juega
            if (matrizValores[i][0].equals("Nublado") && matrizValores[i][4].equals("Si")) {
                contadorNubladoSi++;
            }

            // Nublado - No se juega
            if (matrizValores[i][0].equals("Nublado") && matrizValores[i][4].equals("No")) {
                contadorNubladoNo++;
            }

            // Lluvia - Si se juega
            if (matrizValores[i][0].equals("Lluvia") && matrizValores[i][4].equals("Si")) {
                contadorLluviosSi++;
            }

            // Lluvia - No se juega
            if (matrizValores[i][0].equals("Lluvia") && matrizValores[i][4].equals("No")) {
                contadorLluviosNo++;
            }

            // -----Temperatura-----

            // Calor - Si se juega
            if (matrizValores[i][1].equals("Calor") && matrizValores[i][4].equals("Si")) {
                contadorCalorSi++;
            }

            // Calor - No se juega
            if (matrizValores[i][1].equals("Calor") && matrizValores[i][4].equals("No")) {
                contadorCalorNo++;
            }

            // Templado - Si se juega
            if (matrizValores[i][1].equals("Templado") && matrizValores[i][4].equals("Si")) {
                contadorTempladoSi++;
            }

            // Templado - No se juega
            if (matrizValores[i][1].equals("Templado") && matrizValores[i][4].equals("No")) {
                contadorTempladoNo++;
            }

            // Frio - Si se juega
            if (matrizValores[i][1].equals("Frío") && matrizValores[i][4].equals("Si")) {
                contadorFrioSi++;
            }

            // Frio - No se juega
            if (matrizValores[i][1].equals("Frío") && matrizValores[i][4].equals("No")) {
                contadorFrioNo++;
            }

            // -----Humedad-----

            // Alta - Si se juega
            if (matrizValores[i][2].equals("Alta") && matrizValores[i][4].equals("Si")) {
                contadorAltaSi++;
            }

            // Alta - No se juega
            if (matrizValores[i][2].equals("Alta") && matrizValores[i][4].equals("No")) {
                contadorAltaNo++;
            }

            // Normal - Si se juega
            if (matrizValores[i][2].equals("Normal") && matrizValores[i][4].equals("Si")) {
                contadorNormalSi++;
            }

            // Normal - No se juega
            if (matrizValores[i][2].equals("Normal") && matrizValores[i][4].equals("No")) {
                contadorNormalNo++;
            }

            // -----Viento-----

            // Si hay viento - Si se juega
            if (matrizValores[i][3].equals("Si") && matrizValores[i][4].equals("Si")) {
                contadorHayVientoSi++;
            }

            // Si hay viento - No se juega
            if (matrizValores[i][3].equals("Si") && matrizValores[i][4].equals("No")) {
                contadorHayVientoNo++;
            }

            // No hay viento - Si se juega
            if (matrizValores[i][3].equals("No") && matrizValores[i][4].equals("Si")) {
                contadorNoHayVientoSi++;
            }

            // No hay viento - No se juega
            if (matrizValores[i][3].equals("No") && matrizValores[i][4].equals("No")) {
                contadorNoHayVientoNo++;
            }

        }

        // -----Se llenan de datos las matrices de frecuencia-----

        // -----Cielo-----
        System.out.println(contadorSoleadoNo);

        matrizFrecuenciaCielo[0][0] = contadorSoleadoSi / Double.valueOf(cantidadSi);
        matrizFrecuenciaCielo[1][0] = contadorNubladoSi / Double.valueOf(cantidadSi);
        matrizFrecuenciaCielo[2][0] = contadorLluviosSi / Double.valueOf(cantidadSi);

        matrizFrecuenciaCielo[0][1] = contadorSoleadoNo / Double.valueOf(cantidadNo);
        matrizFrecuenciaCielo[1][1] = contadorNubladoNo / Double.valueOf(cantidadNo);
        matrizFrecuenciaCielo[2][1] = contadorLluviosNo / Double.valueOf(cantidadNo);

        // Se muestra la tabla de frecuencia de cielo

        System.out.println("Tabla de frecuencia de cielo:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 2; j++) {
                System.out.printf("%f ", matrizFrecuenciaCielo[i][j]);
            }
            System.out.print("\n");
        }

        matrizFrecuenciaTemperatura[0][0] = contadorCalorSi / Double.valueOf(cantidadSi);
        matrizFrecuenciaTemperatura[1][0] = contadorTempladoSi / Double.valueOf(cantidadSi);
        matrizFrecuenciaTemperatura[2][0] = contadorFrioSi / Double.valueOf(cantidadSi);

        matrizFrecuenciaTemperatura[0][1] = contadorCalorNo / Double.valueOf(cantidadNo);
        matrizFrecuenciaTemperatura[1][1] = contadorTempladoNo / Double.valueOf(cantidadNo);
        matrizFrecuenciaTemperatura[2][1] = contadorFrioNo / Double.valueOf(cantidadNo);

        // -----Temperatura-----
        System.out.println("Tabla de frecuencia de temperatura:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 2; j++) {
                System.out.printf("%f ", matrizFrecuenciaTemperatura[i][j]);
            }
            System.out.print("\n");
        }

        // -----Humedad-----

        matrizFrecuenciaHumendad[0][0] = contadorAltaSi / Double.valueOf(cantidadSi);
        matrizFrecuenciaHumendad[1][0] = contadorNormalSi / Double.valueOf(cantidadSi);

        matrizFrecuenciaHumendad[0][1] = contadorAltaNo / Double.valueOf(cantidadNo);
        matrizFrecuenciaHumendad[1][1] = contadorNormalNo / Double.valueOf(cantidadNo);

        System.out.println("Tabla de frecuencia de humedad:");
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                System.out.printf("%f ", matrizFrecuenciaHumendad[i][j]);
            }
            System.out.print("\n");
        }

        // -----Viento-----
        matrizFrecuenciaViento[0][0] = contadorHayVientoSi / Double.valueOf(cantidadSi);
        matrizFrecuenciaViento[1][0] = contadorNoHayVientoSi / Double.valueOf(cantidadSi);

        matrizFrecuenciaViento[0][1] = contadorHayVientoNo / Double.valueOf(cantidadNo);
        matrizFrecuenciaViento[1][1] = contadorNoHayVientoNo / Double.valueOf(cantidadNo);

        System.out.println("Tabla de frecuencia de viento:");
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                System.out.printf("%f ", matrizFrecuenciaViento[i][j]);
            }
            System.out.print("\n");
        }

        // Calculo de las condicionales segun los parametros ingresados por el usuario
        // Luvia-temperatura- viento - se jugo?
        double condicionalSi = calculoProbabilidadCondicional(paramCielo, paramTemp, paramViento, paramHumedad, "Si",
                probabilidadJugar, matrizFrecuenciaCielo, matrizFrecuenciaHumendad, matrizFrecuenciaTemperatura,
                matrizFrecuenciaViento);

        double condicionalNo = calculoProbabilidadCondicional(paramCielo, paramTemp, paramViento, paramHumedad, "No",
                probabilidadNoJugar, matrizFrecuenciaCielo, matrizFrecuenciaHumendad, matrizFrecuenciaTemperatura,
                matrizFrecuenciaViento);

        

        double ProbabilidadFinalJugar= condicionalSi/(condicionalSi+condicionalNo);
        double ProbabilidadFinalNoJugar= condicionalNo/(condicionalSi+condicionalNo);

        System.out.printf("* La probabilidad final de que si se juege es de: %f(%f%%) \n",ProbabilidadFinalJugar,ProbabilidadFinalJugar*100);
        System.out.printf("* La probabilidad final de que no se juege es de: %f(%f%%) \n",ProbabilidadFinalNoJugar,ProbabilidadFinalNoJugar*100);

        if(ProbabilidadFinalJugar>ProbabilidadFinalNoJugar){
            System.out.println("****El partido se juega****");
        }else if(ProbabilidadFinalJugar<ProbabilidadFinalNoJugar){
            System.out.println("****El partido no se juega****");
        }else{
            System.out.println("****La probabilidad de que se juegue o no es la misma****");
        } */



    }

    // Funcion que calcula la cantidad de partidos jugados
    public static int calcularJugados(int[][] matrizDatos) {
        int cantidadSi = 0;
        for (int i = 0; i < matrizDatos.length; i++) {
            if (matrizDatos[i][4] == 1) {
                cantidadSi++;
            }
        }
        return cantidadSi;
    }

    /// Funcion que calcula la probabilidad condicional
    /// Se ingresan los parametros a evaluar que son los ingresados por el usuario
    /// Depende de cada paramatro se analiza una u otra columna de las matrices
    /// A cada combinacion de fila y columna de las matrices de frecuencia le
    /// corresponde un numero distinto
    public static double calculoProbabilidadCondicional(String cielo, String temperatura, String viento, String humedad,
            String sejugo, double valorSejugo, double[][] matrizFrecuenciaCielo, double[][] matrizFrecuenciaHumendad,
            double[][] matrizFrecuenciaTemperatura, double[][] matrizFrecuenciaViento) {

        double cieloValor = 0.0;
        double tempValor = 0.0;
        double humedadValor = 0.0;
        double vientoValor = 0.0;
        double resultado = 0.0;

        // Valores que tendran las filas de las tablas de frecuencia
        int filaCielo, filaHumedad, filaTemperatura, filaViento;

        // Dependiendo si es si o no debo analizar una u otra columna(0=Si , 1=No) de la
        // matriz de frecuencia
        int ValorColumna = sejugo.equals("Si") ? 0 : 1;

        // Fila para el cielo según los parametros ingresados
        switch (cielo) {
            case "Soleado":
                filaCielo = 0;
                break;

            case "Nublado":
                filaCielo = 1;
                break;

            case "Lluvia":
                filaCielo = 2;
                break;

            default:
                filaCielo = 0;
        }

        switch (humedad) {
            case "Alta":
                filaHumedad = 0;
                break;

            case "Normal":
                filaHumedad = 1;
                break;

            default:
                filaHumedad = 0;
        }

        switch (temperatura) {
            case "Calor":
                filaTemperatura = 0;
                break;

            case "Templado":
                filaTemperatura = 1;
                break;

            case "Frio":
                filaTemperatura = 2;
                break;

            default:
                filaTemperatura = 0;
        }

        switch (viento) {
            case "Si":
                filaViento = 0;
                break;

            case "No":
                filaViento = 1;
                break;

            default:
                filaViento = 0;
        }

        // Calculo de la ecuacion
        resultado = matrizFrecuenciaCielo[filaCielo][ValorColumna] * matrizFrecuenciaHumendad[filaHumedad][ValorColumna]
                * matrizFrecuenciaTemperatura[filaTemperatura][ValorColumna]
                * matrizFrecuenciaViento[filaViento][ValorColumna] * valorSejugo;

        return resultado;
    }

}