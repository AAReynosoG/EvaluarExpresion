import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] creditos = { "1.- Carlos Gabriel Romero", "2.- Anthony Fuentes",
                "3.- Abraham Alonso Reynoso Gonzalez - 22170060" };
        int opcion;
        String cadena = "";

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1.  Validar cadena.");
            System.out.println("2.  Creditos.");
            System.out.println("3.  Salir.");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa la cadena que deseas validar:");
                    sc.nextLine();
                    cadena = sc.nextLine();
                    EvaluarCadena(cadena);
                    break;
                case 2:
                    System.out.println("--CREDITOS--:");
                    for (String str : creditos) {
                        System.out.println(str);
                    }
                    System.out.println("--########--:");
                    break;
                case 3:
                    System.out.println("Hasta luego...!");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 3);

        sc.close();
    }

    public static void EvaluarCadena(String cadena) {
        char[] cadenaChar = cadena.toCharArray();

        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        char[] consonantes = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        char[] DigInicial = {'2', '6'};
        char[] Digitos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] DigFinal = {'3', '9'};
        int i = 1;

        if (cadenaChar.length > 1) {
            char ultCaracter = cadenaChar[cadenaChar.length - 1];
            char primerCaracter = cadenaChar[0];
            boolean esVocal = false;
            boolean esConsonante = false;


            for (char vocal : vocales) {
                if (primerCaracter == vocal) {
                    esVocal = true;
                    break;
                }
            }
            for (char consonante : consonantes) {
                if (primerCaracter == consonante) {
                    esConsonante = true;
                    break;
                }
            }

            if(esVocal == false && esConsonante == false){
                System.out.println("Inicia con consonante o vocal");
            }

            if (esVocal) {
                if (esConsonante(ultCaracter)) {
                    if (cadenaChar.length == 2) {
                        System.out.println("La cadena: '" + cadena + "' es valida");
                    } else if (cadenaChar.length > 2) {
                        char segundoCaracter = cadenaChar[1];
                        if (segundoCaracter == '2' || segundoCaracter == '6') {
                            int ii = 2; 
                            int countDigits = 0;
                            while (ii < cadenaChar.length && esCaracterEnArreglo(cadenaChar[ii], Digitos)) {
                                countDigits++;
                                ii++;
                            }
                            if (countDigits >= 3 && (cadenaChar[ii - 1] == '3' || cadenaChar[ii - 1] == '9')) {
                                System.out.println("La cadena: '" + cadena + "' es valida");
                            } else {
                                System.out.println("La cadena no cumple con el formato de dígitos requerido");
                            }
                        } else {
                            System.out.println("La cadena debe comenzar con un 2 o un 6 después de la consonante inicial");
                        }
                    }
                } else {
                    System.out.println("Tienes que terminar con vocal");
                }
            } else if (esConsonante) {
                if (esVocal(ultCaracter)) {
                    if (cadenaChar.length == 2) {
                        System.out.println("La cadena: '" + cadena + "' es valida");
                    } else if (cadenaChar.length > 2) {
                        char segundoCaracter = cadenaChar[1];
                        if (segundoCaracter == '2' || segundoCaracter == '6') {
                            int ii = 2; 
                            int countDigits = 0;
                            while (ii < cadenaChar.length && esCaracterEnArreglo(cadenaChar[ii], Digitos)) {
                                countDigits++;
                                ii++;
                            }
                            if (countDigits >= 3 && (cadenaChar[ii - 1] == '3' || cadenaChar[ii - 1] == '9')) {
                                System.out.println("La cadena: '" + cadena + "' es valida");
                            } else {
                                System.out.println("La cadena no cumple con el formato de dígitos requerido");
                            }
                        } else {
                            System.out.println("La cadena debe comenzar con un 2 o 3 y terminar con un 6 o 9 después de la vocal inicial");
                        }
                    }
                } else {
                    System.out.println("Tienes que terminar con consonante");
                }
            }
                    
        } else {
            System.out.println("No se ingreso ninguna cadena o la cadena es demasiado corta!");
        }

    }

    public static boolean esVocal(char c) {
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        for (char vocal : vocales) {
            if (c == vocal) {
                return true;
            }
        }
        return false;
    }

     public static boolean esConsonante(char c) {
        char[] consonantes = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        for (char consonante : consonantes) {
            if (c == consonante) {
                return true;
            }
        }
        return false;
    }

    public static boolean esCaracterEnArreglo(char c, char[] arreglo) {
        for (char elemento : arreglo) {
            if (c == elemento) {
                return true;
            }
        }
        return false;
    }
}
