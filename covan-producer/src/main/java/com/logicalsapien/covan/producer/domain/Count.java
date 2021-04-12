package com.logicalsapien.covan.producer.domain;

public class Count {

    private long daily;
    private long cumulative;

    public long getDaily() {
        return daily;
    }

    public void setDaily(long daily) {
        this.daily = daily;
    }

    public long getCumulative() {
        return cumulative;
    }

    public void setCumulative(long cumulative) {
        this.cumulative = cumulative;
    }
}