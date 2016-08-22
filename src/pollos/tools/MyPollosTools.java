/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pollos.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dpatik
 */
public class MyPollosTools {
    Connection cn;
    String bdriver = "com.mysql.jdbc.Driver";
    //String url = "jdbc:mysql://localhost/chkncounter";
    //String url = "jdbc:mysql://192.168.7.219/chkncounter?autoReconnect=true";
    String url = "jdbc:mysql://192.168.153.219/chkncounter?autoReconnect=true";   //con ?autoReconnect=true soluciono la perdida de conexion
    String usr = "usuario1";
    String pass = "";
    
    public MyPollosTools(){
        try {

            Class.forName(bdriver);
            cn = DriverManager.getConnection(url, usr, pass);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ESTOY en CONEXION");
            Logger.getLogger(MyPollosTools.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public ResultSet ConsultaDB(String query){
                Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);
//cn.close();
        } catch (SQLException ex) {
            System.out.println("ESTOY en CONSULTADB");
            this.ReConecta();
            //Logger.getLogger(MyPollosTools.class.getName()).log(Level.SEVERE, null, ex);
        }


        return rs;
        
    }
    
    public void ReConecta(){
         try {

            Class.forName(bdriver);
            cn = DriverManager.getConnection(url, usr, pass);
             System.out.println("RECONECTE");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ESTOY en CONEXION");
            Logger.getLogger(MyPollosTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public int SumaDia(String fecha) {
        int total = 0;
        ResultSet rs;

        rs = ConsultaDB("SELECT sum(qty) FROM chkncounter.faena where fecha =\'" + fecha + "\'");
        try {
            while (rs.next()) {
                total = rs.getInt("sum(qty)");
                return total;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR en SUMADIA");            
            Logger.getLogger(MyPollosTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
        
    public int GetFrm(String fecha) {
        int nombre = 0;
        ResultSet rs;
        rs = ConsultaDB("SELECT granja FROM faena WHERE fecha=\'" + fecha + "\' order by granja desc limit 1");
        try {

            while (rs.next()) {
                nombre = rs.getInt("granja");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyPollosTools.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nombre;

    }
    
    public void SetFrm(int granja) {
        /*
         * Actualiza la tabla granja_actual
         * para el cambio de granja
         */

        Statement st;
        ResultSet rs;

        String query = "UPDATE granja_actual set nombre=?";

        PreparedStatement pst;

        try {
            pst = cn.prepareCall(query);
            pst.setInt(1, granja);
            pst.execute();
        } catch (SQLException ex) {
            System.out.println("ESTOY en SETFRM");
            Logger.getLogger(MyPollosTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public String GetNombreFrm(int id){
        String FRM = null;
            ResultSet rs;
            
            
            rs = ConsultaDB("SELECT nombre FROM chkncounter.granjas_id where id="+id);
            try {
                while (rs.next()) {
                    FRM = rs.getString("nombre");
                    
                    
                }
            } catch (SQLException ex) {
                System.out.println("ESTOY en GETNOMBREFRM");
                Logger.getLogger(MyPollosTools.class.getName()).log(Level.SEVERE, null, ex);
            }
            return FRM;
    }
        
                public int GetIDFrm(String nombre){
        int id = 0;
            ResultSet rs;
            
            
            rs = ConsultaDB("SELECT id FROM chkncounter.granjas_id where nombre=\'"+nombre+"\'");
            try {
                while (rs.next()) {
                    id = rs.getInt("id");
                    
                    
                }
            } catch (SQLException ex) {
                System.out.println("ESTOY en GetIDFrm");
                Logger.getLogger(MyPollosTools.class.getName()).log(Level.SEVERE, null, ex);
            }
            return id;
    }
                
                public void ModifGranja(String fecha, int frm_new, int frm_old){
                    
                    Statement st;
                    ResultSet rs;

                    String query = "update faena set granja=? where fecha=\'"+fecha+"\' and granja="+frm_old;

                    PreparedStatement pst;

                    try {
                        pst = cn.prepareCall(query);
                        pst.setInt(1, frm_new);
                        pst.execute();
                    } catch (SQLException ex) {
                        System.out.println("ESTOY en ModifGranja");
                        Logger.getLogger(MyPollosTools.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
}
