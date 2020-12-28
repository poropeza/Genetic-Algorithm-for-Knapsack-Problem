/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2_algoritmo.genetico;

import java.util.Scanner;

/**
 *
 * @author HUGO
 */
public class Problema5 {

    public void poblacioninicial(objeto lista[]) {
        Scanner teclado = new Scanner(System.in);
        int numIndividuos;
        int posmayor = 0;

        System.out.println("ingresa cuantos individuos deseas tener");
        numIndividuos = teclado.nextInt();
        int[][] pobini = new int[numIndividuos][15];
        int[] ordbeneficio = new int[15];
        int[] posiciones = new int[15];
        int aux, sobrepeso = 0, peso = 20, beneficio = 0;
        int[] pesos = new int[numIndividuos];
        double[] beneficios = new double[numIndividuos];

        for (int i = 0; i < numIndividuos; i++) {
            for (int j = 0; j < 15; j++) {
                pobini[i][j] = 0;
            }
        }
        for (int i = 0; i < lista.length; i++) {
            ordbeneficio[i] = lista[i].getBeneficio();
        }

        for (int i = 0; i < ordbeneficio.length; i++) {
            for (int j = 0; j < ordbeneficio.length - 1; j++) {
                if (ordbeneficio[j] < ordbeneficio[j + 1]) {
                    int tmp = ordbeneficio[j + 1];
                    ordbeneficio[j + 1] = ordbeneficio[j];
                    ordbeneficio[j] = tmp;
                }

            }
        }

        for (int i = 0; i < ordbeneficio.length; i++) {
            //  System.out.println(ordbeneficio[i]+" " +i);
        }

        for (int i = 0; i < posiciones.length; i++) {
            for (int j = 0; j < posiciones.length; j++) {
                if (ordbeneficio[i] == lista[j].getBeneficio()) {
                    posiciones[i] = j;
                }
            }
        }
        int j = 0;

        System.out.println("gloton");

        for (int i = 0; i < numIndividuos; i++) {
            peso = 0;
            for (int h = 0; h < 15; h++) {

                while (peso < 24) {
                    peso = 0;
                    //        System.out.println("Pocisiones[j]="+posiciones[j]);
                    pobini[i][posiciones[j]] = 1;
                    //  System.out.println("Asignacion");

                    for (int g = 0; g < 15; g++) {
                        if (pobini[i][g] == 1) {
                            peso = peso + lista[g].getPeso();
                        }
                    }

                    //  System.out.println("Peso "+peso);
                    for (int l = 0; l < 15; l++) {
                        //    System.out.print(pobini[i][l]);
                    }
                    if (peso >= 24) {
                        pobini[i][posiciones[j]] = 0;

                    }
                    j++;
                    if (j == 15) {
                        j = 0;
                    }

                }

            }
            peso = 0;
            beneficio = 0;
            for (int z = 0; z < 15; z++) {
                if (pobini[i][z] == 1) {
                    peso = peso + lista[z].getPeso();
                    beneficio = beneficio + lista[z].getBeneficio();
                }
            }

            pesos[i] = peso;
            beneficios[i] = beneficio;

            int cont = 0;
            int[] arregloaux = new int[15];

            if (i >= 1) {
                //System.out.println("\n si entro");
                for (int d = 0; d < 15; d++) {
                    arregloaux[d] = pobini[i][d];
                }

                for (int d = 1; d < i; d++) {
                    //   System.out.println("Aqui estoy");
                    cont = 0;
                    for (int e = 0; e < 15; e++) {

                        if (arregloaux[e] == pobini[d - 1][e]) {
                            cont++;
                        }
                    }
                    //System.out.println("cont= "+cont);
                    if (cont == 15) {
                        // System.out.println("Si hay uno igual");
                        for (int f = 0; f < 5; f++) {
                            pobini[i][f] = 0;
                        }
                        d = i;
                        i--;

                    }
                }

            }
        }

        //Comprobando repeticion de grupos
        System.out.println("Comprobando");

        for (int i = 0; i < numIndividuos; i++) {
            int contpos7 = 0;

            //comprobar grupo 1-2
            int contpos1 = 0;
            for (int l = 1; l < 3; l++) {
                if (pobini[i][l] == 1) {

                    contpos1++;
                    // System.out.println("Hay "+contpos1);
                }
            }
            if (contpos1 >= 2) {

                int nummayor = 0;
                posmayor = 0;

                for (int l = 1; l < 3; l++) {

                    if (pobini[i][l] == 1) {

                        if (lista[l].getBeneficio() > nummayor) {

                            posmayor = l;
                            nummayor = lista[l].getBeneficio();
                        }
                    }
                }
                for (int l = 1; l < 3; l++) {
                    pobini[i][l] = 0;
                }
                pobini[i][posmayor] = 1;
            }
            //comprobar grupo 10-11
            for (int l = 10; l < 12; l++) {
                if (pobini[i][l] == 1) {

                    contpos7++;
                    //System.out.println("Hay "+contpos7);
                }
            }
            if (contpos7 >= 2) {

                int nummayor = 0;
                posmayor = 0;

                for (int l = 10; l < 12; l++) {

                    if (pobini[i][l] == 1) {

                        if (lista[l].getBeneficio() > nummayor) {

                            posmayor = l;
                            nummayor = lista[l].getBeneficio();
                        }
                    }
                }
                for (int l = 10; l < 12; l++) {
                    pobini[i][l] = 0;
                }
                pobini[i][posmayor] = 1;
            }

            //comprobar grupo 12-14
            int contpos11 = 0;
            for (int l = 12; l < 15; l++) {
                if (pobini[i][l] == 1) {
                    contpos11++;
                }
            }
            if (contpos11 >= 2) {
                int nummayor = 0;
                posmayor = 0;

                for (int l = 12; l < 15; l++) {

                    if (pobini[i][l] == 1) {

                        if (lista[l].getBeneficio() > nummayor) {

                            posmayor = l;
                            nummayor = lista[l].getBeneficio();
                        }
                    }
                }
                for (int l = 12; l < 15; l++) {
                    pobini[i][l] = 0;
                }
                pobini[i][posmayor] = 1;
            }

        }

        for (int i = 0; i < numIndividuos; i++) {
            peso = 0;
            beneficio = 0;
            for (int h = 0; h < 15; h++) {
                if (pobini[i][h] == 1) {
                    peso = peso + lista[h].getPeso();
                    beneficio = beneficio + lista[h].getBeneficio();
                }
            }
            beneficios[i] = beneficio;
            pesos[i] = peso;
        }
        System.out.println("\n Poblacion inicial");
        for (int i = 0; i < numIndividuos; i++) {
            System.out.println("");
            for (int k = 0; k < 15; k++) {
                System.out.print(pobini[i][k]);
            }
            System.out.print(" " + pesos[i] + " " + beneficios[i]);
        }

        Problema5 obj5 = new Problema5();
        obj5.cruzamiento(lista, pobini, pesos, beneficios, numIndividuos);

    }

    public void cruzamiento(objeto lista[], int pobini[][], int pesos[], double beneficios[], int numIndividuos) {
        double totalaptitud = 0;
        double[] probabilidades = new double[15];
        double tot = 0;
        double[] rango = new double[16];
        int[][] pobfinal = new int[numIndividuos][15];
        int pos = 0;
        int cruzamiento;
        int mutacion;
        int porcentajecruzamiento;
        int[] padre1 = new int[15];
        int[] padre2 = new int[15];
        int pospadre1 = 0;
        int pospadre2 = 0;
        double na;
        int numeroaleatorio;
        int[] hijo1 = new int[15];
        int[] hijo2 = new int[15];
        int peso = 30;
        int contcruz = 0;
        int cantidadGeneracion;

        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < numIndividuos; i++) {
            for (int j = 0; j < 15; j++) {
                pobfinal[i][j] = 0;
                hijo1[j] = 0;
                hijo2[j] = 0;
            }
        }

        for (int i = 0; i < 15; i++) {
            totalaptitud = totalaptitud + beneficios[i];
        }
        System.out.println("Total Aptitud= " + totalaptitud);
        for (int i = 0; i < 15; i++) {
            tot = beneficios[i] / totalaptitud;
            probabilidades[i] = tot;
        }
        for (int i = 0; i < 15; i++) {
            //  System.out.println(probabilidades[i]);
        }
        for (int i = 0; i < 16; i++) {
            if (i == 0) {
                rango[i] = i;
            } else {
                rango[i] = rango[i - 1] + probabilidades[i - 1];
            }
        }
        System.out.println("Rangos");
        for (int i = 0; i < 16; i++) {
            System.out.println(rango[i]);
        }
        double nummayor = beneficios[0];
        for (int i = 0; i < 15; i++) {
            if (beneficios[i] > nummayor) {
                nummayor = beneficios[i];
                pos = i;
                // System.out.println(nummayor);
            }
        }
        System.out.println("beneficio mayor esta en la pocision= " + pos + " con un beneficio de " + beneficios[pos]);
        for (int i = 0; i < 15; i++) {
            pobfinal[0][i] = pobini[pos][i];
        }
        System.out.println("Ingresa el porcentaje de cruzamiento");
        cruzamiento = teclado.nextInt();
        porcentajecruzamiento = (cruzamiento * numIndividuos) / 100;
        System.out.println("Porcentaje de individuos con cruzamiento= " + porcentajecruzamiento);
        //porcentaje de cruzamiento
        System.out.println("Ingresa cantidad de generacion");
        cantidadGeneracion = teclado.nextInt();
        int contgen = 0;

        while (contgen < cantidadGeneracion) {
            totalaptitud = 0;
            for (int i = 0; i < numIndividuos; i++) {
                for (int j = 0; j < 15; j++) {
                    pobfinal[i][j] = 0;
                    hijo1[j] = 0;
                    hijo2[j] = 0;
                }
            }

            for (int i = 0; i < 15; i++) {
                totalaptitud = totalaptitud + beneficios[i];
            }
            System.out.println("Total Aptitud= " + totalaptitud);
            for (int i = 0; i < 15; i++) {
                tot = beneficios[i] / totalaptitud;
                probabilidades[i] = tot;
            }
            for (int i = 0; i < 15; i++) {
                // System.out.println(probabilidades[i]);
            }
            for (int i = 0; i < 16; i++) {
                if (i == 0) {
                    rango[i] = i;
                } else {
                    rango[i] = rango[i - 1] + probabilidades[i - 1];
                }
            }
            System.out.println("Rangos");
            for (int i = 0; i < 16; i++) {
                System.out.println(rango[i]);
            }
            nummayor = beneficios[0];
            pos = 0;
            for (int i = 0; i < 15; i++) {
                if (beneficios[i] > nummayor) {
                    nummayor = beneficios[i];
                    pos = i;
                    System.out.println(nummayor);
                }
            }
            System.out.println("beneficio mayor esta en la pocision= " + pos + " con un beneficio de " + beneficios[pos]);
            for (int i = 0; i < 15; i++) {
                pobfinal[0][i] = pobini[pos][i];
            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Generacion:" + contgen);
            System.out.println("------------------------------------------------------------------------");
            for (int i = 1; i < porcentajecruzamiento + 1; i++) {
                System.out.println("peso= " + peso + " i= " + i);
                peso = 30;
                while (peso > 24) {
                    peso = 0;
                    na = Math.random();
                    System.out.println("\n numero para elegir padre1 =" + na);
                    for (int k = 0; k < 15; k++) {
                        if (na >= rango[k] && na <= rango[k + 1]) {
                            pospadre1 = k;
                        }
                    }
                    for (int k = 0; k < 15; k++) {
                        padre1[k] = pobini[pospadre1][k];
                    }

                    na = Math.random();
                    System.out.println("\n numero para elegir padre2 =" + na);
                    for (int k = 0; k < 15; k++) {
                        if (na >= rango[k] && na <= rango[k + 1]) {
                            pospadre2 = k;
                        }
                    }
                    for (int k = 0; k < 15; k++) {
                        padre2[k] = pobini[pospadre2][k];
                    }

                    System.out.println("\n Padre 1");
                    for (int k = 0; k < 15; k++) {
                        System.out.print(padre1[k]);
                    }
                    System.out.println("\n Padre 2");
                    for (int k = 0; k < 15; k++) {
                        System.out.print(padre2[k]);
                    }

                    numeroaleatorio = (int) (Math.random() * 13) + 1;
                    System.out.println("\n numero de division " + numeroaleatorio);
                    for (int k = 0; k < numeroaleatorio; k++) {
                        hijo1[k] = padre1[k];
                        if (numeroaleatorio + k < 15) {
                            hijo2[k] = padre1[numeroaleatorio + k];
                        }
                    }
                    for (int k = numeroaleatorio; k < 15; k++) {
                        hijo1[k] = padre2[k];
                        hijo2[k] = padre2[k - numeroaleatorio];
                    }

                    System.out.println("Hijo 1");
                    for (int k = 0; k < 15; k++) {
                        System.out.print(hijo1[k]);
                    }
                    System.out.println("Hijo 2");
                    for (int k = 0; k < 15; k++) {
                        System.out.print(hijo2[k]);
                    }

                    for (int k = 0; k < 15; k++) {
                        if (hijo1[k] == 1) {
                            peso = peso + lista[k].getPeso();
                        }
                    }
                    if (peso <= 24) {
                        for (int k = 0; k < 15; k++) {
                            pobfinal[i][k] = hijo1[k];
                        }

                        contcruz++;
                    }
                    if (peso > 24) {

                    }
                    peso = 0;
                    for (int k = 0; k < 15; k++) {
                        if (hijo2[k] == 1) {
                            peso = peso + lista[k].getPeso();
                        }
                    }
                    if (peso <= 24) {
                        for (int k = 0; k < 15; k++) {
                            pobfinal[i][k] = hijo2[k];
                        }

                        contcruz++;
                    }
                }

                for (int k = 0; k < i; k++) {
                    int contceros = 0;
                    for (int l = 0; l < 15; l++) {
                        if (pobfinal[k][l] == 0) {
                            contceros++;
                        }

                    }
                    if (contceros == 15) {
                        System.out.println("\n En la pocision " + k + " hay " + contceros);
                        i = k;
                        k = cruzamiento + 6;
                    }
                }
            }
            // System.out.println("pobfinal de cruzamiento");
            for (int i = 0; i < numIndividuos; i++) {
                System.out.println(" ");
                for (int j = 0; j < 15; j++) {
                    //  System.out.print(pobfinal[i][j]);
                }
            }
            //porcentaje mutacion
            // System.out.println("Empieza Mutacion");
            for (int i = porcentajecruzamiento; i < numIndividuos; i++) {
                peso = 30;
                while (peso > 24) {
                    na = Math.random();
                    peso = 0;

                    for (int k = 0; k < 15; k++) {
                        if (na >= rango[k] && na <= rango[k + 1]) {
                            pospadre1 = k;
                        }
                    }
                    for (int k = 0; k < 15; k++) {
                        padre1[k] = pobini[pospadre1][k];
                    }

                    numeroaleatorio = (int) (Math.random() * 14) + 0;
                    if (padre1[numeroaleatorio] == 1) {
                        padre1[numeroaleatorio] = 0;
                    } else {
                        padre1[numeroaleatorio] = 1;
                    }
                    for (int k = 0; k < 15; k++) {
                        if (padre1[k] == 1) {
                            peso = peso + lista[k].getPeso();

                        }
                    }
                    if (peso <= 24) {
                        for (int k = 0; k < 15; k++) {
                            pobfinal[i][k] = padre1[k];
                        }
                    }

                }
            }

            System.out.println("\n POBLACION INICIAL PESO BENEFICIO ");
            for (int i = 0; i < numIndividuos; i++) {
                System.out.println("");
                for (int j = 0; j < 15; j++) {
                    System.out.print(pobini[i][j]);

                }
                System.out.println("    " + pesos[i] + "   " + beneficios[i]);
            }

            //aqui esta la restriccion de grupos
            for (int i = 0; i < numIndividuos; i++) {

                //comprobar grupo 1-2
                int contpos1 = 0;
                for (int l = 1; l < 3; l++) {
                    if (pobfinal[i][l] == 1) {

                        contpos1++;
                        // System.out.println("Hay grupo 1-2 "+contpos1);
                    }
                }
                if (contpos1 >= 2) {

                    nummayor = 0;
                    int posmayor = 0;

                    for (int l = 1; l < 3; l++) {

                        if (pobfinal[i][l] == 1) {

                            if (lista[l].getBeneficio() > nummayor) {

                                posmayor = l;
                                nummayor = lista[l].getBeneficio();
                            }
                        }
                    }
                    for (int l = 1; l < 3; l++) {
                        pobfinal[i][l] = 0;
                    }
                    pobfinal[i][posmayor] = 1;
                }
                int contpos7 = 0;
                //comprobar grupo 10-11
                for (int l = 10; l < 12; l++) {
                    if (pobfinal[i][l] == 1) {

                        contpos7++;
                        // System.out.println("Hay grupo 8-11 "+contpos7);
                    }
                }
                if (contpos7 >= 2) {

                    nummayor = 0;
                    int posmayor = 0;

                    for (int l = 10; l < 12; l++) {

                        if (pobfinal[i][l] == 1) {

                            if (lista[l].getBeneficio() > nummayor) {

                                posmayor = l;
                                nummayor = lista[l].getBeneficio();
                            }
                        }
                    }
                    for (int l = 10; l < 12; l++) {
                        pobfinal[i][l] = 0;
                    }
                    pobini[i][posmayor] = 1;
                }

                //comprobar grupo 12-14
                int contpos11 = 0;
                for (int l = 12; l < 15; l++) {
                    if (pobfinal[i][l] == 1) {
                        contpos11++;
                    }
                }
                if (contpos11 >= 2) {
                    nummayor = 0;
                    int posmayor = 0;

                    for (int l = 12; l < 15; l++) {

                        if (pobfinal[i][l] == 1) {

                            if (lista[l].getBeneficio() > nummayor) {

                                posmayor = l;
                                nummayor = lista[l].getBeneficio();
                            }
                        }
                    }
                    for (int l = 12; l < 15; l++) {
                        pobfinal[i][l] = 0;
                    }
                    pobfinal[i][posmayor] = 1;
                }

            }
            //Aqui terminan restricciones
            //  System.out.println("Poblacion con cruzamiento y mutacion");
            for (int i = 0; i < numIndividuos; i++) {
                int beneficio = 0;
                peso = 0;
                System.out.println(" ");
                for (int j = 0; j < 15; j++) {
                    if (pobfinal[i][j] == 1) {
                        beneficio = beneficio + lista[j].getBeneficio();
                        peso = peso + lista[j].getPeso();
                    }
                    // System.out.print(pobfinal[i][j]);
                }
                beneficios[i] = beneficio;
                pesos[i] = peso;
            }
            System.out.println("\n POBLACION FINAL PESO BENEFICIO ");
            for (int i = 0; i < numIndividuos; i++) {
                System.out.println("");
                for (int j = 0; j < 15; j++) {
                    System.out.print(pobfinal[i][j]);

                }
                System.out.println("    " + pesos[i] + "   " + beneficios[i]);
            }
            for (int i = 0; i < numIndividuos; i++) {
                for (int j = 0; j < 15; j++) {
                    pobini[i][j] = pobfinal[i][j];
                }
            }
            contgen++;
        }
    }
}
