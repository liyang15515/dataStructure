package com.founder.demo.secondDay;

/**
 * 栈是一种只能在一端进行插入和删除操作的特殊线性表。
 *
 * 其中，允许插入和删除的一端称为栈顶，另一端称为栈底。通常，将栈的插入操作称为入栈，删除操作称为出栈。
 * 入栈时元素总是放在栈底，而出栈的总是栈顶元素。因此，栈中元素采用的是“后进先出”的方式。
 *
 * 栈的数据元素类型可以任意，只要是同一种类型即可。它的基本操作包括清空、判空、求元素个数、获取栈顶、入栈和出栈等。
 *
 */
public class MyStack {
    private Object[] stackElem;
    private int top;
    public MyStack(int maxSize)
    {
        stackElem=new Object[maxSize];
        top=0;
    }
    //清空
    public void clear()
    {
        top=0;
    }
    //是否为空
    public boolean isEmpty()
    {
        return top==0;
    }
    //元素个数
    public int length()
    {
        return top;
    }
    //栈顶
    public Object peek()
    {
        if(!isEmpty())
            return stackElem[top-1];
        else
            return null;
    }
    //入栈
    public void push(Object x) throws Exception
    {
        if(top==stackElem.length)
        {
            throw new Exception("栈已满！");
        }
        else
        {
            stackElem[top++]=x;
        }
    }
    //出栈
    public Object pop() throws Exception
    {
        if(top==0)
        {
            throw new Exception("栈为空！");
        }
        else
            return stackElem[--top];  //删除然后返回现在的栈顶
    }
    //打印（从栈顶到栈底）
    public void display()
    {
        for(int i=length()-1; i>=0; i--)
        {
            System.out.print(stackElem[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        MyStack sqStack = new MyStack(30);
        sqStack.push(3);
        sqStack.push(6);
        sqStack.push(9);

        System.out.print("打印输出： ");
        sqStack.display();

        int top2 = (int) sqStack.peek();
        System.out.println("栈顶： " + top2);

        sqStack.pop();//弹栈，即删除数据
        System.out.print("弹出栈顶，打印输出： ");
        sqStack.display();
    }

}
