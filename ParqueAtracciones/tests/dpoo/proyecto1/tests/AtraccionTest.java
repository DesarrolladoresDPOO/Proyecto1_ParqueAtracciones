package dpoo.proyecto1.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atracciones.AtraccionCultural;
import atracciones.AtraccionMecanica;
import atracciones.Espectaculo;
import atracciones.Temporada;


public class AtraccionTest
{
    private AtraccionMecanica a1;
    private AtraccionCultural a2;
    private Espectaculo e1;
    private Espectaculo e2;
    private Temporada t1;
    private Temporada t2;

    @BeforeEach
    void setUp( ) throws Exception
    {
        a1 = new AtraccionMecanica("MontanaRusa", 10, 4, true, "oro", 150, 190, 40, 90, "vertigo", "medio");
        // nombre, cupo maximo, empleados encargados, disponible clima, nivel exclusividad, altura min, altura max, peso min, peso max, restricciones salud, nivel riesgo
        
        a2 = new AtraccionCultural("PalacioEspejos", 20, 2, true, "familiar", 9);
        // nombre, cupo maximo, empleados encargados, disponible clima, nivel exclusividad, edad min
        
        LocalDateTime inicio1 = LocalDateTime.of(2025, 1, 10, 12, 00); // 10 de enero de 2025, 12:00
        LocalDateTime fin1 = LocalDateTime.of(2025, 3, 1, 12, 00); // 1 de marzo de 2025, 12:00
        t1= new Temporada(inicio1, fin1);
        
        e1= new Espectaculo("DesfileInvierno", t1, "18:00 - 21:00", false);
        
        LocalDateTime inicio2 = LocalDateTime.of(2025, 1, 10, 12, 00); // 10 de enero de 2025, 12:00
        LocalDateTime fin2 = LocalDateTime.of(2026, 4, 10, 12, 00); // 10 de abril de 2026, 12:00
        t2= new Temporada(inicio2, fin2);
        
        e2= new Espectaculo("DesfileSiempre", t2, "18:00 - 21:00", false);
    }

    @AfterEach
    void tearDown( ) throws Exception
    {
    }

    @Test
    void testMecanica() {
        a1.aptaParaCliente(100, 40, "apendicitis");
        System.out.println("Prueba Mecanica 1 - No cumple con la altura minima, esperada (false), dada: " + a1.isRespuesta());
        assertEquals(false, a1.isRespuesta(), "El usuario dado NO puede utilizar la atracción");

        a1.aptaParaCliente(155, 100, "fatiga");
        System.out.println("Prueba Mecanica 2 - Sobrepasa el peso maximo, esperada (false), dada: " + a1.isRespuesta());
        assertEquals(false, a1.isRespuesta(), "El usuario dado NO puede utilizar la atracción");
        
        a1.aptaParaCliente(165, 60, "vertigo");
        System.out.println("Prueba Mecanica 3 - Tiene una enfermedad que se encuentra en la lista de la atraccion, esperada (false), dada: " + a1.isRespuesta());
        assertEquals(false, a1.isRespuesta(), "El usuario dado NO puede utilizar la atracción");
        
        a1.aptaParaCliente(160, 50, "fatiga");
        System.out.println("Prueba Mecanica 4 - Cumple con todos los parametros, esperada (true), dada: " + a1.isRespuesta());
        assertEquals(true, a1.isRespuesta(), "El usuario dado SI puede utilizar la atracción");
        
    }
    
    @Test
    void testCultural( )
    {
    	a2.aptaParaCliente(8);
    	System.out.println("Prueba Cultural 1 - No cumple con la edad minima, esperada (false), dada: " + a2.isRespuesta());
        assertEquals( false, a2.isRespuesta(), "El usuario dado NO puede utilizar la atraccion" );
        
        a2.aptaParaCliente(15);
        System.out.println("Prueba Cultural 2 - Cumple con la edad minima, esperada (true), dada: " + a2.isRespuesta());
        assertEquals( true, a2.isRespuesta(), "El usuario dado SI puede utilizar la atraccion" );
    }
    
    @Test
    void testEspectaculo( )
    {
    	System.out.println("Prueba Espectaculo - El espectaculo NO esta disponible, esperada (false), dada: " + e1.estaDisponible());
        assertEquals(false, e1.estaDisponible(), "El espectaculo no esta disponible" );
        
        System.out.println("Prueba Espectaculo - El espectaculo SI esta disponible, esperada (true), dada: " + e2.estaDisponible());
        assertEquals(true, e2.estaDisponible(), "El espectaculo no esta disponible" );
    }
    
}
