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
        char[] cadenaChar = cadena.toUpperCase().toCharArray();
        System.out.println("La cadena ingresada: " + cadena);


        char[] vocales = {'A', 'E', 'I', 'O', 'U'};
        char[] consonantes = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
        char[] DigInicial = {'2', '6'};
        char[] Digitos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] DigFinal = {'3', '9'};

        if (cadenaChar.length > 0) {
            char primerCaracter = cadenaChar[0];
            boolean esVocal = false;

            for (char vocal : vocales) {
                if (primerCaracter == vocal) {
                    esVocal = true;
                    break;
                }
            }

            if (esVocal) {
                System.out.println("El primer carácter es una vocal.");
            } else {
                System.out.println("El primer carácter no es una vocal.");
            }
        } else {
            System.out.println("La cadena está vacía.");
        }


    }
}
