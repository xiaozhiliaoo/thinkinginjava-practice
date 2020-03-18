异常情形：
自己处理不了父级【谁调用谁就是父类】处理。

    public void f() throws XXXException{
    
    }
谁调用谁就要处理。
//没在这个方法里面处理异常，继续往上抛

    public void invokef() throws YYYException{
        f();
    }

---

在这个方法里面处理异常，不继续往上抛

    public void invokef() {
    
        try{
            f();
        } catch(YYYException e){
        }
    }
    

---

恢复模型，终止模型[JAVA]

catch按照顺序，Exception放在最后。Exception捕获所有异常。但是不会包含太多信息




