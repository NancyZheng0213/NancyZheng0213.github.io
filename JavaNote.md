---
id: "JavaNote"
export_on_save:
  html: true
---

@import "myStyle.less"

<!-- <style>
   font-family: "Microsoft Yahei", sans-serif;
   font-family: Arial, sans-serif;
   div {
      background-color: #333333;
   }
   .definition {
      color: #6699CC;
      font-weight: bold;
   }
</style> -->

# Java学习笔记

---

## 1. Java环境介绍

1. <b class=definition>Java编程环境</b>由<b class=definition>Java语言</b>和<b class=definition>运行时</b>组成，运行时通常也被称为<b class=definition>Java虚拟机</b>（Java Virtual Machine，<b class=definition>JVM</b>）。  
2. <b class=definition>Java语言</b>是一种基于类、面向对象的可读编程语言。  
   1. Java语言由<b class=definition>Java语言规范（JLS）</b>控制，JLS规定了符合规范的实现必须遵守的标准。  
   2. Java句法部分借鉴了C和C++等语言，源码风格很类似，但在实践中由于Java的语言特性和运行时的存在，Java更像动态语言（如Smalltalk）。  
3. <b class=definition>JVM</b>为Java程序的运行提供必须的环境，其本质是一个程序。
   1. 如果某个硬件或操作系统平台缺少对应的JVM，将不能运行Java程序。  
   2. Java程序常在命令行中启动（`java <arguments> <program name>`），该命令将在操作系统的一个进程中启动JVM，提供Java运行时环境。
