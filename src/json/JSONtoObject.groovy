package json

import com.alibaba.fastjson.JSON
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class Person{
    String name
    int age
}

def psersonList=[new Person(name: "zhizhi",age:12),new Person(name: "honghong",age:15)]
//将数组转换为json
println JsonOutput.toJson(psersonList)
def json=JsonOutput.toJson(psersonList)
//将json按照优美的格式输出
println JsonOutput.prettyPrint(json)
//Json 转对象
def jsonSlpuer=new JsonSlurper();
print jsonSlpuer.parseText(json)[0]
//使用java的第三方jar包
def jsonObject=JSON.parse(json)
print jsonObject.toString()

def response=getNetworkData("https://api.jisuapi.com/xiaohua/text?pagenum=1&pagesize=1&sort=addtime&appkey=yourappkey")
println response.msg
//使用http向网络端发送请求，并解析返回的json 变为对象。（groovy并未提供请求方法，所以我们需要使用Java的那一套）
def  getNetworkData(String url){
    //发送http请求
    def connection=new URL(url).openConnection()
        //connection.setRequestMethod('GET')
        connection.connect()
    def response=connection.content.text
    //将json转换为实体对象
    def jsonSluper =new JsonSlurper()
    return jsonSluper.parseText(response)
}

