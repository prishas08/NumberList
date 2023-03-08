import java.util.List;
import java.util.ArrayList;
public class NumberList
{
    private Integer[] list;
    private int size;
    private int index = 0;

    public NumberList()
    {
    	list = new Integer[2];
    }
    public NumberList(int initial)
    {
        Integer[] list = new Integer[initial];
        size = 0;
 
    }
    
    public int size()
    {
        return list.length;
    }
    
    public boolean isEmpty()
    {
        if(size() == 0)
        {
            return true;
        }
        return false;
        
    }
    
    public String toString()
    {
        String s = "[";
        for(int i = 0; i < size(); i++)
        {
        	if(list[i]!= null)
        	{
        		if(i == 0)
            	{
            		s+= list[i];
            	}
        		else
            	{
            		s+= ", " + list[i];
            	}
        	}
        	
        }
        return s + "]";
    }
    
    private void doubleCapacity()
    {
        Integer[] list2;
        if(size()==0)
        {
        	list2 = new Integer[1];
        }
        else
        {
        	list2 = new Integer[size() * 2];
        }
        for(int i = 0; i < size(); i++)
        {
        	if(list[i]!=null)
        	{
        		list2[i] = list[i];
        	}
            
        }
        list = list2;

    }
    
    public void add(int index, Integer val) 
    {
    	Integer[] tempList = new Integer[size()+1];
        if (index >= size())
        {
            doubleCapacity();
        }
        if(list[index]!=null)
        {
        	for(int i = 0; i < tempList.length; i++)
        	{
        		if(i < index)
        		{
        			tempList[i] = list[i];
        		}
        		else if (i==index)
        		{
        			tempList[i] = val;
        		}
        		else
        		{
        			tempList[i]= list[i-1];
        		}
        		
        	}
        	list = tempList;
        }
        else if(list[index]==null)
        {
        	list[index]=val;
        }
        else
        {
        	throw new IndexOutOfBoundsException();
        }
        
    }
    
    public boolean add(Integer element)
    {
    	add(index++, element);
        return true;
    }
    
    public Integer get(int Index)
    {
    	if(Index > size())
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	else
    	{
    		return this.list[Index];
    	}
    }
    
    public Integer set(int index, Integer val)
    {
    	if(index > size())
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	else
    	{
    		int i = list[index];
    		list[index] = val;
    		return i;
    	}
    }
   
    public Integer remove(int index)
    {
    	Integer[] temp = new Integer[size()-1];
    	if(index > size())
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	else
    	{
    		Integer x = 0;
    		for(int i = 0; i < size(); i++)
    		{
    			if(i==index)
    			{
    				x = list[i];
    			}
    			else if(i>index)
    			{
    				temp[i-1]=list[i];
    			}
    			else
    			{
    				temp[i]=list[i];
    			}
    		}
    		list = temp;
    		return x;
    	}
    }
}


