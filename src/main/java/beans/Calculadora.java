package beans;

import models.enums.IMCEnum;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class Calculadora implements Serializable {

    public IMCEnum imc(Double altura, Double peso) {
        final Double alturaMetro = (altura/100.0);
        Double resultado = peso / Math.pow(alturaMetro, 2);
        return IMCEnum.of(resultado);
    }

}
