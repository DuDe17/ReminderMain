package com.example.dude.remindermain;

/**
 * Created by ashukla on 12/29/2017.
 */

public class AddLogicUnit {

    private String taskName;
    private int resetFrequency;
    private String time;
    private String totalTime;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getResetFrequency() {
        return resetFrequency;
    }

    public void setResetFrequency(int resetFrequency) {
        if(resetFrequency > 0 && resetFrequency < 3)
            this.resetFrequency = resetFrequency;
        else
            this.resetFrequency = 0;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public AddLogicUnit()
    {
        this.taskName = null;
        this.resetFrequency = 0;
        this.time = null;
        this.totalTime = null;
    }
}
