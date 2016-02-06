package com.kushagra;

public class MapImplementation<K,V>
{
  private EntryImplementation<K,V>[] entry;
  
  public void put(K key, V value)
  {
    int hashCode = key.hashCode();
    EntryImplementation<K, V> entryImplementation = new EntryImplementation<K, V>(key, value, hashCode, null);
  }
  
  public V get(K key)
  {
    V value = null;
    return value;
  }
  
  
  
  public EntryImplementation<K, V>[] getEntrySet()
  {
    return entry;
  }
  
   static class EntryImplementation<K,V>
  {
    private EntryImplementation<K, V> next;
    private K key;
    private V value;
    private int hash;

    public EntryImplementation()
    {
    }
    
    public EntryImplementation(K key, V value, int hash, EntryImplementation<K, V> next)
    {
      this.next = next;
      this.key = key;
      this.value = value;
      this.hash = hash;
    }

    
    public K getKey()
    {
      return key;
    }
    public V getValue()
    {
      return value;
    }
    public int getHash()
    {
      return hash;
    }
    public void setNext(EntryImplementation<K, V> next)
    {
      this.next = next;
    }
    public EntryImplementation<K, V> getNext()
    {
      return next;
    }
  }
   
   
}

class TestMap
{
  
}
