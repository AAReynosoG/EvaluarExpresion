import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] creditos = { "1.- Carlos Gabriel Romero - 22170145", "2.- Anthony Fuentes - 22170187",
                "3.- Abraham Alonso Reynoso Gonzalez - 22170060" };
        String opcion;
        String cadena = "";

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1.  Validar cadena.");
            System.out.println("2.  Creditos.");
            System.out.println("3.  Salir.");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingresa la cadena que deseas validar:");
                    cadena = sc.nextLine();
                    EvaluarCadena(cadena);
                    System.out.println("Presiona 'Enter' para continuar...");
                    sc.nextLine();
                    break;
                case "2":
                    System.out.println("--CREDITOS--:");
                    System.out.println("## Estructura de Datos Aplicadas ##");
                    System.out.println("Trabajo realizado por:");
                    System.out.println("1.- Carlos Gabriel Romero Garcia.- 22170145 ");
                    System.out.println("2.- Anthony Fuentes Carrera.- 22170187 ");
                    System.out.println("3.- Abraham Alonso Reynoso Gonzalez.- 22170060");
                    System.out.println("--########--:");
                    System.out.println("Presiona 'Enter' para continuar...");
                    sc.nextLine();
                    break;
                case "3":
                    System.out.println("Hasta luego...!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    System.out.println("Presiona 'Enter' para continuar...");
                    sc.nextLine();
                    break;
            }

        } while (!opcion.equals("3"));

        sc.close();
    }

    public static void EvaluarCadena(String cadena) {
        char[] cadenaChar = cadena.toCharArray();

        boolean sinMayus = ValidarMinusculas(cadenaChar);

        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        char[] consonantes = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        char[] DigInicial = {'2', '6'};
        char[] Digitos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] DigFinal = {'3', '9'};


        String parteCentral = cadena.substring(1, cadena.length() - 1);

        boolean caracteresInvalidosEnMedio = false;
    
        for (int i = 0; i < parteCentral.length(); i++) {
            char actual = parteCentral.charAt(i);
    
            if (Character.isLetter(actual)) { 
                caracteresInvalidosEnMedio = true;
                break;
            }
        }
    
        if (caracteresInvalidosEnMedio) {
            System.out.println("La cadena no debe tener letras adicionales en el medio.");
            return; 
        }
    

        if(sinMayus){

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
                        System.out.println("Tienes que terminar con consonante");
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
                        System.out.println("Tienes que terminar con vocal");
                    }
                }

            } else {
                System.out.println("No se ingreso ninguna cadena o la cadena es demasiado corta!");
            }

        }
        else{
            System.out.println("La cadena no debe tener mayusculas!");
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

    public static boolean ValidarMinusculas(char[] CadenaChar ){

        for (char caracter : CadenaChar){
            if(Character.isUpperCase(caracter)){
                return false;
            }
        }
        return true;
    }
}
