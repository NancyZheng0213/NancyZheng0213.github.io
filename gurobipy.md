---
permalink: /GUROBInote.html
---

# GUROBI笔记

> [gurobi官网教程](https://www.gurobi.com/documentation/9.5/quickstart_windows/cs_simple_python_example.html)  
> [gurobipy：函数和类介绍](https://www.gurobi.com/documentation/9.5/refman/py_python_api_overview.html#sec:Python)

## Model类

Gurobi Python接口中的大多数操作都是通过调用Gurobi对象上的方法来执行的。最常用的对象是```Model```。  

### ```Model```构成  

+ 一组决策变量：```Var```或```MVar```类对象，每个变量都有相关的下限、上限、类型（连续、二进制等）和名称  
+ 变量的线性或二次目标函数：使用```model.setObjective```指定  
+ 变量的一组约束：```CONTR```、```MConstr```、```QConstr```或```GenConstr```类对象，每个线性或二次约束都具有关联的意义（小于或等于、大于或等于或等于）和右侧值  

> 有关变量、约束和目标的更多信息，请参阅[本节](https://www.gurobi.com/documentation/9.5/refman/variables_and_constraints_.html#sec:VarsConstraintsObjectives)。

### 构建模型的方法  

1. 构建```Model```空对象，然后调用```Model```逐步添加变量、约束等  

    ``` python {.line-numbers}
    model = gp.Model("model")
    ```

2. 从文件加载模型：[```read```函数](https://www.gurobi.com/documentation/9.5/refman/py_read.html#pythonmethod:read)

### 添加变量的方法  

1. ```Model.addVar(lb=0.0, ub=float('inf'), obj=0.0, vtype=GRB.CONTINUOUS, name="", column=None)```

   + ```lb```（可选）：新变量的下限。
   + ```ub```（可选）：新变量的上限。
   + ```obj```（可选）：新变量的目标系数。
   + ```vtype```（可选）：新变量的变量类型（GRB.CONTINUOUS、GRB.BINARY、GRB.INTEGER、GRB.semict或GRB.seminint）。
   + ```name```（可选）：新变量的名称。
        > 注意，名称将存储为ASCII字符串。强烈建议不要使用包含空格的名称，因为它们不能写入LP格式文件。
   + ```column```（可选）：column对象，指示新变量参与的约束集以及相关系数。
   + 返回值：新的```Var```对象。  
  
    ``` python {.line-numbers}
    x = model.addVar()
    y = model.addVar(vtype=GRB.INTEGER, obj=1.0, name="y")
    z = model.addVar(0.0, 1.0, 1.0, GRB.BINARY, "z")
    ```
  
2. ```Model.addVars(*indices, lb=0.0, ub=float('inf'), obj=0.0, vtype=GRB.CONTINUOUS, name="")```
   + 
3. Model.addMVar()  

``` python {.line-numbers}
# 添加一个变量
x = model.addVar(vtype=GRB.BINARY, name="x")
x = model.AddVar(0.0, 1.0, 0.0, GRB.BINARY, "x") # 下界、上界、线性目标系数

# 添加多个变量
model.addVars()
```
