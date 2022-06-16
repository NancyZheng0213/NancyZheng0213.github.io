---
author: Nancy
output:
    pdf_document:
        toc: true
papersize: A4
documentclass: article
fontsize: 11
export_on_save:
  prince: true

---

<!-- markdownlint-disable-file MD033 -->

# git介绍

- [git介绍](#git介绍)
  - [1. 什么是git](#1-什么是git)
    - [1.1 git的组成结构](#11-git的组成结构)

---

## 1. 什么是git

<p style="text-indent:2em"> git是一个开源的<b>分布式</b>版本控制系统<sup>[1]</sup>，用于项目开发的过程版本控制，可以回溯历史版本。 </p>

### 1.1 git的组成结构

<p style="text-indent:2em"> git的结构如图，分为<b>工作区</b>、<b>暂存区</b>（stage或index，索引）和<b>版本库</b>（repository，仓库）。</p>

- <b>工作区</b>：即个人电脑上的文件夹目录
- <b>暂存区</b>：追踪（<code>git add</code>）工作区的文件后，

> 参考资料：  
> [1] [Git教程 | 菜鸟教程](https://www.runoob.com/git/git-tutorial.html)

