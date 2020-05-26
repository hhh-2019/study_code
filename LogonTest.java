package com.itheima.api.demo03;

import java.util.Scanner;

/**
 * @PackageName: com.itheima.api.demo03
 * @ClassName: LogonTest
 * @Author: zhangle
 * @Date: 2019/11/6 10:31
 * @Description:
 * 分析步骤:
 *      1. 登陆用用户名和密码(提前是不是该存储一个正确的用户名，密码)
 *      2. 通过键盘录入用户名和密码判断登陆是否成功
 *      3. 登陆的步骤
 *              3.1 用户名和密码匹配成功，登陆成功
 *              3.2 一种是还剩余几次机会，一种是账户锁定
 */
public class LogonTest {
    public static void main(String[] args) {
        //正确的用户名和密码
        String userName = "heimaZhouRunFa";
        String passWord = "zrf123456";
        //登陆
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.println("请输入用户名");
            String uName = sc.nextLine();
            System.out.println("请输入密码");
            String pwd = sc.nextLine();
            //判断登陆是否成功
            if(uName.equals(userName) && pwd.equals(passWord)){
                System.out.println("恭喜您，登陆成功");
                break;
            }else {
                if(i == 3){
                    System.out.println("您的账户已锁定，请联系管理员");
                }else {
                    System.out.println("账户名密码错误，您还有" + (3 - i) + "次机会");
                }
            }
        }

    }
}
