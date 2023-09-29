import java.util.Scanner;

public class AlphabetArray {

    private static final int MAX_LENGTH = 20;
    private String[] array = new String[MAX_LENGTH];
    private int length = 0;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AlphabetArray program = new AlphabetArray();
        program.run();
    }

    public void run() {
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1) Inicializar / Borrar arreglo");
            System.out.println("2) Mostrar Arreglo");
            System.out.println("3) Buscar");
            System.out.println("4) Insertar");
            System.out.println("5) Eliminar");
            System.out.println("6) Modificar");
            System.out.println("7) Créditos");
            System.out.println("8) Salir");
            System.out.print("Selecciona una opción: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    array = initializeArray();
                    System.out.println("Arreglo inicializado.");
                    break;
                case 2:
                    displayArray();
                    break;
                case 3:
                    searchArray();
                    break;
                case 4:
                    insertArray();
                    break;
                case 5:
                    deleteFromArray();
                    break;
                case 6:
                    modifyArray();
                    break;
                case 7:
                    credits();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (choice != 8);
    }

    private String[] initializeArray() {
        length = 0;
        return new String[MAX_LENGTH];
    }

    private void displayArray() {
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private void searchArray() {
        System.out.print("Ingresa la letra a buscar: ");
        String target = scanner.next();
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (array[i].equals(target)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("Letra encontrada en la posición: " + index);
        } else {
            System.out.println("Letra no encontrada.");
        }
    }

    private void insertArray() {
        if (length >= MAX_LENGTH) {
            System.out.println("El arreglo está lleno.");
            return;
        }

        System.out.print("Ingresa la letra a insertar: ");
        String letter = scanner.next();
        int index = 0;
        while (index < length && prioritizeOrder(letter).compareTo(prioritizeOrder(array[index])) > 0) {
            index++;
        }

        for (int i = length; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = letter;
        length++;
        System.out.println("Letra insertada en la posición: " + index);
    }

    private void deleteFromArray() {
        System.out.print("Ingresa la letra a eliminar: ");
        String target = scanner.next();
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (array[i].equals(target)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Letra no encontrada.");
            return;
        }

        for (int i = index; i < length - 1; i++) {
            array[i] = array[i + 1];
        }
        length--;
        System.out.println("Letra eliminada de la posición: " + index);
    }

    private void modifyArray() {
        System.out.print("Ingresa la letra a modificar: ");
        String target = scanner.next();
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (array[i].equals(target)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Letra no encontrada.");
            return;
        }

        System.out.print("Ingresa la nueva letra: ");
        String newLetter = scanner.next();
        array[index] = newLetter;
        while (index > 0 && prioritizeOrder(array[index]).compareTo(prioritizeOrder(array[index - 1])) < 0) {
            String temp = array[index];
            array[index] = array[index - 1];
            array[index - 1] = temp;
            index--;
        }

        while (index < length - 1 && prioritizeOrder(array[index]).compareTo(prioritizeOrder(array[index + 1])) > 0) {
            String temp = array[index];
            array[index] = array[index + 1];
            array[index + 1] = temp;
            index++;
        }

        System.out.println("Letra modificada y ahora se encuentra en la posición: " + index);
    }

    private void credits() {
        System.out.println("Materia: Programación Avanzada");
        System.out.println("Nombre: Juan Pérez, Matrícula: 123456");
    }

    private String prioritizeOrder(String letter) {
        return letter.toUpperCase() + letter;
    }
}
