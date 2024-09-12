package com.example.lab3_20182693.model.repository;

import com.example.lab3_20182693.model.bean.Ingrediente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  IngredienteDAO  extends BaseDAO {

    public ArrayList<Ingrediente> findAll() {

        ArrayList<Ingrediente> listaIngredientes = new ArrayList<>();

        String sql = "select "
                + "i.ingrediente_id, i.ingrediente_nombre "
                + "from ingredientes i ";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {

                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setIngredienteId(Integer.parseInt(rs.getString(1)));
                ingrediente.setNombre(rs.getString(2));

                listaIngredientes.add(ingrediente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaIngredientes;
    }


}