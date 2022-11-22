import controllers.InterfaceController;
import entities.Planificacion;
import org.junit.*;

import static org.junit.Assert.*;

public class BartlebyTest {

    Planificacion plan;

    public BartlebyTest(){}

    @Before
    public void clear(){
    }


    @Test
    public void doceHorasySeisClientesSonDosHorasPorCliente(){
        int ans = 2;

        assertEquals(ans,InterfaceController.calculo(12,6));
    }

}
