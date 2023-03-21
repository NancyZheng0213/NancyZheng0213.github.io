---
id: "JavaNote"
export_on_save:
  html: true
html:
  toc: true
print_background: true
---

<h1>Java 学习笔记</h1>

@import "myStyle.less"

<section>
<div class=toc>

- [1. Java环境介绍](#1-java环境介绍)

</div>

<div class=main-artical>

> <b>一些基础知识：</b>  
>
> + <b class=definition>编程语言（programming language）</b>可以理解为机器和人都能识别的语言，分为<span class=definition>机器语言</span>、<span class=definition>汇编语言</span>和<span class=definition>高级语言</span>。  
> + <b class=definition>机器语言（machine language）</b>用二进制代码表示，是机器能直接识别的语言，不同型号的计算机其机器语言是不相通的，按着一种计算机的机器指令编制的程序，不能在另一种计算机上执行。  
> + <b class=definition>汇编语言（Assembly Language）</b>也称为<b class=definition>符号语言</b>，是一种用于可编程器件（如微处理器、电子计算机）的低级语言，用缩写单词来代替特定的指令，通过<span class=definition>汇编过程</span>转换成机器指令。特定的汇编语言和特定的机器语言指令集是一一对应的，不同平台之间不可直接移植。  
> + <b class=definition>高级语言（High-level programming language）</b>如 C、Java、python，具有抽象功能，是人类容易识别的语言。通过<span class=definition>编译器</span>翻译成机器语言，因此不受限于 CPU 类型（Intel 或 ARM）或指令集。  
> + <b class=definition>编译器（Compiler）</b>就是将一种语言（通常为高级语言）翻译为另一种语言（通常为低级语言）的程序。使用合适的编译器，可以把一种高级语言程序转化为供不同 CPU 使用的机器语言程序。  
> + <b class=definition>JDK（Java Development ToolKit）</b>即Java的 <span class=definition>SDK（Software Development Kit，软件开发工具包）</span>，是整个 Java 的核心，包括了 <span class=definition>JRE</span>、编译 java 源码的<span class=definition>编译器 javac</span>，还包含了很多 java 程序调试和分析的工具（如jconsole，jvisualvm 等工具软件）以及 java 程序编写所需的文档和 demo 例子程序。由 Sun 公司发明，后 Sun 在 09 年被甲骨文（Oracle）公司收购，变更为 <span class=definition>OracleJDK</span>。在被收购前，Sun 公司将 JDK 开源，出现了 <span class=definition>OpenJDK</span>。此后，每次 Oracle 公司发布新版的 JDK 时会发布两个版本：一个是加了一些自己 Oracle 公司的商业技术的 JDK (就类似在一个纯净的软件上加了一些自己的插件等) ，另一个是 OpenJDK（也就是一般没有加任何其他插件的纯净版的 JDK）。
> + <b class=definition>JRE（Java Runtime Enviroment）</b>是运行 Java 程序所必须环境的集合，包含 <span class=definition>JVM（Java Virtual Machine，Java 虚拟机）</span>标准实现及 Java 核心类库，不包含开发工具（编译器、调试器等）。

## 1. Java环境介绍

1. <b class=definition>Java编程环境</b>由<b class=definition>Java语言</b>和<b class=definition>运行时</b>组成，运行时通常也被称为<b class=definition>Java虚拟机</b>（Java Virtual Machine，<b class=definition>JVM</b>）。  
2. <b class=definition>Java语言</b>是一种基于类、面向对象的可读编程语言。  
   1. Java语言由<b class=definition>Java语言规范（JLS）</b>控制，JLS规定了符合规范的实现必须遵守的标准。  
   2. Java句法部分借鉴了C和C++等语言，源码风格很类似，但在实践中由于Java的语言特性和运行时的存在，Java更像动态语言（如Smalltalk）。  
3. <b class=definition>JVM</b>为Java程序的运行提供必须的环境，其本质是一个程序。
   1. 如果某个硬件或操作系统平台缺少对应的JVM，将不能运行Java程序。  
   2. Java程序常在命令行中启动（`java <arguments> <program name>`），该命令将在操作系统的一个进程中启动JVM，提供Java运行时环境，然后在刚启动的空的虚拟机中按用户指定的方式运行指定的程序。

</div>
</section>
