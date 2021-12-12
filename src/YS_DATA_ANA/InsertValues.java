package YS_DATA_ANA;

import java.sql.*;

/**
 * @author zhihuanzhihuan
 */
public class InsertValues {
    private int how_Many,boss_Id;
    public static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Genshin_Impact";
    private static final String USER = "ZHZH";
    private static final String PASSWD = "123ZHZH!";

    /**
     *
     * @param how_Many how many do the boss drop out
     * @param boss_Id the id of the boss
     */
    public void insertMartial(int how_Many,int boss_Id) {
        try {
            Connection conn = DriverManager.getConnection(DBURL,USER,PASSWD);
            PreparedStatement preStmt = conn.prepareStatement("INSERT INTO Level_Up_Martial_Special_Many (How_Many, Boss_Id) VALUES(?,?)");
            preStmt.setInt(1,how_Many);
            preStmt.setInt(2,boss_Id);
            preStmt.execute();
            preStmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("链接数据库失败!");
            e.printStackTrace();
        }
    }
}
