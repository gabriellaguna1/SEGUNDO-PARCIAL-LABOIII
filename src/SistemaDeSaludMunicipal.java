import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jdi.connect.TransportTimeoutException;

import java.io.*;
import java.util.*;

public class SistemaDeSaludMunicipal {
    private List<Persona>listaDePersonas= new ArrayList<>();
    private Integer cantidadDeKits;
    private HashMap<Integer, Registro>testeos= new HashMap<>();

    public SistemaDeSaludMunicipal() {
    }

    public SistemaDeSaludMunicipal(List<Persona> listaDePersonas, Integer cantidadDeKits, HashMap<Integer, Registro> testeos) {
        this.listaDePersonas = listaDePersonas;
        this.cantidadDeKits = cantidadDeKits;
        this.testeos = testeos;
    }

    public List<Persona> getListaDePersonas() {
        return listaDePersonas;
    }

    public void setListaDePersonas(List<Persona> listaDePersonas) {
        this.listaDePersonas = listaDePersonas;
    }

    public Integer getCantidadDeKits() {
        return cantidadDeKits;
    }

    public void setCantidadDeKits(Integer cantidadDeKits) {
        this.cantidadDeKits = cantidadDeKits;
    }

    public HashMap<Integer, Registro> getTesteos() {
        return testeos;
    }

    public void setTesteos(HashMap<Integer, Registro> testeos) {
        this.testeos = testeos;
    }
    public Integer chequearDni(Integer dni){

        for(Map.Entry<Integer, Registro>entry : testeos.entrySet()){
            if(entry.getValue().getDni().equals(dni)){
                return 0;
            }
        }
        return 1;
    }

    public void testear() throws CantidadDeTestException {

        for(Persona p : this.listaDePersonas){
            Random r= new Random();
            Integer num= r.nextInt(39-36)+36;
            if(chequearDni(p.getDni())==1){
                Registro registro= new Registro(p.getDni(), num);
                testeos.put(getCantidadDeKits(), registro);
            }
            try{
                this.setCantidadDeKits(getCantidadDeKits()-1);

            if(getCantidadDeKits()==0){
                throw new CantidadDeTestException(getCantidadDeKits());
            }
            }catch(CantidadDeTestException e){
                e.getMessage();
            }

        }
    }

    public void aislar(Integer temperatura, Persona p, Integer nroRegistro) throws TemperaturaSuperiorException {
        try{
            if(temperatura>38){
                guardarEnArchivoBinario(p.getBarrio(), nroRegistro);
                throw new TemperaturaSuperiorException(nroRegistro, p.getBarrio());
            }

        } catch (TemperaturaSuperiorException | IOException e) {
            e.getMessage();
        }
    }

    public void guardarEnArchivoBinario(String barrio, Integer nroTest) throws IOException {

        BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(new File("urgente.dat"),true));
        bufferedWriter.write(barrio);
        bufferedWriter.newLine();
        bufferedWriter.write(nroTest);
        bufferedWriter.newLine();
    }

    public Registro retornarRegistroPorPersona(Integer dni){
        for(Map.Entry<Integer, Registro>t : this.testeos.entrySet()){
            if(t.getValue().getDni().equals(dni)){
                return t.getValue();
            }
        }
        return null;
    }

    public <T> void guardarEnArchivoJson(HashMap<String, List<T>>t) throws IOException {
        File file= new File("Json.json");
        if(!file.exists()){
            file.createNewFile();
        }
        ObjectMapper mapper= new ObjectMapper();
        mapper.writeValue(file, t);

    }

    public Persona devolverPersona(Integer dni){
        for(Persona p: this.getListaDePersonas()){
            if (p.getDni().equals(dni)){
                return p;
            }
        }
        return null;
    }


}
