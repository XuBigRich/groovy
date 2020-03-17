package objectorention
def person=new Person(name:"BigRich",age:23)
//这里区别一下.运算符 在java中调用.运算符是直接操作 对象属性，但是在groovy中使用.运算符是调用属性的get方法
//如person.age=person.getAge()  也就是说无论你是直接.运算符调用，还是使用get/set方法最终都是调用get/set
println "the name is ${person.name},the age is ${person.age}"
//对方法的调用 与 java一致
person.increaseAge(10)

def man=new Man()
man.eat()
man.play()

// 若类中没有某个方法 ，但是我们在类中重写了invokeMethod方法，那么我们代码会调用invokeMethod方法 并传入方法名和参数
println person.cry()

/**
 *  为类/对象动态的添加 方法/属性
 */
//动态的为person对象添加一个 sex属性
person.metaClass.sex="wman"
println person.sex

//因为是给单个对象添加的属性，所以再从新new一个对象的时候，sex属性并不存在于person中
//def personNoAddSex=new Person()
//println personNoAddSex.sex

//动态的为person类添加一个 sex属性  那么这个类的所有对象都可以使用sex这个属性
Person.metaClass.sex="man"
def personAddSex=new Person()
println personAddSex.sex
//动态为类添加一个方法    通过闭包 把方法注入到类中
Person.metaClass.sexUpperCase={
   -> sex.toUpperCase()
}
def person1=new Person()
println person.sexUpperCase()