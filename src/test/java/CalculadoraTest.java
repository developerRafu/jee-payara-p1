import beans.Calculadora;
import models.enums.IMCEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    Calculadora calculadora;

    final Double defaultAtura = 190d;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void itShouldReturnAbaixoDoPesoWhenItsAbaixoDoPeso() {
        final Double altura = defaultAtura;
        final Double peso = 40d;
        final IMCEnum result = calculadora.imc(altura, peso);
        assertEquals(0, result.getId());
        assertEquals("Abaixo do peso", result.getDesc());
    }

    @Test
    void itShouldReturnIMCNormalWhenItsIMCNormal() {
        final Double altura = defaultAtura;
        final Double peso = 80d;
        final IMCEnum result = calculadora.imc(altura, peso);
        assertEquals(1, result.getId());
        assertEquals("IMC normal", result.getDesc());
    }

    @Test
    void itShouldReturnAcimaDoPesoWhenItIs() {
        final Double altura = defaultAtura;
        final Double peso = 100d;
        final IMCEnum result = calculadora.imc(altura, peso);
        assertEquals(2, result.getId());
        assertEquals("Acima do peso", result.getDesc());
    }

    @Test
    void itShouldReturnObesoWhenItIs() {
        final Double altura = defaultAtura;
        final Double peso = 120d;
        final IMCEnum result = calculadora.imc(altura, peso);
        assertEquals(3, result.getId());
        assertEquals("Obeso", result.getDesc());
    }
}
