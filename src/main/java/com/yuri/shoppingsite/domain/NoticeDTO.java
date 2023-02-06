package com.yuri.shoppingsite.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class NoticeDTO {

    private int noticeId;
    private String noticeTitle;
    private String noticeContent;
    private String noticeWriter;
//    @DateTimeFormat(pattern = "yyyy-MM-DD")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-DD", timezone = "Asia/Seoul")
    private LocalDate noticeRegDate;
    private int noticeView;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeWriter() {
        return noticeWriter;
    }

    public void setNoticeWriter(String noticeWriter) {
        this.noticeWriter = noticeWriter;
    }

    public LocalDate getNoticeRegDate() {
        return noticeRegDate;
    }

    public void setNoticeRegDate(LocalDate noticeRegDate) {
        this.noticeRegDate = noticeRegDate;
    }

    public int getNoticeView() {
        return noticeView;
    }

    public void setNoticeView(int noticeView) {
        this.noticeView = noticeView;
    }
    @Override
    public String toString() {
        return "NoticeDTO{" +
                "noticeId=" + noticeId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeWriter='" + noticeWriter + '\'' +
                ", noticeRegDate=" + noticeRegDate +
                ", noticeView=" + noticeView +
                '}';
    }
}
