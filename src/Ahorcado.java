import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        // Clase scanner permite al usuario escribir
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "inteligancia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // en este bucle reemplaza el arreglo con _ de la cantidad de letras que tiene
        // la palabra a adivinar
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';

        } 

        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " ("
                    + palabraSecreta.length() + " letras )");
            System.out.println("introduce una letra: ");

            // le pido al usuario una letra
            String letras = scanner.next().toUpperCase();
            // de lo que ponga el usuario obtengo el primer caracter
            char letra = letras.charAt(0);
            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                // si el caracter esta dentro de la palabra a adivinar, se reemplaza en los _ y
                // se muestra hasta que se complete la palabra
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;

                }

            }

            // si el caracter es incorrecto se avisa que fallo y se descuenta 1 intento
            if (!letraCorrecta) {
                intentos++;
                System.out.println("Incorrecto, Te quedan " + (intentosMaximos - intentos) + " intentos.");
            }

            // si adivina la palabra se muestra un mensaje que gano
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades has ganado!  la palabra es : " + palabraSecreta);

            }
        }

        // al fallar todos los intentos se muestra un mensaje que el usuario no gano.
        if (!palabraAdivinada) {
            System.out.println("Se acabaron los intentos. Game Over.");
        }

        scanner.close();
    }
}
