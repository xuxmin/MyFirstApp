package com.xxm.myfirstapp;

import java.util.ArrayList;
import java.util.List;

public class HotDataFactory {
    public static final String[] TITLES = {"敬礼我的超级英雄", "我们不一Young", "珍\"eye\"每一天", "请平安出行","现在是怀旧时间","纸短情长","田馥甄","我们一起学猫叫","轻轻牵着你的耳朵", "a", "b", "c", "d", "e", "f", "g"};
    public static final int [] HOTVALUES={548583, 504189, 486636, 301982, 299192, 291049, 289759, 279973, 111111, 10, 9, 8, 7, 6, 5, 4};

    public static final int DEFAULT_SIZE = 16;

    public static HotData getSingleData(int i, String title, int hotValue)
    {
        return new HotData(i, title, hotValue);
    }

    public static List<HotData> getHotData()
    {
        return getHotData(DEFAULT_SIZE);
    }

    public static List<HotData> getHotData(int size)
    {
        if (size > DEFAULT_SIZE)
        {
            size = DEFAULT_SIZE;
        }
        List<HotData>  list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            HotData hotData = new HotData(i+1 , TITLES[i], HOTVALUES[i]);
            list.add(hotData);
        }
        return list;
    }
}
