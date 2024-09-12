package com.example.lab3_20182693.model.repository;

import com.example.lab3_20182693.model.bean.Categoria;
import com.example.lab3_20182693.model.bean.Ingrediente;
import com.example.lab3_20182693.model.bean.Nutricion;
import com.example.lab3_20182693.model.bean.Receta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecetaDAO extends BaseDAO {

    public ArrayList<Receta> findAll() {

        ArrayList<Receta> listaRecetas = new ArrayList<>();

        String sql = "SELECT r.receta_id, r.nombre, r.tiempo_preparacion "
                + "d., l.city "
                + "d.department_name, l.city "
                + "FROM recetas r "
                + "JOIN ingredientes i ON r.ingrediente_id = ingrediente_id "
                + "JOIN nutricion n ON r.nutricion_id = n.nutricion_id "
                + "JOIN categorias c ON n.categoria_id = c.categoria_id";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Receta receta = new Receta();
                receta.setRecetaId(rs.getInt("receta_id"));
                receta.setNombre(rs.getString("nombre"));
                receta.setTiempo_preparacion(rs.getString("tiempo_preparacion"));


                // Ingrediente
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setNombre(rs.getString("nombre_ingrediente"));
                receta.setIngrediente(ingrediente);

                // Nutricion
                Nutricion nutricion = new Nutricion();
                nutricion.setCalorias(rs.getInt("calorias"));
                nutricion.setGrasas(rs.getInt("grasas"));
                nutricion.setProteinas(rs.getInt("proteinas"));
                nutricion.setCarbohidratos(rs.getInt("carbohidratos"));
                nutricion.setFibra(rs.getInt("fibra"));
                receta.setNutricion(nutricion);

                // Categoria
                Categoria categoria = new Categoria();
                categoria.setCategoriaNombre(rs.getString("nombre_categoria"));
                receta.setCategoria(categoria);

                listaRecetas.add(receta);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaRecetas;
    }

    public Receta findById(int id) {

        Receta receta = new Receta();

        String sql = "SELECT r.receta_id, r.nombre, r.tiempo_preparacion "
                + "d., l.city "
                + "d.department_name, l.city "
                + "FROM recetas r "
                + "JOIN ingredientes i ON r.ingrediente_id = ingrediente_id "
                + "JOIN nutricion n ON r.nutricion_id = n.nutricion_id "
                + "JOIN categorias c ON n.categoria_id = c.categoria_id"
                + "WHERE r.receta_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {

                    receta.setRecetaId(rs.getInt("receta_id"));
                    receta.setNombre(rs.getString("nombre"));
                    receta.setTiempo_preparacion(rs.getString("tiempo_preparacion"));
                }
                    // Ingrediente
                    Ingrediente ingrediente = new Ingrediente();
                    ingrediente.setNombre(rs.getString("nombre_ingrediente"));
                    receta.setIngrediente(ingrediente);

                    // Nutricion
                    Nutricion nutricion = new Nutricion();
                    nutricion.setCalorias(rs.getInt("calorias"));
                    nutricion.setGrasas(rs.getInt("grasas"));
                    nutricion.setProteinas(rs.getInt("proteinas"));
                    nutricion.setCarbohidratos(rs.getInt("carbohidratos"));
                    nutricion.setFibra(rs.getInt("fibra"));
                    receta.setNutricion(nutricion);

                    // Categoria
                    Categoria categoria = new Categoria();
                    categoria.setCategoriaNombre(rs.getString("nombre_categoria"));
                    receta.setCategoria(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return receta;
    }

    public boolean deleteById(int id) { /* popup hecho */
        String sql =  "DELETE FROM recetas WHERE employee_id = ?";
        boolean flag = false;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                flag = true;  // Se eliminó correctamente
            }

        }  catch (SQLException ex) {
            Logger.getLogger(RecetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

}
