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
        System.out.println("La cadena ingresada: " + cadena);


        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        char[] consonantes = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        char[] DigInicial = {'2', '6'};
        char[] Digitos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] DigFinal = {'3', '9'};
        ///
        if (cadenaChar.length > 0) {
            char primerCaracter = cadenaChar[0];
            boolean esVocal = false;
            int i = 0;

            for (char vocal : vocales) {
                if (primerCaracter == vocal) {
                    esVocal = true;
                    i = i+1;
                    break;
                }
            }
            ///
            if (esVocal) {
                ///
                if (cadenaChar.length > 1) {
                    char segundoChar = cadenaChar[i];
                    boolean esDig = false;

                    for (char digIn : DigInicial) {
                        if (primerCaracter == digIn) {
                            esDig = true;
                            i = i + 1;
                            break;
                        }
                    }
                    ///
                }else {

                }
            } else {
                System.out.println("");
            }
        } else {
            System.out.println("No se ingreso ninguna cadena");
        }


    }
}
