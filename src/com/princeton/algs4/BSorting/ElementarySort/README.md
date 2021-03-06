# Elementary Sort Algorithms

### 代码的编写需要注意以下

- 验证
- 运行时间
- 算法性能（排序：比较和交换的数量，不交换元素的算法：访问数组的次数）
- 额外的内存使用（原地排序 vs 额外空间）
- 数据类型（compareTo：主键抽象）

### 基本的 10 大排序算法如下:

|             | 命题                 | 特点                                                         |      |
| ----------- | -------------------- | ------------------------------------------------------------ | ---- |
| 1. 冒泡排序 | A                    | 1/运行时间和输入无关，<br/>2/数据移动是最少的                |      |
| 2. 选择排序 | B                    | 对于实际应用中常见的某些类型的非随机数组很有效，<br/>很适合小规模数组<br/>更一般的情况是部分有序的数组，选择排序则不然<br/>改进：2.1.25： 大幅提高插入排序的速度，只需要在内循环中将较大的元素都向右移动而不总是交换两个元素（访问数组的次数就能减半）<br/>练习 2.1.17 ：轨迹变成动画 |      |
| 3. 插入排序 | C                    |                                                              |      |
| 4. 希尔排序 | E                    | 高效的原因是权衡了子数组的规模和有序性<br/>比插入和选择要快，数组越大，优势越大<br/>有经验的程序员会选择希尔排序，所以对于中等大小的数组，运行时间是可以接受的，代码量很小，还不需要额外的空间 |      |
| 5. 归并排序 | 原地归并             | 最好的特点：能够保证将任意长度为 N 的数组排序所需时间和 NlogN 成正比<br/>主要缺点：所需的额外空间和 N 成正比 |      |
|             | 自顶向下归并 F G     |                                                              |      |
|             | 自底向上归并 H       |                                                              |      |
|             | 排序算法的复杂度 I J |                                                              |      |
| 6. 快速排序 |                      |                                                              |      |
| 7. 堆排序   |                      |                                                              |      |
|             |                      |                                                              |      |
|             |                      |                                                              |      |
|             |                      |                                                              |      |
|             |                      |                                                              |      |
