package objectorention.usageEnableGloblly

import objectorention.Person

//程序入口类 一般继承Script类
class Entry {
    static void main(String[] args) {
        println '应用程序正在启动......'
        //初始化
        ApplicationManager.init()
        println '应用程序初始化完成.....'
        def person= PersonManager.createPerson("zhazha.xu",22)
        println person.name+' '+person.age
    }
}
