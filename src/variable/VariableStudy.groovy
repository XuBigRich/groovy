package variable
//groovy中 所有的类型都是 对象类型，没有基本类型
int x=10
println x.class
double y=3.4
println y.class
/*
变量的定义 分为强类型 和弱类型
关于何时为强类型何时定义为弱类型 ：
    规则通常为
        弱类型：如果这个变量只是在本类中使用，那么推荐定义为弱类型
        强类型：如果这个变量，需要在其他类中调用，那么推荐定义为强类型（因为可以规定其他类调用时，传入的类型格式）
*/
//强类型定义   声明变量真实类型的定义方式
int i=20
println i.class
//弱类型定义   def定义方式  编译器会根据后面值的内容 推断出 前面的类类型
def d=20
println d.class
