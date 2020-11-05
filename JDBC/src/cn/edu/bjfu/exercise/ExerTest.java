package cn.edu.bjfu.exercise;

import cn.edu.bjfu.preparedstatement.PreparedStatementTest;

import java.util.Scanner;

/**
 * @author Chao Huaiyu
 * @date 2020/11/5
 */
public class ExerTest {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("四级/六级:");
        int type = scanner.nextInt();
        System.out.print("身份证号:");
        String IDCard = scanner.next();
        System.out.print("准考证号:");
        String examCard = scanner.next();
        System.out.print("学生姓名:");
        String studentName = scanner.next();
        System.out.print("所在城市:");
        String location = scanner.next();
        System.out.print("考试成绩:");
        int grade = scanner.nextInt();

        String sql = "insert into " +
                "examstudent(type,IDCard,ExamCard,studentName,location,Grade)" +
                "values(?,?,?,?,?,?)";
        PreparedStatementTest pst = new PreparedStatementTest();
        int update = pst.update(sql, type, IDCard, examCard, studentName, location, grade);
        if(update>0){
            System.out.println("success");
        }else{
            System.out.println("error");
        }
    }
}
