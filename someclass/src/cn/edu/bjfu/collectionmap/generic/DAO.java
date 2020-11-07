package cn.edu.bjfu.collectionmap.generic;

import java.util.*;

/**
 * @author Chao Huaiyu
 * @date 2020/10/25
 */
public class DAO<T> {
    private Map<String,T> map;
    public void save(String id,T entity){
        if(map == null){
            map = new HashMap<>(16);
        }
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id,T entity){
        if(map.containsKey(id)){
            map.put(id,entity);
        }
    }

    public List<T> list(){
        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        list.addAll(values);
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }
}
