import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Definición de la clase Doctor
        class Doctor {
            public String nameDoc;
            public int idDoc;
            public String docWork;

            // Constructor con parámetros
            public Doctor(String nameDoc, int idDoc, String docWork) {
                this.nameDoc = nameDoc;
                this.idDoc = idDoc;
                this.docWork = docWork;
            }

            // Método para escanear los datos del doctor
            public void scan() {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Introduce el nombre del Doctor: ");
                this.nameDoc = scanner.nextLine();
                System.out.print("Introduce el ID del Doctor: ");
                this.idDoc = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                System.out.print("Introduce la especialidad del Doctor: ");
                this.docWork = scanner.nextLine();
                System.out.println("Registro Exitoso");
            }

            // Método para mostrar detalles del doctor
            public void mostrarDetalles() {
                System.out.println("Doctor: " + nameDoc + " (ID: " + idDoc + ")");
                System.out.println("Especialidad: " + docWork);
            }

            // Método para guardar datos en CSV
            public String toCSV() {
                return idDoc + "," + nameDoc + "," + docWork;
            }
        }

        // Definición de la clase Paciente
        class Paciente {
            public String namePat;
            public int idPat;
            public int agePat;

            // Constructor con parámetros
            public Paciente(String namePat, int idPat, int agePat) {
                this.namePat = namePat;
                this.idPat = idPat;
                this.agePat = agePat;
            }

            // Método para escanear los datos del paciente
            public void scan() {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Introduce el nombre del Paciente: ");
                this.namePat = scanner.nextLine();
                System.out.print("Introduce el ID del Paciente: ");
                this.idPat = scanner.nextInt();
                System.out.print("Introduce la edad del Paciente: ");
                this.agePat = scanner.nextInt();
                System.out.println("Registro Exitoso");
                scanner.nextLine(); // Consumir la nueva línea
            }

            // Método para mostrar detalles del paciente
            public void mostrarDetalles() {
                System.out.println("Paciente: " + namePat + " (ID: " + idPat + ")");
                System.out.println("Edad: " + agePat);
            }

            // Método para guardar datos en CSV
            public String toCSV() {
                return idPat + "," + namePat + "," + agePat;
            }
        }

        // Definición de la clase Cita
        class Cita {
            public String citaID; // Nuevo atributo para el ID de la cita
            public Doctor doctor;
            public Paciente paciente;
            public LocalDate fecha;  // Fecha en formato aaaa-mm-dd

            // Constructor con parámetros
            public Cita(String citaID, Doctor doctor, Paciente paciente, LocalDate fecha) {
                this.citaID = citaID;
                this.doctor = doctor;
                this.paciente = paciente;
                this.fecha = fecha;
            }

            // Método para generar ID de la cita
            private String generarCitaID(Doctor doctor, Paciente paciente) {
                // Obtiene las primeras tres letras del nombre del doctor y paciente
                String doctorInitials = doctor.nameDoc.substring(0, Math.min(3, doctor.nameDoc.length()));
                String pacienteInitials = paciente.namePat.substring(0, Math.min(3, paciente.namePat.length()));
                // Formato: YYYY-MM-DD + Primeras 3 letras del nombre del doctor + Primeras 3 letras del nombre del paciente
                return fecha + doctorInitials + pacienteInitials;
            }

            // Método para escanear los datos de la cita
            public void scan(List<Doctor> doctores, List<Paciente> pacientes) {
                Scanner scanner = new Scanner(System.in);

                // Seleccionar doctor
                if (doctores.isEmpty()) {
                    System.out.println("No hay doctores registrados.");
                    return; // Salir del método
                }
                System.out.println("Selecciona un doctor:");
                for (int i = 0; i < doctores.size(); i++) {
                    System.out.println((i + 1) + ". " + doctores.get(i).nameDoc + " (ID: " + doctores.get(i).idDoc + ")");
                }
                System.out.print("Introduce el número del doctor: ");
                int doctorIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consumir la nueva línea

                // Verificar índice del doctor
                if (doctorIndex < 0 || doctorIndex >= doctores.size()) {
                    System.out.println("Número de doctor no válido.");
                    return; // Salir del método
                }
                this.doctor = doctores.get(doctorIndex);

                // Seleccionar paciente
                if (pacientes.isEmpty()) {
                    System.out.println("No hay pacientes registrados.");
                    return; // Salir del método
                }
                System.out.println("Selecciona un paciente:");
                for (int i = 0; i < pacientes.size(); i++) {
                    System.out.println((i + 1) + ". " + pacientes.get(i).namePat + " (ID: " + pacientes.get(i).idPat + ")");
                }
                System.out.print("Introduce el número del paciente: ");
                int pacienteIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consumir la nueva línea

                // Verificar índice del paciente
                if (pacienteIndex < 0 || pacienteIndex >= pacientes.size()) {
                    System.out.println("Número de paciente no válido.");
                    return; // Salir del método
                }
                this.paciente = pacientes.get(pacienteIndex);

                // Ingresar la fecha de la cita
                System.out.print("Introduce la fecha de la cita (aaaa-mm-dd): ");
                String fechaStr = scanner.nextLine();
                this.fecha = LocalDate.parse(fechaStr);  // Convierte la cadena a LocalDate
                // Generar y establecer el ID de la cita
                this.citaID = generarCitaID(this.doctor, this.paciente);
                System.out.println("Cita registrada con ID: " + this.citaID);
            }

            // Método para mostrar detalles de la cita
            public void mostrarDetalles() {
                System.out.println("ID de la Cita: " + citaID);
                System.out.println("Fecha de la Cita: " + fecha);
                doctor.mostrarDetalles();
                paciente.mostrarDetalles();
            }

            // Método para guardar datos en CSV
            public String toCSV() {
                return citaID + "," + fecha + "," + doctor.toCSV() + "," + paciente.toCSV();
            }
        }

        // Login
        Scanner scanner = new Scanner(System.in);
        String username = "admin";
        String password = "adminpassword";
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Introduce el nombre de usuario: ");
            String inputUser = scanner.nextLine();
            System.out.print("Introduce la contraseña: ");
            String inputPass = scanner.nextLine();

            if (inputUser.equals(username) && inputPass.equals(password)) {
                loggedIn = true;
                System.out.println("Inicio de sesión exitoso.");
            } else {
                System.out.println("Credenciales incorrectas. Inténtalo de nuevo.");
            }
        }

        // Listas para almacenar doctores, pacientes y citas
        List<Doctor> doctores = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        List<Cita> citas = new ArrayList<>(); // Nueva lista para almacenar las citas

        // Menú de opciones
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Introducir datos del Doctor");
            System.out.println("2. Introducir datos del Paciente");
            System.out.println("3. Introducir Cita");
            System.out.println("4. Mostrar detalles de las Citas");
            System.out.println("5. Guardar datos en archivo CSV");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    Doctor doctor = new Doctor("", 0, ""); // Crea un nuevo doctor
                    doctor.scan();  // Pedir los datos del doctor
                    doctores.add(doctor); // Añade el doctor a la lista
                    break;
                case 2:
                    Paciente paciente = new Paciente("", 0, 0); // Crea un nuevo paciente
                    paciente.scan();  // Pedir los datos del paciente
                    pacientes.add(paciente); // Añade el paciente a la lista
                    break;
                case 3:
                    Cita nuevaCita = new Cita(null, null, null, null); // Crea una nueva cita
                    nuevaCita.scan(doctores, pacientes);  // Pedir los datos de la cita
                    citas.add(nuevaCita); // Añadir la cita a la lista
                    break;
                case 4:
                    if (citas.isEmpty()) {
                        System.out.println("No hay citas registradas.");
                    } else {
                        System.out.println("Selecciona una cita:");
                        for (int i = 0; i < citas.size(); i++) {
                            System.out.println((i + 1) + ". " + citas.get(i).citaID);
                        }
                        System.out.print("Introduce el número de la cita: ");
                        int citaIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); // Consumir la nueva línea

                        // Verificar índice de la cita
                        if (citaIndex < 0 || citaIndex >= citas.size()) {
                            System.out.println("Número de cita no válido.");
                        } else {
                            citas.get(citaIndex).mostrarDetalles(); // Mostrar detalles de la cita seleccionada
                        }
                    }
                    break;
                case 5:
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("datos.csv"))) {
                        // Escribir cabecera del archivo
                        writer.write("Tipo,ID,Nombre,Especialidad/E edad,Fecha\n");

                        // Escribir doctores
                        for (Doctor doc : doctores) {
                            writer.write("Doctor," + doc.toCSV() + "\n");
                        }

                        // Escribir pacientes
                        for (Paciente pat : pacientes) {
                            writer.write("Paciente," + pat.toCSV() + "\n");
                        }

                        // Escribir citas
                        for (Cita cita : citas) {
                            writer.write("Cita," + cita.toCSV() + "\n");
                        }

                        System.out.println("Datos guardados en datos.csv");
                    } catch (IOException e) {
                        System.out.println("Error al guardar los datos: " + e.getMessage());
                    }
                    break;
                case 6:
                    continuar = false;  // Salir del programa
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}


