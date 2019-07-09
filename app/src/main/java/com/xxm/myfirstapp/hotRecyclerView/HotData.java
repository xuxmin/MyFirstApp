package com.xxm.myfirstapp.hotRecyclerView;

public class HotData {
    private int No;
    private String Title;
    private int HotValue;

    public HotData(int no, String title, int hotValue)
    {
        this.No = no;
        this.Title = title;
        this.HotValue = hotValue;
    }

    public int getNo(){ return this.No; }

    public String getTitle()
    {
        return this.Title;
    }

    public int getHotValue()
    {
        return this.HotValue;
    }

    public void setData(int no, String title, int hotValue)
    {
        this.No = no;
        this.Title = title;
        this.HotValue = hotValue;
    }

    // 向后移动一位
    public void moveBack()
    {
        this.No = this.No + 1;
    }

    public void moveForward()
    {
        if (this.No > 1){
            this.No = this.No - 1;
        }
    }
}
