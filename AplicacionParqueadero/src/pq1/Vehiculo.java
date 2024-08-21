package pq1;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L; // ID de serialización para persistir

    public String placa;
    public Propietario propietario = new Propietario();
    public String vehiculo;
    public LocalDateTime fechaIngreso;
    public String strFechaIngreso;
    public String strFechaSalida;
    
    // Calcular el pago basado en el tipo de vehículo y la fecha de ingreso
    public double calcularPago(String vehiculo, LocalDateTime fechaIngreso) {
        double minutos = calculaMinutos(fechaIngreso);
        double total = 0;
        if (minutos < 1) {
            minutos = 1;
        }
        if ("Moto".equals(vehiculo)) {
            total = minutos * 50; // Ajustado a 50 por minuto
        } else if ("Carro".equals(vehiculo)) {
            total = minutos * 100; // Ajustado a 100 por minuto
        }
        return total;
    }
    
    // Calcular el número de minutos entre la fecha de ingreso y ahora
    public double calculaMinutos(LocalDateTime fechaIngreso) {
        LocalDateTime horaActual = LocalDateTime.now(); // obtener hora actual
        Duration duracion = Duration.between(fechaIngreso, horaActual); // calcular diferencia en duración
        double minutos = duracion.toMinutes(); // obtener duración en minutos
        return minutos;
    }
    
    // Obtener la fecha y hora actual formateada
    public String obtenerFecha() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHoraFormateada = fechaHoraActual.format(formatter);
        return fechaHoraFormateada;
    }

    @Override
    public String toString() {
        return "Propietario " + propietario.nombre + "\nIdentificacion: " + propietario.identificaion + 
               "\nPlaca: " + placa + "\nTipo vehiculo: " + this.vehiculo + 
               "\nHora ingreso: " + this.strFechaIngreso + "\n";
    }
}