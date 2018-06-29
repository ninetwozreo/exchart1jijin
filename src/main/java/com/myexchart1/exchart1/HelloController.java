package com.myexchart1.exchart1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * 测试控制器
 *
 * @author: @shark
 * @create: 2018-05-08-下午 16:46
 */
@Controller

public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model = huoqu(model);

        return "hello";
    }

    private Model huoqu(Model model) {
        double a,
                k = -1,
                MN = 100,
                RN = 0,
                RNN = 0,
                Fn = 100;
        int n = 100;
        ArrayList<Double> alist = new ArrayList<Double>();
        ArrayList<Double> klist = new ArrayList<Double>();
        ArrayList<Double> mnlist = new ArrayList<Double>();
        ArrayList<Double> rnlist = new ArrayList<Double>();
        ArrayList<Double> fnlist = new ArrayList<Double>();
        ArrayList<Double> rnnlist = new ArrayList<Double>();
        ArrayList<Integer> nlist = new ArrayList<Integer>();
        for (k = -10000000; k < 0; k = k + 10) {
            klist.add(k);
            Fn = MN + RNN;
            fnlist.add(Fn);
            /*獲取MN*/
            for (int i = 0; i < n; i++) {
                nlist.add(i);
//                fnlist.add(Fn);
                mnlist.add(MN);
            if (i % 2 != 0) {

                a = 0.05;
            } else {
                a = -0.05;
            }
//                a = Math.random() * 0.1 - 0.05;
                alist.add(a);
                RN = Rn(MN, a, k);
                rnlist.add(RN);
                MN = mn(MN, a, k);
//                for (Double rn : rnlist) {
//                    RNN = RNN + rn;
//                }
//                Fn = MN + RNN;

            }
            for (Double rn : rnlist) {
                RNN = RNN + rn;
            }
//        Fn = MN + RNN;
//            fnlist.add(Fn);

        }
//            System.out.println(klist);
//            System.out.println(fnlist);
        model.addAttribute("rn", rnlist);
        model.addAttribute("mn", mnlist);
        model.addAttribute("a", alist);
        model.addAttribute("n", nlist);
        model.addAttribute("k", klist);
//        model.addAttribute("fn", fnlist);
        return model;
    }

    /*
     * 输入Mn-1,a,k获取Mn
     * */
    public static double mn(double mn01, double a, double k) {
        return mn01 + mn01 * a + mn01 * k * a;

    }

    /* 輸入Mn-1,a,k獲取Rn */
    public static Double Rn(Double mn01, double a, double k) {
        return k * a * mn01;
    }
}
