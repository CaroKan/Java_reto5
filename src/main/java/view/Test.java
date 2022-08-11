
package view;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import javax.swing.JFrame;

public class Test {
    public static void main(String[] args) throws SQLException {
        var reportsView = new ReportsView();
        FlowLayout flowLayout = new FlowLayout();
        reportsView.setLayout(flowLayout);
        reportsView.setMinimumSize(new Dimension(800,600));
        reportsView.setResizable(false);
        //reportsView.setLocation(100, 100);
        reportsView.setVisible(true);
        reportsView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportsView.setLocationRelativeTo(null);
    }
}
