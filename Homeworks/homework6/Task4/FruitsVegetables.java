package homework6.Task4;

import java.util.*;

public class FruitsVegetables
{

    public static Map<String, String> CreateMap()
    {
        java.util.Map<String, String > map = new HashMap<>();

        map.put("apple", "yellow");
        map.put("tomato", "red");
        map.put("watermelon", "red");
        map.put("cucumber", "green");
        map.put("pineapple", "yellow");
        map.put("orange", "orange");
        map.put("potato", "brown");
        map.put("cabbage", "green");
        map.put("banana", "yellow");
        map.put("eggplant", "pink");
        return map;
    }

public static void removeDuplicate(Map<String, String> map)
{
        Set<String> setNames = new HashSet<>();
        Set<String> duplicateNames = new HashSet<>();
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String name = pair.getValue();
            if (setNames.contains(name))
            {
                duplicateNames.add(name);
            } else {
                setNames.add(name);
            }
        }
        for (String name : duplicateNames)
        {
            removeItemFromMap(map, name);
        }
        System.out.println(map);
}

    private static void removeItemFromMap(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}

