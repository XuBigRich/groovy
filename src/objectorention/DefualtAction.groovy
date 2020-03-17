package objectorention

trait DefualtAction {
    //如果方法为抽象类型 （需要被去实现） 那么要添加abstract关键字
    abstract void eat()
    void play(){
        println 'i can play'
    }
}