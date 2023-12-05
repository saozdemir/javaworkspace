package com.sao.swing.dragdrop;

import java.util.Comparator;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swing.dragdrop
 * @date 28.Kas.2023
 * <p>
 * @description:
 */
public class NewsAdvice implements Comparator<News> {
    @Override
    public int compare(News news1, News news2) {
        // İlk olarak, showFirst değerine göre sırala
        if (news1.isShowFirst() && !news2.isShowFirst()) {
            return -1;
        } else if (!news1.isShowFirst() && news2.isShowFirst()) {
            return 1;
        } else if (news1.isShowFirst() && news2.isShowFirst()) {
            // showFirst true ise, tarih ve priority değerlerine göre sırala
            int tarihKarsilastirma = news2.getStartDate().compareTo(news1.getStartDate());
            if (tarihKarsilastirma != 0) {
                return tarihKarsilastirma;
            }

            return Integer.compare(news1.getPriority(), news2.getPriority());
        } else {
            // showFirst false ise, tarih ve priority değerlerine göre sırala
            int tarihKarsilastirma = news2.getStartDate().compareTo(news1.getStartDate());
            if (tarihKarsilastirma != 0) {
                return tarihKarsilastirma;
            }

            return Integer.compare(news1.getPriority(), news2.getPriority());
        }
    }
}
