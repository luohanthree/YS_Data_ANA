package YS_DATA_ANA;

import java.sql.*;

/**
 * @author zhihuanzhihuan
 */
public class MeanANA {
    public static final String MS_SQL_DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Genshin_Impact";
    private double Mean;
    private int total;
    private int How_Many,Boss_Id;
    private int[] numbers = new int[4];
    public MeanANA() {
        this.total = 0;

    }
    public double getMean(int Id) {
        try {
            Connection conn = DriverManager.getConnection(DBURL,InsertValues.USER,InsertValues.PASSWD);
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM Level_Up_Martial_Special_Many");
            while (rs.next()) {
                rs.next();
                if(rs.getInt(2) == 2) {
                    numbers[0]++;
                } else if (rs.getInt(2) == 3) {
                    numbers[1]++;
                }
                total++;
            }
        } catch (SQLException e) {
            return -1;
        }
        Mean = (numbers[0] / (total * 1.0)) * 2 + (numbers[1] / total * (1.0)) * 3;
        return Mean;
    }

}
