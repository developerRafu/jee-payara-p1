package models.enums;

import java.util.Arrays;

public enum IMCEnum {
    ABAIXO(0, "Abaixo do peso"),
    NORMAL(1, "IMC normal"),
    ACIMA(2, "Acima do peso"),
    OBESO(3, "Obeso");

    private Integer id;
    private String desc;

    IMCEnum(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static IMCEnum of(Integer id) {
        return Arrays.stream(IMCEnum.values())
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Valor não encontrado"));
    }

    public static IMCEnum of(String desc) {
        return Arrays.stream(IMCEnum.values())
                .filter(p -> p.getDesc().equals(desc))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Valor não encontrado"));
    }

    public static IMCEnum of() {
        return IMCEnum.ABAIXO;
    }

    public static IMCEnum of(Double imc) {
        if (isLessThan(imc, 18.5)) {
            return IMCEnum.ABAIXO;
        }

        if (isGreaterThanOrEquals(imc, 18.5) && isLessThan(imc, 25.0)) {
            return IMCEnum.NORMAL;
        }

        if (isGreaterThanOrEquals(imc, 25.01) && isLessThan(imc, 30.0)) {
            return IMCEnum.ACIMA;
        }

        if (isGreaterThanOrEquals(imc, 30.0)) {
            return IMCEnum.OBESO;
        }
        throw new IllegalArgumentException("Valores inválidos");
    }

    private static boolean isGreaterThanOrEquals(Double imc, Double value) {
        return imc >= value;
    }

    private static boolean isLessThan(Double imc, Double value) {
        return imc < value;
    }

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
}
