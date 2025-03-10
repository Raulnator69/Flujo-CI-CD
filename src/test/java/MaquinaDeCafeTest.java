import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaquinaDeCafeTest {

    Cafetera cafetera;
    Vaso vasoPequeno;
    Vaso vasoMediano;
    Vaso vasoGrande;
    Azucarero azucarero;
    MaquinaDeCafe maquinaDeCafe;

    @BeforeEach
    public void setUp() {
        cafetera = new Cafetera(50);
        vasoPequeno = new Vaso(5, 10);
        vasoMediano = new Vaso(5, 20);
        vasoGrande = new Vaso(5, 30);
        azucarero = new Azucarero(20);

        maquinaDeCafe = new MaquinaDeCafe(cafetera, vasoPequeno, vasoMediano, vasoGrande, azucarero);
    }

    @Test
    public void deberiaDevolverUnVasoPequeno() {
        Vaso vaso = maquinaDeCafe.getTipoVaso("Pequeno");
        assertEquals(vasoPequeno, vaso);
    }

    @Test
    public void deberiaDevolverUnVasoMediano() {
        Vaso vaso = maquinaDeCafe.getTipoVaso("Mediano");
        assertEquals(vasoMediano, vaso);
    }

    @Test
    public void deberiaDevolverUnVasoGrande() {
        Vaso vaso = maquinaDeCafe.getTipoVaso("Grande");
        assertEquals(vasoGrande, vaso);
    }

    @Test
    public void deberiaDevolverNoHayVasos() {
        String resultado = maquinaDeCafe.getVasoDeCafe("Pequeno", 10, 2) ? "Sí hay vasos" : "No hay vasos";
        assertEquals("No hay vasos", resultado);
    }

    @Test
    public void deberiaDevolverNoHayCafe() {
        cafetera = new Cafetera(5);
        maquinaDeCafe = new MaquinaDeCafe(cafetera, vasoPequeno, vasoMediano, vasoGrande, azucarero);
        String resultado = maquinaDeCafe.getVasoDeCafe("Grande", 6, 7) ? "Sí hay café" : "No hay cafe";
        assertEquals("No hay cafe", resultado);
    }

    @Test
    public void deberiaDevolverNoHayAzucar() {
        azucarero = new Azucarero(2);
        maquinaDeCafe = new MaquinaDeCafe(cafetera, vasoPequeno, vasoMediano, vasoGrande, azucarero);
        String resultado = maquinaDeCafe.getVasoDeCafe("Pequeno", 1, 3) ? "Sí hay azúcar" : "No hay azucar";
        assertEquals("No hay azucar", resultado);
    }

@Test
public void deberiaRestarCafe() {
    System.out.println("Café antes: " + cafetera.getCantidadCafe());  
    maquinaDeCafe.getVasoDeCafe("Pequeno", 1, 3);
    int resultado = cafetera.getCantidadCafe();
    System.out.println("Café después: " + resultado);
    assertEquals(40, resultado);
}


    @Test
    public void deberiaRestarVaso() {
        maquinaDeCafe.getVasoDeCafe("Pequeno", 1, 3);
        int resultado = vasoPequeno.getCantidadVasos();
        assertEquals(4, resultado);
        
    }

    @Test
    public void deberiaRestarAzucar() {
        maquinaDeCafe.getVasoDeCafe("Pequeno", 1, 3);
        int resultado = azucarero.getCantidadAzucar();
        assertEquals(17, resultado);
    }

    @Test
    public void deberiaDevolverFelicitaciones() {
        boolean resultado = maquinaDeCafe.getVasoDeCafe("Pequeno", 1, 3);
        assertTrue(resultado, "Felicitaciones");
    }
}
