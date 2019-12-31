package com.koala.utils;


import com.jieba.JiebaSegmenter;
import com.koala.entity.bar_;
import com.koala.entity.post_;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于关键字查找.
 * @author Marting.Lee
 * 2019/12/31
 */
public class SearchUtils {

    /**
      *根据关键词获取微博.
      * @param keyword String
     * @param list com.koala.entity.bar_
      * @return java.util.List(com.koala.entity.bar_)
      **/
    public static List<bar_> getList(String keyword, List<bar_> list){
        List<String> words;
        JiebaSegmenter jiebaSegmenter =new JiebaSegmenter();
        words = jiebaSegmenter.sentenceProcess(keyword);
        int i = 0;
        if (search(keyword,list).isEmpty()){
            while (search(words.get(i),list).isEmpty())
                i++;
            System.out.println("分词大小 "+words.size()+" i= "+i);
            if (i>=words.size())
                return null;
            return search(words.get(i),list);
        }else {
            return search(keyword,list);
        }
    }

    /**
      *简单搜索.
      * @param keyword String
     * @param list com.koala.entity.post_
      * @return java.util.List(com.koala.entity.post_)
      **/
    public static List<bar_> search(String keyword,List<bar_> list){
        List<bar_> postList = new ArrayList<>();
        for (int i=0;i<list.size();i++)
            if (list.get(i).getContent().indexOf(keyword) != -1)//含有关键词
                postList.add(list.get(i));
            return postList;
    }
}
