import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static <T> void main(String[] args) throws CantidadDeTestException, TemperaturaSuperiorException, IOException {

    SistemaDeSaludMunicipal sistemaDeSaludMunicipal= new SistemaDeSaludMunicipal();

    ///le cargo personas para empezar a trabajar
        Persona p= new Persona("jose lopez", 38, "los naranjos", 25368941, "electricista");
        Persona p1= new Persona("amanda perez", 52, "los troncos", 20569322, "ama de casa");
        Persona p2= new Persona("alfonso gonzalez", 35, "nueva pompeya", 26555248, "empleado administrativo");

        sistemaDeSaludMunicipal.getListaDePersonas().add(p);
        sistemaDeSaludMunicipal.getListaDePersonas().add(p1);
        sistemaDeSaludMunicipal.getListaDePersonas().add(p2);

        for(Persona a: sistemaDeSaludMunicipal.getListaDePersonas()){
            System.out.println(a);
        }

        ///agrego 5 kits
        sistemaDeSaludMunicipal.setCantidadDeKits(5);

        //testeo todas las personas de la lista
        sistemaDeSaludMunicipal.testear();

        //por cada persona, saco su registro y pruebo la funcion aislar, si supera los 38 grados se guarda en archivo
        for(Persona per: sistemaDeSaludMunicipal.getListaDePersonas()){
            Registro r= sistemaDeSaludMunicipal.retornarRegistroPorPersona(p.getDni());
            sistemaDeSaludMunicipal.aislar(r.getTemperatura(), per, r.getNroRegistro());
        }

        for(Map.Entry<Integer, Registro>entry: sistemaDeSaludMunicipal.getTesteos().entrySet()){
            System.out.println("TEMPERATURA");
            System.out.println(entry.getValue().getTemperatura());
        }



        Sano sano= new Sano();
        List<Aislar> listaDeAislados= new ArrayList<>();

        //por cada persona dentro de la lista, comparo el dni con los testeos realizados, si al encuentro y coincide que en el registro
        // //la temperatura es menor a 38 grados, la guardo en la lista, sino (es decir que la temperatura es mayor) lo guardo en la lista de aislados
        for(Persona perso: sistemaDeSaludMunicipal.getListaDePersonas()){
            for(Map.Entry<Integer, Registro>entry: sistemaDeSaludMunicipal.getTesteos().entrySet()){
                if(perso.getDni().equals(entry.getValue().getDni())){
                    if(entry.getValue().getTemperatura()<38){
                        sano.getSanos().add(perso);
                    }
                    else{
                        Aislar aislar;
                        listaDeAislados.add(aislar= new Aislar(entry.getKey(), entry.getValue().getTemperatura(), perso.getBarrio()));
                    }
                }
            }
        }

        HashMap<String, List<T>> hashMap= new HashMap<>();
        hashMap.put("sanos", (List<T>) sano.getSanos());
        hashMap.put("aislados", (List<T>) listaDeAislados);

        sistemaDeSaludMunicipal.guardarEnArchivoJson(hashMap);




    }
}