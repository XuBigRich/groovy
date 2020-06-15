package io

import json.Person

/**
 * @Author ：hongzhi.xu* @Date: 2020/6/15 3:55 下午
 * @Version 1.0
 */

def file=new File("/Users/xuhongzhi/studen/groovy/.gitignore")
//groovy操作文件 的方式（真方便呀！）
//遍历输出每一行
//file.eachLine {println it}
//一下子全部输出
//println file.getText()
//这会将每一行变为List元素放入一个List中的。
def result=file.readLines()
println result

//读取文档的前20个字节
def reader=file.withReader {
    char[] buffer=new char[20]
    it.read(buffer)
    return buffer
}
println reader

//拷贝 里面 牵扯读和写
def copy(){
    def file=new File("/Users/xuhongzhi/studen/groovy/.gitignore")
    def file2=new File("/Users/xuhongzhi/studen/groovy/gitignore2")
    if(!file2.exists()){
        file2.createNewFile()
    }
    //获取整个文本内容用于复制
    //def text=file.getText();
    //file2.write(text)
    file.withReader {
        def lines=it.readLines()
        file2.withWriter {
            lines.each {
                line->it.append(line )
            }
        }
    }

}
copy()

class Text implements Serializable{
    String text;
}

def saveObject(){
    def file3=new File("/Users/xuhongzhi/studen/groovy/gitignore3")
    if(!file3.exists()){
        file3.createNewFile()
    }else {
        file3.delete()
    }
    file3.withObjectOutputStream {
        it.writeObject(new Text(text: "我是一个记事本，我里面有好多内容。"))
    }
}
def readObject(){
    def obj=null
    try{
        def file=new File("/Users/xuhongzhi/studen/groovy/gitignore3")
        if(file==null||!file.exists())return null;
        file.withObjectInputStream {
            obj=it.readObject()
        }
        return obj
    }catch(Exception e){

    }
}
saveObject()

println readObject().text