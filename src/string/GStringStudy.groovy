package string

def GStringName1="The"
println GStringName1.center(4,'a')
println GStringName1.padLeft(8,'av')
println GStringName1.padRight(8,'av')

def GStringName2="abcdefg"
//对比GStringName2与GStringName1的 Unicode的编码大小
println GStringName2>GStringName1
//取出字符串中某一个。某一范围 字符
println GStringName2[1]
println GStringName2[1..2]
//从某一字符串中提出掉某一字符串
def goal="hello world!"
def bullet="world"
println goal.minus(bullet)
println goal-bullet
//倒叙操作
println goal.reverse()
//首字母大写
println goal.capitalize()