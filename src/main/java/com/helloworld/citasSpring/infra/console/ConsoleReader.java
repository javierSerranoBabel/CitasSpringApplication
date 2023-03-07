package com.helloworld.citasSpring.infra.console;

import com.helloworld.citasSpring.domain.Cita;
import com.helloworld.citasSpring.service.CitaService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Component
public class ConsoleReader {
    private CitaService citaService;

    public ConsoleReader(CitaService citaService) {
        this.citaService = citaService;
    }

    SimpleDateFormat fechaFormateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.forLanguageTag("es_ES"));

    @PostConstruct
    public void init(){
        Scanner sc = new Scanner(System.in);
        String entadaConsola;
        int opcion = 1;

        while(opcion != 0){
            System.out.println("Menú por consola");
            System.out.println("1.- Registrar nueva cita");
            System.out.println("2.- Borrar una cita");
            System.out.println("4.- Listar todas las cita");
            System.out.println("0.- Salir");
            System.out.println("Ingrese una acción: ");
            entadaConsola = sc.next();

            try{
                opcion = Integer.parseInt(entadaConsola);
            } catch(Exception e){
                System.out.println("Opción no valida,ingresa un numero");
            }
            switch(opcion){
                case 0:
                    System.out.println("Saliendo");
                    break;
                case 1:
                    System.out.println("Ingrese nombre");
                    String nombre = sc.next();
                    System.out.println("Ingrese apellidos");
                    String apelldios = sc.next();
                    System.out.println("Ingrese fecha(dd-MM-YYYY HH:mm:ss)");
                    String fecha = sc.nextLine();

                    Date fechaCita;
                    try{
                        fechaCita =fechaFormateador.parse(sc.nextLine());
                        citaService.alta(new Cita(nombre,apelldios,fechaCita));
                    }catch(ParseException e){
                        System.out.println("Fecha no válida");
                        //throw new RuntimeException(e);
                    }

                    break;
                case 2:
                    // TODO por desarrollar
                    break;
                case 3:
                    // TODO por desarrollar
                    break;
                case 4:
                    List<Cita> citas = citaService.listar();
                    System.out.println("Listado de citas:");
                    for (Cita cita: citas) {
                        System.out.printf("Id %s, nombre: %s, apellidos: %s, fecha: %s",citas.indexOf(cita) , cita.getNombre(), cita.getApellidos(), fechaFormateador.format(cita.getFecha()));
                    }
                    break;


                default:
                    System.out.println("Opcion no encontrada");
                    break;
            }

        }
    }
}
