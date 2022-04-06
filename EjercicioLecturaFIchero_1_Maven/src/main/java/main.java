import model.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class main {
    public static void main(String[] args) throws IOException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura (disponer del metodo readLine()).
            List<Persona> people = new ArrayList<>();
            List<String> atributosPersona = new ArrayList<>();

            archivo = new File("C:\\Users\\david.cueto\\Desktop\\Practicas\\Proyectos Intellij\\EjercicioLecturaFIchero_1_Maven\\target\\classes\\data");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = "";
            while ((linea = br.readLine()) != null) {
                // Parto la linea para tratar los elementos
                atributosPersona = List.of(linea.split(":"));

                // Hago la copia para poder modificarla a mi gusto
                List<String> finalAtributosPersona = new ArrayList<>(atributosPersona);

                // Si la lista es menor que 3 significa que falta la edad
                if (atributosPersona.size() < 3) finalAtributosPersona.add(null);

                // Recorro la lista y si alguno de los elementos tiene 0 caracteres lo cambio por un null
                for (int i = 0; i < finalAtributosPersona.size(); i++) {
                    if (finalAtributosPersona.get(i) != null && finalAtributosPersona.get(i).length() < 1) {
                        finalAtributosPersona.set(i, null);
                    }
                }

                // Ahora inserto la persona
                people.add(
                        cambiarNull(
                                new Persona(
                                        finalAtributosPersona.get(0),
                                        finalAtributosPersona.get(1),
                                        finalAtributosPersona.get(2) == null
                                                ? null
                                                : Integer.parseInt(finalAtributosPersona.get(2)))));
            }
            AtomicInteger contador = new AtomicInteger();

            people.stream()
                    .filter(elemento -> (elemento.getEdad() != -1 && elemento.getEdad() < 25))
                    .forEach(
                            elemento -> {
                                System.out.println(
                                        "Línea "
                                                + contador.incrementAndGet()
                                                + " | Nombre: "
                                                + elemento.getNombre()
                                                + " | Población: "
                                                + elemento.getPoblacion()
                                                + " | Edad: "
                                                + elemento.getEdad());
                            });

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static Persona cambiarNull(Persona p) {
        Persona newPerson = new Persona(p.getNombre(), p.getPoblacion(), p.getEdad());

        Optional<String> nombre = Optional.ofNullable(p.getNombre());
        Optional<String> poblacion = Optional.ofNullable(p.getPoblacion());
        Optional<Integer> edad = Optional.ofNullable(p.getEdad());

        if (!nombre.isPresent()) newPerson.setNombre("Desconocido");
        if (!poblacion.isPresent()) newPerson.setPoblacion("Desconocido");
        if (!edad.isPresent()) newPerson.setEdad(-1);

        return newPerson;
    }
}

