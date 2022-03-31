package beans;

import models.enums.IMCEnum;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class IndexController implements Serializable {
    private Integer idade;
    private Double altura;
    private Double peso;
    private String result;

    @Inject
    private Calculadora calculadora;

    public IndexController() {
    }

    public IndexController(Integer idade, Double altura, Double peso, String result) {
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.result = result;
    }

    public void submit(){
        final IMCEnum imc = calculadora.imc(altura, peso);
        this.result = imc.getDesc();
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
