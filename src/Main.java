import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] creditos = {"1.- Carlos Gabriel Romero","2.- Anthony Fuentes","3.- Abraham Alonso Reynoso Gonzalez - 22170060"};
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
                    for (String str : creditos){
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
            char primerCaracter = cadenaChar[0];
            boolean esVocal = false;

            for (char vocal : vocales) {
                if (primerCaracter == vocal) {
                    esVocal = true;
                    break;
                }
            }
            if (esVocal) {
                boolean esCons = false;
                char segundoCaracter = cadenaChar[1];
                for (char cons : consonantes){
                    if (segundoCaracter == cons && cadenaChar.length == 2){
                        esCons = true;
                        break;
                    }
                }
                if (esCons){
                    System.out.println("La cadena: " + "'" + cadena + "'" + " es valida");
                }
                else {
                    if (!esCons){

                        if (cadenaChar.length >= 5 && esVocal(cadenaChar[0])) {
                            if (esCaracterEnArreglo(cadenaChar[i], DigInicial)) {
                                i++;
                                int digitCount = 0;
                                while (i < cadenaChar.length && digitCount < 2) {
                                    if (esCaracterEnArreglo(cadenaChar[i], Digitos)) {
                                        digitCount++;
                                    } else {
                                        break;
                                    }
                                    i++;
                                }

                                if (digitCount >= 2 && i < cadenaChar.length && esCaracterEnArreglo(cadenaChar[i], DigFinal)) {
                                    i++;
                                    if (i < cadenaChar.length && esCaracterEnArreglo(cadenaChar[i], consonantes)) {
                                        System.out.println("La cadena: '" + cadena + "' es válida");
                                        return;
                                    }
                                }
                            }
                        }

                        System.out.println("La cadena: '" + cadena + "' es inválida");


                    }
                }
            } else {
                System.out.println("lol");
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

    public static boolean esCaracterEnArreglo(char c, char[] arreglo) {
        for (char elemento : arreglo) {
            if (c == elemento) {
                return true;
            }
        }
        return false;
    }
}
