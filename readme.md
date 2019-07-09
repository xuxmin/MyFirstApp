### 2019/7/9 Chapter2

#### 课程内容

- Activity 
- UI 
- RecyclerView

#### 练习

主界面有两个按钮，第1个按钮 “个人信息” 是 Chapter1 的作业内容。第2个按钮“热搜榜”是今天的作业内容。

主要实现的内容有：

- RecyclerView 热搜榜的所有**基本要求**，包括每个 Item 按格式显示 No，Title，HotValue，并且前3个item的No值标为黄色。
- **Insert 与 delete 功能**。最上方有1个 TextEdit 用于获取插入和删除的位置(从0开始)，点击插入按钮会在相应位置处插入一个 item，点击删除按钮会删除相应位置的 item。插入和删除的同时更新后面所有Item 的 No值。
- **增加分割线**。使用 itemDecoration 给前三个热搜增加了分割线

热搜榜界面如下：

<img src="http://i2.tiimg.com/693314/96b8202bd327be4c.png" width=300>

