import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AzucareroTest {
    
    private Azucarero azucarero;

    @BeforeEach
    public void setUp() {
        azucarero = new Azucarero(10);  
    }

    @Test
    public void deberiaDevolverVerdaderoSiHaySuficienteAzucar() {
        assertTrue(azucarero.hasAzucar(5));
        assertTrue(azucarero.hasAzucar(10));
    }

    @Test
    public void deberiaDevolverFalsoSiNoHaySuficienteAzucar() {
        assertFalse(azucarero.hasAzucar(15));
    }

    @Test
    public void deberiaRestarAzucarAlAzucarero() {
        azucarero.giveAzucar(5);
        assertEquals(5, azucarero.getCantidadAzucar());  

        azucarero.giveAzucar(2);
        assertEquals(3, azucarero.getCantidadAzucar());  
    }
}



