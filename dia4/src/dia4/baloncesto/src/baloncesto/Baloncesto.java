package baloncesto;

import java.util.Scanner;

abstract class Partido {
    protected String equipoLocal;
    protected String equipoVisitante;
    protected int cestasLocal;
    protected int cestasVisitante;
    protected boolean finalizado;
    protected String fecha;

    public Partido(String equipoLocal, String equipoVisitante, String fecha) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.cestasLocal = 0;
        this.cestasVisitante = 0;
        this.finalizado = false;
    }

    public abstract void registrarPuntosLocal(int puntos);

    public abstract void registrarPuntosVisitante(int puntos);

    public abstract String obtenerGanador();

    public abstract void finalizarPartido();

    public String obtenerInformacion() {
        return "Partido entre " + equipoLocal + " y " + equipoVisitante + " el " + fecha;
    }

    public boolean isFinalizado() {
        return finalizado;
    }
}

class PartidoLiga extends Partido {
    private int jornada;

    public PartidoLiga(String equipoLocal, String equipoVisitante, String fecha, int jornada) {
        super(equipoLocal, equipoVisitante, fecha);
        this.jornada = jornada;
    }

    @Override
    public void registrarPuntosLocal(int puntos) {
        cestasLocal += puntos;
    }

    @Override
    public void registrarPuntosVisitante(int puntos) {
        cestasVisitante += puntos;
    }

    @Override
    public String obtenerGanador() {
        if (cestasLocal > cestasVisitante) {
            return equipoLocal;
        } else if (cestasVisitante > cestasLocal) {
            return equipoVisitante;
        } else {
            return "Empate";
        }
    }

    @Override
    public void finalizarPartido() {
        finalizado = true;
    }

    @Override
    public String obtenerInformacion() {
        return super.obtenerInformacion() + ", Jornada: " + jornada;
    }
}

class PartidoPlayOffs extends Partido {
    private String ronda;

    public PartidoPlayOffs(String equipoLocal, String equipoVisitante, String fecha, String ronda) {
        super(equipoLocal, equipoVisitante, fecha);
        this.ronda = ronda;
    }

    @Override
    public void registrarPuntosLocal(int puntos) {
        cestasLocal += puntos;
    }

    @Override
    public void registrarPuntosVisitante(int puntos) {
        cestasVisitante += puntos;
    }

    @Override
    public String obtenerGanador() {
        if (cestasLocal > cestasVisitante) {
            return equipoLocal;
        } else if (cestasVisitante > cestasLocal) {
            return equipoVisitante;
        } else {
            return "Empate";
        }
    }

    @Override
    public void finalizarPartido() {
        if (cestasLocal != cestasVisitante) {
            finalizado = true;
        } else {
            System.out.println("No se puede finalizar el partido hasta que haya un ganador.");
        }
    }

    @Override
    public String obtenerInformacion() {
        return super.obtenerInformacion() + ", Ronda: " + ronda;
    }
}

