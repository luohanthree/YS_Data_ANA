package YS_DATA_ANA;


import java.util.Scanner;

/**
 * @author zhihuanzhihuan
 */
public class Main {
    public static final String msSqlDriver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static void main(String[] args) {
        try{
            Class.forName(msSqlDriver);
        } catch (Exception e) {
            System.out.println("failed");
        }
        Scanner in = new Scanner(System.in);
        int boss_Id,how_Many;
        System.out.println("请输入掉落的数量和掉落怪物的Id");
        how_Many = in.nextInt();
        boss_Id = in.nextInt();
        InsertValues insertValues = new InsertValues();
        if (boss_Id < 100) {
            System.out.println("输入的Boss_Id有误!");
        } else {
            insertValues.insertMartial(how_Many,boss_Id);
        }

    }
}
