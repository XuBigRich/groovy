package closure

/*闭包就类似于一段闭合的代码块*/
//声明一个无参闭包
def clouser={
    println 'Hello world!'
}
//执行闭包
    clouser.call()
    clouser()
//声明一个有参闭包  箭头之前是参数部分，之后是闭包体
//弱类型闭包
def parameterClouser={
    x-> println x
}
//强类型闭包
def strongParameterClouser={
   String x,y-> println x + y
}
parameterClouser(1)
strongParameterClouser('hello',2)
// 闭包特性  ，闭包一定有参数，一定有返回值
// 闭包默认参数it
def defaultParameterClouser={
    println "it : ${it}"
}
//若调用默认参数it时  需要传一个参数
defaultParameterClouser()
defaultParameterClouser('hello ,i am here')
//当没有写return 的时候  默认返回null  如果有return 那么就实际返回
def defaultReturnClouser={
}
println defaultReturnClouser()