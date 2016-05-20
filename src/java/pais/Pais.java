/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pais;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author Francisco
 */
@WebService(serviceName = "Pais")
public class Pais {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "obtener_ciudades")
    public String[] obtenerCiudad(@WebParam(name = "country") String country){
        String[] arreglo = new String[2];
        
        GlobalWeather gw = new GlobalWeather();
        
        Airport ar = new Airport();
        
        GlobalWeatherSoap gws =  gw.getGlobalWeatherSoap();
        AirportSoap ars = ar.getAirportSoap();
        
        arreglo[0] = gws.getCitiesByCountry(country);
        
        arreglo[1] = ars.getAirportInformationByCountry(country);

        
        return arreglo;
    }
}
