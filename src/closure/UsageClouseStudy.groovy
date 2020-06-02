package closure
/*          闭包用途
* 1. 与基本类型的结合使用
* 2. 与String结合使用
* 3. 与数据结构结合使用
* 4. 与文件等结合使用
* */
//用来求指定number的阶乘
int x=fab(5)
println x
def int fab(int number){
    int result=1
    //从1 upto 到 number ,每次增加的时候执行 闭包操作
    1.upto(number,{num->result*=num})
    return result
}
def int fab2(int number){
    int result=1
    //从number downto 到 1 ,每次减少的时候执行 闭包操作  闭包可以放到参数外面
    number.downto(1){num->result*=num}
    return result
}
def int cal(int number){
    int result=1
    //从number downto 到 1 ,每次减少的时候执行 闭包操作  闭包可以放到参数外面
    number.times{num->result*=num}
    return result
}