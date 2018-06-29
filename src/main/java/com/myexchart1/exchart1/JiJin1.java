package com.myexchart1.exchart1;

import com.sun.org.apache.bcel.internal.generic.FNEG;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

/**
 * 基金检测
 *
 * @author: @shark
 * @create: 2018-05-08-下午 16:46
 */
@Controller

public class JiJin1 {

    @RequestMapping("/jijin")
    public String hello(Model model) {
        model = huoqu(model);

        return "jijin";
    }

    private Model huoqu(Model model) {
        double a = 0,//基金波动
                k = -0.75,//买入的a的倍数的基金
                MN = 100,//仓库中当前基金价值
                RN = 0,//
                RNN = 0,
                Fn = 100;
        int n = 100;//周期次数
        ArrayList<Double> alist = new ArrayList<Double>();
        ArrayList<Double> klist = new ArrayList<Double>();
        ArrayList<Double> mnlist = new ArrayList<Double>();
        ArrayList<Double> rnlist = new ArrayList<Double>();
        ArrayList<Double> fnlist = new ArrayList<Double>();
        ArrayList<Double> rnnlist = new ArrayList<Double>();
        ArrayList<Integer> nlist = new ArrayList<Integer>();
        mnlist.add(100.0);
        fnlist.add(100.0);
//        for (k = -1; k < 0; k = k + 0.1) {
            for (n = 1; n <= 100; n++) {
                alist.add(a);
                if (n % 2 != 0) {
                    a = 0.05;
                } else {
                    a = -0.05;
                }
                nlist.add(n);
                klist.add(k);

//            fnlist.add(Fn);
                rnlist.add(RN);
                Fn = 0;
                System.out.println("mn=" + MN);
                System.out.println("rnn=" + RNN);

                fnlist.add(Fn);
                RN = Rn(MN, a, k);
                System.out.println("RRRNNN="+RNN);
                MN = mn(MN, a, k);
                mnlist.add(MN);
                for (int i = 0; i < rnlist.size(); i++) {
                    RNN += rnlist.get(i);
                    System.out.println(RNN);
                }
                rnnlist.add(RNN);
                Fn=RNN + MN;
                fnlist.add(Fn);
                RNN=0;
            }
//        }
        System.out.println("n=" + nlist);
        System.out.println("a=" + alist);
        System.out.println("mn=" + mnlist);
        System.out.println("rn=" + rnlist);
        System.out.println("rnn=" + rnnlist);
        System.out.println("fn=" + fnlist);


        model.addAttribute("rn", rnlist);
        model.addAttribute("mn", mnlist);
        model.addAttribute("a", alist);
        model.addAttribute("n", nlist);
        model.addAttribute("k", klist);
        model.addAttribute("fn", fnlist);
        return model;
    }

    /**
     * 输入Mn-1,a,k获取Mn
     */
    public static double mn(double mn01, double a, double k) {
        return mn01 + mn01 * a + mn01 * k * a;

    }

    /**
     * 輸入Mn-1,a,k獲取Rn
     */
    public static Double Rn(Double mn01, double a, double k) {
        return -k * a * mn01;
    }
}
