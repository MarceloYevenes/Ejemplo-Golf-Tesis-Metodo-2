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

        
        // matrices de frecuencia para si y no
        double[][] matrizFrecuenciaSi = new double[3][4];
        double[][] matrizFrecuenciaNo = new double[3][4];

        //matrices de probabilidad
        double[][] matrizProbabilidadSi = new double[3][4];
        double[][] matrizProbabilidadNo = new double[3][4];

        //Se llenan ambas matrices con 0 para evitar espacion con valores no definidos
        for(i=0; i<3; i++ ){
            for (j=0;j<4;j++){
                matrizFrecuenciaSi[i][j] = 0.0;
                matrizFrecuenciaNo[i][j] = 0.0;
            }
        }

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
            if (matrizValores[i][0] == (1) && matrizValores[i][4] == (1)) {
                contadorSoleadoSi++;
            }

            // Nublado - Si se juega
            if (matrizValores[i][0] == (2) && matrizValores[i][4] == (1)) {
                contadorNubladoSi++;
            }

            // Lluvia - Si se juega
            if (matrizValores[i][0] == (3) && matrizValores[i][4] == (1)) {
                contadorLluviosSi++;
            }


            // -----Temperatura-----

            // Calor - Si se juega
            if (matrizValores[i][1] == (1) && matrizValores[i][4] == (1)) {
                contadorCalorSi++;
            }

             // Templado - Si se juega
             if (matrizValores[i][1] == (2) && matrizValores[i][4] == (1)) {
                contadorTempladoSi++;
            }

             // Frio - Si se juega
             if (matrizValores[i][1] == (3) && matrizValores[i][4] == (1)) {
                contadorFrioSi++;
            }

            // -----Humedad-----

            // Alta - Si se juega
            if (matrizValores[i][2] == (1) && matrizValores[i][4] == (1)) {
                contadorAltaSi++;
            }

            // Normal - Si se juega
            if (matrizValores[i][2] == (2) && matrizValores[i][4] == (1)) {
                contadorNormalSi++;
            }
            
            // -----Viento-----

            // Si hay viento - Si se juega
            if (matrizValores[i][3] == (1) && matrizValores[i][4] == (1)) {
                contadorHayVientoSi++;
            }

            // No hay viento - Si se juega
            if (matrizValores[i][3] == (2) && matrizValores[i][4] == (1)) {
                contadorNoHayVientoSi++;
            }

            
            // -----Cielo-----

            // Soleado - No se juega
            if (matrizValores[i][0] == (1) && matrizValores[i][4] == (2)) {
                contadorSoleadoNo++;
            }

            
            // Nublado - No se juega
            if (matrizValores[i][0] == (2) && matrizValores[i][4] == (2)) {
                contadorNubladoNo++;
            }

            // Lluvia - No se juega
            if (matrizValores[i][0] == (3) && matrizValores[i][4] == (2)) {
                contadorLluviosNo++;
            }

            // -----Temperatura-----

            
            // Calor - No se juega
            if (matrizValores[i][1] == (1) && matrizValores[i][4] == (2)) {
                contadorCalorNo++;
            }

            // Templado - No se juega
            if (matrizValores[i][1] == (2) && matrizValores[i][4] == (2)) {
                contadorTempladoNo++;
            }

            // Frio - No se juega
            if(matrizValores[i][1] == (3) && matrizValores[i][4] == (2)) {
                contadorFrioNo++;
            }

            // -----Humedad-----

            // Alta - No se juega
            if (matrizValores[i][2] == (1) && matrizValores[i][4] == (2)) {
                contadorAltaNo++;
            }

            // Normal - No se juega
            if (matrizValores[i][2] == (2) && matrizValores[i][4] == (2)) {
                contadorNormalNo++;
            }

            // -----Viento-----

            // Si hay viento - No se juega
            if (matrizValores[i][3] == (1) && matrizValores[i][4] == (2)) {
                contadorHayVientoNo++;
            }

            // No hay viento - No se juega
            if (matrizValores[i][3] == (3) && matrizValores[i][4] == (2)) {
                contadorNoHayVientoNo++;
            }

        }

        // -----Se llenan de datos las matrices de frecuencia-----

        // -----Si se juega-----
    
        //Cielo
        matrizFrecuenciaSi[0][0] = contadorSoleadoSi; 
        matrizFrecuenciaSi[1][0] = contadorNubladoSi; 
        matrizFrecuenciaSi[2][0] = contadorLluviosSi; 

        //Temperatura
        matrizFrecuenciaSi[0][1] = contadorCalorSi; 
        matrizFrecuenciaSi[1][1] = contadorTempladoSi; 
        matrizFrecuenciaSi[2][1] = contadorFrioSi; 

        //Humedad
        matrizFrecuenciaSi[0][2] = contadorAltaSi; 
        matrizFrecuenciaSi[1][2] = contadorNormalSi; 

        //Viento
        matrizFrecuenciaSi[0][3] = contadorHayVientoSi; 
        matrizFrecuenciaSi[1][3] = contadorNoHayVientoSi; 

        System.out.println("------------------------------------------");
        System.out.println("Tabla de frecuencia de si se juega:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                System.out.printf("%f ", matrizFrecuenciaSi[i][j]);
            }
            System.out.print("\n");
        }

        // -----No se juega-----
        
        //Cielo
        matrizFrecuenciaNo[0][0] = contadorSoleadoNo;
        matrizFrecuenciaNo[1][0] = contadorNubladoNo;
        matrizFrecuenciaNo[2][0] = contadorLluviosNo;

        //Temperatura
        matrizFrecuenciaNo[0][1] = contadorCalorNo;
        matrizFrecuenciaNo[1][1] = contadorTempladoNo;
        matrizFrecuenciaNo[2][1] = contadorFrioNo;

        //Humedad
        matrizFrecuenciaNo[0][2] = contadorAltaNo;
        matrizFrecuenciaNo[1][2] = contadorNormalNo;

        //Viento
        matrizFrecuenciaNo[0][3] = contadorHayVientoNo;
        matrizFrecuenciaNo[1][3] = contadorNoHayVientoNo;
      
        System.out.println("------------------------------------------");
        System.out.println("Tabla de frecuencia de no se juega:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                System.out.printf("%f ", matrizFrecuenciaNo[i][j]);
            }
            System.out.print("\n");
        }

        /*Comprobar si las matrices tienen algun valor 0
        en caso que alguna tenga un valor 0 se debe normalizar la matriz*/
        Boolean valorCeroSiJuega = encontrarValorCero(matrizFrecuenciaSi);
        Boolean valorCeroNoJuega = encontrarValorCero(matrizFrecuenciaNo);
        
        //Se deben normalizar las matrices de frecuencia si se encuentra un 0;
        if(valorCeroSiJuega){
            System.out.println("------------------------------------------");
            System.out.println("Matriz normalizada para si se juega");
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 4; j++) {
                   matrizFrecuenciaSi[i][j]+=1;
                   System.out.printf("%f ", matrizFrecuenciaSi[i][j]);
                }
                System.out.print("\n");
            }
        }
   
        if(valorCeroNoJuega){
            System.out.println("------------------------------------------");
            System.out.println("Matriz normalizada para no se juega");
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 4; j++) {
                    matrizFrecuenciaNo[i][j]+=1;
                   System.out.printf("%f ", matrizFrecuenciaNo[i][j]);
                }
                System.out.print("\n");
            }
        }

        /*Se debe obtener la suma de una columna de ambas matrices para
        obtener la probabilidades respectivas para cada evento*/

        double sumColMatrizSi = sumColumnas(matrizFrecuenciaSi);  
        double sumColMatrizNo = sumColumnas(matrizFrecuenciaNo);

        System.out.println("------------------------------------------");
        //Matriz de probabilida para si
        System.out.println("Matriz de probabilidad para si se juega");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                matrizProbabilidadSi[i][j] = (matrizFrecuenciaSi[i][j])/(sumColMatrizSi);
               System.out.printf("%f ", matrizProbabilidadSi[i][j]);
            }
            System.out.print("\n");
        }

        System.out.println("------------------------------------------");
        //Matriz de probabilida para no
        System.out.println("Matriz de probabilidad para no se juega");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                matrizProbabilidadNo[i][j] = (matrizFrecuenciaNo[i][j])/(sumColMatrizNo);
               System.out.printf("%f ", matrizProbabilidadNo[i][j]);
            }
            System.out.print("\n");
        }

        //Determinar factor para si se juega
        double factorSiJuega = determinarFactorProbabilidad(paramCielo, paramTemp, 
        paramHumedad, paramViento, matrizProbabilidadSi, probabilidadJugar);
        
        //Determinar facctor para no se juega
        double factorNoJuega = determinarFactorProbabilidad(paramCielo, paramTemp, 
        paramHumedad, paramViento, matrizProbabilidadNo, probabilidadJugar);

        //Obtener la probabilidades respectivas
        double probabilidadFinalSiJuega = ((factorSiJuega)/(factorSiJuega + factorNoJuega))*100; 
        double probabilidadFinalNoJuega = ((factorNoJuega)/(factorSiJuega + factorNoJuega))*100; 

        System.out.println("------------------------------------------");
        System.out.printf("Probabilida que si se juegue el partido %f porciento \n",probabilidadFinalSiJuega);
        System.out.printf("Probabilida que no se juegue el partido %f porciento \n",probabilidadFinalNoJuega);

        //Comparar y entregar el resultado final
        if(probabilidadFinalSiJuega > probabilidadFinalNoJuega){
            System.out.println("Finalmente, el partido se juega");
        }else{
            System.out.println("Finalmente, el partido no se juega");
        }


    
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

    public static boolean encontrarValorCero(double[][] matrizObjetivo){
        int row, colum;
        for(row = 0;row < matrizObjetivo.length; row++ ){
            for(colum = 0;colum < matrizObjetivo[row].length; colum++){
                if(matrizObjetivo[row][colum]==0){
                    return true;
                }
            }
        }
        return false;
    }

    public static double sumColumnas(double[][] matrizObjetivo){

        int row;
        double total=0.0;
        for(row = 0; row < matrizObjetivo.length; row++){
            total+=matrizObjetivo[row][0]; 
        }

        return total;

    }

    public static double determinarFactorProbabilidad(int paramCielo, int paramTemp, 
    int paramHumedad, int paramViento, double [][]matrizObjetivo, double probTotal){

        double totalFactor;

        double probCielo = matrizObjetivo[paramCielo-1][0];
        double probTemp = matrizObjetivo[paramTemp-1][1];
        double probHumedad = matrizObjetivo[paramHumedad-1][2];
        double probViento = matrizObjetivo[paramViento-1][3];

        totalFactor = probCielo*probTemp*probHumedad*probViento*probTotal;
        return totalFactor;
    }    


}