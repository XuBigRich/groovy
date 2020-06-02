package objectorention
//关于实现groovy中trait类型
//trait类型 类似于java中的 接口适配模式，所以建议去学习一下接口适配设计模式
class Man implements DefualtAction {
    @Override
    void eat() {
        println 'i can eat'
    }
}
