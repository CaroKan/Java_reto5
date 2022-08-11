
package model.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import model.vo.LideresVo;
import model.vo.ProyectosVo;
import utilities.Conexion;
import static utilities.Conexion.close;

public class ProyectosDao implements IProyectos{
    private static final String SQL_SELECT ="select p.ID_Proyecto ,p.Constructora ,p.Numero_Habitaciones ,p.Ciudad  from Proyecto p where p.Clasificacion ='Casa Campestre' and p.Ciudad IN  (\"Santa Marta\", \"Cartagena\",\"Barranquilla\")";
    
    
    @Override
    public List<ProyectosVo> listaProyectos() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs=null;
        ProyectosVo proyecto= null;
        List<ProyectosVo> proyectos= new ArrayList<>();
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs= stmt.executeQuery();
            while(rs.next()){
               Integer idProyecto = rs.getInt("ID_Proyecto");
               String constructora = rs.getString("Constructora");
               Integer numHabitaciones= rs.getInt("Numero_Habitaciones");
               String ciudad = rs.getString("Ciudad");
               proyecto = new ProyectosVo(idProyecto, constructora, numHabitaciones, ciudad);
               proyectos.add(proyecto);
            }
            
        }finally{
            close(rs);
            close(stmt);
            close(conn);
        }
        return proyectos;
    }
    
}
