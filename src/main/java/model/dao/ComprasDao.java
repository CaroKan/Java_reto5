
package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.vo.ComprasVo;
import utilities.Conexion;
import static utilities.Conexion.close;

public class ComprasDao implements ICompras{
     private static final String SQL_SELECT = "select c.ID_Compra, p.Constructora, p.Banco_Vinculado  from Compra c join Proyecto p ON c.ID_Proyecto = p.ID_Proyecto  where c.Proveedor ='Homecenter' AND p.Ciudad ='Salento'";
            
    @Override
    public List<ComprasVo> listadoCompras() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt=null;
        ResultSet rs = null;
        ComprasVo compra=null;
        List<ComprasVo> listaCompras=new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                Integer idCompra = rs.getInt("ID_Compra");
                String constructora = rs.getString("Constructora");
                String banco = rs.getString("Banco_Vinculado");
                compra = new ComprasVo(idCompra,constructora,banco);
                listaCompras.add(compra);
            }
        }finally{
            close(rs);
            close(stmt);
            close(conn);
        }
        
        return listaCompras;
    }
    
}
