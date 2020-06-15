package container

/**
 * groovy容器
 * @Author ：hongzhi.xu* @Date: 2020/6/14 4:47 下午
 * @Version 1.0
 */
//在groovy脚本中，list默认使用ArrayList。定义List 使用的就是下面这个方法。
def list = [1, 2, 3, 4, 5, 6]
println list.class
println list.size()
//如果要是定义数组 有两种方式，一种是弱类型，另一种是强类型定义
//弱类型
def array = [1, 2, 3, 4, 5, 6] as int[]
println array.class
//强类型
int[] array2 = [1, 2, 3, 4, 5]
println array2.class

//对list的排序

// 在Java中 使用Collectios排序
def sortList = [5, 3, 9, 2, 1, 4]
Collections.sort(sortList)
println sortList
//配合闭包
def sortList2 = [5, 3, 9, 2, 1, 4, -22, -6]
Comparator mc = { a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 }
Collections.sort(sortList2, mc)
println sortList2

//在groovy中 groovy提供了更强大的方法,直接使用sort方法就可以排序了
def groovySortList2 = [5, 3, 9, 2, 1, 4, -22, -6]
groovySortList2.sort()
println groovySortList2
//配合闭包提供排序规则
groovySortList2.sort { a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 }
println groovySortList2

//对字符串的排序
def stringList=['hello','groovy','by','xu']
//按照长度分组
stringList.sort{return it.size()}
println stringList

class Person{
    String name
    int age
}

def man1=new Person(name:"xu",age:21)
def man2=new Person(name:"big",age:22)
def man3=new Person(name:"rich",age:23)
def man4=new Person(name:"zhi",age:22)


def personList=[man3,man1,man2,man4]

personList.sort{it.age}

personList.each {print it.age +" "}

//列表查找  查找第一额符合条件的的对象（age等于22的person）
println personList.find {it.age==22}.name
//列表查找 查找所有符合条件的对象
personList.findAll {it.age==22}.each {print it.name+" "}
println ""
//查找列表中是否有符合条件的对象
println personList.any{it.age==22}
//查找列表中是否全部的元素都符合条件
println personList.every{it.age==22}
//查找最大值和最小值
println personList.min {it.age}.name
println personList.max{it.age}.name
//计数 计算年龄为22的个数
println personList.count{it.age==22}