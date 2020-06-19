package closure
/*
    闭包进阶讲解
*
   1. 闭包关键内置变量this owner delegate

    2.闭包委托策略
*/
// 默认情况下，三个变量输出结果完全一样。
//this 在groovy中的this 与java中的this 一样
def scripClouser = {
    println "scripClouser this :" + this           //代表闭包定义处的类
    println "scripClouser owner:" + owner
    //代表闭包定义处的类 或者对象（这里说的对象通常指闭包） （也就是说闭包还可以定义在闭包中，也就是说闭包嵌套闭包，这是owner指向闭包定义处的闭包 ）
    println "scripClouser delegain:" + delegate   //delegate 指向 任意一个第三方对象 （但其有默认值，其默认值 与owner指向对象一致）
}
scripClouser.call()

//定义一个内部类
//测试的时候 注意删掉/增加一个static
class Person {
    def static staticclassClouser = {
        println "classClouser this :" + this
        println "classClouser owner:" + owner
        println "classClouser delegain:" + delegate
    }

    def static staticSay() {   //这是一个对方法的声明   因为方法不属于对象 也不属于类 那么 this 与owner依然指向Peron字节码  static 不依附与对象 依附于类
        def methodClassClouser = {
            println "methodClassClouser this :" + this
            println "methodClassClouser owner:" + owner
            println "methodClassClouser delegain:" + delegate
        }
        methodClassClouser.call()
    }
    //====================================================================================================
    //非静态
    def classClouser = {
        println "classClouser this :" + this
        println "classClouser owner:" + owner
        println "classClouser delegain:" + delegate
    }

    def say() {   //这是一个对方法的声明   因为方法不属于对象 也不属于类 那么 this 与owner依然指向Peron字节码  static 不依附与对象 依附于类
        def methodClassClouser = {
            println "methodClassClouser this :" + this
            println "methodClassClouser owner:" + owner
            println "methodClassClouser delegain:" + delegate
        }
        methodClassClouser.call()
    }

}
//======================================
//静态测试
Person.staticclassClouser.call()
Person.staticSay()
//非静态测试
Person person = new Person()
person.say()
person.classClouser.call()
//======================================
//闭包中定义闭包
def nestClouser = {
    def innerClouser = {
        println "innerClouser this :" + this   //this 指向所在类对象
        println "innerClouser owner:" + owner //owner指向 定义本包的对象或类
        println "innerClouser delegain:" + delegate  //默认同owner
    }
    innerClouser.call()
}
nestClouser.call()
//关于 delegate
def demoDelegateClouser = {
    def innerClouser = {
        println "innerClouser this :" + this   //this 指向所在类对象
        println "innerClouser owner:" + owner //owner指向 定义本包的对象或类
        println "innerClouser delegain:" + delegate  //默认同owner
    }
    innerClouser.delegate = person   //设置delegate 指向 person这个对象
    innerClouser.call()
}
demoDelegateClouser.call()


/*
 闭包委托策略,与闭包的穿参

 */
//1.闭包委托策略
class Student {
    String name
    def pertty = { "My name is ${name}" }

    String toSting() {
        pertty.call()
    }
}

class Teacher {
    String name
}

def stu = new Student(name: 'BigRich')
def tea = new Teacher(name: 'Li')
println stu.toSting()
//将stu的 pertty包 delegate属性设置为tea对象
stu.pertty.delegate = tea
//修改委托策略  因为委托策略默认是从owner  表明闭包的方法和属性默认从 owner处指向的对象寻找 属性和方法
//下面我们修改委托策略改为delegate优先 ，那么 闭包在搜索方法和属性的时候 就优先从delagate指向对象处 寻找属性和方法
stu.pertty.resolveStrategy = Closure.DELEGATE_FIRST
println stu.toSting()

//闭包穿参
class Humen {
    String sex
}

class Man extends Humen {
    def pertty = {
        Humen a, Humen b ->
            println "My sex is ${sex}"
            println "other sex is ${b.sex}"
    }
}

class WoMan extends Humen {
}

def man = new Man(sex: 'f')
def woman = new WoMan(sex: 'n')
//闭包默认操作的是默认代理，就如122行所展示的 不加参数直接操作的属性或者是方法，默认就是操作的闭包的代理 对象。
//切换下面的注释即可改变闭包的代理
//man.pertty.delegate = woman
man.pertty.resolveStrategy = Closure.DELEGATE_FIRST
//闭包的入参，一定要与闭包声明的参数个数对应
man.pertty.call(woman, man)



