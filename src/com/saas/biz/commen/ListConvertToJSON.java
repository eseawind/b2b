package com.saas.biz.commen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class ListConvertToJSON
  implements Serializable
{
  private static final long serialVersionUID = 7120396773177990035L;

  public static String getJSONByList(ArrayList paramArrayList, int paramInt)
    throws JSONException
  {
    String str = "";
    JSONArray localJSONArray = new JSONArray();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        JSONObject localJSONObject2 = new JSONObject();
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        Iterator localIterator = localHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          Object localObject1 = localEntry.getKey();
          Object localObject2 = localEntry.getValue();
          if ((localObject2 == null) || (localObject2.equals("")))
            localJSONObject2.put(localObject1, "");
          else
            localJSONObject2.put(localObject1, localObject2);
        }
        localJSONArray.add(localJSONObject2);
      }
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("root", localJSONArray);
    localJSONObject1.put("totalCount", Integer.valueOf(paramInt));
    str = localJSONObject1.toString();
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.ListConvertToJSON
 * JD-Core Version:    0.6.0
 */