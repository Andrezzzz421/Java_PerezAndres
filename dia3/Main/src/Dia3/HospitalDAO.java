package Dia3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAO {
    private Connection con;

    public HospitalDAO() {
        this.con = new Conection().getConnection();
    }

    public void addHospital(Hospital hospital) {
        String query = "INSERT INTO Hospital (nombre, direccion) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, hospital.getNombre());
            ps.setString(2, hospital.getDireccion());
            ps.executeUpdate();
            System.out.println("Hospital añadido exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al añadir hospital: " + e.getMessage());
        }
    }

    public Hospital getHospital(int id) {
        String query = "SELECT * FROM Hospital WHERE id_hospital = ?";
        Hospital hospital = null;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hospital = new Hospital();
                hospital.setId_hospital(rs.getInt("id_hospital"));
                hospital.setNombre(rs.getString("nombre"));
                hospital.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener hospital: " + e.getMessage());
        }
        return hospital;
    }

    public List<Hospital> getAllHospitals() {
        String query = "SELECT * FROM Hospital";
        List<Hospital> hospitals = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Hospital hospital = new Hospital();
                hospital.setId_hospital(rs.getInt("id_hospital"));
                hospital.setNombre(rs.getString("nombre"));
                hospital.setDireccion(rs.getString("direccion"));
                hospitals.add(hospital);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener hospitales: " + e.getMessage());
        }
        return hospitals;
    }

    public void updateHospital(Hospital hospital) {
        String query = "UPDATE Hospital SET nombre = ?, direccion = ? WHERE id_hospital = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, hospital.getNombre());
            ps.setString(2, hospital.getDireccion());
            ps.setInt(3, hospital.getId_hospital());
            ps.executeUpdate();
            System.out.println("Hospital actualizado exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al actualizar hospital: " + e.getMessage());
        }
    }

    public void deleteHospital(int id) {
        String query = "DELETE FROM Hospital WHERE id_hospital = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Hospital eliminado exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al eliminar hospital: " + e.getMessage());
        }
    }
}
