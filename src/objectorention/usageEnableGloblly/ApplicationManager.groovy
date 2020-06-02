package objectorention.usageEnableGloblly

import objectorention.Person


/**
 * 管理类
 * */
class ApplicationManager {
    static void init(){
        //将动态添加的方法/属性 设置为全局可用的
        ExpandoMetaClass.enableGlobally()
        //为第三方类添加方法
        Person.metaClass.static.createPerson={
            String name,Integer age-> new Person (name:name,age:age)
        }
    }
}
