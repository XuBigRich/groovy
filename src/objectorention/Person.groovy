package objectorention
/*
关于groovy 的面向对象特性
* */
/**
 * 1.groovy中默认都是public 类型的
 * 2.所有类默认继承GroovyObject 与java中所有类继承Object类似
 */
class Person implements Action{
    String name
    String age
    //def 代替为返回值 也就代表了返回一个Object类型
    def increaseAge(Integer years){
        this.name+=years
    }

    @Override
    void eat() {

    }

    @Override
    void drink() {

    }

    @Override
    void play() {

    }
    /**
     * 一个方法找不到的时，调用它代替  3个序号它属于3
     * @param name   方法名
     * @param arge    参数
     * @return
     */
    def invokeMethod(String name,Object arge){
        return "the method is ${name},the params is ${arge} the method is invoke"
    }
    /**
     *一个方法找不到的时，调用它代替  3个序号它属于2
     * @param name
     * @param arge
     * @return
     */
    def methodMissing(String name,Object arge){
        return "the method is ${name},the params is ${arge} the method is missing"
    }

}
