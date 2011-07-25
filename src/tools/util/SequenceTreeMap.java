package tools.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;

public class SequenceTreeMap
{
  private HashMap khash = null;
  private TreeMap kmap = null;
  private TreeMap vmap = null;
  private int size = 0;
  private int takeEqual = 0;
  private boolean desc = false;

  public SequenceTreeMap()
  {
  }

  public SequenceTreeMap(int paramInt)
  {
    this.takeEqual = paramInt;
  }

  public SequenceTreeMap(boolean paramBoolean)
  {
    this.desc = paramBoolean;
  }

  public SequenceTreeMap(int paramInt, boolean paramBoolean)
  {
    this.takeEqual = paramInt;
    this.desc = paramBoolean;
  }

  public void clear()
  {
    this.size = 0;
    this.khash = null;
    this.kmap = null;
    this.vmap = null;
  }

  public boolean containsKey(Object paramObject)
  {
    return this.khash == null ? false : this.khash.containsKey(paramObject);
  }

  public boolean containsValue(Object paramObject)
  {
    return this.vmap == null ? false : this.vmap.containsValue(paramObject);
  }

  public Object get(Object paramObject)
  {
    if (this.khash == null)
      return null;
    Integer localInteger = (Integer)this.khash.get(paramObject);
    if (localInteger == null)
      return null;
    return this.vmap.get(localInteger);
  }

  public Collection keySet()
  {
    return this.kmap == null ? null : this.kmap.values();
  }

  public Object put(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      return null;
    if (this.khash == null)
    {
      this.khash = new HashMap();
      this.kmap = new TreeMap(new IntegerComparator(this.takeEqual != 0, this.desc));
      this.vmap = new TreeMap(new IntegerComparator(this.takeEqual != 0, this.desc));
    }
    if (!this.khash.containsKey(paramObject1))
      this.size += 1;
    this.khash.put(paramObject1, new Integer(this.size));
    this.kmap.put(new Integer(this.size), paramObject1);
    Object localObject = this.vmap.put(new Integer(this.size), paramObject2);
    return localObject;
  }

  public Object remove(Object paramObject)
  {
    if (this.khash == null)
      return null;
    if (this.khash.containsKey(paramObject))
      this.size -= 1;
    Integer localInteger = (Integer)this.khash.get(paramObject);
    this.khash.remove(paramObject);
    this.kmap.remove(localInteger);
    return this.vmap.remove(localInteger);
  }

  public int size()
  {
    return this.size;
  }

  public Collection values()
  {
    return this.vmap == null ? null : this.vmap.values();
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.SequenceTreeMap
 * JD-Core Version:    0.6.0
 */