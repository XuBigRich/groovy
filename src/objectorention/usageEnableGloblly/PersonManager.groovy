package objectorention.usageEnableGloblly

import objectorention.Person

/**
 * person管理器
 */
class PersonManager {
    static Person createPerson(String name,Integer age){
        Person.createPerson(name,age)
    }
}
