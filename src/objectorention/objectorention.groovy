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
 *  但是 动态添加的方法和属性不能跨文件域
 *  若要解决 请查看 usageEnableGloblly (主要是使用ExpandoMetaClass.enableGloblly（） 方法 设置为全局可用的)
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
//注意当对象 在通过元编程添加方法之前添加 那么，方法将不起作用
Person.metaClass.sexUpperCase={
    sex.toUpperCase()
}  
//person对象 是在 Person添加sexUpperCase方法之前添加的 所以调用失败了
//println person.sexUpperCase()
def person1=new Person()
println person1.sexUpperCase()

//给某个类添加静态方法/静态属性类似
Person.metaClass.static.creatPerson={
   String name,Integer age
   ->new Person(name: name,age: age)
}
def staticPerson=Person.creatPerson("hongzhi.xu",21)
println staticPerson.name +' and '+staticPerson.age