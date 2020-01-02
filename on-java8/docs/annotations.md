## 注解

###标注注解
| 注解接口 | 应用场合 | 目的 |
| :---: | :---: | :---: |
| @Deprecated | 全部 | 将项标记过时的 |
| @SuppressWarnings | 除了包和注解之外的所有情况 | 阻止某个给定类型的警告信息 |
| @SafeVarargs | 方法和构造器 | 断言varargs参数可安全使用 |
| @Override | 方法 | 检查该方法是否覆盖了某一个超类方法 |
| @FunctionalInterface | 接口 | 将接口标记为只有一个抽象方法的函数式接口 |
| @PostConstruct | 方法 | 被标记的方法应该在构造之后被调用 |
| @PreDestroy | 方法 | 在类移除之后被调用|
| @Resource | 类,接口,方法，域 | 在方法或域上，为注入而标记　|
| @Resources | 类，接口 | 一个资源数组　|
| @Generated | 全部 |
| @Target | 元注解 | 指明可以应用这个注解的那些项　|
| @Retention | 注解 |　指明这个注解可以保留多久　|
| @Documented | 注解 | 指明这个注解应该包含在注解项的文档中 |
| @Inherited | 注解 | 指明当这个注解应用于一个类的时候，能够自动被它的子类继承 |
| @Repeatable | 注解 | 指明这个注解可以在同一个项上应用多次 |

注解元素的类型为下列之一:
- 基本类型(int, short, long, byte, char, double, float, boolean)
- String
- Class(具有一个可选的类型参数, 例如Class<? extends MyClass>)
- enum类型
- 注解类型
- 由前面所述类型组成的数组
```
public @interface BugReport {
    enum Status { UNCONFIRMED, CONFIRMED, FIXED, NOTABUG };
    boolean showStopper() default false;
    String assignedTo() default "[none]";
    Class<?> testCase default Void.class;
    Status status() default Status.UNCONFIRMED;
    Renderence ref() default @Reference(); // an annotation type
    String[] reportedBy()
}
```

### 元注解

- @Target元注解可以应用于一个注解，以限制该注解可以应用到哪些项上
```
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface BugReReport
```

@Target注解的元素类型

| 元素类型 | 注解适合场合 |
| :---: | :---: |
| ANNOTATION_TYPE | 注解类型声明 |
| PACKAGE | 包 |
| TYPE | 类(包括enum)以接口(包括注解类型) | 
| METHOD | 方法 |
| CONSTRUCTOR | 构造器 |
| FIELD | 成员域 |
| PARAMETER | 方法或构造器参数 |
| LOCAL_VARIABLE | 局部变量 |
| TYPE_PARAMETER | 类型参数 |
| TYPE_USER | 类型用法 |

@Retention注解的保留策略

| 保留规则 | 描述 |
| SOURCE | 不包括在类文件中的注解 |
| CLASS | 包括在类文件中的注解,但是虚拟机不需要将它们载入 |
| RUNTIME | 包括在类文件中的注解,并由虚拟机载入 |

