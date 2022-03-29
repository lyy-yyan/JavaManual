package com.lyy.base.testCopy;

public class Major implements Cloneable {

    private String majorName;
    private long majorId;

    Major() {

    }

    Major(String majorName, long majorId) {
        this.majorName = majorName;
        this.majorId = majorId;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public void setMajorId(long majorId) {
        this.majorId = majorId;
    }

    public long getMajorId() {
        return majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorName='" + majorName + '\'' +
                ", majorId=" + majorId +
                '}';
    }
}
