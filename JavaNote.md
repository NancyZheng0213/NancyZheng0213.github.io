# Java学习笔记

---

## 1. Java环境介绍

1. <font color=#6699CC>Java编程环境</font>由<font color=#6699CC>**Java语言**</font>和<font color=#6699CC>**运行时**</font>组成，运行时通常也被称为<font color=#6699CC>**Java虚拟机**</font>（Java Virtual Machine，<font color=#6699CC>**JVM**</font>）。  
2. <font color=#6699CC>**Java语言**</font>是一种基于类、面向对象的可读编程语言。  
   1. Java语言由<font color=#6699CC>**Java语言规范（JLS）**</font>控制，JLS规定了符合规范的实现必须遵守的标准。  
   2. Java句法部分借鉴了C和C++等语言，源码风格很类似，但在实践中由于Java的语言特性和运行时的存在，Java更像动态语言（如Smalltalk）。  
3. <font color=#6699CC>**JVM**</font>为Java程序的运行提供必须的环境，其本质是一个程序。
   1. 如果某个硬件或操作系统平台缺少对应的JVM，将不能运行Java程序。  
   2. Java程序常在命令行中启动（```java <arguments> <program name>```），该命令将在操作系统的一个进程中启动JVM，提供Java运行时环境。
