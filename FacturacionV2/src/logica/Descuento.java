package logica;
import java.util.function.BiFunction;

public class Descuento {
    public static final BiFunction<Double, Cliente, Double> calcularDescuento = (total, cliente) -> {
        double descuento = 0.0;
        switch (cliente.getTipo().toLowerCase()) {
            case "bronze":
                if (total > 100) {
                    descuento = total * 0.05;
                }
                break;
            case "plata":
                if (total > 300) {
                    descuento = total * 0.15;
                }
                break;
            case "oro":
                if (total > 500) {
                    descuento = total * 0.25;
                }
                break;
        }
        return descuento;
    };
}

