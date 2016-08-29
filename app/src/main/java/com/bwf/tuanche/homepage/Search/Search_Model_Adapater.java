package com.bwf.tuanche.homepage.Search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.tuanche.R;

import java.util.List;

/**
 * Created by wanli on 2016/8/26.
 * Description:
 * <p>
 * 搜索页面的搜索记录
 */
public class Search_Model_Adapater extends BaseAdapter {
    private List<String> strings;
    private Context context;
    private Search_Model model;

    //传值


    public Search_Model_Adapater(Context context) {
        model=new Search_Model();
        this.context = context;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings == null ? 0 : strings.size();
    }

    @Override
    public Object getItem(int i) {
        return strings == null ? null : strings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewhoder viewhoder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.search_history_item, null);
            viewhoder = new Viewhoder();
            viewhoder.search_icon_history_text = (TextView) view.findViewById(R.id.search_icon_history_text);
            view.setTag(viewhoder);
        } else {
            viewhoder = (Viewhoder) view.getTag();
        }
        viewhoder.search_icon_history_text.setText(strings.get(i));
        return view;
    }

    public class Viewhoder {
        TextView search_icon_history_text;
    }
}
