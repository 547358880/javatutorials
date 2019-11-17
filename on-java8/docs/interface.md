## 接口

### 抽象类和接口
抽象类和接口的主要区别:

| 特性 | 接口 | 抽象类 |
| :-----: | :-----: | :-----:|
| 组合 | 可以组合多个接口 | 只能继承单一抽象类 | 
| 状态 | 不能包含属性(除了静态属性，不支持对象状态) | 可以包含属性，非抽象方法也可以引用这些属性 |
| 默认方法和抽象方法 | 不需要在子类中实现默认方法， 默认方法可以引用其他接口的方法 | 必须在子类中实现抽象方法 |
| 构造器 | 没有构造器 | 可以有构造器 |
| 可见性 | 隐式public | 可以是protected |