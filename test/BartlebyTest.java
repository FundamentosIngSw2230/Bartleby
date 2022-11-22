import controllers.InterfaceController;
import entities.Carta;
import entities.DBconnection;
import entities.Planificacion;
import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class BartlebyTest {

    Planificacion plan;

    public BartlebyTest(){}

    @Before
    public void clear(){
    }

    @Test
    public void laDivisionSoloDevuelveValoresEnteros(){
        int ans = 0;
        assertEquals(ans,InterfaceController.calculo(8,10));
    }
    @Test
    public void doceHorasySeisClientesSonDosHorasPorCliente(){
        int ans = 2;
        assertEquals(ans,InterfaceController.calculo(12,6));
    }

    @Test
    public void elMismoNumeroDeHorasyClientesEsunHoraPorCliente(){
        int ans = 1;
        assertEquals(ans,InterfaceController.calculo(8,8));
    }
    @Test
    public void agregarCartaAlaPlanificacion(){
        Planificacion plan = new Planificacion();
        Carta carta = new Carta(104, "cra 23 #12-22","express",222, LocalDate.parse("2022-11-26"));
        boolean exp = true;
        boolean real = plan.agregarAPlan(carta);

        assertEquals(exp,real);
    }

    /*
    @Test
    public void agregarCartaAlaPlanificacionConIdInvalido(){
        Planificacion plan = new Planificacion();
        Carta carta = new Carta(, "cra 23 #12-22","express",222, LocalDate.parse("2022-11-26"));
        boolean exp = true;
        boolean real = plan.agregarAPlan(carta);

        assertEquals(exp,real);
    }
     */


}
