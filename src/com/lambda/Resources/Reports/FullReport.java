package com.lambda.Resources.Reports;

import java.text.DecimalFormat;

public class FullReport extends Report{

    public FullReport(){
        this.total = 0;
        this.time = 0;
    }

    public void update(double total, int time){
        this.total += total;
        this.time += time;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        return "[Total Sold: $" + df.format(this.total) + "][Time Elapsed: " + this.time + "s]";
    }
}
