package com.sao.swing.dragdrop;

import java.time.Instant;
import java.util.Date;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swing.dragdrop
 * @date 28.Kas.2023
 * <p>
 * @description:
 */
public class News implements Comparable<News> {
    private String title;
    private String contents;
    private Date startDate;
    private Integer priority;
    private boolean showFirst;

    public News(String title, String contents, Date startTime, Integer priority,boolean showFirst) {
        this.title = title;
        this.contents = contents;
        this.startDate = startTime;
        this.priority = priority;
        this.showFirst = showFirst;
    }

    @Override
    public int compareTo(News o) {
        //İlk tarihe göre sıralama
        int dateCompareResult = o.startDate.compareTo(this.startDate);
        if(dateCompareResult != 0)
            return o.startDate.compareTo(this.startDate);

        //Önceliğe göre sıralama
        return Integer.compare(this.priority, o.priority);
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", startTime=" + startDate +
                ", priority=" + priority +
                ", showFirst=" + showFirst +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public boolean isShowFirst() {
        return showFirst;
    }

    public void setShowFirst(boolean showFirst) {
        this.showFirst = showFirst;
    }
}
