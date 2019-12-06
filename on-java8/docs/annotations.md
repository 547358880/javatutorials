## 注解

### 元注解
| 注解 | 解释 |
| :---: | --- |
| @Target | 表示注解可以用于哪里地方， 可能的ElementType参数包括:<br/> **CONSTRUCTOR**: 构造器的声明 <br/> **FIELD**: 字段声明(包括enum实例)<br/>**LOCAL_VARIABLE**: 局部变量声明 <br/> **METHOD**: 方法声明<br/>**PACKAGE**: 包声明<br>**PARAMETER**:参数声明<br/>**TYPE**:类、接口(包括注解类型)或者enum声明 |
| @Retention | 表示注解信息保存的时长, 可选的RetentionPolicy参数包括:<br/> **SOURCE**: 注解将被编译器丢弃<br/>**CLASS**:注解在class文件中可用，但是会被VM丢弃<br/>**RUNTIME**:VM将在运行期也保留注解，因此可以通过反射机制读取注解的信息 |
| @Documented | 将此注解保存在Javadoc中 |
| @Interited | 允许子类继承父类的注解 |
| @Repeatable | 允许一个注解可以被使用一次或者多次 |


