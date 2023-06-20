---
id: "JavaNote"
export_on_save:
  html: true
html:
  toc: true
print_background: true
---
<!-- title: JavaNote -->
<h1>Java 学习笔记</h1>
<!-- omit from toc --> 

@import "myStyle.less"

<section>
<div class="toc">

- [1. Java环境介绍](#1-java环境介绍)
  - [1.1. Java语言](#11-java语言)
  - [1.2. JVM](#12-jvm)
  - [1.3. Java 程序的生命周期](#13-java-程序的生命周期)
- [2. Java 的基本程序结构](#2-java-的基本程序结构)
- [3. 对象与类](#3-对象与类)
- [4. 继承](#4-继承)
  - [4.1. 类、超类（superclass）、子类（subclass）](#41-类超类superclass子类subclass)
  - [4.2. Object：所有类的超类](#42-object所有类的超类)
  - [4.3. 泛型数组列表](#43-泛型数组列表)
  - [4.4. 对象包装器与自动装箱](#44-对象包装器与自动装箱)
  - [4.5. 参数个数可变的方法](#45-参数个数可变的方法)
  - [4.6. 抽象类](#46-抽象类)
  - [4.7. 枚举类](#47-枚举类)

</div>

<div class="main-artical">

<div class="foreword">

> <b>一些基础知识：</b>  
>
> + <b class=definition>编程语言（programming language）</b>可以理解为机器和人都能识别的语言，分为<span class=definition>机器语言</span>、<span class=definition>汇编语言</span>和<span class=definition>高级语言</span>。  
> + <b class=definition>机器语言（machine language）</b>用二进制代码表示，是机器能直接识别的语言，不同型号的计算机其机器语言是不相通的，按着一种计算机的机器指令编制的程序，不能在另一种计算机上执行。  
> + <b class=definition>汇编语言（Assembly Language）</b>也称为<b class=definition>符号语言</b>，是一种用于可编程器件（如微处理器、电子计算机）的低级语言，用缩写单词来代替特定的指令，通过<span class=definition>汇编过程</span>转换成机器指令。特定的汇编语言和特定的机器语言指令集是一一对应的，不同平台之间不可直接移植。  
> + <b class=definition>高级语言（High-level programming language）</b>如 C、Java、python，具有抽象功能，是人类容易识别的语言。通过<span class=definition>编译器</span>翻译成机器语言，因此不受限于 CPU 类型（Intel 或 ARM）或指令集。  
> + <b class=definition>编译器（Compiler）</b>就是将一种语言（通常为高级语言）翻译为另一种语言（通常为低级语言）的程序。使用合适的编译器，可以把一种高级语言程序转化为供不同 CPU 使用的机器语言程序。  
> + <b class=definition>JDK（Java Development ToolKit）</b>即Java的 <span class=definition>SDK（Software Development Kit，软件开发工具包）</span>，是整个 Java 的核心，包括了 <span class=definition>JRE</span>、编译 java 源码的<span class=definition>编译器 javac</span>，还包含了很多 java 程序调试和分析的工具（如jconsole，jvisualvm 等工具软件）以及 java 程序编写所需的文档和 demo 例子程序。由 Sun 公司发明，后 Sun 在 09 年被甲骨文（Oracle）公司收购，变更为 <span class=definition>OracleJDK</span>。在被收购前，Sun 公司将 JDK 开源，出现了 <span class=definition>OpenJDK</span>。此后，每次 Oracle 公司发布新版的 JDK 时会发布两个版本：一个是加了一些自己 Oracle 公司的商业技术的 JDK (就类似在一个纯净的软件上加了一些自己的插件等) ，另一个是 OpenJDK（也就是一般没有加任何其他插件的纯净版的 JDK）。
> + <b class=definition>JRE（Java Runtime Enviroment）</b>是运行 Java 程序所必须环境的集合，包含 <span class=definition>JVM（Java Virtual Machine，Java 虚拟机）</span>标准实现及 Java 核心类库，不包含开发工具（编译器、调试器等）。

</div>

## 1. Java环境介绍

<p><b class=definition>Java编程环境</b>由<b class=definition>Java语言</b>和<b class=definition>运行时</b>组成，运行时通常也被称为<b class=definition>Java虚拟机</b>（Java Virtual Machine，<b class=definition>JVM</b>）。</p>

### 1.1. Java语言

<b class=definition>Java语言</b>是一种基于类、面向对象的可读编程语言。  

   + Java语言由<b class=definition>Java语言规范（JLS）</b>控制，JLS规定了符合规范的实现必须遵守的标准。  
   + Java句法部分借鉴了C和C++等语言，源码风格很类似，但在实践中由于Java的语言特性和运行时的存在，Java更像动态语言（如Smalltalk）。  

### 1.2. JVM  

<b class=definition>JVM</b>为Java程序的运行提供必须的环境，其本质是一个程序。  

   + 如果某个硬件或操作系统平台缺少对应的JVM，将不能运行Java程序。  
   + Java程序常在命令行中启动（`java <arguments> <program name>`），该命令将在操作系统的一个进程中启动JVM，提供Java运行时环境，然后在刚启动的空的虚拟机中按用户指定的方式运行指定的程序。
   + JVM 包含以下优点：
     1. 提供一个容器，让应用程序代码在其中运行；
     2. 与 C/C++ 相比，提供了一个安全、可靠的执行环境；
     3. 为开发者管理内存
     4. 提供一个跨平台的执行环境，<q>一次编译，到处运行</q><span class='tip'>[ link](https://zhuanlan.zhihu.com/p/364545050)</span>。
     5. 收集运行时信息，监控和优化其托管的应用程序。

> JVM 还提供一个运行时编译器，执行 <span class=definition>JIT 编译（just-in-time compilation）</span>：当JVM发现某个方法或代码块运行特别频繁的时候，就会认为这是<span class=definition>“热点代码”（Hot Spot Code)</span>。然后JIT会跳过 JVM 解释器，直接将这部分编译成本地机器相关的机器码。

### 1.3. Java 程序的生命周期  

Java 源码 --(javac)--> 类文件 --(类加载)--> 新类型 --(JVM解释器)--> 运行

Java 9 引入了 JShell，提供<b span class="definition">“读取 - 评估 - 打印循环”（Read-Evaluate-Print Loop, REPL）</b>。可以通过终端窗口（cmd、powershell 或 Git）键入 `JShell` 来启动。其 Tab 补全功能可以方便地完成小片段代码的输入和运行。  

## 2. Java 的基本程序结构  

``` java class="line-numbers"
public class FirstSimple() {
  public static void main(String[] args) {
    System.out.println("This is a simple.");
  }
}
```

`public` 称为<b class="definition">访问修饰符（access modifier）</b>，关键字`class` 是<b class="definition">类</b>，是所有 Java 应用的构建模块。

## 3. 对象与类

## 4. 继承  

``` java class="line-numbers"
// 超类 Employee
public class Employee {
  private String name;
  private double salary;
  private LocalDate hireDay;

  public Employee(String name, double salary, int year, int month, int day) {
    this.name = name;
    this.salary = salary;
    hireDay = LocalDate.of(year, month, day);
  }

  public void raiseSalary(double byPercent) {
    double raise = salary * byPercent / 100;
    salary += raise;
  }

  // GET-methods
}
```

``` java class="line-numbers"
// 子类
public class Manager extends Employee {
  // 增加字段
  private double bonus;

  // 子类构造器
  public Manager(String name, double salary, int year, int month, int day) {
    super(name, salary, year, month, day);
    bonus = 0;
  }

  // 增加方法
  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

  // 覆盖超类
  public double getSalary() {
    double baseSalary = super.getSalary();
    return baseSalary + bonus;
  }
  // other GET-methods
}
```

### 4.1. 类、超类（superclass）、子类（subclass）

#### 4.1.1. 子类构造

使用关键字 `extends` 表示继承。已存在的类 `Employee` 称为<b class="definition">超类（superclass）</b>、<b class="definition">基类（base class）</b>、<b class="definition">父类（parent class）</b>；新类 `Mnager` 称为<b class="definition">子类（subclass/child class）</b>或<b class="definition">派生类（derived class）</b>。  

这个例子中，超类 `Employee` 本身具有三个字段：`name`、`salary`、`hireDay`，这些字段也会被子类 `Manager` 继承。此外，`Manager` 还具有 `Employee` 没有的字段，即 `bonus`。

#### 4.1.2. 覆盖（override）

使用关键字 `super` 调用超类中的方法，从而<b class="definition">覆盖（override）</b>超类中的方法，形成新方法。

#### 4.1.3. 子类构造器

子类无法访问超类中的私有字段，因此初始化子类的时候，通过关键字 `super()` 来<span>调用超类 `Employee` 中带有 `name`、`salary`、`year`、`month`、`day` 参数的构造器</span>。

> + `super`调用构造器的语句必须是子类构造器的第一条语句
> + 如果子类没有显式调用超类的构造器，那么超类必须有一个无参数构造器。这个构造器要在子类构造之前调用。

#### 4.1.4. 阻止继承  

使用修饰符 `final` 表示不允许被扩展。被修饰的类无法派生子类，被修饰的方法无法被任何子类覆盖。当一个类声明为 `final` 时，只有其方法自动成为 `final`，而字段不会。

#### 4.1.5. 强制类型转换

只能在继承层次内进行强制类型转换。将超类转换成子类之前，要使用 `instanceof` 进行检查。

``` java class="line-numbers"
if (staff[i] instanceof Manager) {
  boss = (Manager) staff[i];
  boss.setBonus(5000);
}

// java 16
if (staff[i] instanceof Manager boss) {
  boss.setBonus(5000);
}
```

此处的 `staff[i]` 是初始定义为 `Employee[3]`、混合有 `Employee` 和 `Manager` 的数组。

#### 4.1.6. 受保护访问（protected）  

使用修饰符 `protected` 声明的方法或字段可以被子类访问。但仅限于同一个包中的子类。

> + 一般使用时，为了避免后续修改带来的问题，不提倡使用受保护字段。相反的，受保护方法更有意义。

### 4.2. Object：所有类的超类

`Object` 类是所有类的超类。在 Java 中，只有<span class='definition'>基本类型（primitive type）</span>不是对象，如数值、字符和布尔类型。

> + 所有数组类型都扩展了 Object 类的类类型。

#### 4.2.1. equals 方法

`a.equal(b)` 用于检验对象 `a` 是否等于另一个对象 `b`。

> + 当 `a` 或 `b` 可能为 `null` 时，需要用 `Object.equals(a,b)`，如果两个参数都为 `null`，会返回 `true`。
> + 在子类中调用 `equals()` 时，首先调用超类的 `super.equals()`，如果返回 `false` 那么对象就必定不相等。
> + 记录作为一种不可变类，会自动定义一个比较字段的 `equals()` 方法，当两个记录实例中相应字段相等时，这两个记录就想等。

``` Java class="line-numbers"
// 一种合理避开坑的 equals 方法
public class Employee {
  ...
  public boolean equals(Object otherObject) {     // 将显示参数命名为 otherObject
    if (this == otherObject) return true;       // 检测 this 与 otherObject 是否引用同一个对象
    if (otherObject == null) return false;      // 检测 otherObject 是否为 null
    // 比较 this 与 otherObject 的类

    // 如果 equals 的语义在每个子类中有所改变，就用 getClass 检测
    if (getClass() != otherObject.getClass())
        return false;
    // 如果所有的子类都拥有统一的语义，就是用 instanceof 检测
    if (!(otherObject instanceof ClassName)) return false;

    ClassName other = (ClassName) otherObject;  // 将 otherObject 转换为相应的类类型变量

    // 到这一步，需要比较所有字段，使用 == 比较基本类型字段，使用 equals 比较对象字段
    return field1 == other.field1 && Objects.equals(field2, other.field2);
  }
}
```

#### 4.2.2. hashCode 方法

<b class='definition'>散列码（hash code）</b>是有对象导出的一个整型值（可能是负数）。两个不同对象的散列码基本不相同。  

`hashCode` 方法定义在 `Object` 类中，因此对每个对象都有一个默认的散列码，其值由对象的存储地址得出。

> + 字符串的散列码是由内容导出的，因此引用同样的字符串的不同对象具有相同散列码。  

对于重新定义 `equals()` 的类，必须为可能插入的对象重新定义 `hashCode()` 方法。定义的时候要尽可能使得不同对象的散列码尽量分散开。且 `hashCode` 必须与 `equals` 相容，当 `x.equals(y)` 返回 `true` 时，`x.hashCode()` 必须等于 `y.hashCode()`。也就是说，`hashCOde()` 计算散列值的参数必须与 `equals()` 对比的参数一致。

``` Java class="line-numbers"
// 组合多个散列值时，可以调用 `Objects.hash()` 并提供所有这些值作为输入参数。
// 这个方法会为所有参数调用 `Objects.hashCode()` 并组合这些散列值。
public int hashCode() {
    return Objects.hash(name, salary, hireDay);
}

// 上述方法等同于
public int hashCode() {
  return 7*Objects.hashCode(neme)   // 7、11、13可替换成其他
    + 11*Objects.hashCode(salary)
    + 13*Objects.hashCode(hireDay);
}
```

#### 4.2.3. toString 方法

`toString()` 会返回一个字符串，表示对象的值，格式类似于：类名[字段值]，如 `java.Employee[name=...,salary=...]`。设计子类时，应该定义子类的 `toString()` 方法，并加入子类字段。如果超类使用了 `getClass().getName()` 那么子类调用 `super.toString()` 即可。

> + 调用 `print()` 和使用 `"" +` 连接对象时，本质上都是调用 `toString()` 方法。
> + 数组继承了 `Object` 类的 `toString` 方法，因此调用时避免使用 `"" + 数组` 的形式，而应该采用 `Arrays.toString(数组)`。多维数组则采用 `Arrays.deepToString()`。

``` Java class="line-numbers"
// 超类
public class Employee {
  ...
  public String toString() {
    return getClass().getName() + "[name=]" + name
      + ",salary=" + salary + ",hireDay=" + hireDay + "]";
  }
}

// 子类
public class Manager extends Employee {
  ...
  public String toString() {
    return super.toString() + "[bonus=" + bonus + "]";
  }
}
```

### 4.3. 泛型数组列表

`ArrayList` 就是一种有<b class='definition'>类型参数（type parameter）</b>的<b class='definition'>泛型类（generic class）</b>，称为<b class='definition'>数组列表</b>。它管理着一个内部的对象引用数组，当数组空间用尽时能自动创建更大的数组，并将所有对象拷贝到新数组中。

<span class='tip'></span>如果已经知道列表所需的容量（假设是100），可以在使用 `add()` 填充列表之前调用 `ensureCapacity(100)`，这样在前 100 次 `add()` 调用时不会带来很大的开销。

``` Java class='line-numbers'
// 菱形语法，直接分配100个容量
ArrayList<Employee> staff = new ArrayList<>(100);
// Java 10
var staff = new ArrayList<Employee>();
staff.ensureCapacity(100);
```

一旦能够确定数组列表的大小不再改变，就可以使用 `trimToSize()` 固定内存块的空间并释放多余的存储空间。但固定后如果再次添加新元素就需要再次移动内存块，会造成大量的时间消耗。

> + 插入 `add` 和删除 `remove` 效率很低，当数组规模较大且插入和删除操作频繁发生时，应该考虑使用链表而不是数组列表。

### 4.4. 对象包装器与自动装箱

<b class='definition'>包装器（wrapper）</b>指基本类型（`int`、`float` 等）对应的类（`Int`、`Float` 等）。<b class='definition'>自动装箱（autoboxing）</b>指调用 `ArrayList<Integer>.add(3)` 时将自动换成 `ArrayList<Integer>.add(Integer.ValueOf(3))`。<b class='definition'>自动拆箱（u你boxed）</b>则与之相反。

> + 装箱和拆箱是编译器的工作，而非虚拟机。

``` Java class='line-numbers'
// 将 Integer 转为 int
int intVallue()
// 将 int 类型的数字转化为十（radix）进制的 String
static String Integer.toString(int i)
static String Integer.toString(int i, int radix)
// 将 String 类型的数字转化为一个十（radix）进制的 int
static int Integer.parseInt(String s)
static int Integer.parseInt(String s, int radix)
// 将 String 类型的数字转化为十（radix）进制的 Integer
static Integer Integer.valueOf(String s)
static Integer Integer.valueOf(String s, int radix)
// 将 String 类型的数字转化为 Number
Number parse(String s)
```

### 4.5. 参数个数可变的方法

<b class='definition'>变参（varargs）</b>可以提供参数个数可变的方法，如 `print()` 方法。用 `...` 表示接受任意数量的对象作为输入。

``` Java class='line-numbers'
// 最大值方法
public double max(double... values) {
  double largest = Double.NEGATIVE_INFINITY;  // 负无穷大
  for (double v : values) if (v > largest) largest = v;
  return largest;
}
// 调用方法
double d = max(3.1, 2.2222, -3);
```

### 4.6. 抽象类

使用关键字 `abstract` 声明抽象类，抽象类可以包含一个或多个抽象方法、抽象字段，也可以不包含。包含抽象方法的类本身必须声明为抽象类。抽象类不能实例化，但可以创建其<b class='definition'>对象变量（object variable）</b>，这样的变量只能引用非抽象子类的对象

``` Java class='line-numbers'
public abstract class Person {
  ...
  public abstract String getDescription();
}
new Person("ABC");              // wrong
Person P = new Student("ABC");  // right
```

抽象方法相当于占位符，在子类中可以将其明确定义，也可以继续保留为未定义的抽象方法。

### 4.7. 枚举类

<b class='definition'>枚举类（enumerated type）</b>只包含固定的、有限的一组值。枚举类型的变量只能存储这种枚举类的某个值或 `null`。

``` Java class='line-numbers'
// 自定义枚举类
enum Size {SMALL, MEDIUM, LARGE};
// 自定义包含构造器和字段的枚举类
enum Size {
  SMALL("S"), MEDIUM("M"), LARGE("L");

  private String abbreviation;

  Size(String abb) {this.abbreviation = abb;}
  public String gerAbbreviation() {return this.abbreviation;}
}
// 声明枚举变量
Size s = Size.LARGE;
```

枚举类的构造器都是稀有的，可以省略 `private`，所有枚举类都是 `Enum` 的子类，继承了 `toString()`、 `values()` 和 `ordinal()` 等方法。

``` Java class='line-numbers'
// 返回给定的类 enumclass 中含有指定名字 name 的枚举常量，可以用于读取屏幕输入的值并转化为枚举变量。
static Enum Enum.valueOf(Class enumClass, String name)
// 返回枚举常量名
String toString()
// 返回枚举常量在 enum 中的位置，从 0 开始计数
int ordinal()
// 返回包含全部枚举值的数组
enumClass[] values()
// 比较前后顺序。如果 this 出现在 other 前面，返回负整数；如果在后面返回正整数；否则 0
int compareTo(E other)
```

### 密封类



</div>
</section>
