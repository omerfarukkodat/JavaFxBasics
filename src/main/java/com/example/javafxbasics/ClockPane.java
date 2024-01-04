package com.example.javafxbasics;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;

    /**
     * Construct a default clock with the current time
     */
    public ClockPane() {
        setCurrentTime();
    }

    /**
     * Construct a clock with specified hour, minute, and second
     */

    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }


    /* Set the current time for the clock */

    public void setCurrentTime() {
        // Construct a calendar for the current date and time
        Calendar calendar = new GregorianCalendar();
        // Set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        paintClock();
    }


    /** Paint the clock */

    private void paintClock(){
        // Initialize clock parameters
        double clockRadius = Math.min(getHeight(),getWidth())*0.8 * 0.5;
        double centerX = getWidth()/2;
        double centerY = getHeight()/2;



    // Draw circle

    Circle circle = new Circle(centerX , centerY , clockRadius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    Text text1 = new Text(centerX-5,centerY-clockRadius + 12 , "12");
    Text text2 = new Text(centerX-clockRadius,centerY+5,"9");
    Text text3 = new Text(centerX+clockRadius-10,centerY + 3,"3");
    Text text4 = new Text(centerX-3,centerY+centerX-3,"6");

        // Draw second hand

        double sLength = clockRadius * 0.8;
        double secondX = centerX +sLength * Math.sin(second * (2 * Math.PI/60));
        double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX,centerY,secondX,secondY);
        sLine.setStroke(Color.RED);
        // Draw minute hand

        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength * Math.sin(minute * ( 2 * Math.PI/60));
        double minuteY = centerY - mLength * Math.cos(minute * ( 2 * Math.PI/60));
        Line mLine = new Line(centerX,centerY,xMinute,minuteY);

        double hLength = clockRadius * 0.50;
        double hourX = centerX + hLength * Math.sin((hour % 12 + minute /60) * (2 * Math.PI / 12));
        double hourY = centerY - hLength * Math.cos((hour % 12 +minute / 60) * (2 * Math.PI/12));
        Line hLine = new Line(centerX , centerY , hourX , hourY);
        hLine.setStroke(Color.GREEN);

        getChildren().addAll(circle,text1,text2,text3,text4,sLine,mLine,hLine);


    }

    @Override
    protected void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }

    @Override
    protected void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }
}
