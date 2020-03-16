package string
/*
Groovy 为String字符串提供了 新的 类GString
* */
//关于string 的定义

/*使用单/三引号定义字符串 与java中 定义Sting的方式无异*/
// 使用单引号操作与java操作也无异 使用特殊符号时需要转义字符  等
def name='a single \" string'
println name.class
// 使用三引号时候 groovy 输出会与输入保持一致 包括换行等
def thupleName="""three s"ignle String"""
println thupleName.class
/*
* 关于GString的使用
* */
// 使用双引号时候，但其原类依然是String
def GStringNameMeta="a single String"
println GStringNameMeta.class
// 但当字符串输出时携带了变量（其值可使用变量扩展） 那么类型将变为GString类型了
def GStringName="a single GString${name}"
println GStringName.class
// ${} 中可以扩展 任意表达式
def sum="""The sum of 2 and 3 equals ${2+3}"""
println sum

//GString 类型 在Groovy中可以被String接收
def result =echo(sum)
String echo(String message){
    println message.class
    return message
}
GString
println result +' '+result.class