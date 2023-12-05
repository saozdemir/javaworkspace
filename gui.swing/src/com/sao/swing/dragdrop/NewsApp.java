package com.sao.swing.dragdrop;

import java.util.*;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swing.dragdrop
 * @date 28.Kas.2023
 * <p>
 * @description:
 */
public class NewsApp {
    public static void main(String[] args) {
        List<News> newsList = new ArrayList<>();
        newsList.add(new News("AAA1","asdasdasd",new Date(2023, Calendar.NOVEMBER,27,0,0,0),2, true));
        newsList.add(new News("AAA2","asdasdasd",new Date(2023,Calendar.NOVEMBER,28,0,0,0),2,false));
        newsList.add(new News("AAA33","asdasdasd",new Date(2023,Calendar.NOVEMBER,28,0,0,0),1,false));
        newsList.add(new News("AAA4","asdasdasd",new Date(2023, Calendar.NOVEMBER,26,0,0,0),2,false));

//        Collections.sort(newsList);
        Collections.sort(newsList, new NewsAdvice());

        for (News news : newsList){
            System.out.println(news);
        }
    }
}
