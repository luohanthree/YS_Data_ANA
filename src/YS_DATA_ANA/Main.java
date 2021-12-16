package YS_DATA_ANA;


import java.util.Scanner;

/**
 * @author zhihuanzhihuan
 */
public class Main {
    public static final int MAX_BOSS_ID = 1000;
    public static final int MIN_BOSS_ID = 100;
    public static final String MS_SQL_DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static void main(String[] args) {
        int bossId,howMany;
        int identifyNum;
        try{
            Class.forName(MS_SQL_DRIVER);
        } catch (Exception e) {
            System.out.println("failed");
        }
        Scanner in = new Scanner(System.in);
        System.out.println("请输入掉落的数量和掉落材料的Id");
        howMany = in.nextInt();
        bossId = in.nextInt();
        InsertValues insertValues = new InsertValues();
        if (bossId > MAX_BOSS_ID || bossId < MIN_BOSS_ID) {
            System.out.println("输入的Boss_Id有误!");
        } else {
            insertValues.insertMartial(howMany,bossId);
        }
        MeanANA mean = new MeanANA();
        System.out.println(mean.getMean(201));
    }
}
