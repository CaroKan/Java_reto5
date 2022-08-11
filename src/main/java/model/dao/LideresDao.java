
package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.vo.LideresVo;
import utilities.Conexion;
import static utilities.Conexion.close;

public class LideresDao implements ILideres {
   private static final String SQL_SELECT = "select l.ID_Lider ,l.Nombre, l.Primer_Apellido ,l.Ciudad_Residencia from Lider l order by Ciudad_Residencia"; 

    @Override
    public List<LideresVo> Listarlideres() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs=null;
        LideresVo lider= null;
        List<LideresVo> lideres= new ArrayList<>();
        
        try{
            conn = Conexion.getConnection();
            stmt= conn.prepareStatement(SQL_SELECT);
            rs= stmt.executeQuery();
            while(rs.next()){
                Integer idLider=rs.getInt("ID_Lider");
                String nombre =rs.getString("Nombre");
                String primerApellido= rs.getString("Primer_Apellido");
                String residencia= rs.getString("Ciudad_Residencia");
                lider= new LideresVo(idLider,nombre,primerApellido,residencia);
                lideres.add(lider);
            }
        
        }finally{
            close(rs);
            close(stmt);
            close(conn);
            
        }
        
        return lideres;
    }
   
   
   
}
