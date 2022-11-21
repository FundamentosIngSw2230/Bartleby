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
    public void OrganizarCartasIsDivisionOftheRouteString(){

        boolean expected = true;
        plan.OrganizarCartas("cra77 #19-35\ncra77 #23-55");

    }

}
